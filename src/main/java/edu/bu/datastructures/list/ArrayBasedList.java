package edu.bu.datastructures.list;

import java.util.Stack;

public class ArrayBasedList<T> implements BUList<T> {
	private static final int DEFAULT_CAPACITY = 20;
	private T[] elements;
	private int size;

	public ArrayBasedList() {
		this(DEFAULT_CAPACITY);
	}

	public ArrayBasedList(int capacity) {
		elements = (T[]) new Object[capacity];
	}

	public int size() {
		return size;
	}

	public T get(int i) {
		if (violateBound(i))
			throw new IndexOutOfBoundsException(String.format("index %d, size %d", i, size));
		return elements[i];
	}

	public void set(int i, T x) {
		if (violateBound(i))
			throw new IndexOutOfBoundsException(String.format("index %d, size %d", i, size));
		elements[i] = x;
	}

	public void add(int i, T x) {
		if (violateBound(i))
			throw new IndexOutOfBoundsException(String.format("index %d, size %d", i, size));
		if (isFullArray())
			resize();
		shiftForwards(i);
		elements[i] = x;
		size++;
	}

	public T remove(int i) {
		if (violateBound(i))
			throw new IndexOutOfBoundsException(String.format("index %d, size %d", i, size));
		T x = elements[i];
		shiftBack(i);
		size--;
		return x;
	}

	public void add(T x) {
		if (isFullArray())
			resize();
		elements[size] = x;
		size++;
	}

	private void resize() {
		T[] tmp = (T[]) new Object[elements.length * 2];
		copy(elements, tmp);
		elements = tmp;
	}

	private boolean violateBound(int i) {
		return i < 0 || i >= size;
	}

	private void copy(T[] source, T[] destination) {
		for (int i = 0; i < source.length; i++) {
			destination[i] = source[i];
		}
	}

	private boolean isFullArray() {
		return size == elements.length;
	}

	private void shiftForwards(int startShiftingIndex) {
		for (int i = size; i > startShiftingIndex; i--) {
			elements[i] = elements[i - 1];
		}
	}

	private void shiftBack(int startShiftingIndex) {
		for (int i = startShiftingIndex; i < size - 1; i++) {
			elements[i] = elements[i + 1];
		}
	}

	@Override
	public void addAll(BUList<T> other) {
		for (int i = 0; i < other.size(); i++) {
			add(other.get(i));
		}
	}

	@Override
	public void addAll(int index, BUList<T> other) {
		if (violateBound(index))
			throw new IndexOutOfBoundsException(String.format("index %d, size %d", index, size));
		// easiest approach, still you can shift by other.size() starting from index
		// before you start adding to avoid multiple shifts.
		for (int i = 0; i < other.size(); i++) {
			add(index + i, other.get(i));
		}
	}

	@Override
	public void reverse() {
		Stack<T> stack = new Stack<>();
		for (int i = 0; i < size; i++) {
			stack.add(remove(0));
		}
		while (!stack.empty()) {
			add(stack.pop());
		}
	}
}
