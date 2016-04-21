package com.lihuanyu.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 课程/实验 类别
 * Created by Explorer on 2016/4/21.
 */
public class Classify {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Classify() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
