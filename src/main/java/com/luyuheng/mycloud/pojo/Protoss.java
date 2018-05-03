package com.luyuheng.mycloud.pojo;

/**
 * @Author:luyuheng
 * @Date:2018/4/26 09 19
 * @Description
 */
public class Protoss {

    private Long id;

    private String name;

    private Skill skill;

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

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Protoss{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", skill=" + skill +
                '}';
    }
}
