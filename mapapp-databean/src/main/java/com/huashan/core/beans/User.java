package com.huashan.core.beans;

import com.huashan.core.base.AbstractItem;
import com.huashan.core.base.ItemBase;

import javax.persistence.*;

/**
 * 
 * 
 * @author lixu
 * 
 * Tue Aug 16 17:25:54 CST 2016
 */
@Entity
@Table(name = "db_user")
public class User extends AbstractItem implements ItemBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public final static String USERSESSIONLOG = "USERSESSIONLOG";
	
	public User(){}
	
	@Column( name = "id" , nullable=false ,length = 11)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	
	@Column( name = "openid" ,length = 500 )
	private String openid;	
	
	@Column( name = "nickname" ,length = 100 )
	private String nickname;	
	
	@Column( name = "sex" ,length = 11 )
	private Integer sex;	
	
	@Column( name = "province" ,length = 120 )
	private String province;	
	
	@Column( name = "city" ,length = 120 )
	private String city;	
	
	@Column( name = "county" ,length = 120 )
	private String county;	
	
	@Column( name = "headImgUrl" ,length = 500 )
	private String headImgUrl;	
	
	@Column( name = "privilege" ,length = 500 )
	private String privilege;	
	
	@Column( name = "unionid" ,length = 120 )
	private String unionid;

	@Column(name = "accessToken" ,length = 512)
	private String accessToken;

	@Column( name = "tokenTime" ,length = 120 )
	private String tokenTime;

	@Column( name = "refreshToken" ,length = 120 )
	private String refreshToken;

	@Column( name = "scope" ,length = 120 )
	private String scope;
	
	public User(Integer id, String openid, String nickname, Integer sex, String province, String city, String county, String headImgUrl, String privilege, String unionid){
		this.id = id;
		this.openid = openid;
		this.nickname = nickname;
		this.sex = sex;
		this.province = province;
		this.city = city;
		this.county = county;
		this.headImgUrl = headImgUrl;
		this.privilege = privilege;
		this.unionid = unionid;
	}
	public void setId( Integer id ) {
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	}
	public void setOpenid( String openid ) {
		this.openid = openid;
	}
	public String getOpenid() {
		return this.openid;
	}
	public void setNickname( String nickname ) {
		this.nickname = nickname;
	}
	public String getNickname() {
		return this.nickname;
	}
	public void setSex( Integer sex ) {
		this.sex = sex;
	}
	public Integer getSex() {
		return this.sex;
	}
	public void setProvince( String province ) {
		this.province = province;
	}
	public String getProvince() {
		return this.province;
	}
	public void setCity( String city ) {
		this.city = city;
	}
	public String getCity() {
		return this.city;
	}
	public void setCounty( String county ) {
		this.county = county;
	}
	public String getCounty() {
		return this.county;
	}
	public void setHeadImgUrl( String headImgUrl ) {
		this.headImgUrl = headImgUrl;
	}
	public String getHeadImgUrl() {
		return this.headImgUrl;
	}
	public void setPrivilege( String privilege ) {
		this.privilege = privilege;
	}
	public String getPrivilege() {
		return this.privilege;
	}
	public void setUnionid( String unionid ) {
		this.unionid = unionid;
	}
	public String getUnionid() {
		return this.unionid;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenTime() {
		return tokenTime;
	}

	public void setTokenTime(String tokenTime) {
		this.tokenTime = tokenTime;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
}
