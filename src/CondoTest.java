import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CondoTest {

    private Condo condo =
            new Condo("this is where I live",
                    "99999",
                    5,
                    3,
                    1800,
                    2);

    @Test
    void getFloorLvl() {
       assertEquals(condo.getFloorLvl(), 2);
    }

    @Test
    void setFloorLvl() {
        condo.setFloorLvl(5);
        assertEquals(condo.getFloorLvl(), 5);
    }

    @Test
    void calculateAppraisalPrice() {
        //88	* 1800 = $158,400
        //8000	* 5	   = $40,000
        //10000	* 3	   = $30,000
        //5000	* 2	   = $5,000
        // TOTAL = 233400
        assertEquals(233400.00,condo.calculateAppraisalPrice());
    }
}