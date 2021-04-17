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
    public void GenRedGreenBall() {
    	RedGreenBallService.GenRedGreenBall();
    }
    
    //  封盘算结果
    @Scheduled(cron = "30 2/3 * * * ?")
    public void RedGreenBallResult() {
    	RedGreenBallService.RedGreenBallResult();
    }    
//  封盘开奖
    @Scheduled(cron = "58 2/3 * * * ? ")
    public void DrawRedGreenBall() {
    	RedGreenBallService.DrawRedGreenBall();
    }    
    
}