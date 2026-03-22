class TestArrayRotation {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        TestArrayRotation.rotate(arr, k);
    }

    public static void rotate(int[] arr, int k) {
        int n = arr.length;
        if (n < 2) {
            return;
        }
        int last = arr[arr.length-1];
        for (int i = n-1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = last;
        for(int j=0; j < arr.length; j ++) {
        System.out.print(arr[j]);

        }
    }
}