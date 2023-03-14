/* FILE NAME   : Address.java
 * PROGRAMMER  : DS6
 * @author     : Sokolov Dmitry
 * LAST UPDATE : 13.03.2023
 * PURPOSE     : Address Organization
 */

package Organization;

public class Address 
{
    private String street; //Строка не может быть пустой, Поле может быть null
    private String zipCode; //Поле не может быть null
    private Location town; //Поле может быть null

    public Address(String zipCode, String street, Location town){
        this.zipCode = zipCode;
        this.street = street;
        this.town = town;
    }

    public void print(){
        System.out.println("ZipCode = " + this.zipCode);
        System.out.println("Street = " + this.street);
        town.print();
    }
    public String getAddressinXML(){
        String start = "\t\t<postalAddress>\n";
        String zipCode = "\t\t\t<zipCode>" + this.zipCode + "</zipCode>\n";
        String street = "\t\t\t<street>" + this.street + "</street>\n";
        String location = town.getLocationinXML();
        String end = "\t\t</postalAddress>\n";
        return start + zipCode + street + location + end;
    }
}