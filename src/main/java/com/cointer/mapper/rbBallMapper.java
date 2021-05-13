package com.cointer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cointer.pojo.po.rbBall;
import com.cointer.pojo.po.rbBallBet;
@Mapper
public interface rbBallMapper {


	@Select("select * from rbball where period=#{period} and issue=#{issue}")
	public List<rbBall> currRbBall(int period,long issue);

	@Insert("insert into rbball(period,issue,time,lotteryPool,lotteryPrice,totalWin,isDraw) values (#{period},#{issue},#{time},#{lotteryPool},#{lotteryPrice},#{totalWin},#{isDraw})")
	public int  initRbBall(rbBall rbBall);
	
	@Update("update rbball set lotteryResult=#{lotteryResult},lotteryPool=#{lotteryPool},lotteryPrice=#{lotteryPrice},totalWin=#{totalWin} ,isDraw=#{isDraw} where period=#{period} and issue=#{issue}")
	public int  updateRbBall(rbBall rbBall);
	
	@Insert("insert into rbballbet(uid,coin,period,issue,bet,time) values (#{uid},#{coin},#{period},#{issue},#{bet},#{time})")
	public int  laid(rbBallBet rbBallBet);
	
//	@Select("select id,uid,coin,issue,bet,time from rbballbet where uid=#{uid} and issue=#{issue}")
//	public List<rbBallBet> currBets(int uid,long issue);

	@Select("select id,uid,coin,issue,bet,time from rbballbet where uid=#{uid} and period=#{period}")
	public List<rbBallBet> myBets(int uid,int period);
	
	@Select("select sum(coin) as total from rbballbet where uid=#{uid} and period=#{period} and issue=#{issue} and bet=#{bet}")
	public Integer coinByBet(int uid,int period,long issue,String bet);
	
	
	@Delete("delete from rbball where time < #{time}")
	public int cleanRbball(long time);
	
	@Delete("delete from rbballbet where time < #{time}")
	public int cleanRbballBets(long time);
	

	
	
}
