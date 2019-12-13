package com.cointer.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cointer.pojo.po.bills;
import com.cointer.pojo.vo.billsInfo;
@Mapper
public interface billsMapper {

	@Select("select * from bills where  uid=#{uid} and time BETWEEN #{begin} and #{end} order by time DESC")    
	List<billsInfo> billsList(int uid,long begin, long end);
    
    @Insert("insert into bills(id,nick,uid,remain,cost,type,tagId,accountOut,accountIn,reason,time) values (#{id},#{nick},#{uid},#{remain},#{cost},#{type},#{tagId},#{accountOut},#{accountIn},#{reason},#{time})")
	public int  writeBills(bills bills);
    
}
