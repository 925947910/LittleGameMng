package com.cointer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cointer.pojo.po.crowdFund;
import com.cointer.pojo.po.crowdFundBet;
import com.cointer.pojo.po.gameUser;
import com.cointer.pojo.po.rbBallBet;
@Mapper
public interface crowdFundMapper {


	
	@Insert("insert into crowdfund(issue,name,currBuy,price,picture,time,version) values (#{issue},#{name},#{currBuy},#{price},#{picture},#{time},#{version})")
	public int  initCrowdFund(crowdFund crowdFund);
	
	
	@Select("select id,issue,name,currBuy,price,picture,time,uid,uname,uphoto,uticket from crowdfund where issue=#{issue}")
	public List<crowdFund> crowdFundByIssue(long issue);
	


	@Select("select currBuy,price,version FROM crowdfund where issue = #{issue}")
	public List<crowdFund> checkCurrBuy(long issue);
	
	
	@Update("update crowdfund set currBuy=#{currBuy},version=#{version}+1  where issue=#{issue} and version=#{version}")
	public int  addCurrBuy(long issue,int currBuy, int version);
	
	@Update("update crowdfund set uid=#{uid},uname=#{uname},uphoto=#{uphoto} ,uticket=#{uticket}  where issue=#{issue}")
	public int  addWinner(long issue,int uid,String uname,String uphoto ,String uticket);
	
	
	@Insert("insert into crowdfundbet(issue,uid,name,coin,ticket,time) values (#{issue},#{uid},#{name},#{coin},#{ticket},#{time})")
	public int  addCrowdFundBet(crowdFundBet crowdFundBet);
	
	
	@Select("select id,issue,uid,name,coin,ticket,time from crowdfundbet where issue=#{issue}")
	public List<crowdFundBet> betRecByIssue(long issue);
	
	@Select("select id,issue,uid,name,coin,ticket,time from crowdfundbet where issue=#{issue} and uid=#{uid}")
	public List<crowdFundBet> MybetRec(long issue,int uid);
	
	@Delete("delete from crowdfundbet where time < #{time}")
	public int cleanCrowdfundBet(long time);
	
	
}
