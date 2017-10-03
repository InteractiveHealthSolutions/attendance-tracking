package com.ihs.ats.api;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "publicholiday")
public class PublicHoliday {
	
	@Id
	private int IdPH;
	
	@Column(length = 30)
	private String typePH;
	
	@Temporal(TemporalType.DATE)
	private Date datePH;

	public int getIdPH() {
		return IdPH;
	}

	public void setIdPH(int idPH) {
		IdPH = idPH;
	}

	public String getTypePH() {
		return typePH;
	}

	public void setTypePH(String typePH) {
		this.typePH = typePH;
	}

	public Date getDatePH() {
		return datePH;
	}

	public void setDatePH(Date datePH) {
		this.datePH = datePH;
	}
	}
