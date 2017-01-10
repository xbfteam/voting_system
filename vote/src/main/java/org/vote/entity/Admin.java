package org.vote.entity;

import javax.persistence.*;

/**
 * Created by Hql on 2016/12/28.
 * 管理员实体
 */
@Entity
@Table(name="admin_info")
@SuppressWarnings("serial")
public class Admin {
    private int aid;
    private String aName;
    private String aPwd;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    @Column(name = "a_name")
    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    @Column(name = "a_passwd")
    public String getaPwd() {
        return aPwd;
    }

    public void setaPwd(String aPwd) {
        this.aPwd = aPwd;
    }
}
