// Java implementation of iterative Binary Search
package com.allan;

class BinarySearch {
    // Returns index of x if it is present in arr[],
    // else return -1
    int binarySearch(int arr[], int x)
    {
        int left = 0, right = arr.length - 1;
        int count = 0;
        while (left <= right) {
            System.out.println("searched time " + ++count);
            int m = left + (right - left) / 2;

            // Check if x is present at mid
            if (arr[m] == x)
                return m;

            // If x greater, ignore left half
            if (arr[m] < x)
                left = m + 1;

                // If x is smaller, ignore right half
            else
                right = m - 1;
        }

        // if we reach here, then element was
        // not present
        return -1;
    }

    // Driver method to test above
    public static void main(String args[])
    {
        int[] array =  new int[64];
        for (int i = 0; i < array.length; i++) {
            array[i] = 5 + i;
        }
        array[63] = 200;


        int valueToSearch = 2;
        valueToSearch = 5;


        BinarySearch ob = new BinarySearch();
        int n = array.length;
        int result = ob.binarySearch(array, valueToSearch);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at "
                    + "index " + result);
    }
}
