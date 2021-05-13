package com.cointer.task;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.cointer.service.impl.RedGreenBallService;



@Component
public class SchedulingRedGreenBall {
	private static final Logger log = LoggerFactory.getLogger(SchedulingRedGreenBall.class);

	@Autowired
	private   RedGreenBallService RedGreenBallService;
//  生成彩票
    @Scheduled(cron = "0 0/3 * * * ?")
    public void GenRedGreenBall3() {
    	RedGreenBallService.GenRedGreenBall(3);
    }
    
    //  封盘算结果
    @Scheduled(cron = "30 2/3 * * * ?")
    public void RedGreenBallResult3() {
    	RedGreenBallService.RedGreenBallResult(3);
    }    
//  封盘开奖
    @Scheduled(cron = "58 2/3 * * * ? ")
    public void DrawRedGreenBall3() {
    	RedGreenBallService.DrawRedGreenBall(3);
    }    
//  生成彩票
    @Scheduled(cron = "0 0/5 * * * ?")
    public void GenRedGreenBall5() {
    	RedGreenBallService.GenRedGreenBall(5);
    }
    
    //  封盘算结果
    @Scheduled(cron = "30 4/5 * * * ?")
    public void RedGreenBallResult5() {
    	RedGreenBallService.RedGreenBallResult(5);
    }    
//  封盘开奖
    @Scheduled(cron = "58 4/5 * * * ? ")
    public void DrawRedGreenBall5() {
    	RedGreenBallService.DrawRedGreenBall(5);
    }    
//  生成彩票
    @Scheduled(cron = "0 0/10 * * * ?")
    public void GenRedGreenBall10() {
    	RedGreenBallService.GenRedGreenBall(10);
    }
    
    //  封盘算结果
    @Scheduled(cron = "30 9/10 * * * ?")
    public void RedGreenBallResult10() {
    	RedGreenBallService.RedGreenBallResult(10);
    }    
//  封盘开奖
    @Scheduled(cron = "58 9/10 * * * ? ")
    public void DrawRedGreenBall10() {
    	RedGreenBallService.DrawRedGreenBall(10);
    }    
}