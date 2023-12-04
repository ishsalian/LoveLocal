import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MajorityElementFinder {

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        // Step 1: Initialization
        int candidate1 = 0, candidate2 = 1;
        int count1 = 0, count2 = 0;

        // Step 2: First Pass
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Step 3: Second Pass
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        // Step 4: Checking Majority Elements
        if (count1 > nums.length / 3) {
            result.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            result.add(candidate2);
        }

        // Step 5: Result
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User input for array size
        int n = sc.nextInt();

        // User input for array elements
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Calling the majorityElement method and printing the result
        List<Integer> res = majorityElement(nums);
        System.out.println(res);
    }
}
