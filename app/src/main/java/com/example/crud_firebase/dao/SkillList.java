package com.example.crud_firebase.dao;

import java.util.ArrayList;

public class SkillList {
    // The list of Skills
    private ArrayList<Skill> list;

    /**
     * Adds a new com.example.crud_firebase.dao.Skill to the list
     *
     * @param skill The com.example.crud_firebase.dao.Skill to add
     */
    public void addSkill(Skill skill) {
        this.list.add(skill);
    }

    /**
     * Returns the list of Skills
     *
     * @return The list of Skills
     */
    public ArrayList<Skill> getList() {
        return list;
    }
}