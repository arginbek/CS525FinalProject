package edu.mum.cs.cs525.labs.exercises.project.framework;

import java.util.Observable;

public interface Observer {
	void update(Observable o, Object arg);
}
