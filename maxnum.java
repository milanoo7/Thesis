public class maxnum {


    public int largest(int [] arr)
    {
        int i;

        // Initialize maximum element
        int max = arr[0];
        int index = 0;

        // Traverse array elements from second and
        // compare every element with current max
        for (i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        System.out.println(" max element " + max + "index is " + index);
        return index;


    }

}

