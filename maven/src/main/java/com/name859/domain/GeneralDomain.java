package com.name859.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public abstract class GeneralDomain implements Comparable<GeneralDomain>, Serializable {

	/**
	 * serialVersionUID = 339591641690326997L
	 */
	private static final long serialVersionUID = 339591641690326997L;
	
	@Column(name = "add_time", nullable = false)
	private Date addTime;
	
	@Column(name = "modify_time", nullable = false)
	private Date modifyTime;
	
	@Override
	public int compareTo(GeneralDomain domain) {
		return this.getAddTime().compareTo(domain.getAddTime());
	}
	
	/**
	 * Method To Run Before Insert Into Database <=> @PostPersist
	 */
	@PrePersist
	public void prePersist() {
		addTime = modifyTime = new Date();
	}
	
	/**
	 * Method To Run Before Update To The Database <=> @PostUpdate
	 */
	@PreUpdate
	public void preUpdate() {
		modifyTime = new Date();
	}
	
	/**
	 * Method To Run Before Delete The Database <=> @PostRemove
	 */
//	@PreRemove
//	public void preRemove() {}
	
	/**
	 * Method To Run After Select In The Database
	 */
//	@PostLoad
//	public void postLoad() {}
	
	public Date getAddTime() {
		return addTime;
	}
	
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	
	public Date getModifyTime() {
		return modifyTime;
	}
	
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	
}
