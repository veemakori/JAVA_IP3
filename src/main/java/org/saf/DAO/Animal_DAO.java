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

    //ANIMAL DATA ADDED INTO THE ANIMALS TABLE
    public static void addAnimals (Animals newAnimal) {
        try (Connection db = database.getConnection().open()) {
            String addingSpell = "INSERT INTO animals (animal, endangered) VALUES (UPPER(:animal), (:endangered));";
            db.createQuery(addingSpell).bind(newAnimal).executeUpdate();
        } catch (Exception error) { System.out.println(error.getMessage());}
    }

    //RETURNS ALL ANIMALS
    public static List<Animals> allAnimals (){
        List<Animals> animalList = null;
        try(Connection db = database.getConnection().open()) {
            String querySpell = "SELECT * FROM animals WHERE NOT deleted; ";
            animalList = db.createQuery(querySpell).executeAndFetch(Animals.class);
        } catch (Exception error){ System.out.println(error.getMessage());}
        return animalList;
    }

    //GETS A PARTICULAR ANIMAL FROM THE ANIMALS TABLE
    public static List<Animals> oneAnimal (String animal) {
        List<Animals> oneAnimalList = null;
        try(Connection db = database.getConnection().open()){
            String oneAnimalSpell = "SELECT * FROM animals WHERE animal = (:animal) AND NOT deleted;";
            oneAnimalList = db.createQuery(oneAnimalSpell).addParameter("animal", animal).executeAndFetch(Animals.class);
        } catch (Exception error) { System.out.println(error.getMessage());}
        return oneAnimalList;
    }

    //DELETES A SQUAD FROM THE DATABASE
    public static void deleteAnimal(String animal){
        try(Connection db = database.getConnection().open()){
            String deletionSpell = " UPDATE animals SET deleted = true WHERE animal = (:animal);";
            db.createQuery(deletionSpell).addParameter("animal", animal).executeUpdate();
        } catch (Exception error) { System.out.println(error.getMessage());}
    }

}
