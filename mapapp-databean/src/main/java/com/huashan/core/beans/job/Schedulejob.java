package com.huashan.core.beans.job;

import com.huashan.core.base.AbstractItem;
import com.huashan.core.base.ItemBase;

import javax.persistence.*;
import java.util.Date;

/**
 * 
 * 
 * @author lixu
 * 
 * Fri Aug 12 17:38:14 CST 2016
 */
@Entity
@Table(name = "db_schedulejob")
public class Schedulejob extends AbstractItem implements ItemBase {

	public static final String STATUS_RUNNING = "1";
	public static final String STATUS_NOT_RUNNING = "0";
	public static final String CONCURRENT_IS = "0";
	public static final String CONCURRENT_NOT = "1"; //有状态、会等上一次执行完再执行
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Schedulejob(){}
	
	@Column( name = "createTime"  )
	private Date createTime;

	@Column( name = "id" ,length = 11)
	@Id
	@GeneratedValue
	private Integer id;

	@Column( name = "updateTime"  )
	private Date updateTime;	
	
	@Column( name = "jobName" , nullable=false ,length = 200)
	private String jobName;	
	
	@Column( name = "jobGroup" , nullable=false ,length = 200)
	private String jobGroup;	
	
	@Column( name = "jobStatus" , nullable=false ,length = 11)
	private Integer jobStatus;	
	
	@Column( name = "cronExpression" , nullable=false ,length = 120)
	private String cronExpression;	
	
	@Column( name = "memo" ,length = 200 )
	private String memo;	
	
	@Column( name = "beanClass" , nullable=false ,length = 120)
	private String beanClass;	
	
	@Column( name = "isConcurrent" , nullable=false ,length = 11)
	private Integer isConcurrent;	
	
	@Column( name = "methodName" , nullable=false ,length = 60)
	private String methodName;	
	
	public Schedulejob(Integer id, Date createTime, Date updateTime, String jobName, String jobGroup, Integer jobStatus, String cronExpression, String memo, String beanClass, Integer isConcurrent, String methodName){
		this.id = id;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.jobName = jobName;
		this.jobGroup = jobGroup;
		this.jobStatus = jobStatus;
		this.cronExpression = cronExpression;
		this.memo = memo;
		this.beanClass = beanClass;
		this.isConcurrent = isConcurrent;
		this.methodName = methodName;
	}
	public void setId( Integer id ) {
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	}
	public void setCreateTime( Date createTime ) {
		this.createTime = createTime;
	}
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setUpdateTime( Date updateTime ) {
		this.updateTime = updateTime;
	}
	public Date getUpdateTime() {
		return this.updateTime;
	}
	public void setJobName( String jobName ) {
		this.jobName = jobName;
	}
	public String getJobName() {
		return this.jobName;
	}
	public void setJobGroup( String jobGroup ) {
		this.jobGroup = jobGroup;
	}
	public String getJobGroup() {
		return this.jobGroup;
	}
	public void setJobStatus( Integer jobStatus ) {
		this.jobStatus = jobStatus;
	}
	public Integer getJobStatus() {
		return this.jobStatus;
	}
	public void setCronExpression( String cronExpression ) {
		this.cronExpression = cronExpression;
	}
	public String getCronExpression() {
		return this.cronExpression;
	}
	public void setMemo( String memo ) {
		this.memo = memo;
	}
	public String getMemo() {
		return this.memo;
	}
	public void setBeanClass( String beanClass ) {
		this.beanClass = beanClass;
	}
	public String getBeanClass() {
		return this.beanClass;
	}
	public void setIsConcurrent( Integer isConcurrent ) {
		this.isConcurrent = isConcurrent;
	}
	public Integer getIsConcurrent() {
		return this.isConcurrent;
	}
	public void setMethodName( String methodName ) {
		this.methodName = methodName;
	}
	public String getMethodName() {
		return this.methodName;
	}


}
