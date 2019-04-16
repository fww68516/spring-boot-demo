package com.springboot.demo;

public enum  CommonEnum {

    SUCCESS("0000","成功"),
    FILE("1001","失败");

    private String code;
    private String msg;

    CommonEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
