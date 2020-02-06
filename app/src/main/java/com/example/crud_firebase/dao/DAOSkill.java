package com.example.crud_firebase.dao;
import com.example.crud_firebase.*;

public class DAOSkill {


    /**
     * Constructor of the DAOSKill
     */
    private DAOSkill() {

    }

    /**
     * Returns an instance of the DAOSkill
     *
     * @return An instance of the DAOSkill
     */
    public static DAOSkill getInstance() {
        return new DAOSkill();
    }

    /**
     * Inserts a new com.example.crud_firebase.dao.Skill into the database
     *
     * @param skill The com.example.crud_firebase.dao.Skill to insert
     */
    public static void insert(Skill skill) {

    }

    /**
     * Selects all the Skills from the database
     *
     * @return The SkillList of Skills from the database
     */
    public static SkillList select() {
        return null;
    }

    /**
     * Selects the com.example.crud_firebase.dao.Skill with the specific id from the database
     *
     * @param id The id of the com.example.crud_firebase.dao.Skill to select
     * @return The com.example.crud_firebase.dao.Skill selected
     */
    public static Skill select(int id) {
        return null;
    }

    /**
     * Updates an com.example.crud_firebase.dao.Skill into the database
     *
     * @param skill The com.example.crud_firebase.dao.Skill to update
     */
    public static void update(Skill skill) {

    }

    /**
     * Deletes an com.example.crud_firebase.dao.Skill from the database
     *
     * @param id The id of the com.example.crud_firebase.dao.Skill to delete
     */
    public static void delete(int id) {

    }
}