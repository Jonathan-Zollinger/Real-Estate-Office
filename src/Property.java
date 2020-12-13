public abstract class Property {
    //values
    private String streetAddress;
    private String zip; //I defined this as a string because we wont perform actual math on this, it's more of a name.
    private double listPrice;
    private double appraisalPrice;

    //constructors
    public Property(){
        streetAddress = "";
        zip = "";
        listPrice = 0;
        appraisalPrice = 0;
    }
    public Property(String StreetAddress, String zip){
        this.streetAddress = StreetAddress;
        this.zip = zip;
        listPrice = 0;
        appraisalPrice = 0;
    }
    public Property(String StreetAddress, String zip,double listPrice,double appraisalPrice){
        this.streetAddress = StreetAddress;
        this.zip = zip;
        this.listPrice = listPrice;
        this.appraisalPrice = appraisalPrice;
    }

    //abstract methods
    public abstract double calculateAppraisalPrice();

    //methods
    public String   getStreetAddress() {
        return streetAddress;
    }

    public String   getZip() {
        return zip;
    }

    public void     setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void     setZip(String zip) {
        this.zip = zip;
    }

    public double   getAppraisalPrice() {
        return appraisalPrice;
    }

    public double   getListPrice() {
        return listPrice;
    }

    protected void  setAppraisalPrice(double appraisalPrice) {
        this.appraisalPrice = appraisalPrice;
    }

    public void     setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

}//end public class Property

