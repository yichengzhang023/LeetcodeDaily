/**
 * LeetCode16 给定一个包括 n 个整数的数组 nums 和
 * 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。 返回这三个数的和。假定每组输入只存在唯一答案。 示例
 * 输入：nums = [-1,2,1,-4], target = 1 输出：2 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2)
 * 。
 */

public class LeetCode16 {
    public int threeSumClosest(int[] nums, int target) {
        // 先排序 因为有个大小趋近的问题
        Arrays.sort(nums);
        // 前三个的和
        int closeNum = nums[0] + nums[1] + nums[2];
        // 从第一位开始循环
        for (int i = 0; i < nums.length; i++) {
            // 第二个数的index
            int j = i + 1;
            // 第三个数的index
            int k = nums.length - 1;
            // index没有相交的时候即双指针没有重合
            while (j < k) {
                // 算和
                int sum = nums[i] + nums[j] + nums[k];
                // 找最小sum
                if (Math.abs(target - closeNum) > Math.abs(target - sum)) {
                    closeNum = sum;
                }
                // 如果和大于目标 则说明右指针需要往左
                if (sum > target) {
                    k--;
                } else if (sum < target) {
                    // 如果和小于目标 则说明左指针需要往右
                    j++;
                } else {
                    // 刚好相等 直接返回
                    return target;
                }
            }
        }
        // 返回找到的最小值
        return closeNum;
    }
}