package Commands;

public class Help extends Command{

    private static final String name = "help";
    private static final String description = "";

    public static void help(){
        System.out.println("-" + getName() + ": " + getDescription());
        System.out.println("-" + Info.getName() + ": " + getDescription());
        System.out.println("-" + Info.getName() + ": " + getDescription());
        System.out.println("-" + Info.getName() + ": " + getDescription());
        System.out.println("-" + Info.getName() + ": " + getDescription());
        System.out.println("-" + Info.getName() + ": " + getDescription());
        System.out.println("-" + Info.getName() + ": " + getDescription());
        System.out.println("-" + Info.getName() + ": " + getDescription());
        System.out.println("-" + Info.getName() + ": " + getDescription());
        System.out.println("-" + Info.getName() + ": " + getDescription());
        System.out.println("-" + Info.getName() + ": " + getDescription());
        System.out.println("-" + Info.getName() + ": " + getDescription());
        System.out.println("-" + Info.getName() + ": " + getDescription());
        System.out.println("-" + Info.getName() + ": " + getDescription());
        System.out.println("-" + Info.getName() + ": " + getDescription());

    }


    public static String getName(){return name;}
    public static String getDescription(){return description;}

}
