package com.ihs.ats.api;

import java.util.Date;

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
import com.ihs.ats.api.WorkGroupType;

@Entity
@Table (name = "workgroupmapper")
public class WorkGroupMapper {
	@Id
	private int	userId;
	
	@OneToOne(fetch = FetchType.LAZY, targetEntity = User.class, optional = false)
	@PrimaryKeyJoinColumn(name = "userId")
	@ForeignKey(name = "userId_pk_fk")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = WorkGroupType.class, optional = false)
	@JoinColumn(name = "workGroupTypeId", insertable = false, updatable = false)
	@ForeignKey(name = "workGroupTypeiI_FK")
	private WorkGroupType wgt;
	//TODO name change
	
/*	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "lastEditedByUserId")
	@ForeignKey(name = "editedByU_fk")
	private User lastEditedByUserId;
	
	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "createdByUserId")
	@ForeignKey(name = "createdByU_fk")
	private User createdByUserId;
	
	
	public User getLastEditedByUserId() {
		return lastEditedByUserId;
	}

	public void setLastEditedByUserId(User lastEditedByUserId) {
		this.lastEditedByUserId = lastEditedByUserId;
	}

	public User getCreatedByUserId() {
		return createdByUserId;
	}

	public void setCreatedByUserId(User createdByUserId) {
		this.createdByUserId = createdByUserId;
	}
	*/
	
	private int	workGroupTypeId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int mappedId) {
		this.userId = mappedId;
	}

	public int getWorkGroupTypeId() {
		return workGroupTypeId;
	}

	public void setWorkGroupTypeId(int workGroupId) {
		this.workGroupTypeId = workGroupId;
	}

	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastEditedDate() {
		return lastEditedDate;
	}

	public void setLastEditedDate(Date lastEditedDate) {
		this.lastEditedDate = lastEditedDate;
	}

	/** The created date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	/** The last edited date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastEditedDate;
	
}
