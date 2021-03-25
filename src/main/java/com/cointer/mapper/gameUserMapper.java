package com.cointer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cointer.pojo.po.gameUser;
import com.cointer.pojo.po.bots;
import com.cointer.pojo.po.coinFailed;
@Mapper
public interface gameUserMapper {
	@Select("select * from bots ")
	public List<bots> getBots();

	@Select("select * from gameuser where id= #{id}")
	public List<gameUser> userById(int id);

	@Select("select count(id) from gameuser where presenterId= #{uid}")
	public Integer getMembers(int uid);
	
	@Update("update gameuser set isTourist= #{isTourist} where id= #{id} ")
	public int  updateTourist(int id,int isTourist);

	@Update("update gameuser set photo= #{photo} where id= #{id} ")
	public int  updatePhoto(int id,String photo);
	
	@Update("update gameuser set nick= #{nick},email= #{email},phone= #{phone} where id= #{id} ")
	public int  updateUserBaseInfo(gameUser user);

	@Select("select * from gameuser where acc=#{acc} and plat=#{plat}")
	public List<gameUser> checkAcc(String acc,int plat);


	@Insert("insert into gameuser(id,acc,pwd,plat,phone,nick,sex,photo,freezed,isTourist,isLeader,coin,agentId,presenterId,regTime) values (#{id},#{acc},#{pwd},#{plat},#{phone},#{nick},#{sex},#{photo},#{freezed},#{isTourist},#{isLeader},#{coin},#{agentId},#{presenterId},#{regTime})")
	public int  registGameUser(gameUser user);

	@Update("update gameuser set coin=#{coin},version=#{version}+1  where id=#{id} and version=#{version}")
	public int  coinChange(int id,int coin, int version);

	@Insert("insert into coinfailed(id,nick,uid,cost,type,tagId,reason,time) values (#{id},#{nick},#{uid},#{cost},#{type},#{tagId},#{reason},#{time})")
	public int  saveFailedCoin(coinFailed coinFailed);

	@Select("SELECT coin,aid,plat,phone,email FROM gameuser WHERE id =#{id} and extractPwd=#{extractPwd}")
	public List<gameUser> authPwd(int id,String extractPwd);


	@Update("update gameuser  set extractPwd=#{extractPwd} where id=#{id}")
	public int  resetPwd(int id,String extractPwd);
	
	@Select("select * FROM gameuser where id = #{id}")
	public List<gameUser> checkCoin(int id);
	
	@Select("select * FROM gameuser where extractPwd=#{extractPwd}")
	public List<gameUser> checkCoinByExtractPwd(String extractPwd);
	
	@Insert("insert into gamepresenter(uid,presenterId,time) values (#{uid},#{presenterId},#{time})")
	public int  bindPresenter(int uid,int presenterId,long time);
	
	@Update("update gameuser set aid= #{aid},plat= #{plat} where id= #{id} and plat=0 ")
	public int  bindRemoteUser(gameUser user);
	
}
