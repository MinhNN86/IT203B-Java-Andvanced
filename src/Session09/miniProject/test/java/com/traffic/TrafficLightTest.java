package Session09.miniProject.test.java.com.traffic;

import Session09.miniProject.main.java.com.traffic.pattern.state.*;

public class TrafficLightTest {

    void testStateTransition() {
        TrafficLight light = new TrafficLight();
        light.setState(new GreenState());
        assertEquals("GREEN", light.getCurrentSignal());

        light.setState(new YellowState());
        assertEquals("YELLOW", light.getCurrentSignal());

        light.setState(new RedState());
        assertEquals("RED", light.getCurrentSignal());
    }

    void testHandleTransitions() {
        TrafficLight light = new TrafficLight();

        light.setState(new GreenState());
        light.changeState();
        assertEquals("YELLOW", light.getCurrentSignal());

        light.changeState();
        assertEquals("RED", light.getCurrentSignal());
    }

    private static void assertEquals(String expected, String actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError("Expected=" + expected + ", actual=" + actual);
        }
    }
}