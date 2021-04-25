package com.cointer.pojo.dto;

import java.util.List;

public class staticTask {
	private   Integer  id;
	private   List<Integer> conditions;
	private   List<Integer> priceTypes;
	private   List<Integer> priceNums;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Integer> getConditions() {
		return conditions;
	}
	public void setConditions(List<Integer> conditions) {
		this.conditions = conditions;
	}
	public List<Integer> getPriceTypes() {
		return priceTypes;
	}
	public void setPriceTypes(List<Integer> priceTypes) {
		this.priceTypes = priceTypes;
	}
	public List<Integer> getPriceNums() {
		return priceNums;
	}
	public void setPriceNums(List<Integer> priceNums) {
		this.priceNums = priceNums;
	}
	

}
