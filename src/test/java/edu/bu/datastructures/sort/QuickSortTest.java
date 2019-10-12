package edu.bu.datastructures.sort;

import java.util.Arrays;

import org.junit.Test;

import edu.bu.datastructures.sorting.QuickSort;

public class QuickSortTest {
	@Test
	public void testSort() {
		int[] a = { 6, 44, 5, 8, 2, 7 };
		QuickSort quickSort = new QuickSort();
		quickSort.sort(a);
		System.out.println(Arrays.toString(a));

	}
}
