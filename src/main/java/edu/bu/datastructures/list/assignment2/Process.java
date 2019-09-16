package edu.bu.datastructures.list.assignment2;

import java.util.logging.Logger;

public class Process {
	private String name;
	private int remainigTime;

	public Process(String name, int remainigTime) {
		super();
		this.remainigTime = remainigTime;
		this.setName(name);
	}

	public void execute(int quantum) {
		int timeToExecute = Math.min(quantum, remainigTime);
		System.out.println(String.format("now executing process %s for period %d", getName(), timeToExecute));
		try {
			Thread.sleep(timeToExecute * 1000);
		} catch (InterruptedException e) {
			System.out.println("execution error");
		}
		remainigTime -= timeToExecute;
	}

	public boolean finished() {
		return remainigTime == 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
