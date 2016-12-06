package com.huashan.core.beans;

import com.huashan.core.base.AbstractItem;
import com.huashan.core.base.ItemBase;

import javax.persistence.*;

/**
 *
 * @author lixu
 * 
 * Fri Aug 12 16:41:21 CST 2016
 */
@Entity
@Table(name = "db_wechat_user")
public class WechatUser extends AbstractItem implements ItemBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public WechatUser(){}
	
	@Column( name = "id" , nullable=false ,length = 11)
	@Id
	@GeneratedValue
	private Integer id;	
	
	@Column( name = "AppID" , nullable=false ,length = 200)
	private String appID;	
	
	@Column( name = "AppSecret" , nullable=false ,length = 200)
	private String appSecret;	
	
	@Column( name = "grant_type" , nullable=false ,length = 300)
	private String grantType;	
	
	@Column( name = "access_token" , nullable=false ,length = 1000)
	private String accessToken;	
	
	@Column( name = "expires_h" ,length = 11 )
	private Integer expiresH;

	@Column( name = "url" , length = 500)
	private String url;
	
	public WechatUser(Integer id, String appID, String appSecret, String grantType, String accessToken, Integer expiresH){
		this.id = id;
		this.appID = appID;
		this.appSecret = appSecret;
		this.grantType = grantType;
		this.accessToken = accessToken;
		this.expiresH = expiresH;
	}
	public void setId( Integer id ) {
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	}
	public void setAppID( String appID ) {
		this.appID = appID;
	}
	public String getAppID() {
		return this.appID;
	}
	public void setAppSecret( String appSecret ) {
		this.appSecret = appSecret;
	}
	public String getAppSecret() {
		return this.appSecret;
	}
	public void setGrantType( String grantType ) {
		this.grantType = grantType;
	}
	public String getGrantType() {
		return this.grantType;
	}
	public void setAccessToken( String accessToken ) {
		this.accessToken = accessToken;
	}
	public String getAccessToken() {
		return this.accessToken;
	}
	public void setExpiresH( Integer expiresH ) {
		this.expiresH = expiresH;
	}
	public Integer getExpiresH() {
		return this.expiresH;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
