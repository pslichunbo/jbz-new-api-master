package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
@TableName("tb_user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long userId;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 真实姓名
	 */
	private String realName;
	/**
	 * 昵称
	 */
	private String nickname;
	/**
	 * 头像url
	 */
	private String avatar;
	/**
	 * 性别  1男 0女
	 */
	private Long gender;
	/**
	 * 生日
	 */
	private Date birthday;
	/**
	 * 状态 1可用 0禁用
	 */
	private Long state;
	/**
	 * 推送是否需要声音 1需要 0不需要
	 */
	private Long canSound;
	/**
	 * 是否需要推送消息 1需要 0不需要
	 */
	private Long canMessage;
	/**
	 * 用户所在国家
	 */
	private String country;
	/**
	 * 用户所在省份
	 */
	private String province;
	/**
	 * 用户所在城市
	 */
	private String city;
	/**
	 * 微信用户标识
	 */
	private String openId;
	/**
	 * 微信唯一标识
	 */
	private String unionId;
	/**
	 * 用户的金币数量
	 */
	private Long goldAccout;
	/**
	 * 用户最后一次签到时间
	 */
	private Date lastSignTime;
	/**
	 * 连续签到的次数
	 */
	private Long signTimes;
	/**
	 * 身份id
	 */
	private String identityAttestationId;

	/**
	 * 设置：
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：用户名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：手机号
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：真实姓名
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}
	/**
	 * 获取：真实姓名
	 */
	public String getRealName() {
		return realName;
	}
	/**
	 * 设置：昵称
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * 获取：昵称
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * 设置：头像url
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	/**
	 * 获取：头像url
	 */
	public String getAvatar() {
		return avatar;
	}
	/**
	 * 设置：性别  1男 0女
	 */
	public void setGender(Long gender) {
		this.gender = gender;
	}
	/**
	 * 获取：性别  1男 0女
	 */
	public Long getGender() {
		return gender;
	}
	/**
	 * 设置：生日
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	/**
	 * 获取：生日
	 */
	public Date getBirthday() {
		return birthday;
	}
	/**
	 * 设置：状态 1可用 0禁用
	 */
	public void setState(Long state) {
		this.state = state;
	}
	/**
	 * 获取：状态 1可用 0禁用
	 */
	public Long getState() {
		return state;
	}
	/**
	 * 设置：推送是否需要声音 1需要 0不需要
	 */
	public void setCanSound(Long canSound) {
		this.canSound = canSound;
	}
	/**
	 * 获取：推送是否需要声音 1需要 0不需要
	 */
	public Long getCanSound() {
		return canSound;
	}
	/**
	 * 设置：是否需要推送消息 1需要 0不需要
	 */
	public void setCanMessage(Long canMessage) {
		this.canMessage = canMessage;
	}
	/**
	 * 获取：是否需要推送消息 1需要 0不需要
	 */
	public Long getCanMessage() {
		return canMessage;
	}
	/**
	 * 设置：用户所在国家
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * 获取：用户所在国家
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * 设置：用户所在省份
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：用户所在省份
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：用户所在城市
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：用户所在城市
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：微信用户标识
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	/**
	 * 获取：微信用户标识
	 */
	public String getOpenId() {
		return openId;
	}
	/**
	 * 设置：微信唯一标识
	 */
	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}
	/**
	 * 获取：微信唯一标识
	 */
	public String getUnionId() {
		return unionId;
	}
	/**
	 * 设置：用户的金币数量
	 */
	public void setGoldAccout(Long goldAccout) {
		this.goldAccout = goldAccout;
	}
	/**
	 * 获取：用户的金币数量
	 */
	public Long getGoldAccout() {
		return goldAccout;
	}
	/**
	 * 设置：用户最后一次签到时间
	 */
	public void setLastSignTime(Date lastSignTime) {
		this.lastSignTime = lastSignTime;
	}
	/**
	 * 获取：用户最后一次签到时间
	 */
	public Date getLastSignTime() {
		return lastSignTime;
	}
	/**
	 * 设置：连续签到的次数
	 */
	public void setSignTimes(Long signTimes) {
		this.signTimes = signTimes;
	}
	/**
	 * 获取：连续签到的次数
	 */
	public Long getSignTimes() {
		return signTimes;
	}
	/**
	 * 设置：身份id
	 */
	public void setIdentityAttestationId(String identityAttestationId) {
		this.identityAttestationId = identityAttestationId;
	}
	/**
	 * 获取：身份id
	 */
	public String getIdentityAttestationId() {
		return identityAttestationId;
	}
}
