package com.ihs.ats.api;

import java.util.Date;

import com.ihs.ats.api.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ForeignKey;


@Entity
@Table (name = "attendance")
public class Attendance {
	
	@Id
	private int attendanceId;
//	
//	private int	userId;

	@ManyToOne (targetEntity = User.class, fetch = FetchType.LAZY)
	@JoinColumn (name = "userId")
	@ForeignKey (name = "User_Attendance_FK")
	private User user;
	
	private int workGroupTypeId;
	
	
	public int getWorkGroupTypeId() {
		return workGroupTypeId;
	}

	public void setWorkGroupTypeId(int workGroupTypeId) {
		this.workGroupTypeId = workGroupTypeId;
	}

	public Date getAssignedCheckIn() {
		return assignedCheckIn;
	}

	public void setAssignedCheckIn(Date assignedCheckIn) {
		this.assignedCheckIn = assignedCheckIn;
	}

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = WorkGroupType.class, optional = false)
	@JoinColumn(name = "workGroupTypeId", insertable = false, updatable = false)
	@ForeignKey(name = "workGroupId_fk")
	private WorkGroupType wgt;
	
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

	@Column(name = "laxTime",length = 30)
	private String laxTime;
	
	public String getLaxTime() {
		return laxTime;
	}

	public void setLaxTime(String laxTime) {
		this.laxTime = laxTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	private Date checkIn;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date checkOut;
	
	@Temporal(TemporalType.TIME)
	private Date assignedCheckIn;
	
	@Temporal(TemporalType.TIME)
	private Date assignedCheckOut;
	
	public Date getAssignedCheckOut() {
		return assignedCheckOut;
	}

	public void setAssignedCheckOut(Date assignedCheckOut) {
		this.assignedCheckOut = assignedCheckOut;
	}

	@Column(length = 30)
	private String latitude;
	
	@Column(length = 30)
	private String longitude;
	
	@Column(length = 30)
	private String geopoint;
//	
//	public int getUserId() {
//		return userId;
//	}
//
//	public void setUserId(int mappedId) {
//		this.userId = mappedId;
//	}

	public void setWgt(WorkGroupType wgt) {
		this.wgt = wgt;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getGeopoint() {
		return geopoint;
	}

	public void setGeopoint(String geopoint) {
		this.geopoint = geopoint;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column
	private String status;
	
	@Column
	private String description;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
