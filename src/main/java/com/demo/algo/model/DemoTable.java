package com.demo.algo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="demotable")
public class DemoTable implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	private Long Id;

	@Column(name="Unsorted")
	private String unsorted;
	
	@Column(name="Sorted")
	private String sorted;
 
	@Column(name="Duration")
	private Long duration;

	@Column(name="Swaps")
	private Long swaps;
    
	public DemoTable() {
		super();
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getUnsorted() {
		return unsorted;
	}


	public void setUnsorted(String unsorted) {
		this.unsorted = unsorted;
	}


	public String getSorted() {
		return sorted;
	}


	public void setSorted(String sorted) {
		this.sorted = sorted;
	}


	public Long getDuration() {
		return duration;
	}


	public void setDuration(Long duration) {
		this.duration = duration;
	}


	public Long getSwaps() {
		return swaps;
	}


	public void setSwaps(Long swaps) {
		this.swaps = swaps;
	}


	}