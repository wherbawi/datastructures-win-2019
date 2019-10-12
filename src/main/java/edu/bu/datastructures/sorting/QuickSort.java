package edu.bu.datastructures.sorting;

import java.util.Arrays;

public class QuickSort {

	public void sort(int[] data) {
		sort(data, 0, data.length - 1);
	}

	public void sort(int[] data, int l, int h) {
		if (l < h) {
			int x = partition(data, l, h);
			sort(data, l, x - 1);
			sort(data, x + 1, h);
		}
	}

	public int partition(int[] data, int l, int h) {
		int pivot = data[h];
		int candidateNewIndexOfPivot = l;
		for (int j = l; j < h; j++) {
			if (data[j] < pivot) {
				swap(data, candidateNewIndexOfPivot, j);
				candidateNewIndexOfPivot++;
			}
		}
		swap(data, candidateNewIndexOfPivot, h);
		return candidateNewIndexOfPivot;
	}

	private void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
}
