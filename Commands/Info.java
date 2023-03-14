package Commands;

import Organization.Organization;

import java.util.Vector;

public class Info extends Command{
    private static final String name = "info";
    private static final String description = "";
    public static String getName(){return name;}
    public static String getDescription(){return description;}

    public static void info(Vector<Organization> org) {
        /*
        * Date of initialization
        * Size
        * ...
        */
        String dateInitialization = org.get(0).getLastUpdate();
        int size = org.size();
        System.out.println("Date of initialization collection: " + dateInitialization);
        System.out.println("Size of collection: " + Integer.valueOf(size));
    }
}
