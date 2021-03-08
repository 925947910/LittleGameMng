package com.cointer.pojo.po;

public class rbBall {
	private   Integer  id;
	private   Long     issue;
	private   String   lotteryResult; 
	private   Integer  lotteryPool;
	private   Integer  lotteryPrice;
	private   Long     time;
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getIssue() {
		return issue;
	}
	public void setIssue(Long issue) {
		this.issue = issue;
	}
	public String getLotteryResult() {
		return lotteryResult;
	}
	public void setLotteryResult(String lotteryResult) {
		this.lotteryResult = lotteryResult;
	}
	public Integer getLotteryPool() {
		return lotteryPool;
	}
	public void setLotteryPool(Integer lotteryPool) {
		this.lotteryPool = lotteryPool;
	}
	public Integer getLotteryPrice() {
		return lotteryPrice;
	}
	public void setLotteryPrice(Integer lotteryPrice) {
		this.lotteryPrice = lotteryPrice;
	}
    

}
