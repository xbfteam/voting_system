package org.vote.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Hql on 2016/12/29.
 */
@Entity
@Table(name = "vote_info")
public class Vote implements Serializable {
    //编号
    private int vid;
    //姓名
    private String vName;
    //票数
    private int vticket = 1;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    @Column(name = "vote_name")
    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    @Column(name = "vote_ticket")
    public int getVticket() {
        return vticket;
    }

    public void setVticket(int vticket) {
        this.vticket = vticket;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Vote))
            return  false;
        Vote vote = (Vote) obj;
        if(vote.getVid() == this.vid)
            return true;
        else
            return false;
    }
}
