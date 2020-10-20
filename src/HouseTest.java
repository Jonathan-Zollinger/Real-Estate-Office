import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseTest {
    
    private House house = new House();

    @Test
    void getYardAcres() {
        assertEquals(0, house.getYardAcres());
    }

    @Test
    void setYardAcres() {
        double yardage = 123.45;
        house.setYardAcres(yardage);
        assertEquals(yardage, house.getYardAcres());
    }
}