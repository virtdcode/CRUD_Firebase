package com.example.crud_firebase.dao;

public class Skill {

    // The id of the com.example.crud_firebase.dao.Skill
    private int id;
    // The name of the com.example.crud_firebase.dao.Skill
    private String name;

    /**
     * Constructor of the com.example.crud_firebase.dao.Skill
     */
    public Skill() {
    }

    /**
     * Constructor of the com.example.crud_firebase.dao.Skill
     *
     * @param id   The id of the com.example.crud_firebase.dao.Skill
     * @param name The name of the com.example.crud_firebase.dao.Skill
     */
    public Skill(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Returns the id of the com.example.crud_firebase.dao.Skill
     *
     * @return The id of the com.example.crud_firebase.dao.Skill
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id of the com.example.crud_firebase.dao.Skill
     *
     * @param id The new id of the com.example.crud_firebase.dao.Skill
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the name of the com.example.crud_firebase.dao.Skill
     *
     * @return The name of the com.example.crud_firebase.dao.Skill
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the com.example.crud_firebase.dao.Skill
     *
     * @param name The new name of the com.example.crud_firebase.dao.Skill
     */
    public void setName(String name) {
        this.name = name;
    }
}