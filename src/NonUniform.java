
/**
 * This program uses the creation of 3 different formats of
 * arrays to hypothesize, test and Benchmark Sorting
 * Algorithms.
 * 
 * @author Luis Ramirez-Zamacona, Professor Acuna
 * @version 06/12/2019
 */

import java.util.Random;

public class NonUniform {
	static Integer[] array; // static Integer array

	/**
	 * Creates, prints and returns array with half
	 * of the elements being 0's and the other half
	 * being 1's.
	 * 
	 * @param numElements Number of elements
	 * @return an array with 0's and 1's
	 */
	public static Integer[] halfZeros(int numElements) {
		// Create array
		array = new Integer[numElements];

		// Initialize values in array to 0's and 1's
		for (int i = 0; i < numElements; i++) {
			if (i < (numElements / 2)) {
				array[i] = 0;
			} else {
				array[i] = 1;
			}
		}

		// Print array
		toString(array);

		// Shuffle elements of the array
		Randomize(array);

		// return array
		return array;
	}

	/**
	 * Creates, prints and returns array with half
	 * of the elements being 0's and increasing the values
	 * as number of elements are halved.
	 * 
	 * @param numElements Number of elements
	 * @return an array with 0's and remainders
	 */
	public static Integer[] halfRemainders(int numElements) {
		// Create array
		array = new Integer[numElements];

		// Initialize half to half of the total number of elements
		int half = numElements / 2;

		// Initialize temp to half of half
		int temp = half / 2;

		// Initialize value to 0
		int value = 0;

		// Create array with 0's and remainders
		for (int i = 0; i < numElements; i++) {
			// If i is greater than or equal to half,
			// change halfway point and IT's halfway point
			if (i >= half) {
				half = half + temp;
				temp /= 2;

				// Increase value by 1
				value++;
			}

			// ith element equals value
			array[i] = value;
		}

		// Print array
		toString(array);

		// Shuffle elements in array
		Randomize(array);

		// return array
		return array;
	}

	/**
	 * Creates, prints and returns array with half
	 * of the elements being 0's and the other half
	 * being random.
	 * 
	 * @param numElements Number of elements
	 * @return an array with 0's and random integers
	 */
	public static Integer[] halfRandom(int numElements) {
		// Create array
		array = new Integer[numElements];

		// Create an Object of Random class
		Random random = new Random();

		// Initialize array values with 0's and randoms
		for (int i = 0; i < numElements; i++) {
			if (i < numElements / 2) {
				array[i] = 0;
			} else {
				array[i] = random.nextInt();
			}
		}

		// Print array
		toString(array);

		// Shuffle elements in array
		Randomize(array);

		// return array
		return array;
	}

	/**
	 * Shuffle elements of array
	 * 
	 * @param array array of Integers
	 * @return array
	 */
	public static Integer[] Randomize(Integer[] array) {
		// Create an Object of Random class
		Random random = new Random();

		// Shuffle the elements in array
		for (int i = 0; i < array.length; i++) {
			// Pick a random index
			int j = random.nextInt(i + 1);

			// Swap ith element at random index
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}

		// Print array
		toString(array);

		// return array
		return array;
	}

	/**
	 * Calculate b to find Big-OH
	 * 
	 * @param tN  time of N
	 * @param tN2 time of 2N
	 * @return b
	 */
	public static double Log(double tN, double tN2) {
		// Doubling Formula
		double b = Math.log(tN2 / tN);

		// return b
		return b;
	}

	/**
	 * Print the array
	 * 
	 * @param array array of Integer
	 */
	public static void toString(Integer[] array) {
		// Prints array
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);

