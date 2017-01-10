package org.vote.entity;



import javax.persistence.*;
import java.io.Serializable;

/**
 * 候选人详细信息实体
 * hibernate 1对1映射
 * 外键映射
 * 单向
 * Created by Hql on 2016/12/29.
 */
@Entity
@Table(name = "ctt_info")
public class Content implements Serializable {
    private int cid;
    private int cage;
    private String cDescription;
    private Vote vote;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
    @Column(name = "ctt_age")
    public int getCage() {
        return cage;
    }

    public void setCage(int cage) {
        this.cage = cage;
    }

    @Column(name = "ctt_description")
    public String getcDescription() {
        return cDescription;
    }

    public void setcDescription(String cDescription) {
        this.cDescription = cDescription;
    }


    //cascade=CascadeType.MERGE
    //或者写多个cascade={CascadeType.MERGE,CascadeType.DETACH}
    //CascadeType.PERSIST 级联保存
    //CascadeType.MERGE 级联更新
    //CascadeType.DETACH 未知级联
    //CascadeType.REMOVE 级联删除

    //一对一关联学生
    //关系维护端需要使用@JoinColumn注解，指定关联表的外键列
    //@JoinColumn只需要在关系的维护端指定即可


    // mappedBy属性指定将关联关系的维护全交由给对方，相当于hibernate中的inverse
    // 它的值是指定对方关联自己的属性名。
    // （注意：只有双向关联的情况才需要指定，且只需要在任意一遍指定即可）
    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)//级联更新设置，否则content和vote需要单独保存了
    @JoinColumn(name="vid")//指定主表外键名字
    public Vote getVote() {
        return vote;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }
}
