public class LeetCode941 {
    /**
     * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
     * A.length >= 3 在 0 < i < A.length - 1 条件下，存在 i 使得： A[0] < A[1] < ... A[i-1] <
     * A[i] A[i] > A[i+1] > ... > A[A.length - 1]
     */
    public boolean validMountainArray(int[] A) {
        int size = A.length;
        if (size < 3) {
            // 山脉宽度大于3
            return false;
        }
        int i = 0;
        // 上山 如果后一位有下降的趋势则结束
        while (i + 1 < size && A[i] < A[i + 1]) {
            i++;
        }
        // 如果没有递增 或者一直递增 则不是山脉
        if (i == 0 || i == size - 1) {
            return false;
        }
        // 下山 如果有上升趋势则结束
        while (i + 1 < size && A[i] > A[i + 1]) {
            i++;
        }
        // 判断是否遍历完
        return i == size - 1;
    }
}
