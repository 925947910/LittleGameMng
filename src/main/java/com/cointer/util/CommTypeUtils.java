package com.cointer.util;



import org.apache.commons.lang3.RandomStringUtils;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Administrator
 * @version 1.0
 * @description 工具类
 * @date 2019/8/5 0005 17:32
 */
public class CommTypeUtils {
    private static final String PATTERN = "yyyyMMddHHmmssSSS";

    /**
     * 订单号 时间的 yyMMddHHmmssSSS 字符串 加上 6位随机数
     *
     * @return
     */
    private static String generateOrderNo() {
        StringBuffer sb = new StringBuffer(LocalDateTime.now().format(DateTimeFormatter.ofPattern(PATTERN)));
        sb.append(getRandomNumeric(6));
        return sb.toString();
    }

    public static String getRandomNumeric(int size) {
        return RandomStringUtils.randomNumeric(size);
    }

    /**
     * 根据业务类型生成订单号
     */
    public static String getOrderNo(String bizType) {
        String order = generateOrderNo();
        return new StringBuffer(bizType).append(order).toString();
    }

}
