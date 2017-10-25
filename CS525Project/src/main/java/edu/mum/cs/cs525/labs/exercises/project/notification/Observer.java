package edu.mum.cs.cs525.labs.exercises.project.notification;

public interface Observer<E> {

    void update(E element, ObserverEvent eventType);
}
