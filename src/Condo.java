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

}//end public class Condo extends Residential
