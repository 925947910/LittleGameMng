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

	

	
	@Select("select * from bills where  uid=#{uid} and type=#{type} ")    
	List<billsInfo> billsByType(int uid,int type);
	
	@Select("select * from bills where  uid=#{uid} and (type=#{type1} or type=#{type2} or type=#{type3} or type=#{type4})")    
	List<billsInfo> billsListByTypes(int uid,int type1,int type2,int type3,int type4);
	
	@Select("select * from bills where  uid=#{uid} and time BETWEEN #{begin} and #{end} order by time DESC")    
	List<billsInfo> billsList(int uid,long begin, long end);
    
    @Insert("insert into bills(id,nick,uid,agentId,remain,cost,type,tagId,accountOut,accountIn,reason,time) values (#{id},#{nick},#{uid},#{agentId},#{remain},#{cost},#{type},#{tagId},#{accountOut},#{accountIn},#{reason},#{time})")
	public int  writeBills(bills bills);
    
    
	@Delete("delete from bills where time < #{time}")
	public int cleanBills(long time);
    
    
    
    
}
