//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int nums[] = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(maxConsecutiveOnesIII(nums,2));
    }

    // Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
    // O(n) ==>  Each element is visited at most twice (once by i, once by j), where n is the length of the array.
    public static int maxConsecutiveOnesIII(int[] nums, int k){
        int i = 0, j = 0;
        int count0 = 0;
        int ans = 0;

        while (i < nums.length) {
            if (nums[i] == 0) {
                count0++;

                if (count0 > k) {
                    // shrink the window from the left until count0 <= k
                    while (count0 > k) {
                        if (nums[j] == 0) {
                            count0--;
                        }
                        j++;
                    }
                }
            }

            ans = Math.max(ans, i - j + 1);
            i++;
        }

        return ans;
    }



}