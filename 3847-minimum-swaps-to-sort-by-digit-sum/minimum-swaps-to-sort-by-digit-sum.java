import java.util.*;

class Solution {

    public int minSwaps(int[] nums) {

        int n = nums.length;

        // Make Integer array for custom sorting
        Integer[] sorted = new Integer[n];

        for (int i = 0; i < n; i++) {
            sorted[i] = nums[i];
        }

        // Sort by digit sum, then by number
        Arrays.sort(sorted, (a, b) -> {

            int sumA = digitSum(a);
            int sumB = digitSum(b);

            if (sumA != sumB) {
                return sumA - sumB;
            }

            return a - b;
        });

        // number -> current index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        int swaps = 0;

        for (int i = 0; i < n; i++) {

            if (nums[i] == sorted[i]) {
                continue;
            }

            int j = map.get(sorted[i]);

            // Swap
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            // Update map
            map.put(nums[i], i);
            map.put(nums[j], j);

            swaps++;
        }

        return swaps;
    }

    private int digitSum(int num) {

        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}