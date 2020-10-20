import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ResidentialTest {

    private Residential residential = new Residential();

    @Test
    void getBeds() {
        assertEquals(residential.getBeds(),0);
    }

    @Test
    void getBaths() {
        assertEquals(residential.getBaths(),0);
    }

    @Test
    void getSize() {
        assertEquals(residential.getSize(),0);
    }

    @Test
    void setBeds() {
        int beds = 3;
        residential.setBeds(beds);
        assertEquals(residential.getBeds(),beds);
    }

    @Test
    void setBaths() {
        int baths = 5;
        residential.setBaths(baths);
        assertEquals(residential.getBaths(),baths);
    }

    @Test
    void setSize() {
        double size = 234.56;
        residential.setSize(size);
        assertEquals(residential.getSize(),size);
    }
}