public class Sort {
    public static void qsort(double[] input, int start, int end) {
        int left = start;
        int right = end - 1;
        double pivot = input[(left + right) / 2];

        while (left <= right) {
            while (input[left] < pivot) {
                left++;
            }
            while (input[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(input, left, right);
                left++;
                right--;
            }
        }
        if (start < right) {
            qsort(input, start, right + 1);
        }
        if (left < end) {
            qsort(input, left, end);
        }
    }

    public static void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int checkArray(double[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i - 1] > arr[i])
                return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        double[] inputData = new double[args.length];

        for (int i = 0; i < args.length; ++i) {
            inputData[i] = Double.parseDouble(args[i]);
        }
        if (inputData.length == 0) {
            System.out.print("array is empty");
            return;
        }
        if (checkArray(inputData) == 0) {
            qsort(inputData, 0, args.length);
        }
        for (int i = 0; i < args.length; ++i) {
            System.out.print(inputData[i] + " ");
        }
    }
}
