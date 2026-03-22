

public class RotateArray189 {

    public static void main(String[] args) {

    }

    public void rotate(int[] nums, int k) {

        int n = nums.length;

        if (n < 2)
            return;
        if (k > n)
            k = k % n;
        int firstEnd = n - k - 1;

        reverseArr(nums, 0, firstEnd);
        printArr(nums);
        reverseArr(nums, firstEnd + 1, n - 1);
        printArr(nums);
        reverseArr(nums, 0, n - 1);
        printArr(nums);

    }

    public void printArr(int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j]);
        }
        System.out.println("-----------");
    }

    public void reverseArr(int[] arr, int startPos, int endPos) {
        for (int i = startPos; i < endPos; i++, endPos--) {
            int tmp = arr[i];
            arr[i] = arr[endPos];
            arr[endPos] = tmp;
        }
    }
}