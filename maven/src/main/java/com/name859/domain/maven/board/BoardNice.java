package com.name859.domain.maven.board;

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
import com.name859.domain.maven.user.User;

@Entity
@Table(name = "board_nice")
@TableGenerator(name = "user_id_sequence", table = "id_sequence", pkColumnName = "id_option", pkColumnValue = "user", allocationSize = 1)
public class BoardNice extends GeneralVitalDomain {

	/**
	 * serialVersionUID = 1059497939653935545L
	 */
	private static final long serialVersionUID = 1059497939653935545L;
	
	@Id @GeneratedValue(strategy = GenerationType.TABLE, generator = "user_id_sequence")
	@Column(name = "board_nice_id")
	private Long boardNiceId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "board_id")
	public Board board;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public User user;
	
	public BoardNice() {}
	
	public void setBoard(Board board) {
		this.board = board;
		board.getBoardNiceList().add(this);
	}
	
	public void setUser(User user) {
		this.user = user;
		user.getBoardNiceList().add(this);
	}
	
	public Long getBoardNiceId() {
		return boardNiceId;
	}
	
	public void setBoardNiceId(Long boardNiceId) {
		this.boardNiceId = boardNiceId;
	}
	
	public Board getBoard() {
		return board;
	}
	
	public User getUser() {
		return user;
	}
	
	@Override
	public String toString() {
		return "BoardNice [boardNiceId=" + boardNiceId
				+ ", vital=" + this.getVital()
				+ ", addTime=" + this.getAddTime() + ", modifyTime=" + this.getModifyTime() + "]";
	}
	
}
