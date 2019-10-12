package edu.bu.datastructures.sorting;

public class BubbleSort {
	public void sort(int[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length - 1 - i; j++) {
				if (data[j] > data[j + 1])
					swap(data, j, j + 1);
			}
		}
	}
	private void swap(int[] data, int j, int i) {
		int temp = data[j];
		data[j] = data[i];
		data[i] = temp;

	}
}
