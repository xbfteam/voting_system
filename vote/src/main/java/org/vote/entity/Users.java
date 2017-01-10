package org.vote.entity;

import javax.persistence.*;

/**
 * Created by Hql on 2016/12/27.
 * 用户实体
 */
@Entity
@Table(name = "user_info")
@SuppressWarnings("serial")
public class Users {
    private int uid;
    private String uName;
    private String uPwd;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Column(name = "user_name")
    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    @Column(name = "user_pwd")
    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }
}
