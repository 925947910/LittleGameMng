package com.cointer.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cointer.pojo.po.bills;
import com.cointer.pojo.vo.billsInfo;
@Mapper
public interface billsMapper {

	
	@Select("select * from bills where  uid=#{uid} and (type=#{type1} or type=#{type2})")    
	List<billsInfo> billsListByTypes(int uid,int type1,int type2);
	
	@Select("select * from bills where  uid=#{uid} and time BETWEEN #{begin} and #{end} order by time DESC")    
	List<billsInfo> billsList(int uid,long begin, long end);
    
    @Insert("insert into bills(id,nick,uid,agentId,remain,cost,type,tagId,accountOut,accountIn,reason,time) values (#{id},#{nick},#{uid},#{agentId},#{remain},#{cost},#{type},#{tagId},#{accountOut},#{accountIn},#{reason},#{time})")
	public int  writeBills(bills bills);
    
    
	@Delete("delete from bills where time < #{time} and (type!=#{type1} or type!=#{type2})")
	public int cleanBills(long time,int type1, int type2);
    
    
    
    
}
