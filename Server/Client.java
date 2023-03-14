package Server;

import Commands.*;
import Organization.Organization;

import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;

public class Client {
    private Vector<Organization> org;
    public Client(Vector<Organization> org){
        this.org = org;
    }
    public void run() {
        Scanner scanner = new Scanner(System.in);
        //Show.show();
        Help.help();
        System.out.print("Input command: ");
        loop(scanner);
    }

    /**
     * Loop of client commands.
     */
    public void loop(Scanner scan) {
        while (scan.hasNext()) {
            String command = scan.nextLine();
            switch (command) {
                case "help" -> Help.help();
                case "info" -> Info.info(this.org);/*
                case "clear" -> {
                    Clear.clear();
                    System.out.println("Now the collection is empty.\n");
                }
                case "save" -> {
                    String outputfile = "out.txt";
                    save(outputfile);
                }
                case "add" -> add(scan);
                case "exit" -> exit(0);
                case "show" -> show();
                case "delete", "remove", "delete_by_id" -> {
                    System.out.println("Input the index");
                    deleteById(scan.nextLong());
                }
                case "execute_script" -> {
                    System.out.println("Input filename");
                    execute_script(scan.nextLine());
                }
                case "print_field_descending_distance" -> {
                    print_field_descending_distance();
                }
                case "filter_greater_than_distance" -> {
                    filter_greater_than_distance(scan);
                }*/
                default -> System.out.println(command + ": this command doesn't exist.");
            }
        }
        scan.close();
    }
}
