package com.cointer.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cointer.pojo.po.tradeOrder;
import com.cointer.trans.TransExchange;
@Mapper
public interface tradeOrderMapper {

	@Select("SELECT id,uid,freezeId,coin FROM tradeOrder WHERE orderLocal = #{orderLocal}")
	public List<tradeOrder> tradeOrderByOrderLocal(String orderLocal);  
	
	@Select("SELECT id,status  FROM tradeOrder WHERE orderRemote = #{orderRemote}")
	public List<tradeOrder> OrderStatusByOrderRemote(String orderRemote); 
	
	
	@Update("update tradeOrder set status=#{status} ,freezeId=#{freezeId} where id=#{id} and status=#{needStatus}")
	public int  updateStatusWithFreezeId(int id,int needStatus, int status,int freezeId);
	
	@Update("update tradeOrder set status=#{status}  where id=#{id} and status=#{needStatus}")
	public int  updateStatusByStatus(int id,int needStatus, int status);

	@Update("update tradeOrder set status=#{status}  where id=#{id} ")
	public int  updateStatus(int id, int status);
    
	@Update("update tradeOrder set status=#{status},orderRemote=#{orderRemote}  where id=#{id} and status=#{needStatus}")
	public int  updateStatusWithOrderRemote(int id,int needStatus, int status,String orderRemote);

	@Insert("insert into tradeOrder(id,uid,coin,accountOut,accountIn,orderType,time,status) values (#{id},#{uid},#{coin},#{accountOut},#{accountIn},#{orderType},#{time},#{status})")
	public int  insertTradeOrder(tradeOrder tradeOrder);

	
}
