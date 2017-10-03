package com.ihs.ats.api;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ForeignKey;
import com.ihs.ats.api.User;

//TODO change the table name to leave

@Entity
@Table(name = "leavemanagement")
public class Leave {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int leaveId;
	
	
	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	@JoinColumn (name = "UserId")
	@ForeignKey (name = "Leave_By_User")
	private User userId;
	
	public void setUserId(User id){
		this.userId = id;
	}
	
	public User getUserId(){
		return userId;
	}
	
	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}
	@Column(length = 30)
	private String leaveType;
	
	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public Date getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

	@Temporal(TemporalType.DATE)
	private Date leaveDate;
}
