class Solution {
    public int[] getConcatenation(int[] nums) {
        int totalLength = nums.length * 2;
        int[] ans = new int[totalLength];

        int i = 0;
        int j = 0;

        for (i = 0; i < nums.length; i++, j++) {
            ans[i] = nums[i];
        }

        for (i = 0; i < nums.length; i++, j++) {
            ans[j] = nums[i];
        }

        return ans;
    }
}