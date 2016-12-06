package com.huashan.core.beans;

import java.util.Date;

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
 * Tue Nov 01 21:41:24 CST 2016
 */
@Entity
@Table(name = "db_pointLine")
public class PointLine extends AbstractItem implements ItemBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PointLine (){}
	
	@Column( name = "id" , nullable=false ,length = 11)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	
	@Column( name = "pointInfoId" ,length = 11 )
	private Integer pointInfoId;	
	
	@Column( name = "lineId" ,length = 11 )
	private Integer lineId;	
	
	@Column( name = "position" ,length = 11 )
	private Integer position;


	
	public PointLine( Integer id,Integer pointInfoId,Integer lineId,Integer position ){
		this.id = id;
		this.pointInfoId = pointInfoId;
		this.lineId = lineId;
		this.position = position;
	}
	public void setId( Integer id ) {
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	}
	public void setPointInfoId( Integer pointInfoId ) {
		this.pointInfoId = pointInfoId;
	}
	public Integer getPointInfoId() {
		return this.pointInfoId;
	}
	public void setLineId( Integer lineId ) {
		this.lineId = lineId;
	}
	public Integer getLineId() {
		return this.lineId;
	}
	public void setPosition( Integer position ) {
		this.position = position;
	}
	public Integer getPosition() {
		return this.position;
	}
}
