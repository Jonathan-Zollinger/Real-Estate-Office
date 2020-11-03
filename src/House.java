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

}//end public class House extends Residential
