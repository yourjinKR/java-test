class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        
        int[] arr1 = Arrays.copyOfRange(nums, 0, n);
        int[] arr2 = Arrays.copyOfRange(nums, n, nums.length);
        
        int j = 0;
        for (int i = 0; i < n; i++, j++) {
            ans[j] = arr1[i];
            j++;
            ans[j] = arr2[i];
        }
        
        return ans;
    }
}