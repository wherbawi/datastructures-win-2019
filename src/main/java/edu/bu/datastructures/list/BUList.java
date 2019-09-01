package edu.bu.datastructures.list;

public interface BUList<T> {
	public int size();

	public T get(int i);

	public void set(int i, T x);

	public void add(int i, T x);

	public void add(T x);

	public T remove(int i);
}
