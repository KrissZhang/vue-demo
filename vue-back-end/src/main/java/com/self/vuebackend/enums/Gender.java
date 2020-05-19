package com.self.vuebackend.enums;

/**
 * 性别
 */
public enum Gender {
    //男
    GENDER_MALE(0, "男"),

    //女
    GENDER_FEMALE(1, "女");

    Gender(Integer key, String msg){
        this.key = key;
        this.msg = msg;
    }

    private Integer key;

    private String msg;

    public Integer getKey() {
        return key;
    }

    public String getMsg() {
        return msg;
    }

}
