import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CondoTest {

    private final Condo condo = new Condo();

    @Test
    void getFloorLvl() {
       assertEquals(condo.getFloorLvl(), 0);
    }

    @Test
    void setFloorLvl() {
        condo.setFloorLvl(5);
        assertEquals(condo.getFloorLvl(), 5);
    }
}