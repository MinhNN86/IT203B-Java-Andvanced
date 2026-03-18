package Session08.Ex04.subject;

import Session08.Ex04.observer.Observer;

public interface Subject {

    void attach(Observer o);

    void detach(Observer o);

    void notifyObservers();
}
