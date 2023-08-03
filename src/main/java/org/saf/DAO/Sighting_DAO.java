package org.saf.DAO;
import org.saf.database.database;
import org.saf.models.Sighting;
import org.sql2o.Connection;

import java.util.List;
public class Sighting_DAO {
    //CREATES  SIGHTINGS TABLE
    public static void createTable (){
        try(Connection db = database.getConnection().open()){
            String tableSpell = "CREATE TABLE IF NOT EXISTS sightings (id serial, animal varchar, endangered boolean default false, health varchar, age varchar, location varchar, ranger varchar, time timestamps, deleted boolean default false);";
            db.createQuery(tableSpell).executeUpdate();
        } catch (Exception error) {System.out.println(error.getMessage());}
    }
    // NEW ANIMAL SIGHTING ADDED TO THE TABLE
    public static void addSighting (Sighting newSighting) {
        try (Connection db = database.getConnection().open()) {
            String addingSpell = "INSERT INTO sightings (animal, endangered, age, health, location, ranger, time) VALUES (UPPER(:animal), :endangered, :age, :health, :location, UPPER(:ranger), :time);";
            db.createQuery(addingSpell).bind(newSighting).executeUpdate();
        } catch (Exception error) { System.out.println(error.getMessage());}
    }

    //SELECTS A PARTICULAR ANIMAL FROM THE SIGHTINGS TABLE
    public static List<Sighting> distinctSightings (String animal){
        List<Sighting> specialSighting = null;
        try (Connection db = database.getConnection().open()){
            String distinctSpell = "SELECT * FROM sightings WHERE animal = (:animal) AND NOT deleted;";
            specialSighting = db.createQuery(distinctSpell).addParameter("animal", animal).executeAndFetch(Sighting.class);
        } catch (Exception error){System.out.println(error.getMessage());}
        return specialSighting;
    }

    //RETURNS ALL SIGHTED ANIMALS
    public static List<Sighting> allSightings() {
        List<Sighting> everySighting = null;
        try (Connection db = database.getConnection().open()){
            String sightingsSpell = "SELECT * FROM sightings WHERE NOT deleted;";
            everySighting = db.createQuery(sightingsSpell).executeAndFetch(Sighting.class);
        } catch (Exception error){System.out.println(error.getMessage());}
        return everySighting;
    }

    public static void deleteSighting(String animal){
        try(Connection db = database.getConnection().open()){
            String deletionSpell = " UPDATE sightings SET deleted = true WHERE animal = (:animal);";
            db.createQuery(deletionSpell).addParameter("animal", animal).executeUpdate();
        } catch (Exception error) { System.out.println(error.getMessage());}
    }

}
