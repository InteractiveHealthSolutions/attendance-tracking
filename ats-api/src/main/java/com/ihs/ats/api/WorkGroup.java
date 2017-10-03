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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ForeignKey;
import com.ihs.ats.api.WorkGroupType;

@Entity
@Table (name = "workgroup")
public class WorkGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int	workGroupId;
	
	private int workGroupTypeId;
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = WorkGroupType.class)
	@JoinColumn(name = "workGroupTypeId", insertable = false, updatable = false)
	@ForeignKey(name = "workGroupTypeId_FK")
	private WorkGroupType wgt; //TODO change name
	
	@Column(length = 30)
	private String day;
	
	@Temporal(TemporalType.TIME)
	private Date assignedCheckIn;
	
	@Temporal(TemporalType.TIME)
	private Date assignedCheckOut;
	
	//TODO laxtime change it to int
	@Column(name = "laxTime",length = 30)
	private String laxTime;
	
	public String getLaxTime() {
		return laxTime;
	}

	public void setLaxTime(String laxTime) {
		this.laxTime = laxTime;
	}

	public int getWorkGroupId() {
		return workGroupId;
	}

	public void setWorkGroupId(int workGroupId) {
		this.workGroupId = workGroupId;
	}

	public WorkGroupType getWgt() {
		return wgt;
	}

	public void setWgt(WorkGroupType wgt) {
		this.wgt = wgt;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Date getAssignCheckIn() {
		return assignedCheckIn;
	}

	public void setAssignCheckIn(Date assignCheckIn) {
		this.assignedCheckIn = assignCheckIn;
	}

	public Date getAssignCheckOut() {
		return assignedCheckOut;
	}

	public void setAssignCheckOut(Date assignCheckOut) {
		this.assignedCheckOut = assignCheckOut;
	}

	public int getWorkGroupTypeId() {
		return workGroupTypeId;
	}

	public void setWorkGroupTypeId(int workGroupTypeId) {
		this.workGroupTypeId = workGroupTypeId;
	}
	
	/** The created date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	/** The last edited date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastEditedDate;

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
	
}
