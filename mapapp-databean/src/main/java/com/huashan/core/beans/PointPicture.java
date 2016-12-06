package com.huashan.core.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.huashan.core.base.AbstractItem;
import com.huashan.core.base.ItemBase;

/**
 * 
 * 
 * @author lixu
 * 
 * Wed Oct 26 23:13:48 CST 2016
 */
@Entity
@Table(name = "db_pointPicture")
public class PointPicture extends AbstractItem implements ItemBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PointPicture (){}
	
	@Column( name = "id" , nullable=false ,length = 11)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	
	@Column( name = "picture" , nullable=false ,length = 260)
	private String picture;	
	
	@Column( name = "pointInfoId" , nullable=false ,length = 11)
	private Integer pointInfoId;	
	
	@Column( name = "status" , nullable=false ,length = 11)
	private Integer status;	
	
	public PointPicture( Integer id,String picture,Integer pointInfoId,Integer status ){
		this.id = id;
		this.picture = picture;
		this.pointInfoId = pointInfoId;
		this.status = status;
	}
	public void setId( Integer id ) {
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	}
	public void setPicture( String picture ) {
		this.picture = picture;
	}
	public String getPicture() {
		return this.picture;
	}
	public void setPointInfoId( Integer pointInfoId ) {
		this.pointInfoId = pointInfoId;
	}
	public Integer getPointInfoId() {
		return this.pointInfoId;
	}
	public void setStatus( Integer status ) {
		this.status = status;
	}
	public Integer getStatus() {
		return this.status;
	}


}
