package org.launchcode.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "helloLog")
public class HelloLog {
	
	private String name;
	private Date timeStamp;
	private int uid;
	
	public HelloLog(String name) {
		this.name = name;
		this.timeStamp = new Date();
	}
	
	// no-argument constructor
	// required for hibernate
	public HelloLog() {}
	
	@Id // makes this a "primary key"
	@GeneratedValue // tells Hibernate to create a value for us
	@NotNull // required value
	@Column(name = "uid", unique = true)
	public int getUid() {
		return this.uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	@Column(name = "name") // names data (similar to the key in python)
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@NotNull // makes value "required"
	@Column(name = "timeStamp") // names data (similar to the key in python)
	public Date getTimeStamp() {
		return this.timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

}
