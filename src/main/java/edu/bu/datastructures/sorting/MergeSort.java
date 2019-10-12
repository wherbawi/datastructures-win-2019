package edu.bu.datastructures.sorting;

import java.util.Arrays;

public class MergeSort {
	public void sort(int[] data) {
		if (data.length < 2)
			return;
		int mid = (data.length) / 2;
		int[] leftHalf = Arrays.copyOfRange(data, 0, mid);
		int[] rightHalf = Arrays.copyOfRange(data, mid, data.length);
		sort(leftHalf);
		sort(rightHalf);
		merge(data, leftHalf, rightHalf);

	}

	private void merge(int[] data, int[] leftHalf, int[] rightHalf) {

		int indexOfLeftHalf = 0;
		int indexOfRightHalf = 0;
		int indexOfParent = 0;
		while (indexOfLeftHalf < leftHalf.length && indexOfRightHalf < rightHalf.length) {
			if (leftHalf[indexOfLeftHalf] < rightHalf[indexOfRightHalf]) {
				data[indexOfParent] = leftHalf[indexOfLeftHalf];
				indexOfLeftHalf++;
			} else {
				data[indexOfParent] = rightHalf[indexOfRightHalf];
				indexOfRightHalf++;
			}
			indexOfParent++;
		}

		while (indexOfLeftHalf < leftHalf.length) {
			data[indexOfParent] = leftHalf[indexOfLeftHalf];
			indexOfLeftHalf++;
			indexOfParent++;
		}
		while (indexOfRightHalf < rightHalf.length) {
			data[indexOfParent] = rightHalf[indexOfRightHalf];
			indexOfRightHalf++;
			indexOfParent++;
		}

	}
}
