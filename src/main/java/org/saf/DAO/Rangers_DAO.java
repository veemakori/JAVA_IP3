package org.saf.DAO;

import org.saf.database.database;
import org.saf.models.Rangers;
import org.sql2o.Connection;

import java.util.List;
public class Rangers_DAO {
    public static void createTable (){
        try(Connection db = database.getConnection().open()){
            String tableSpell = "CREATE TABLE IF NOT EXISTS rangers (id serial, ranger varchar, username varchar unique, gender varchar, contacts varchar unique, email varchar unique, deleted boolean default false);";
            db.createQuery(tableSpell).executeUpdate();
        } catch (Exception error) {System.out.println(error.getMessage());}
    }

    //INSERTS RANGER IN  TABLE
    public static void addRanger (Rangers newRanger){
        try (Connection db = database.getConnection().open()) {
            String addingSpell = "INSERT INTO rangers (ranger, username, gender, contacts, email, deleted) VALUES (UPPER(:ranger), LOWER(:username), :gender, :contacts, LOWER(:email), :deleted);";
            db.createQuery(addingSpell).bind(newRanger).executeUpdate();
        } catch (Exception error) { System.out.println(error.getMessage());}
    }

    //RETURNS ALL RANGERS
    public static List<Rangers> allRangers (){
        List<Rangers> rangersList = null;
        try(Connection db = database.getConnection().open()) {
            String querySpell = "SELECT * FROM rangers WHERE NOT deleted;";
            rangersList = db.createQuery(querySpell).executeAndFetch(Rangers.class);
        } catch (Exception error){ System.out.println(error.getMessage());}
        return rangersList;
    }


    //DELETES A RANGER FROM THE DB
    public static void deleteRanger (String ranger){
        try(Connection db = database.getConnection().open()){
            String deletionSpell = " UPDATE rangers SET deleted = true WHERE ranger = (:ranger);";
            db.createQuery(deletionSpell).addParameter("ranger", ranger).executeUpdate();
        } catch (Exception error) { System.out.println(error.getMessage());}
    }


}
