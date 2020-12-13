import java.util.HashMap;
import java.util.Set;

public abstract class Residential extends Property implements Biddable{
    //values
    HashMap<String, Double> bids;
    private int bedCount, bathCount;
    private double sqFootage;

    //constructors
    public Residential() {
        super();
        bedCount    = 0;
        bathCount   = 0;
        sqFootage   = 0;
        bids = new HashMap<>();
    }
    public Residential(String StreetAddress, String zip, int bedCount, int bathCount, double sqFootage){
        super(StreetAddress, zip);
        this.bedCount   = bedCount;
        this.bathCount  = bathCount;
        this.sqFootage  = sqFootage;
        bids = new HashMap<>();
    }
    //abstract methods
    public abstract double calculateAppraisalPrice();

    //methods
    public int      getBeds(){
        return bedCount;
    }
    public int      getBaths(){
        return bathCount;
    }
    public double   getSize(){
        return sqFootage;
    }
    public void     setBeds(int bedCount){
        this.bedCount   = bedCount;
    }
    public void     setBaths(int bathCount){
        this.bathCount  = bathCount;
    }
    public void     setSize(double sqFootage){
        this.sqFootage  = sqFootage;
    }

    public String getBidsPrintout(){
        String string = "";
        String lines = "----------------------------------------\n";
        string += "Current bids for this listing:\n";
        string += lines;
        string += String.format("%15s%20s\n","Bidder","Bid");
        string += lines;
        for (String key: bids.keySet()){
            string += String.format("%15s%20s\n",key,String.format("$%.2f",bids.get(key)));
        }
        return string;
    }

    @Override
    public HashMap<String, Double> getBids() {
        return bids;
    }

    @Override
    public double getBid(String bidderName) {
        return bids.get(bidderName);
    }

    @Override
    public Set<String> getBidders() {
        return bids.keySet();
    }

    @Override
    public int getBidCount() {
        try {
            return bids.size();
        }catch(NullPointerException isZero){
            return 0;
        }
    }

    @Override
    public void newBid(String bidderName, Double bid) {
        bids.put(bidderName,bid);
    }

}//end public class Residential extends Property
