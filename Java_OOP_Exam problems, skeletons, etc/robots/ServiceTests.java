package robots;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceTests {

    Service service;

    @Before
    public void setUp() {
        service = new Service("test", 4);
        Robot robot = new Robot("robotOne");
        Robot robot2 = new Robot("robotTwo");
        Robot robot3 = new Robot("robotThree");
        service.add(robot);
        service.add(robot2);
        service.add(robot3);
    }




    @Test
    public void testConstructor() {
        Service service = new Service("test", 4);
        assertEquals("test", service.getName());
        assertEquals(4, service.getCapacity());
        assertEquals(0, service.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorWithNullName() {
        Service service = new Service(null, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNegativeCapacity() {
        Service service = new Service("test", -1);
    }

    @Test
    public void testGetCountShouldReturnCorrectCount() {
        assertEquals(3, service.getCount());
    }

    @Test
    public void testAddShouldAddRobot() {
        Robot robot = new Robot("robotFour");
        service.add(robot);
        assertEquals(4, service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowExceptionWhenListIsFull() {
        Robot robot = new Robot("robotFour");
        Robot robot2 = new Robot("robotFive");

        service.add(robot);
        service.add(robot2);
    }

    @Test
    public void testRemoveShouldRemoveRobot() {
        service.remove("robotOne");
        assertEquals(2, service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveShouldThrowExceptionIfTheRobotDoesntExist() {
        service.remove("robotFour");
    }

    @Test
   public void testForSaleShouldSetReadyForSaleShouldSetFalse(){
       Service service = new Service("test", 4);
         Robot robot = new Robot("robotOne");
         service.add(robot);
         service.forSale("robotOne");
         assertFalse(robot.isReadyForSale());
    }

    @Test
    public void testForSaleShouldReturnTheRightRobot(){
        Service service = new Service("test", 4);
        Robot robot = new Robot("robotOne");
        service.add(robot);
        Robot actual = service.forSale("robotOne");
        assertEquals(robot, actual);

    }
    @Test (expected = IllegalArgumentException.class)
    public void testForSaleShouldThrowExceptionIfRobotDoesntExist(){

        service.forSale("robotFour");


    }

    @Test
    public void testReport(){
        String expected = "The robot robotOne, robotTwo, robotThree is in the service test!";
        String actual = service.report();
        assertEquals(expected, actual);
    }









}




