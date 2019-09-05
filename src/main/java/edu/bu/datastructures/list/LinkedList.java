package edu.bu.datastructures.list;

public class LinkedList<T> implements BUList<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size;

	public LinkedList() {
	}
	
	public int size() {
		return size;
	}

	public T get(int i) {
		// TODO check if i<0 or i>=size--> throw exception
		T data = getData(i);
		return data;
	}

	public void set(int i, T x) {
		// TODO: check if index is valid
		Node<T> targetNode = getNodeAtIndex(i);
		targetNode.setData(x);

	}

	public void add(int index, T x) {
		// TODO check if dataIndex is valid
		Node<T> newNode = new Node<T>();
		newNode.setData(x);

		if (index == 0) {
			addFirstPositionNode(newNode);
			return;
		}

		Node<T> predNode = getNodeAtIndex(index - 1);
		newNode.setNext(predNode.getNext());
		predNode.setNext(newNode);
		size++;

	}

	public void add(T x) {
		Node<T> newNode = new Node<T>();
		newNode.setData(x);
		newNode.setNext(null);
		if (size == 0) {
			setHead(newNode);
			setTail(newNode);
		} else {
			getTail().setNext(newNode);
			setTail(newNode);
		}
		size++;
	}

	public T remove(int i) {
		// TODO: check if i is valid
		Node<T> toRemoveNode;
		if (i == 0) { // special case when deleting the first node
			toRemoveNode = head;
			head = head.next;
			toRemoveNode.next = null;// remove the pointer to the next node to avoid any future side effects
			size--;
			return toRemoveNode.getData();
		}

		Node<T> predNode = getNodeAtIndex(i - 1);
		toRemoveNode = predNode.next;
		predNode.next = toRemoveNode.next;
		toRemoveNode.next = null;
		size--;
		return toRemoveNode.getData();
	}

	public int getSize() {
		return size;
	}

	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	public Node<T> getTail() {
		return tail;
	}

	public void setTail(Node<T> tail) {
		this.tail = tail;
	}

	private void addFirstPositionNode(Node<T> newNode) {
		newNode.setNext(getHead());
		setHead(newNode);
		size++;
	}

	private T getData(int index) {
		Node<T> currData = getNodeAtIndex(index);
		return currData.data;
	}

	private Node<T> getNodeAtIndex(int index) {
		int i = 0;
		Node<T> currNode = getHead();
		while (i != index) {
			currNode = currNode.getNext();
			i++;
		}
		return currNode;
	}

	class Node<T> {
		private T data;
		private Node<T> next;

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}
	}

	@Override
	public void addAll(BUList<T> other) {
		// TODO add all elements of other to this list in order
		
	}

	@Override
	public void addAll(int index, BUList<T> other) {
		// TODO add all elements of other to this list in order starting from index. Shift all elements after index
		
	}

	@Override
	public void reverse() {
		// TODO reverse the elements of the list
		
	}
}
