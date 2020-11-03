import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyTest {

    private final Property property = new House();
    private Property house =
            new House(
                    "this is where I live",
                    "84014",
                    3,
                    2,
                    1000,
                    3.5);

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

    @Test
    void getAppraisalPrice() {
        house.setAppraisalPrice(5.3);
        assertEquals(house.getAppraisalPrice(),5.3);
    }

    @Test
    void getListPrice() {
        house.setListPrice(9.8);
        assertEquals(house.getListPrice(),9.8);
    }

    @Test
    void setAppraisalPrice() {
        house.setAppraisalPrice(5.3);
        assertEquals(house.getAppraisalPrice(),5.3);
    }

    @Test
    void setListPrice() {
        house.setListPrice(9.8);
        assertEquals(house.getListPrice(),9.8);
    }
}