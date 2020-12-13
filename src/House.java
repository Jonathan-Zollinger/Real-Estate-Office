import java.util.HashMap;
import java.util.Set;

public class House extends Residential {
    //values
    private double yardAcres;

    //constructors
    public House() {
        super();
        yardAcres = 0;
    }

    public House(String StreetAddress, String zip, int bedCount, int bathCount, double sqFootage, double yardAcres) {
        super(StreetAddress, zip, bedCount, bathCount, sqFootage);
        this.yardAcres = yardAcres;
    }

    //methods
    public double getYardAcres() {
        return yardAcres;
    }

    public void setYardAcres(double yardAcres) {
        this.yardAcres = yardAcres;
    }

    @Override
    public double calculateAppraisalPrice() {
        double price;
        //add $97 per sq ft
        price = 97 * this.getSize();
        //add $10K for each bedroom
        price = price + 10000 * this.getBeds();
        //add $12K for each bath
        price = price + 12000 * this.getBaths();
        //add $460K per FULL acre yard .: full acre means it is rounded down
        price = price + 460000 * Math.floor(this.getYardAcres());

        //set appraisal price? I think to make the programmer do this outside this method for flexibility
        //this.setAppraisalPrice(price);

        return price;
    }

    public String toString() {
        String string = "";
        String lines = "\n----------------------------------------\n";
        String headerLines =
                "\n------------------------------------------------------------------------------------------------\n";
        string += headerLines;
        string += String.format(
                "%28s%-32s%24s",
                "Residence Type: House",
                "     Address: " + getStreetAddress(),
                "Zip Code:" + getZip());
        string += headerLines;
        string += String.format("%20s%.2f%n%20s%d%n%20s%d%n%20s%.2f",
                "Sq Footage: ",getSize(),
                "Bedrooms: ",getBeds(),
                "Bathrooms: ", getBaths(),
                "Yard Size (Acres): ", getYardAcres());
        string += lines;
        string += String.format("%20s$%.2f%n%20s$%.2f",
                "Appraisal Price: ",calculateAppraisalPrice(),
                "List Price: ", getListPrice());
        string += lines;
        return string;

    }//end public class House extends Residential
}
