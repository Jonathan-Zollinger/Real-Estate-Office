import java.util.HashMap;
import java.util.Set;

public interface Biddable {
    /**
    Takes no arguments and  returns a HashMap<String, Double>
    containing a list of bidder names (key) and their associated bid (value)
    */
    HashMap<String, Double> getBids();

    /**
    Takes a String argument and returns the Double value for the associated String key in a HashMap<String, Double>
     */
    double getBid(String bidderName);

    /**
    Takes no arguments and returns a Set<String> of keys from a HashMap<String, Double>
     */
    Set<String> getBidders();

    /**
    Takes no arguments and returns the number of bids in the HashMap<String, Double>
     */
    int getBidCount();

    /**
    Returns void. Either updates the value for the key or adds a new key/value pair in a HashMap<String, Double>
     */
    void newBid(String bidderName, Double bid);
}


