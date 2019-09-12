package edu.bu.datastructures.list;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

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
		List<Integer> l = new ArrayList<>();

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

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemovingFromEmptyList() {
		ArrayBasedList<Integer> list = new ArrayBasedList<Integer>();
		Integer removed = list.remove(0);

	}

	@Test
	public void testReverseList() {
		ArrayBasedList<Integer> list = new ArrayBasedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);

		list.reverse();

		assertEquals(3, list.size());
		assertEquals((int) 3, (int) list.get(0));
		assertEquals((int) 2, (int) list.get(1));
		assertEquals((int) 1, (int) list.get(2));

	}

	@Test
	public void testAddAll() {
		ArrayBasedList<Integer> list = new ArrayBasedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);

		ArrayBasedList<Integer> list2 = new ArrayBasedList<Integer>();

		list2.add(5);
		list2.add(6);
		list2.add(7);

		list.addAll(list2);
		assertEquals(6, list.size());
		assertEquals((int) 1, (int) list.get(0));
		assertEquals((int) 2, (int) list.get(1));
		assertEquals((int) 3, (int) list.get(2));
		assertEquals((int) 5, (int) list.get(3));
		assertEquals((int) 6, (int) list.get(4));
		assertEquals((int) 7, (int) list.get(5));

	}

	@Test
	public void testAddAllAtIndex() {
		ArrayBasedList<Integer> list = new ArrayBasedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);

		ArrayBasedList<Integer> list2 = new ArrayBasedList<Integer>();

		list2.add(5);
		list2.add(6);
		list2.add(7);

		list.addAll(1, list2);
		assertEquals(6, list.size());
		assertEquals((int) 1, (int) list.get(0));
		assertEquals((int) 5, (int) list.get(1));
		assertEquals((int) 6, (int) list.get(2));
		assertEquals((int) 7, (int) list.get(3));
		assertEquals((int) 2, (int) list.get(4));
		assertEquals((int) 3, (int) list.get(5));

	}
}
