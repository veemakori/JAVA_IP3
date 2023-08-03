package org.saf.database;
import org.sql2o.Sql2o;
public class db {
    private static final Sql2o connection = new Sql2o (

            "jdbc:postgresql://localhost:5432/wildlife_tracker",
            "postgres",
            "postgres"
    );

    public static Sql2o getConnection() { return connection; }

}

