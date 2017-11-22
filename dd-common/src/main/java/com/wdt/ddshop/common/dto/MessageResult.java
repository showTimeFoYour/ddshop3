package com.wdt.ddshop.common.dto;

/**
 * 处理消息结果的DTO
 * User: DHC
 * Date: 2017/11/22
 * Time: 14:04
 * Version:V1.0
 */
public class MessageResult {
    private boolean success;
    private String message;
    private Object data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
