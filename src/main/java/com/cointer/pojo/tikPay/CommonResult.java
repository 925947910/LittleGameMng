package com.cointer.pojo.tikPay;


/**
 * 通用返回对象
 */
public class CommonResult<T> {
    private long code;
    private String message;
    private T data;

    public  CommonResult(long code,String message, T data ){
        this.code = code;
        this.message = message;
        this.data = data;

    }


}
