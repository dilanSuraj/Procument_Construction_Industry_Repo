package com.procument.construction.industry.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "site")
public class Site {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long siteid;

    @Column(name = "location")
    private String location;

    @Column(name = "budget")
    private double budget;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_employee_id", referencedColumnName = "employee_id")
    private Employee employee_employee_id;

	public Long getSiteid() {
		return siteid;
	}

	public void setSiteid(Long siteid) {
		this.siteid = siteid;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public Employee getEmployee_employee_id() {
		return employee_employee_id;
	}
	

	public void setEmployee_employee_id(Employee employee_employee_id) {
		this.employee_employee_id = employee_employee_id;
	}

	@Override
	public String toString() {
		return "Site [siteid=" + siteid + ", location=" + location + ", budget=" + budget + ", employee_employee_id="
				+ employee_employee_id + "]";
	}
    
	
    
    
}
