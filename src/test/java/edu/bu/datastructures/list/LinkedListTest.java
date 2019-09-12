package edu.bu.datastructures.list;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import edu.bu.datastructures.list.ArrayBasedList;
import edu.bu.datastructures.list.LinkedList;

public class LinkedListTest {
	@Test
	public void testSizeOfEmptyList() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		assertEquals(0, list.size());
		List<Integer> l;
	}

	@Test
	public void testSizeOfList() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(3);
		list.add(4);
		assertEquals(2, list.size());
	}

	@Test
	public void testAddingToList() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(3);
		assertEquals(3, (int) list.get(0));
	}

	@Test
	public void testAddingToListAtPosition() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(3);
		list.add(0, 5);
		assertEquals(5, (int) list.get(0));
		assertEquals(3, (int) list.get(1));
		assertEquals(2, list.size());
	}

	@Test
	public void testListSet() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(3);
		list.add(20);
		list.set(0, 5);
		list.set(1, 1);
		assertEquals(5, (int) list.get(0));
		assertEquals(1, (int) list.get(1));
		assertEquals(2, list.size());
	}

	@Test
	public void testListRemoveFirstEntry() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(3);
		list.add(20);
		list.remove(0);
		assertEquals(1, list.size());
		assertEquals(20, (int) list.get(0));
	}

	@Test
	public void testListRemoveFirstAndOnlyEntry() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(3);
		list.remove(0);
		assertEquals(0, list.size());
	}

	@Test
	public void testListRemoveEntry() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(3);
		list.add(20);
		list.add(30);
		list.remove(1);
		assertEquals(2, list.size());
		assertEquals(30, (int) list.get(1));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemovingFromEmptyList() {
		BUList<Integer> list = new LinkedList<Integer>();
		Integer removed = list.remove(0);
	}

	@Test
	public void testReverseList() {
		BUList<Integer> list = new LinkedList<Integer>();
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
	public void testAddAllAtIndex() {
		BUList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		// list2 could be any list of type BUList
		BUList<Integer> list2 = new ArrayBasedList<Integer>();

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
