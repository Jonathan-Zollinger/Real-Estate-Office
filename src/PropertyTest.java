import static org.junit.jupiter.api.Assertions.*;

class PropertyTest {

    private final Property property = new Property();

    @org.junit.jupiter.api.Test
    void getStreetAddress() {
        assertEquals("",property.getStreetAddress());
    }

    @org.junit.jupiter.api.Test
    void getZip() {
        assertEquals("",property.getZip());
    }

    @org.junit.jupiter.api.Test
    void setStreetAddress() {
        String address = "SLC, UT";
        property.setStreetAddress(address);
        assertEquals(address,property.getStreetAddress());
    }

    @org.junit.jupiter.api.Test
    void setZip() {
        String zip = "84044";
        property.setZip(zip);
        assertEquals(zip,property.getZip());
    }
}