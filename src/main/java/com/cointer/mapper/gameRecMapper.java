package com.cointer.mapper;



import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import com.cointer.pojo.po.gameRec;


@Mapper
public interface gameRecMapper {


    
    @Insert("insert into gameRec(gameId,recordCode,beginTime) values (#{gameId},#{recordCode},#{beginTime})")
	public int  initGameRec(gameRec gameRec);
	@Update("update gameRec set endTime= #{endTime},gameResult= #{gameResult} where recordCode= #{recordCode} ")
    public int  gameCleanRec(gameRec gameRec);
}
