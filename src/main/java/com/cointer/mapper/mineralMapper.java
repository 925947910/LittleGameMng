package com.cointer.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cointer.pojo.po.gamePresenter;
import com.cointer.pojo.po.mineralBills;
import com.cointer.pojo.po.mineralCode;
import com.cointer.pojo.po.userMineral;

@Mapper
public interface mineralMapper {


	@Select("select * from userMineral where uid=#{uid}")    
	List<userMineral> getUserMineral(int uid);
	
	@Select("select *  from gamePresenter  where uid= #{uid}")    
	List<gamePresenter> getPresenter(int uid);
	
	@Select("select * from mineralCode where codeNo=#{codeNo}")    
	List<mineralCode> getMineralCode(String codeNo);

	
	@Update("update mineralCode set status= 1,uid=#{uid} where status= 0 and codeNo=#{codeNo}")
	public int  useMineralCode(String codeNo,int uid);
	
	@Insert("insert into userMineral(uid,mineral) values (#{uid},#{mineral})")
	public int  insertMineral(int uid, int mineral );
	
	@Update("update userMineral set mineral= #{mineral},version= #{version}+1 where version= #{version} and uid=#{uid}")
	public int  updateMineralNum(int uid, int mineral,int version);
	
	
	@Select("select * from mineralBills where  uid=#{uid} and time BETWEEN #{begin} and #{end}")    
	List<mineralBills> mineralBillsList(int uid,long begin, long end);
    
    @Insert("insert into mineralBills(id,nick,uid,mineral,cost,freeze,type,tagId,reason,time) values (#{id},#{nick},#{uid},#{mineral},#{cost},#{freeze},#{type},#{tagId},#{reason},#{time})")
	public int  writeMineralBills(mineralBills mineralBills);
    
	@Select("select  uid  from gamePresenter  where presenterId= #{presenterId}")    
	public List<Integer> presenterMembers(int presenterId);
    
}
