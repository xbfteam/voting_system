package org.vote.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Hql on 2016/12/29.
 * 投票IP和时间
 */
@Entity
@Table(name = "info_info")
@SuppressWarnings("serial")
public class Info {
    private int iId;
    private String ip;
    private Date iVotetime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getiId() {
        return iId;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    @Column(name = "info_ip")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Temporal(TemporalType.DATE)
    public Date getiVotetime() {
        return iVotetime;
    }

    public void setiVotetime(Date iVotetime) {
        this.iVotetime = iVotetime;
    }
}
