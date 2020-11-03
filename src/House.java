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
}//end public class House extends Residential
