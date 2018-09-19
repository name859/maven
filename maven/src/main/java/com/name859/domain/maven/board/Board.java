package com.name859.domain.maven.board;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.name859.domain.GeneralVitalDomain;
import com.name859.domain.maven.comment.Comment;
import com.name859.domain.maven.user.User;

@Entity
@Table(name = "board")
@TableGenerator(name = "user_id_sequence", table = "id_sequence", pkColumnName = "id_option", pkColumnValue = "user", allocationSize = 1)
public class Board extends GeneralVitalDomain {

	/**
	 * serialVersionUID = 2249507366855244323L
	 */
	private static final long serialVersionUID = 2249507366855244323L;
	
	@Id @GeneratedValue(strategy = GenerationType.TABLE, generator = "user_id_sequence")
	@Column(name = "board_id")
	private Long boardId;
	
	@Column(length = 1000, nullable = false)
	private String subject;
	
	@Column(columnDefinition = "MEDIUMTEXT", nullable = false)
	private String content;
	
	@Column(name = "group_id")
	private Long groupId;
	
	@Column(name = "reference_id")
	private Long referenceId;
	
	private int sequence;
	private int level;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
	private List<BoardNice> boardNiceList = new ArrayList<BoardNice>();
	
	@OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
	private List<Comment> commentList = new ArrayList<Comment>();
	
	public Board() {}
	
	public void setUser(User user) {
		this.user = user;
		user.getBoardList().add(this);
	}
	
	public Long getBoardId() {
		return boardId;
	}
	
	public void setBoardId(Long boardId) {
		this.boardId = boardId;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
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
		return "Board [boardId=" + boardId + ", subject=" + subject + ", content=" + content + ", groupId=" + groupId
				+ ", referenceId=" + referenceId + ", sequence=" + sequence + ", level=" + level
				+ ", vital=" + this.getVital()
				+ ", addTime=" + this.getAddTime() + ", modifyTime=" + this.getModifyTime() + "]";
	}
	
}
