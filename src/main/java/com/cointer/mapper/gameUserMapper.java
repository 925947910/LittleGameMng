package com.cointer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cointer.pojo.po.gameUser;
import com.cointer.pojo.po.coinFailed;
@Mapper
public interface gameUserMapper {


	@Select("select * from gameUser where id= #{id}")
	public List<gameUser> userById(int id);

	@Update("update gameUser set photo= #{photo} where id= #{id} ")
	public int  updatePhoto(int id,String photo);

	@Update("update gameUser set nick= #{nick},email= #{email},phone= #{phone} where id= #{id} ")
	public int  updateUserBaseInfo(gameUser user);

	@Select("select * from gameUser where acc=#{acc} and plat=#{plat}")
	public List<gameUser> checkRegist(String acc,int plat);

	@Select("SELECT id  FROM gameUser WHERE aid =#{aid} and plat= #{plat}")
	public List<gameUser> getIdByRemoteAid(int aid,int plat);

	@Insert("insert into gameUser(id,acc,pwd,aid,plat,phone,email,address,nick,sex,photo,coin,extractPwd,regTime) values (#{id},#{acc},#{pwd},#{aid},#{plat},#{phone},#{email},#{address},#{nick},#{sex},#{photo},#{coin},#{extractPwd},#{regTime})")
	public int  registGameUser(gameUser user);

	@Update("update gameUser set coin=#{coin},version=#{version}+1  where id=#{id} and version=#{version}")
	public int  coinChange(int id,int coin, int version);

	@Insert("insert into coinFailed(id,nick,uid,cost,type,tagId,reason,time) values (#{id},#{nick},#{uid},#{cost},#{type},#{tagId},#{reason},#{time})")
	public int  saveFailedCoin(coinFailed coinFailed);

	@Select("SELECT coin,aid,plat,phone,email FROM gameUser WHERE id =#{id} and extractPwd=#{extractPwd}")
	public List<gameUser> authPwd(int id,String extractPwd);

	@Select("select phone,email FROM gameUser where id=#{id}")
	public List<gameUser> phoneEmailById(int id);

	@Update("update gameUser  set extractPwd=#{extractPwd} where id=#{id}")
	public int  resetPwd(int id,String extractPwd);
	
	@Select("select acc,nick,coin,version FROM gameUser where id=#{id}")
	public List<gameUser> checkCoin(int id);

	@Insert("insert into gamePresenter(uid,presenterId,time) values (#{uid},#{presenterId},#{time})")
	public int  bindPresenter(int uid,int presenterId,long time);
	
	@Update("update gameUser set aid= #{aid},plat= #{plat} where id= #{id} and plat=0 ")
	public int  bindRemoteUser(gameUser user);
	
}
