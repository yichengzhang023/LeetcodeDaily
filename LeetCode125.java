public class LeetCode125 {
    public boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        s = s.replaceAll("[^a-z^A-Z^0-9]", "");
        s = s.toLowerCase();
        int j = s.length() - 1;
        for (int i = 0; i < j; i++) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            j--;
        }
        return true;
    }
}