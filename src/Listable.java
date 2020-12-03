import java.util.*;

public interface Listable {
    /*
    Takes no arguments and  returns a HashMap<String, Residential> containing a list of street \
    addresses (key) and their associated residences (value)
    */
    HashMap<String, Residential> getListings();

    /*
    Takes a String argument and returns the Residential value for the associated String key
     in a HashMap<String, Residential>
    */
    Residential getListing(String address);

    //Takes no arguments and returns a Set<String> of keys from a HashMap<String, Residential>
    Set<String> getStreetAddresses();

    //Takes no arguments and returns a Collection<Residential> of values from a HashMap<String, Residential>
    Collection<Residential> getResidences();

    //Takes no arguments and returns the number of listings in the HashMap<String, Residential>
    int getListingCount();

    //Adds a new key/value pair in a HashMap<String, Residential>
    void addListing(String address, Residential residential);
}
