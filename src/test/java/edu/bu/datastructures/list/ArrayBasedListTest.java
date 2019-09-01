package edu.bu.datastructures.list;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import edu.bu.datastructures.list.ArrayBasedList;

public class ArrayBasedListTest {
	@Test
	public void testSizeOfEmptyList() {
		ArrayBasedList<Integer> list = new ArrayBasedList<Integer>();
		assertEquals(0, list.size());
	}

	@Test
	public void testAddingToList() {
		ArrayBasedList<Integer> list = new ArrayBasedList<Integer>();
		list.add(3);
		assertEquals(3, (int) list.get(0));
	}

	@Test
	public void testAddingToListAtPosition() {
		ArrayBasedList<Integer> list = new ArrayBasedList<Integer>();
		list.add(3);
		list.add(0, 5);

		int actual = (int) list.get(0);
		assertEquals(5, actual);

		assertEquals(2, list.size());
	}

	@Test
	public void testAddingToListWithFullArray() {
		ArrayBasedList<Integer> list = new ArrayBasedList<Integer>(3);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		assertEquals(4, (int) list.size());
		assertEquals(4, (int) list.get(3));
	}

	@Test
	public void testAddingAtIndexToListWithFullArray() {
		ArrayBasedList<Integer> list = new ArrayBasedList<Integer>(3);
		list.add(1);
		list.add(2);
		list.add(4);
		list.add(2, 3);
		assertEquals(4, (int) list.size());
		assertEquals(3, (int) list.get(2));
		assertEquals(4, (int) list.get(3));
	}

	@Test
	public void testRemovingFromList() {
		ArrayBasedList<Integer> list = new ArrayBasedList<Integer>();
		list.add(3);
		list.add(4);
		Integer removed = list.remove(1);
		assertEquals(4, (int) removed);
		assertEquals(1, list.size());
	}
	// TODO: add more tests 1) test removing from empty list 2)adding to full list
	// 3)add test for cases that expect exception
}
