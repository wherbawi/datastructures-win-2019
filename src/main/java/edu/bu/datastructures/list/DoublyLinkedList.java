package edu.bu.datastructures.list;

public class DoublyLinkedList<T> implements BUList<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size;

	public DoublyLinkedList() {
	}

	public int size() {
		return size;
	}

	public T get(int i) {
		T data = getData(i);
		return data;
	}

	public void set(int i, T x) {
		Node<T> targetNode = getNodeAtIndex(i);
		targetNode.setData(x);
	}

	public void add(int index, T x) {
		Node<T> newNode = new Node<T>();
		newNode.setData(x);

		if (index == 0) {
			addFirstPositionNode(newNode);
			return;
		}
		// ...predNode-successorNode (newNode to come in between)
		Node<T> predNode = getNodeAtIndex(index - 1);
		Node<T> successorNode = predNode.next;
		newNode.setNext(successorNode);
		successorNode.setPrev(newNode);
		predNode.setNext(newNode);
		newNode.setPrev(predNode);
		size++;
	}

	public void add(T x) {
		Node<T> newNode = new Node<T>();
		newNode.setData(x);
		newNode.setNext(null);
		newNode.setPrev(null);
		if (size == 0) {
			setHead(newNode);
			setTail(newNode);
		} else {
			newNode.setPrev(getTail());
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
			head.prev = null;
			toRemoveNode.next = null;// remove the pointer to the next node to avoid any future side effects
			size--;
			return toRemoveNode.getData();
		}
		// ...predNode-toRemoveNode-successorNode
		Node<T> predNode = getNodeAtIndex(i - 1);
		toRemoveNode = predNode.next;
		Node<T> successorNode = toRemoveNode.next;// this might be null if i=size-1 (removing last element)
		predNode.next = successorNode;
		if (successorNode != null)
			successorNode.prev = predNode;

		toRemoveNode.next = null;
		toRemoveNode.prev = null;
		size--;
		return toRemoveNode.getData();
	}

	public int getSize() {
		return size;
	}

	private T getData(int index) {
		int i = 0;
		Node<T> currData = getHead();
		while (i != index) {
			currData = currData.getNext();
			i++;
		}

		return currData.data;
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

	private Node<T> getNodeAtIndex(int index) {
		int i = 0;
		Node<T> currNode = getHead();
		while (i != index) {
			currNode = currNode.getNext();
			i++;
		}
		return currNode;
	}

	private void addFirstPositionNode(Node<T> newNode) {
		newNode.setNext(getHead());
		getHead().setPrev(newNode);
		setHead(newNode);
		size++;
	}

	class Node<T> {
		private T data;
		private Node<T> next;
		private Node<T> prev;

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

		public Node<T> getPrev() {
			return prev;
		}

		public void setPrev(Node<T> prev) {
			this.prev = prev;
		}

	}

	@Override
	public void addAll(BUList<T> other) {
		// TODO impl this method

	}

	@Override
	public void addAll(int index, BUList<T> other) {
		// TODO Impl this method

	}

	@Override
	public void reverse() {
		// TODO Impl this method. This simply reverse the order of the list elements as
		// in the other list implementations. See linkedList reverse()

	}

	public void remove(T data) {
		// TODO impl this method. for more description see point 2 in the assignment
	}

}
