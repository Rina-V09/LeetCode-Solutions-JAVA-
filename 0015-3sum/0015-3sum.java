public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i<nums.length-2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            List<List<Integer>> temp = twoSum(nums, -nums[i], i+1);
            for(List<Integer> list: temp) {
                list.add(0, nums[i]);
                triplets.add(list);
            }
        }

        return triplets;
    }

    static List<List<Integer>> twoSum(int nums[], int sum, int startFrom) {
        int l = startFrom;
        int r = nums.length-1;
        List<List<Integer>> ans = new ArrayList<>();

        while(l < r) {
            if(l > startFrom && nums[l] == nums[l-1]) {
              l++;
              continue;
            }
            if(r < nums.length-1 && nums[r] == nums[r+1]) {
              r--;
              continue;
            }
            if(nums[l]+nums[r] > sum) {
                r--;
            }else if(nums[l]+nums[r] < sum) {
                l++;
            }else {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[l]);
                temp.add(nums[r]);
                ans.add(temp);
                l++;
                r--;
            }
        }
        return ans;
    }
}