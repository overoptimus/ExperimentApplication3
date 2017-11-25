package com.example.experimentapplication3;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;

/**
 * Created by 常江 on 2017/11/13.
 */

public class Users extends BmobUser {
//    private String name;
    private String hobby;
    private String sex;
    private String bir_date;



//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getBir_date() {
        return bir_date;
    }

    public void setBir_date(String bir_date) {
        this.bir_date = bir_date;
    }

}
