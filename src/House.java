public class House extends Residential{
    //values
    private double yardAcres;

    //constructors
    public House(){
        yardAcres = 0;
    }

    //methods
    public double getYardAcres(){
        return yardAcres;
    }
    public void setYardAcres(double yardAcres){
        this.yardAcres = yardAcres;
    }
}//end public class House extends Residential
