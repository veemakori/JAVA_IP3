package org.saf.DAO;

import org.saf.database.database;

import org.saf.models.Animals;

import org.sql2o.Connection;
import java.util.List;
public class Animal_DAO {
    //AUTOMATICALLY CREATES  ANIMALS TABLE IN THE DATABASE
    public static void createTable (){
        try(Connection db = database.getConnection().open()){
            String tableSpell = "CREATE TABLE IF NOT EXISTS animals (id serial, animal varchar unique, endangered boolean default false, deleted boolean default false);";
            db.createQuery(tableSpell).executeUpdate();
        } catch (Exception error) {System.out.println(error.getMessage());}
    }
}
