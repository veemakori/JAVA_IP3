package org.saf;
import org.saf.DAO.Animal_DAO;
import org.saf.DAO.Rangers_DAO;
import org.saf.DAO.Sighting_DAO;
import org.saf.models.Animals;
import org.saf.models.Rangers;
import org.saf.models.Sighting;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        staticFileLocation("/public");
        HandlebarsTemplateEngine views = new HandlebarsTemplateEngine();
    }
}