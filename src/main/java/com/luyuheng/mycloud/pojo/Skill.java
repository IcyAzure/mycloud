package com.luyuheng.mycloud.pojo;

/**
 * @Author:luyuheng
 * @Date:2018/4/26 09 20
 * @Description
 */
public class Skill {

    private Long id;

    private String name;

    private int mPcost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getmPcost() {
        return mPcost;
    }

    public void setmPcost(int mPcost) {
        this.mPcost = mPcost;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mPcost=" + mPcost +
                '}';
    }
}
