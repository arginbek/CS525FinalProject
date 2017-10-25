package edu.mum.cs.cs525.labs.exercises.project.notification;

public interface Observable<E> {

    void notifyAllObservers(E element, ObserverEvent eventType);

    void addObserver(Observer<E> observer);

    void removeObserver(Observer<E> observer);
}
