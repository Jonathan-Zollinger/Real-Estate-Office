public class Condo extends Residential{
    //values
    int floorLvl;

    //constructors
    public Condo(){
        super();
        floorLvl = 0;
    }

    public Condo(String StreetAddress, String zip, int bedCount, int bathCount, double sqFootage,int floorLvl) {
        super(StreetAddress, zip, bedCount, bathCount, sqFootage);
        this.floorLvl = floorLvl;
    }
    //methods
    public int getFloorLvl(){
        return floorLvl;
    }
    public void setFloorLvl(int floorLvl){
        this.floorLvl = floorLvl;
    }
    @Override
    public double calculateAppraisalPrice() {
        double price;
        //add $88 per sq ft
        price = 88 * this.getSize();
        //add $8K for each bedroom
        price = price + 8000 * this.getBeds();
        //add $10K for each bath
        price = price + 10000 * this.getBaths();
        //add $5k for each floor above the ground floor. thus floor 2 would be (2-1)*$5000
        price = price + 5000 * (this.getFloorLvl()-1);
        return price;
    }
    public String toString(){
        String string = "";
        String lines = "\n----------------------------------------\n";
        String headerLines = "\n--------------------------------------------------------------------------------" +
                "-----------------------\n";
        string += headerLines;
        string += String.format(
                "Residence Type: Condo\t\t\t\tAddress: %s\t\t\t\tZip Code:%s",getStreetAddress(),getZip());
        string += headerLines;
        string += String.format("Sq Footage: %f%nBedrooms: %d%nBathrooms: %d%nYard Size (Acres): %d",
                getSize(),getBeds(),getBaths(),getFloorLvl());
        string += lines;
        string += String.format("Appraisal Price: $%f%nList Price: $%f",calculateAppraisalPrice(),getListPrice());
        string += lines;
        return string;
    }//end public String toString()

}//end public class Condo extends Residential
