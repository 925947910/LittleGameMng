package com.cointer.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cointer.pojo.dto.freezeDto;
import com.cointer.pojo.po.freeze;
import com.cointer.pojo.vo.freezeInfo;
@Mapper
public interface freezeMapper {

	@Select("SELECT freeze.uid AS uid,freeze.orderId AS orderId,freeze.coin AS coin,freeze.orderType AS orderType,tradeOrder.time AS time,tradeOrder.orderLocal AS orderLocal,tradeOrder.orderRemote AS orderRemote,tradeOrder.plat AS plat FROM freeze LEFT JOIN tradeOrder ON (freeze.id = tradeOrder.freezeId) where freeze.id = #{freezeId}")
	public List<freezeDto> freezeDTOById(int freezeId);

	@Insert("insert into freeze(id,uid,orderId,coin,orderType,time) values (#{id},#{uid},#{orderId},#{coin},#{orderType},#{time})")
	public int  insertFreeze(freeze freeze);

	@Delete("delete from freeze where id= #{id} ")
	public int delFreeze(int id);
	
	@Select("select * from freeze where uid=#{uid}")    
	List<freezeInfo> freezeList(int uid);

	
}
