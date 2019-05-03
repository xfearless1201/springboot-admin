package com.cn.tianxia.admin.web.member;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.project.txdata.UserMember;
import com.cn.tianxia.admin.service.txdata.UserMemberService;
import com.cn.tianxia.admin.web.sys.BaseController;

/**
 * 
 * @ClassName MemberController
 * @Description TODO(平台会员管理)
 * @author Toby
 * @Date 2019年4月27日 下午9:05:31
 * @version 1.0.0
 */

@RestController
@RequestMapping("/member/user")
public class UserMemberController extends BaseController {

	@Autowired
	private UserMemberService userMemberService;

	/**
	 * 
	 * @Description (平台会员查询)
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ResultResponse MemberInquiry(@RequestParam Map<String, String> params) throws Exception {

			// 判断不是管理员获取平台商ID
			if (!isAdmin()) {
				if (getCid() == 0) {
					// 根据平台ID只能查看自己平台下面的
					params.put("cid", getCid().toString());
				}
			}
			Pager<UserMember> pager = userMemberService.MemberInquiry(params);
			return ResultResponse.success("查询成功", pager);
	}
}
