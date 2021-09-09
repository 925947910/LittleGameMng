package com.cointer.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cointer.pojo.po.bills;
//import com.cointer.pojo.po.broadCast;
import com.cointer.pojo.dto.staticData;
import com.cointer.pojo.vo.billsInfo;
@Mapper
public interface commonMapper {

	


//	
//	@Select("select * from broadcast where uid=#{uid} order by time  desc limit #{limit}")    
//	List<broadCast> broadCastCommon(int uid,int limit);
	
	@Select("select * from staticdata  where name=#{name} and fid=#{fid}")    
	List<staticData> StaticData(String name,int fid);
	
	@Select("select * from staticdata")    
	List<staticData> AllStaticData();
	
    @Insert("insert into broadcast(uid,text,time) values (#{uid},#{text},#{time})")
	public int  addBroadCast(int uid, String text, long time);
    
    
    
    
}
