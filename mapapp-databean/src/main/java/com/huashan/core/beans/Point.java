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
 * Wed Oct 26 23:00:00 CST 2016
 */
@Entity
@Table(name = "db_point")
public class Point extends AbstractItem implements ItemBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Point (){}
	
	@Column( name = "id" , nullable=false ,length = 11)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	
	@Column( name = "longitude" , nullable=false )
	private Double longitude;
	
	@Column( name = "latitude" , nullable=false )
	private Double latitude;
	
	@Column( name = "note" , nullable=false ,length = 120)
	private String note;	
	
	public Point( Integer id,Double longitude,Double latitude,String note ){
		this.id = id;
		this.longitude = longitude;
		this.latitude = latitude;
		this.note = note;
	}
	public void setId( Integer id ) {
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	}
	public void setLongitude( Double longitude ) {
		this.longitude = longitude;
	}
	public Double getLongitude() {
		return this.longitude;
	}
	public void setLatitude( Double latitude ) {
		this.latitude = latitude;
	}
	public Double getLatitude() {
		return this.latitude;
	}
	public void setNote( String note ) {
		this.note = note;
	}
	public String getNote() {
		return this.note;
	}


}
