package com.name859.domain.maven.category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.name859.domain.GeneralDomain;
import com.name859.domain.maven.user.User;

@Entity
@Table(name = "category")
@TableGenerator(name = "user_id_sequence", table = "id_sequence", pkColumnName = "id_option", pkColumnValue = "user", allocationSize = 1)
public class Category extends GeneralDomain {

	/**
	 * serialVersionUID = 7085383688509491208L
	 */
	private static final long serialVersionUID = 7085383688509491208L;
	
	@Id @GeneratedValue(strategy = GenerationType.TABLE, generator = "user_id_sequence")
	@Column(name = "category_id")
	private Long categoryId;
	
	@Column(length = 100, nullable = false)
	private String name;
	
	@Column(length = 1000)
	private String note;
	
	@Column(name = "group_id")
	private Long groupId;
	
	@Column(name = "reference_id")
	private Long referenceId;
	
	private int sequence;
	private int level;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	public Category() {}
	
	public void setUser(User user) {
		this.user = user;
		user.getCategoryList().add(this);
	}
	
	public Long getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	public Long getGroupId() {
		return groupId;
	}
	
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	
	public Long getReferenceId() {
		return referenceId;
	}
	
	public void setReferenceId(Long referenceId) {
		this.referenceId = referenceId;
	}
	
	public int getSequence() {
		return sequence;
	}
	
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public User getUser() {
		return user;
	}
	
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name + ", note=" + note + ", groupId=" + groupId
				+ ", referenceId=" + referenceId + ", sequence=" + sequence + ", level=" + level
				+ ", addTime=" + this.getAddTime() + ", modifyTime=" + this.getModifyTime() + "]";
	}
	
}
