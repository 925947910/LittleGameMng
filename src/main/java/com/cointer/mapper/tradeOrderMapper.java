package com.cointer.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cointer.pojo.po.tradeOrder;
import com.cointer.trans.TransExchange;
@Mapper
public interface tradeOrderMapper {

	
	@Select("SELECT * FROM tradeorder WHERE id = #{orderId}")
	public List<tradeOrder> tradeOrderById(int orderId);
	
	@Select("SELECT * FROM tradeorder WHERE orderLocal = #{orderLocal}")
	public List<tradeOrder> tradeOrderByOrderLocal(String orderLocal);  
	
	@Select("SELECT id,status  FROM tradeorder WHERE orderRemote = #{orderRemote}")
	public List<tradeOrder> OrderStatusByOrderRemote(String orderRemote); 
	
	
	@Update("update tradeorder set status=#{status} ,freezeId=#{freezeId} where id=#{id} and status=#{needStatus}")
	public int  updateStatusWithFreezeId(int id,int needStatus, int status,int freezeId);
	
	@Update("update tradeorder set status=#{status}  where orderLocal=#{order} and status=#{needStatus}")
	public int  updateStatusByOrder(String order,int needStatus, int status);
	
	@Update("update tradeorder set status=#{status} ,cost=#{cost}  where orderLocal=#{order} and status=#{needStatus}")
	public int  updateStatusCostByOrder(String order,float cost,int needStatus, int status);
	
	
	@Update("update tradeorder set status=#{status}  where id=#{id} ")
	public int  updateStatus(int id, int status);
    
	@Update("update tradeorder set orderRemote=#{orderRemote}  where id=#{id}")
	public int  updateOrderRemote(int id,String orderRemote);

	@Insert("insert into tradeorder(id,uid,agentId,presenterId,freezeId,coin,cost,accountOut,accountIn,orderLocal,orderRemote,plat,currency,orderType,time,status) values (#{id},#{uid},#{agentId},#{presenterId},#{freezeId},#{coin},#{cost},#{accountOut},#{accountIn},#{orderLocal},#{orderRemote},#{plat},#{currency},#{orderType},#{time},#{status})")
	public int  insertTradeOrder(tradeOrder tradeOrder);

	@Delete("delete from tradeorder where time < #{time} and orderType=1 and status !=3")
	public int cleanTradeorderIn(long time);
	@Delete("delete from tradeorder where time < #{time} and orderType=2 and status =4")
	public int cleanTradeorderOut(long time);
	@Delete("delete from tradeorder where time < #{time}")
	public int cleanTradeorder(long time);
}
