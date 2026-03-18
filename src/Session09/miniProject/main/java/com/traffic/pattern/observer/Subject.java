package Session09.miniProject.main.java.com.traffic.pattern.observer;

public interface Subject {
    void registerObserver(Observer o);
    void notifyObservers(String signal);
}