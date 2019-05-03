package com.cn.tianxia.admin.service.txdata.impl;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.domain.txdata.UserMemberMapper;
import com.cn.tianxia.admin.domain.txdata.UserPlatformReportMapper;
import com.cn.tianxia.admin.domain.txdata.UserTypeMapper;
import com.cn.tianxia.admin.domain.txdata.UserWalletMapper;
import com.cn.tianxia.admin.project.txdata.UserMember;
import com.cn.tianxia.admin.project.txdata.UserPlatformReport;
import com.cn.tianxia.admin.project.txdata.UserType;
import com.cn.tianxia.admin.project.txdata.UserWallet;
import com.cn.tianxia.admin.service.txdata.UserMemberService;
import com.cn.tianxia.admin.vo.txdata.UserMemberVO;

@Service
public class UserMemberServiceImpl implements UserMemberService {

	// 日志
	private static final Logger logger = LoggerFactory.getLogger(UserMemberServiceImpl.class);

	/**
	 * 平台会员
	 */
	@Autowired
	private UserMemberMapper userMemberMapper;

	/**
	 * 会员总输赢额
	 */
	@Autowired
	private UserPlatformReportMapper userPlatformReportMapper;

	/**
	 * 会员分层
	 */
	@Autowired
	private UserTypeMapper userTypeMapper;

	/**
	 * 会员积分
	 */
	@Autowired
	private UserWalletMapper userWalletMapper;

	@Override
	public int deleteByPrimaryKey(Integer uid) {
		return userMemberMapper.deleteByPrimaryKey(uid);
	}

	@Override
	public int insertSelective(UserMember record) {
		return userMemberMapper.insertSelective(record);
	}

	@Override
	public UserMember selectByPrimaryKey(Integer uid) {
		return userMemberMapper.selectByPrimaryKey(uid);
	}

	@Override
	public int updateByPrimaryKeySelective(UserMember record) {
		return userMemberMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 平台会员查询
	 */
	@Override
	public Pager<UserMember> MemberInquiry(Map<String, String> params) throws Exception {

		logger.info("查询用户角色列表请求参数:{}", params.toString());
		Pager<UserMemberVO> pager = new Pager<UserMemberVO>();
		pager.setParams(params);
		// 根据条件查询会员列表
		List<UserMember> userMember = userMemberMapper.memberInquiry(pager);

		// 根据条件查询会员总条数
		int userMemberCount = userMemberMapper.memberInquiryCount(pager);

		userMember.stream().forEach(userMemberid -> {

			/**
			 * 拼接会员打码量，以及输赢额
			 */
			List<UserPlatformReport> userPlatformReport = userPlatformReportMapper.selectByUid(userMemberid.getUid());
			if (null == userPlatformReport || userPlatformReport.size() == 0) {
				userMemberid.setUserQuantity(0d);
				userMemberid.setUserWinAmount(0d);
			} else {
				/**
				 * 统计会员打码量，输赢额
				 */
				DoubleSummaryStatistics userQuantity = userPlatformReport.stream()
						.mapToDouble(value -> value.getValidBetAmount()).summaryStatistics();
				DoubleSummaryStatistics userWinAmount = userPlatformReport.stream()
						.mapToDouble(value -> value.getNetAmount()).summaryStatistics();

				userMemberid.setUserQuantity(userQuantity.getSum());
				userMemberid.setUserWinAmount(userWinAmount.getSum());
			}
			/**
			 * 拼接会员分层
			 */
			UserType usertype = userTypeMapper.selectByPrimaryKey(userMemberid.getTypeId());
			if (usertype != null) {
				userMemberid.setTypeName(usertype.getTypename());
			} else {
				userMemberid.setTypeName("");
			}
			/**
			 * 拼接会员积分
			 */
			UserWallet userWallet = userWalletMapper.selectByUid(userMemberid.getUid());
			if (userWallet != null) {
				userMemberid.setIntegral(userWallet.getBalance());
			} else {
				userMemberid.setIntegral(0d);
			}

		});
		// 总条数
		Pager<UserMember> result = new Pager<>(userMemberCount, pager.getPage(), pager.getLimit());
		result.setList(userMember);
		return result;
	}
}
