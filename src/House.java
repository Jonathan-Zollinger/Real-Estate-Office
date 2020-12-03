public class House extends Residential{
    //values
    private double yardAcres;

    //constructors
    public House(){
        super();
        yardAcres = 0;
    }

    public House(String StreetAddress, String zip, int bedCount, int bathCount, double sqFootage,double yardAcres){
        super(StreetAddress,zip,bedCount,bathCount,sqFootage);
        this.yardAcres = yardAcres;
    }

    //methods
    public double getYardAcres(){
        return yardAcres;
    }
    public void setYardAcres(double yardAcres){
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
    public String toString(){
        String string = "";
        String lines = "\n----------------------------------------\n";
        String headerLines = "\n--------------------------------------------------------------------------------" +
                "-----------------------\n";
        string += headerLines;
        string += String.format(
                "Residence Type: House\t\t\t\tAddress: %s\t\t\t\tZip Code:%s",getStreetAddress(),getZip());
        string += headerLines;
        string += String.format("Sq Footage: %f%nBedrooms: %d%nBathrooms: %d%nYard Size (Acres): %f",
                getSize(),getBeds(),getBaths(),getYardAcres());
        string += lines;
        string += String.format("Appraisal Price: $%f%nList Price: $%f",calculateAppraisalPrice(),getListPrice());
        string += lines;
        return string;
    }

}//end public class House extends Residential
