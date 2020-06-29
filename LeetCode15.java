import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ， 使得 a + b + c = 0
 * ？请你找出所有满足条件且不重复的三元组。 nums = [-1, 0, 1, 2, -1, -4] 返回[ [-1, 0, 1], [-1, -1,
 * 2]]
 */
public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(nums.length);
        // 对数组排序
        Arrays.sort(nums);
        // 遍历数组
        for (k = 0; k < nums.length - 2; k++) {
            // 如果当前节点已经大于0 则之后的数字相加绝对大于0 所以直接中止
            if (nums[k] > 0) {
                break;
            }
            // 如果前此位和下一位数字相同 则直接继续
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            // 双指针 一个从后一位开始扫描，一个从最后一位往前扫描
            int left = k + 1;
            int right = nums.length - 1;
            // 左右指针一直扫描
            while (left < right) {
                // 三个数之和
                int tempSum = nums[k] + nums[left] + nums[right];
                // 和小于目标值，则说明左边的数太小 需要移动左指针
                if (tempSum < 0) {
                    while (left < right && nums[left] == nums[++left])
                        ;
                } else if (tempSum > 0) {
                    // 和大于目标值，则说明右边的数太小 需要移动右指针
                    while (left < right && nums[right] == nums[--right])
                        ;
                } else {
                    // 和刚好等于目标值 则添加此次结果 并且继续移动左右指针
                    res.add(new ArrayList<>(Arrays.asList(nums[k], nums[left], nums[right])));
                    while (left < right && nums[left] == nums[++left])
                        ;
                    while (left < right && nums[right] == nums[--right])
                        ;
                }
            }
        }
        return res;
    }
}