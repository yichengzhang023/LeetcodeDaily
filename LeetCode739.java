import java.util.Deque;
import java.util.LinkedList;

/**
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 * 
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4,
 * 2, 1, 1, 0, 0]。
 * 
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 **/
public class LeetCode739 {
    public int[] dailyTemperatures(int[] T) {
        // 列表存取结果
        int[] res = new int[T.length];
        // 构建一个单调栈
        Deque<Integer> stack = new LinkedList<Integer>();
        // 遍历一遍数组
        for (int i = 0; i < T.length; i++) {
            // 当栈内有元素 且即将入栈的温度大于栈顶的元素
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                // 弹出栈顶温度并且获取index的距离
                res[stack.peek()] = i - stack.pop();
            }
            // 入栈
            stack.push(i);
        }
        return res;
    }
}