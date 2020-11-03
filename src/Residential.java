public abstract class Residential extends Property{
    //values
    private int bedCount, bathCount;
    private double sqFootage;

    //constructors
    public Residential() {
        super();
        bedCount    = 0;
        bathCount   = 0;
        sqFootage   = 0;
    }
    public Residential(String StreetAddress, String zip, int bedCount, int bathCount, double sqFootage){
        super(StreetAddress, zip);
        this.bedCount   = bedCount;
        this.bathCount  = bathCount;
        this.sqFootage  = sqFootage;
    }

    public Residential(int bedCount, int bathCount){
        this.bedCount   = bedCount;
        this.bathCount  = bathCount;
        sqFootage       = 0;
    }
    public Residential(double sqFootage){
        this.bedCount   = 0;
        this.bathCount  = 0;
        this.sqFootage  = sqFootage;
    }

    //abstract methods
    public abstract double calculateAppraisalPrice();

    //methods
    public int getBeds(){
        return bedCount;
    }
    public int getBaths(){
        return bathCount;
    }
    public double getSize(){
        return sqFootage;
    }
    public void setBeds(int bedCount){
        this.bedCount   = bedCount;
    }
    public void setBaths(int bathCount){
        this.bathCount  = bathCount;
    }
    public void setSize(double sqFootage){
        this.sqFootage  = sqFootage;
    }

}//end public class Residential extends Property
