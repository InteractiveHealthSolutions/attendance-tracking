package com.ihs.ats.api;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Working {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int WorkingId;
	
	public int getWorkingId(){
		return WorkingId;
	}
	
	public void setWorkingId(int id){
		this.WorkingId = id;
	}
	
	private int mappedId;
	
	public int getMappedId(){
		return mappedId;
	}
	
	public void setMappedId(int m_id){
		this.mappedId = m_id;
	}
	
	private String Description;
	
	public void setDescription(String desc){
		this.Description = desc;
	}
	
	public String getDescription(){
		return Description;
	}
	
}
  
