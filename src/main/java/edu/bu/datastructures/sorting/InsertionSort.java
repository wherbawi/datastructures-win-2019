package edu.bu.datastructures.sorting;

public class InsertionSort {
	public void sort(int data[]) {
		for (int i = 1; i < data.length; i++) {
			int j = i;
			while (j > 0 && data[j] < data[j - 1]) {
				swap(data, j, j - 1);
				j--;
			}
		}
	}
	private void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
}
