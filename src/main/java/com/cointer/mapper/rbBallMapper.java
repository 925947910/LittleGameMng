package com.cointer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cointer.pojo.po.crowdFund;
import com.cointer.pojo.po.rbBall;
import com.cointer.pojo.po.rbBallBet;
@Mapper
public interface rbBallMapper {


	@Select("select id,issue,lotteryResult,lotteryPool,lotteryPrice from rbball where issue=#{issue}")
	public List<rbBall> currRbBall(long issue);

	@Insert("insert into rbball(issue,time,lotteryPool,lotteryPrice) values (#{issue},#{time},#{lotteryPool},#{lotteryPrice})")
	public int  initRbBall(rbBall rbBall);
	
	@Update("update rbball set lotteryResult=#{lotteryResult},lotteryPool=#{lotteryPool},lotteryPrice=#{lotteryPrice} where issue=#{issue}")
	public int  updateRbBall(rbBall rbBall);
	
	
	
	@Insert("insert into rbballbet(uid,coin,issue,bet,time) values (#{uid},#{coin},#{issue},#{bet},#{time})")
	public int  laid(rbBallBet rbBallBet);
	
	@Select("select id,uid,coin,issue,bet,time from rbballbet where uid=#{uid} and issue=#{issue}")
	public List<rbBallBet> currBets(int uid,long issue);

	@Select("select sun(coin) as total from rbballbet where uid=#{uid} and issue=#{issue} and bet=#{bet}")
	public Integer coinByBet(int uid,long issue,String bet);
	
	@Delete("delete from rbballbet where time < #{time}")
	public int cleanRbballBets(long time);
	

	
	
}
