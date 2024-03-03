import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.print(solve(s));
    }

    public static int solve(String s) {
        HashSet<Character> hs = new HashSet<>();
        int i = 0, cnt = 0;
        for (int j = 0; j < s.length(); j++) {
            if (!hs.contains(s.charAt(j))) {
                hs.add(s.charAt(j));
                cnt = Math.max(cnt, j - i + 1);
            } else {
                while (s.charAt(i) != s.charAt(j)) {
                    hs.remove(s.charAt(i));
                    i++;
                }
                hs.remove(s.charAt(i));
                i++;
                hs.add(s.charAt(j));

            }

        }
        return cnt;

    }
}
