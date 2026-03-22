class TestArrayRotationAdv {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        TestArrayRotationAdv.rotate(arr, k);
    }

    public static void rotate(int[] nums, int k) {
        // int first = 0;
        int n = nums.length;
        int firstEnd = n - k -1;

        TestArrayRotationAdv.reverseArr(nums, 0, firstEnd);
        printArr(nums);
        TestArrayRotationAdv.reverseArr(nums, firstEnd+1, n-1);
        printArr(nums);
        TestArrayRotationAdv.reverseArr(nums, 0, n-1);
        printArr(nums);

    }

    public static void printArr(int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j]);
        }
           System.out.println("-----------");
    }

    public static void reverseArr(int[] arr, int startPos, int endPos) {
        for (int i = startPos; i < endPos; i++, endPos--) {
            int tmp = arr[i];
            arr[i] = arr[endPos];
            arr[endPos] = tmp;
        }
    }
}