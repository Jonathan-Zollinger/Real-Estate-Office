public class Property {
    //values
    private String streetAddress;
    private String zip; //I defined this as a string because we wont perform actual math on this, it's more of a name.

    //constructors
    public Property(){
        streetAddress = null;
        zip = null;
    }
    public Property(String StreetAddress, String zip){
        this.streetAddress = StreetAddress;
        this.zip = zip;
    }

    //methods
    public String getStreetAddress() {
        return streetAddress;
    }
    public String getZip() {
        return zip;
    }
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
}//end public class Property

