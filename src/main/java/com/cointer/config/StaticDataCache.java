package com.cointer.config;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cointer.mapper.commonMapper;
import com.cointer.pojo.dto.staticData;


@Component
public class StaticDataCache implements CommandLineRunner{
	private Logger logger=LoggerFactory.getLogger(StaticDataCache.class);
	@Autowired
	private   commonMapper CommonMapper;
	private Map<String,JSONObject> staticDataMap=new HashMap<String, JSONObject>();
    @Override
	public void run(String... args) throws Exception {
    	reloadData();
	}
    
    
    public JSONObject getData(String name, int fid){
    	return staticDataMap.get(name+":"+fid);
    }
    
    public void reloadData(String name, int fid){
    	List<staticData> l=CommonMapper.StaticData(name,fid);
    	staticDataMap.put(name+":"+fid, JSON.parseObject(l.get(0).getVal()));
    }
    public void reloadData(){
//    	List<staticData> vip1=CommonMapper.StaticData("vip",1);
//    	staticDataMap.put("vip:1", JSON.parseObject(vip1.get(0).getVal()));
//    	List<staticData> vip2=CommonMapper.StaticData("vip",2);
//    	staticDataMap.put("vip:2", JSON.parseObject(vip2.get(0).getVal()));
//    	List<staticData> vip3=CommonMapper.StaticData("vip",3);
//    	staticDataMap.put("vip:3", JSON.parseObject(vip3.get(0).getVal()));
//    	List<staticData> vip4=CommonMapper.StaticData("vip",4);
//    	staticDataMap.put("vip:4", JSON.parseObject(vip4.get(0).getVal()));
//    	List<staticData> vip5=CommonMapper.StaticData("vip",5);
//    	staticDataMap.put("vip:5", JSON.parseObject(vip5.get(0).getVal()));
//    	List<staticData> vip6=CommonMapper.StaticData("vip",6);
//    	staticDataMap.put("vip:6", JSON.parseObject(vip6.get(0).getVal()));
//    	List<staticData> financing=CommonMapper.StaticData("financing",1);
//    	staticDataMap.put("financing:1", JSON.parseObject(financing.get(0).getVal()));
    	List<staticData> channelPay=CommonMapper.StaticData("channelPay",1);
    	staticDataMap.put("channelPay:1", JSON.parseObject(channelPay.get(0).getVal()));
    	List<staticData> NibPay1=CommonMapper.StaticData("NibPay",1);
    	staticDataMap.put("NibPay:1", JSON.parseObject(NibPay1.get(0).getVal()));
    	List<staticData> NibPay2=CommonMapper.StaticData("NibPay",2);
    	staticDataMap.put("NibPay:2", JSON.parseObject(NibPay2.get(0).getVal()));
//    	List<staticData> img=CommonMapper.StaticData("img",1);
//    	staticDataMap.put("img:1", JSON.parseObject(img.get(0).getVal()));
//    	List<staticData> SepPay1=CommonMapper.StaticData("SepPay",1);
//    	List<staticData> SepPay2=CommonMapper.StaticData("SepPay",2);
//    	List<staticData> SepPay3=CommonMapper.StaticData("SepPay",3);
//    	staticDataMap.put("SepPay:1", JSON.parseObject(SepPay1.get(0).getVal()+SepPay2.get(0).getVal()+SepPay3.get(0).getVal()));
//    	List<staticData> reback=CommonMapper.StaticData("reback",1);
//    	staticDataMap.put("reback:1", JSON.parseObject(reback.get(0).getVal()));
    	
    }
    
    
}