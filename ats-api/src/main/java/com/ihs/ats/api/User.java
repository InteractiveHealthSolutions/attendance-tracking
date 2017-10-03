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

@Entity
@Table (name = "user")

public class User {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int userId;
	
	public User(){
	}
	
	@Column (length = 30)
	private String nic;
	
	@Column (length = 30)
	private String name;
	
	@Column (length = 30)
	private String voidStatus;
	
	@Temporal (TemporalType.TIMESTAMP)
	@Column (name = "dateVoided")
	private Date voidedDate;
	
	@Column (name = "voidReason" , length = 30)
	private String voidedReason;
	
	public int getUserId(){
		return userId;
	}

	public void setUserId(int number){
		this.userId = number;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName (String Name){
		this.name = Name;
	}
	
	public String getVoidStatus(){
		return voidStatus;
	}
	
	public void setVoidStatus(String status){
		this.voidStatus = status;
	}
	
	public Date getVoidedDate(){
		return voidedDate;
	}
	
	public void setVoidedDate(Date VDate){
		this.voidedDate = VDate;
	}
	
	public String getVoidedReason(){
		return voidedReason;
	}
	
	public void setVoidedReason(String reason){
		this.voidedReason = reason;
	}
	
	public String getNic(){
		return nic;
	}
	
	public void setNic(String NIC){
		this.nic = NIC;
	}
}

