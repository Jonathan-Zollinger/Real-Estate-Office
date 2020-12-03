import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Listings implements Listable{
    //attributes
    HashMap<String,Residential> hashMap;

    Listings(){
        hashMap = new HashMap<>();
    }

    //methods
    @Override
    public HashMap<String, Residential> getListings() {
        return this.hashMap;
    }

    @Override
    public Residential getListing(String address) {
        return hashMap.get(address);
    }

    @Override
    public Set<String> getStreetAddresses() {
        return hashMap.keySet();
    }

    @Override
    public Collection<Residential> getResidences() {
        return hashMap.values();
    }

    @Override
    public int getListingCount() {
        return hashMap.size();
    }

    @Override
    public void addListing(String address, Residential residential) {
        hashMap.put(address,residential);
        System.out.printf("added the residence at %s%n",address);
    }
}
