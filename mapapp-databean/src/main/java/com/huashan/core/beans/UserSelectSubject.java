package com.huashan.core.beans;

import com.huashan.core.base.AbstractItem;
import com.huashan.core.base.ItemBase;

import javax.persistence.*;

/**
 * 用户答题记录
 * Created by lixu on 2017-01-01.
 */
@Entity
@Table(name = "db_userSelectSubject")
public class UserSelectSubject extends AbstractItem implements ItemBase {

    @Column( name = "id" , nullable=false ,length = 11)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column( name = "timestamp" ,length = 32 )
    private String timestamp;

    @Column( name = "userid" , nullable=false ,length = 11 )
    private Integer userid;

    @Column( name = "question" , nullable=false , length = 11 )
    private Integer question;

    @Column( name = "answer" ,nullable=false , length = 11 )
    private Integer answer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getQuestion() {
        return question;
    }

    public void setQuestion(Integer question) {
        this.question = question;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }
}
