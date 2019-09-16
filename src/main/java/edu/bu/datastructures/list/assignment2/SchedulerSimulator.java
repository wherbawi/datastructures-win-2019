package edu.bu.datastructures.list.assignment2;

import edu.bu.datastructures.list.ArrayBasedList;

public class SchedulerSimulator {

	public static void main(String[] args) {
		Scheduler s = new Scheduler(new ArrayBasedList<>(), 1);
		s.add(new Process("P1", 11));
		s.add(new Process("P2", 10));
		s.execute();
		System.out.println("done");
	}

}
