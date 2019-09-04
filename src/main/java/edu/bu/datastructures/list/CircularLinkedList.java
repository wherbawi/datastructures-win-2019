package edu.bu.datastructures.list;

public class CircularLinkedList<T> extends LinkedList<T> implements CircularList<T> {

	@Override
	public void add(T x) {
		super.add(x);
		getTail().setNext(getHead());
	}

	@Override
	public void add(int index, T x) {
		super.add(index, x);
		if(index==0)
			getTail().setNext(getHead());;
	}

	@Override
	public void rotate() {
		// size()>0?
		setHead(getHead().getNext());
		setTail(getTail().getNext());
	}

}
