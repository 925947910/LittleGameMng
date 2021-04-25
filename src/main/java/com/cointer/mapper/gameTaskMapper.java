package com.cointer.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cointer.pojo.po.gameTask;
@Mapper
public interface gameTaskMapper {

	
	@Select("select * from gametask where  uid=#{uid}")    
	public List<gameTask> getTask(int uid);
	
	@Select("select * from gametask where  uid=#{uid} and taskId=#{taskId}")    
	public List<gameTask> getTaskByType(int uid,int taskId);
    
    @Insert("insert into gametask(taskId,uid,schedul,step) values (#{taskId},#{uid},#{schedul},#{step})")
	public int  initTask(gameTask gameTask);
    
    
    @Update("update gametask set schedul=#{schedul} where  id=#{id}")
	public int  Onschedul(int id,int schedul);
    
    @Update("update gametask set step=#{step} where  id=#{id}")
	public int  onStep(int id,int step);
    
    
    

    
    
    
}
