package com.name859.domain.maven.comment;

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

import com.name859.domain.GeneralVitalDomain;
import com.name859.domain.maven.board.Board;
import com.name859.domain.maven.user.User;

@Entity
@Table(name = "comment")
@TableGenerator(name = "user_id_sequence", table = "id_sequence", pkColumnName = "id_option", pkColumnValue = "user", allocationSize = 1)
public class Comment extends GeneralVitalDomain {

	/**
	 * serialVersionUID = 1908513328591237297L
	 */
	private static final long serialVersionUID = 1908513328591237297L;
	
	@Id @GeneratedValue(strategy = GenerationType.TABLE, generator = "user_id_sequence")
	@Column(name = "comment_id")
	private Long commentId;
	
	@Column(length = 5000, nullable = false)
	private String comment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "board_id")
	private Board board;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	public Comment() {}
	
	public void setBoard(Board board) {
		this.board = board;
		board.getCommentList().add(this);
	}
	
	public void setUser(User user) {
		this.user = user;
		user.getCommentList().add(this);
	}
	
	public Long getCommentId() {
		return commentId;
	}
	
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public Board getBoard() {
		return board;
	}
	
	public User getUser() {
		return user;
	}
	
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", comment=" + comment
				+ ", vital=" + this.getVital()
				+ ", addTime=" + this.getAddTime() + ", modifyTime=" + this.getModifyTime() + "]";
	}
	
}
