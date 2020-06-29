/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。 如果不存在公共前缀，返回空字符串 ""。 示例 输入:
 * ["flower","flow","flight"] 输出: "fl"
 */
public class LeetCode14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 第一个字符串的长度
        int length = strs[0].length();
        // 字符串数组的长度
        int num = strs.length;
        // 第一个字符串每个字母循环
        for (int i = 0; i < length; i++) {
            // 第一个字符串的第i个字母
            char c = strs[0].charAt(i);
            // 循环除第一个字符串之外的字符串
            for (int j = 1; j < num; j++) {
                // 当前长度已经超过字符串本身长度 或者出现第一个不等于此位置的字母(即不满足公共字符串的定义)
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    // 返回至今为止的字符串
                    return strs[0].substring(0, i);
                }
            }
        }
        // 当前字符串就是 最长相同字符串
        return strs[0];
    }
}