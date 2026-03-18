package Session09.miniProject.main.java.com.traffic.pattern.state;

public interface TrafficLightState {
    void handle(TrafficLight context);

    String getName();
}