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
 * Wed Oct 26 23:21:08 CST 2016
 */
@Entity
@Table(name = "db_pointTxt")
public class PointTxt extends AbstractItem implements ItemBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PointTxt (){}
	
	@Column( name = "id" , nullable=false ,length = 11)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	
	@Column( name = "document" , nullable=false ,length = 8000)
	private String document;	
	
	@Column( name = "pointInfoId" , nullable=false ,length = 11)
	private Integer pointInfoId;	
	
	@Column( name = "status" , nullable=false ,length = 11)
	private Integer status;	
	
	public PointTxt( Integer id,String document,Integer pointInfoId,Integer status ){
		this.id = id;
		this.document = document;
		this.pointInfoId = pointInfoId;
		this.status = status;
	}
	public void setId( Integer id ) {
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	}
	public void setDocument( String document ) {
		this.document = document;
	}
	public String getDocument() {
		return this.document;
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
