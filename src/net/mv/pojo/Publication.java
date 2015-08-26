package net.mv.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.struts.action.ActionForm;

@Entity
public class Publication{

	@Id
	private int id;
	@Column
	private String name;
	@Column
	private String location;
	@Column
	private String needApproval;
	@Column
	private String approved;
	@Column
	private String requested;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getNeedApproval() {
		return needApproval;
	}
	public void setNeedApproval(String needApproval) {
		this.needApproval = needApproval;
	}
	public String getApproved() {
		return approved;
	}
	public void setApproved(String approved) {
		this.approved = approved;
	}
	public String getRequested() {
		return requested;
	}
	public void setRequested(String requested) {
		this.requested = requested;
	}
	@Override
	public String toString() {
		return "Publication [id=" + id + ", name=" + name + ", location="
				+ location + ", needApproval=" + needApproval + ", approved="
				+ approved + ", requested=" + requested + "]";
	}
	
}
