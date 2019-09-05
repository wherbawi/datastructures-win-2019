package edu.bu.datastructures.list;

public interface BUList<T> {
	public int size();

	public T get(int i);

	public void set(int i, T x);

	public void add(int i, T x);

	public void add(T x);

	public T remove(int i);
	
	public void addAll(BUList<T> other);
	
	public void addAll(int index,BUList<T> other);
	
	public void reverse();
}
