import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseTest {
    
    private House house = new House();
    private Property home =
            new House(
                    "this is where I live",
                    "84014",
                    3,
                    2,
                    1000,
                    3.9);

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

    @Test
    void calculateAppraisalPrice() {
        //	        cost	count	line total
        //sq ft	    97	    1000	 $97,000
        //beds	    10000	3	    $30,000
        //baths	    12000	2	    $24,000
        //lvl	    460000	3.9	    $1,380,000
        //			                $1,531,000
        assertEquals(1531000,home.calculateAppraisalPrice());
    }
}