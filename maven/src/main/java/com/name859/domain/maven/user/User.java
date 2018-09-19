package com.name859.domain.maven.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.name859.domain.GeneralVitalDomain;
import com.name859.domain.maven.board.Board;
import com.name859.domain.maven.board.BoardNice;
import com.name859.domain.maven.comment.Comment;

@Entity
@Table(name = "user")
@TableGenerator(name = "user_id_sequence", table = "id_sequence", pkColumnName = "id_option", pkColumnValue = "user", allocationSize = 1)
public class User extends GeneralVitalDomain {

	/**
	 * serialVersionUID = 3767063337153622161L
	 */
	private static final long serialVersionUID = 3767063337153622161L;
	
	@Id @GeneratedValue(strategy = GenerationType.TABLE, generator = "user_id_sequence")
	@Column(name = "user_id")
	private Long userId;
	
	@Column(length = 30, nullable = false)
	private String name;
	
	@Column(length = 100, nullable = false)
	private String password;
	
	@Column(length = 255)
	private String mail;
	
	@Column(length = 30)
	private String phone;
	
	@Column(length = 255)
	private String photo;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Board> boardList = new ArrayList<Board>();
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<BoardNice> boardNiceList = new ArrayList<BoardNice>();
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Comment> commentList = new ArrayList<Comment>();
	
	public User() {}
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPhoto() {
		return photo;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public List<Board> getBoardList() {
		return boardList;
	}
	
	public void setBoardList(List<Board> boardList) {
		this.boardList = boardList;
	}
	
	public List<BoardNice> getBoardNiceList() {
		return boardNiceList;
	}
	
	public void setBoardNiceList(List<BoardNice> boardNiceList) {
		this.boardNiceList = boardNiceList;
	}
	
	public List<Comment> getCommentList() {
		return commentList;
	}
	
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", password=" + password + ", mail=" + mail + ", phone="
				+ phone + ", photo=" + photo
				+ ", vital=" + this.getVital()
				+ ", addTime=" + this.getAddTime() + ", modifyTime=" + this.getModifyTime() + "]";
	}
	
}
