package algorithm;

import org.testng.Assert;

public class UnitTestSorting {

    /*
      This class is about Unit testing for Sorting Algorithm.
     */
    public static void main(String[] args) {
        int[] unSortedArray = {6, 9, 2, 5, 1, 0, 4};
        int[] sortedArray = {0, 1, 2, 4, 5, 6, 9};
        //Create Sort object
        Sort sort = new Sort();

        //insertion sort Unit Test
        //apply unsorted array to selectionSort.
        sort.selectionSort(unSortedArray);
        //verify if the unsorted array is sorted by the selection sort algorithm.
        try {
            Assert.assertEquals(sortedArray, unSortedArray, "Array is not Sorted");
        } catch (Exception ex) {
            ex.getMessage();
        }
        System.out.println("Selection Sort passed Unit Test");

        //Now implement Unit test for rest of the soring algorithm...................below

        //insertion sort Unit Test
        unSortedArray = new int[]{6, 9, 2, 5, 1, 0, 4};
        sort.insertionSort(unSortedArray);
        try {
            Assert.assertEquals(sortedArray, unSortedArray, "Array is not Sorted");
        } catch (Exception ex) {
            ex.getMessage();
        }
        System.out.println("Insertion Sort passed Unit Test");

        //bubble sort Unit Test
        unSortedArray = new int[]{6, 9, 2, 5, 1, 0, 4};
        sort.bubbleSort(unSortedArray);
        try {
            Assert.assertEquals(sortedArray, unSortedArray, "Array is not Sorted");
        } catch (Exception ex) {
            ex.getMessage();
        }
        System.out.println("Bubble Sort passed Unit Test");

        //quick sort Unit Test
        unSortedArray = new int[]{6,9,2,5,1,0,4};
        sort.quickSort(unSortedArray,0,unSortedArray.length-1);
        try {
            Assert.assertEquals(sortedArray, unSortedArray, "Array is not Sorted");
        }catch(Exception ex){
            ex.getMessage();
        }
        System.out.println("Quick Sort passed Unit Test");

        //heap sort Unit Test
        unSortedArray = new int[]{6,9,2,5,1,0,4};
        sort.heapSort(unSortedArray);
        try {
            Assert.assertEquals(sortedArray, unSortedArray, "Array is not Sorted");
        }catch(Exception ex){
            ex.getMessage();
        }
        System.out.println("Heap Sort passed Unit Test");

        //merge sort Unit Test
        unSortedArray = new int[]{6,9,2,5,1,0,4};
        sort.mergeSort(unSortedArray,0,unSortedArray.length-1);
        try {
            Assert.assertEquals(sortedArray, unSortedArray, "Array is not Sorted");
        }catch(Exception ex){
            ex.getMessage();
        }
        System.out.println("Merge Sort passed Unit Test");

        //Shell Sort Unit Test
        unSortedArray = new int[]{6,9,2,5,1,0,4};
        sort.shellSort(unSortedArray);
        try {
            Assert.assertEquals(sortedArray, unSortedArray, "Array is not Sorted");
        }catch(Exception ex){
            ex.getMessage();
        }
        System.out.println("Shell Sort passed Unit Test");

        //bucket sort
        unSortedArray = new int[]{6, 9, 2, 5, 1, 0, 4};
        sort.bucketSort(unSortedArray, 9);
        try {
            Assert.assertEquals(sortedArray, unSortedArray, "Array is not Sorted");
        } catch (Exception ex) {
            ex.getMessage();

        }
    }
}
