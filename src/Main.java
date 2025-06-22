import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int nums[] = {1,2,3,2,2};
        System.out.println(totalFruit(nums));
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


    public static int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int ans = 0;
        while(i < fruits.length){

            map.put(fruits[i],map.getOrDefault(fruits[i],0)+1);
            System.out.println(map);
            if(map.size() > 2){

                while(map.size() > 2){
                    map.put( fruits[j], map.get(fruits[j])-1);

                    if(map.get(fruits[j]) == 0)map.remove(fruits[j]);
                    j++;
                }

            }
            ans = Math.max(i-j+1,ans);
            i++;
        }
        return ans;
    }

    // Binary Subarrays With Sum
    // O(N)
    public static int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums,goal) - helper(nums,goal-1);
    }

    public static int helper(int nums[], int goal) {
        if(goal < 0 )return 0;
        int count = 0;
        int sum = 0;
        int right = 0;
        int left = 0;

        while (right < nums.length) {
            sum += nums[right];
            while (sum > goal) {
                sum -= nums[left];
                left++;
            }
            if (sum <= goal) {
                count += (right - left + 1);
            }
            right++;
        }
        return count;
    }

    // Count Number of Nice Subarrays
    // O(N)
    public static int numberOfSubarrays(int[] nums, int k) {
        int i = 0, j = 0, res = 0, oddCount = 0, temp = 0;

        while(i < nums.length){
            if((nums[i] % 2) == 1){
                oddCount++;
                temp = 0;
            }

            while(oddCount == k){
                temp++;
                if((nums[j] % 2) == 1){
                    oddCount--;
                }
                j++;
            }
            res += temp;
            i++;
        }

        return res;
    }


}