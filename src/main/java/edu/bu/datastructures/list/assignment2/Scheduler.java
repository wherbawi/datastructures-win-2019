package edu.bu.datastructures.list.assignment2;

import edu.bu.datastructures.list.BUList;
import edu.bu.datastructures.list.CircularLinkedList;

public class Scheduler {
	BUList<Process> processes;
	private int quantum;

	public Scheduler(BUList<Process> processes, int quantum) {
		this.processes = processes;
		this.quantum = quantum;
	}

	public void add(Process p) {
		processes.add(p);
	}

	public void execute() {
		if (processes instanceof CircularLinkedList) {
			executeWithCircular();
		}
		while (processes.size() > 0) {
			Process toExecute = processes.remove(0);
			toExecute.execute(quantum);
			if (!toExecute.finished())
				processes.add(toExecute);
		}
	}

	private void executeWithCircular() {
		while (processes.size() > 0) {
			Process toExecute = processes.get(0);
			toExecute.execute(quantum);
			if (toExecute.finished())
				processes.remove(0);
			else
				((CircularLinkedList) processes).rotate();

		}

	}
}
