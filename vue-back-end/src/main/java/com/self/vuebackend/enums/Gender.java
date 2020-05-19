package com.self.vuebackend.enums;

/**
 * 性别
 */
public enum Gender {
    //男
    GENDER_MALE,

    //女
    GENDER_FEMALE;

    private Integer type;

    private String msg;

    public Integer getType() {
        return type;
    }

    public String getMsg() {
        return msg;
    }

}
