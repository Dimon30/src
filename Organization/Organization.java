/* FILE NAME   : Organization.java
 * PROGRAMMER  : DS6
 * @author     : Sokolov Dmitry
 * LAST UPDATE : 13.03.2023
 * PURPOSE     : Info Organization
 */

package Organization;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Organization
{
    private int id = 30; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Float annualTurnover; //Поле может быть null, Значение поля должно быть больше 0
    private OrganizationType type; //Поле может быть null
    private Address postalAddress; //Поле может быть null
    private String lastUpdate;

    public Organization(String name, long x, double y, LocalDateTime creationDate, Float annualTurnover, OrganizationType type, Address ad){
        this.id = (int) (Math.random() * 999999999 + 1);
        this.name = name;
        this.coordinates = new Coordinates(x, y);
        setCreationDate(creationDate);
        this.annualTurnover = annualTurnover;
        this.type = type;
        this.postalAddress = ad;
    }

    public Organization(String name, long x, double y, Float annualTurnover, OrganizationType type, Address ad){
        this.id = (int) (Math.random() * 999999999 + 1);
        this.name = name;
        this.coordinates = new Coordinates(x, y);
        setCreationDate(LocalDateTime.now());
        this.annualTurnover = annualTurnover;
        this.type = type;
        this.postalAddress = ad;
    }

    public void print() {
        System.out.println("id = " + this.id);
        System.out.println("name = " + this.name);
        coordinates.print();
        System.out.println("Date = " + this.creationDate);
        System.out.println("Annual Turnover = " + this.annualTurnover);
        System.out.println("Type = " + this.type);
        postalAddress.print();
    }
    public String getName(){return this.name;}

    public String getXML(){
        String start = "\t<Organization>\n";
        String id = getIdinXML();
        String name = getNameinXMl();
        String coordinates = getCoordinatesinXML();
        String creationDate = getCreatonDateinXML();
        String annualTurnover = getAnnualTurnoverinXML();
        String type = getTypeinXML();
        String address = getAddressinXML();
        String lastUpdate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String end = "\t</Organization>\n";
        return  start + id + name + coordinates + creationDate + annualTurnover + type + address + lastUpdate + end;
    }
    private String getIdinXML(){return "\t\t<id>" + String.valueOf(this.id) + "</id>\n";}
    private String getNameinXMl(){return "\t\t<name>" + this.name + "</name>\n";}
    private String getCoordinatesinXML(){return coordinates.getCoordinatesinXML();}
    public String getCreatonDateinXML(){return "\t\t<creationDate>" + String.valueOf(this.creationDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))) + "</creationDate>\n";}
    public String getAnnualTurnoverinXML(){return "\t\t<annualTurnover>" + String.valueOf(this.annualTurnover) + "</annualTurnover>\n";}
    public String getTypeinXML(){return "\t\t<type>" + String.valueOf(this.type) + "</type>\n";}
    public String getAddressinXML(){return postalAddress.getAddressinXML();}
    public void setCreationDate(LocalDateTime creationDate){
        this.creationDate = creationDate;
    }
    public void setId(int id){this.id = id;}
    public void setLastUpdate(String s){this.lastUpdate = s;}
    public String getLastUpdate(){return this.lastUpdate;}
}