			if (i < array.length - 1) {
				System.out.print(", ");
			}
		}

		System.out.println("]");
	}

	public static void main(String[] args) {
		// Initialize value of number of elements
		int numberOfElements = 4096;

		// Create object of Stopwatch class
		Stopwatch stopwatch = new Stopwatch();

		// Declare time variable
		double time;

		// Create Integer array of half 0's and half 1's
		Integer[] data1 = halfZeros(numberOfElements);
		System.out.println();

		// Create Integer array of half 0's and half remainders
		Integer[] data2 = halfRemainders(numberOfElements);
		System.out.println();

		// Create Integer array of half 0's and half randoms
		Integer[] data3 = halfRandom(numberOfElements);
		System.out.println();

		/*
		 * Note Prior to Hypotheses:
		 * Data1 is array that has half 0's and half 1's
		 * Data2 is array that has half 0's, with increasing remainders
		 * Data3 is array that has half 0's and half random integers
		 * 
		 * Hypotheses for Insertion Sort
		 * For insertion sort I would say that all 3 arrays have the possibility
		 * to be O(n) when the number of elements of the arrays are low because
		 * with insertion sort the method will read the integer at the current
		 * element and compare it to the other integers in the array to find
		 * the smallest integer and swap it with the current element in the loop
		 * if needed. For all 3 data sets, each loop will quickly run into a small
		 * integer since half of them are 0's. Although I think that Data2 and
		 * Data3 have the possibility of being O(n), I also think that they could
		 * be O(n^2) depending on what the other integers are which depends on how
		 * many elements there are in the arrays. For example, once Data2 reaches
		 * a certain number of elements, the integers in the array will no longer
		 * just be 0's, 1's, or 2's. Same goes for Data3 except that it will include
		 * a wide variety of random numbers including negatives.
		 * Data1 - O(n)
		 * Data2 - O(n) or O(n^2)
		 * Data3 - O(n) or O(n^2)
		 * 
		 * Hypotheses for Selection Sort
		 * For selection sort I think that all 3 arrays are capable of being O(n^2)
		 * at their best, but Data2 and Data 3 could also be O(n^3) due to the
		 * wide range of integers when the arrays are set to a high number of
		 * elements. The reason Selection sort would take longer than insertion sort
		 * is due to the fact that insertion sort is comparing 1 integer to the rest
		 * of the array and keeping that integer or swapping it if there's another
		 * integer smaller than it, whereas selection sort will go down the array and
		 * make several swaps sorting the array along the way until it reaches the end
		 * of the array. For example if there are 50 elements and elements 0 through 48
		 * have been sorted with integers ranging from 1 to 49, but element 49 contains
		 * 0; selection sort will compare and swap that 0 with all 49 of the integers
		 * that are before in order to sort that array. Thus, selection sort takes
		 * longer than insertion sort for all 3 arrays and with the integers that
		 * are possible for Data2 and Data3, selection sort can take longer than Data1.
		 * Data1 - O(n^2)
		 * Data2 - O(n^2) or O(n^3)
		 * Data3 - O(n^2) or O(n^3)
		 * 
		 * Hypotheses for Shell Sort
		 * Since my hypotheses is that insertion sort is faster than selection sort
		 * than I would say that shell sort is also faster than selection sort since
		 * shell sort incorporates insertion sort in it. I think that shell sort
		 * will be O(n) for all 3 arrays due to the fact that 2 integers that are in 2
		 * different ends in the array are being compared and swapped if necessary and
		 * with half of the integers in all 3 of the arrays being 0's, most of the array
		 * will have been sorted prior to the final insertion sort that takes place.
		 * Data1 - O(n)
		 * Data2 - O(n)
		 * Data3 - O(n)
		 */

		/*
		 * Tests for 4096 elements
		 * Before SelectionSort(Data1): 1.469
		 * After SelectionSort(Data1): 1.639
		 * Total Data1: 0.17
		 * 
		 * Before SelectionSort(Data2): 2.509
		 * After SelectionSort(Data2): 2.769
		 * Total Data2: 0.26
		 * 
		 * Before SelectionSort(Data3): 2.314
		 * After SelectionSort(Data3): 2.624
		 * Total Data3: 0.31
		 * 
		 * Before ShellSort(Data1): 2.444
		 * After ShellSort(Data1): 2.474
		 * Total Data1: 0.03
		 * 
		 * Before ShellSort(Data2): 1.317
		 * After ShellSort(Data2): 1.357
		 * Total Data2: 0.04
		 * 
		 * Before ShellSort(Data3): 1.381
		 * After ShellSort(Data3): 1.431
		 * Total Data3: 0.05
		 */

		/*
		 * Tests for 8192 elements
		 * Before SelectionSort(Data1): 2.046
		 * After SelectionSort(Data1): 2.49
		 * Total Data1: 0.444
		 * 
		 * Before SelectionSort(Data2): 1.93
		 * After SelectionSort(Data2): 2.41
		 * Total Data2: 0.48
		 * 
		 * Before SelectionSort(Data3): 2.05
		 * After SelectionSort(Data3): 2.553
		 * Total Data3: 0.503
		 * 
		 * Before ShellSort(Data1): 2.164
		 * After ShellSort(Data1): 2.224
		 * Total Data1: 0.06
		 * 
		 * Before ShellSort(Data2): 1.91
		 * After ShellSort(Data2): 1.98
		 * Total Data2: 0.07
		 * 
		 * Before ShellSort(Data3): 2.108
		 * After ShellSort(Data3): 2.188
		 * Total Data3: 0.08
		 */

		/*
		 * Result of Doubling Formula
		 * SelectionSort(Data1) b = 0.960026125381963
		 * 
		 * SelectionSort(Data2) b = 0.6131044728864088
		 * 
		 * SelectionSort(Data3) b = 0.48401787262054724
		 * 
		 * ShellSort(Data1) b = 0.6931471805599453
		 * 
		 * ShellSort(Data2) b = 0.5596157879354228
		 * 
		 * ShellSort(Data3) b = 0.47000362924573547
		 */

		time = stopwatch.elapsedTime();
		System.out.println("Time before sorting begins: " + time);
		System.out.println();

		SelectionSort.sort(data1);
		time = stopwatch.elapsedTime();
		System.out.println("SelectionSort(Data1): " + time);
		System.out.println();

		SelectionSort.sort(data2);
		time = stopwatch.elapsedTime();
		System.out.println("SelectionSort(Data2): " + time);
		System.out.println();

		SelectionSort.sort(data3);
		time = stopwatch.elapsedTime();
		System.out.println("SelectionSort(Data3): " + time);
		System.out.println();

		ShellSort.sort(data1);
		time = stopwatch.elapsedTime();
		System.out.println("ShellSort(Data1): " + time);
		System.out.println();

		ShellSort.sort(data2);
		time = stopwatch.elapsedTime();
		System.out.println("ShellSort(Data2): " + time);
		System.out.println();

		ShellSort.sort(data3);
		time = stopwatch.elapsedTime();
		System.out.println("ShellSort(Data3): " + time);
		System.out.println();

		System.out.println("SelectionSort(Data1) b = " + Log(0.17, 0.444));
		System.out.println("SelectionSort(Data2) b = " + Log(0.26, 0.48));
		System.out.println("SelectionSort(Data3) b = " + Log(0.31, 0.503));
		System.out.println("ShellSort(Data1) b = " + Log(0.03, 0.06));
		System.out.println("ShellSort(Data2) b = " + Log(0.04, 0.07));
		System.out.println("ShellSort(Data3) b = " + Log(0.05, 0.08));
	}

}
