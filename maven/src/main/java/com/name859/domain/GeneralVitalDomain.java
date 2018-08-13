package com.name859.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class GeneralVitalDomain extends GeneralDomain {

	/**
	 * serialVersionUID = 3610449505390517072L
	 */
	private static final long serialVersionUID = 3610449505390517072L;
	
	@Column(columnDefinition = "CHAR(1)", nullable = false)
	private String vital;
	
	public String getVital() {
		return vital;
	}
	
	public void setVital(String vital) {
		this.vital = vital;
	}
	
}
