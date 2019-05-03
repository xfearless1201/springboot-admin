package com.cn.tianxia.admin.project.ftpdata;

import java.io.Serializable;

/**
 * 表单查询条件
 * @author Administrator
 *
 */
public class FormData implements Serializable{
	
	/**
	 * 序列化唯一标识
	 */
	private static final long serialVersionUID = -2591359892712257238L;
	
	/**
	 * 平台商名称
	 */
	private String cagentName;
	/**
	 * 用来拼接平台查询sql,例如:当选择的时间范围是2019-04-01 12:00:00 到 2019-04-27 11:59:59
	 * 则2019-04-01 12:00:00 到 2019-04-01 23:59:59 和 2019-04-27 00:00:00 到 2019-04-27 11:59:59 是查询明细记录的
	 */
	private String platFormId;
	/**
	 * 会员账号
	 */
	private String userName;
	/**
	 * 用户姓名
	 */
	private String realname;
	/**
	 * 代理商
	 */
	private String topUidName;
	/**
	 * 会员分层
	 */
	private String userTypeName;
	/**
	 * 游戏类型
	 */
	private String gameType;
	/**
	 * 开始时间
	 */
	private String startTime;
	/**
	 * 结束时间
	 */
	private String endTime;
	/**
	 * 当前第几页
	 */
	private int page;
	/**
	 * 每页显示多少行
	 */
	private int rows;
	
	/**
	 * 是否会员分组
	 */
	private String userGrouping;
	
	/**
	 * 是否实时分页
	 */
	private String dateGrouping;
	
	public String getCagentName() {
		return cagentName;
	}
	public void setCagentName(String cagentName) {
		this.cagentName = cagentName;
	}
	public String getPlatFormId() {
		return platFormId;
	}
	public void setPlatFormId(String platFormId) {
		this.platFormId = platFormId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getTopUidName() {
		return topUidName;
	}
	public void setTopUidName(String topUidName) {
		this.topUidName = topUidName;
	}
	public String getUserTypeName() {
		return userTypeName;
	}
	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}
	public String getGameType() {
		return gameType;
	}
	public void setGameType(String gameType) {
		this.gameType = gameType;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
    public String getUserGrouping() {
        return userGrouping;
    }
    public void setUserGrouping(String userGrouping) {
        this.userGrouping = userGrouping;
    }
    public String getDateGrouping() {
        return dateGrouping;
    }
    public void setDateGrouping(String dateGrouping) {
        this.dateGrouping = dateGrouping;
    }
}
