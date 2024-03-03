import java.util.*;

public class LongestSubstringWithKUniqueCharacters {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        System.out.print(solve(s, k));
    }

    public static int solve(String s, int k) {
        Map<Character, Integer> mp = new HashMap<>();
        int i = 0, j = 0;
        int maxi = Integer.MIN_VALUE;
        while (j < s.length()) {
            char c = s.charAt(j);
            mp.put(c, mp.getOrDefault(c,  0) + 1);

            if (mp.size() < k) {
                j++;
            } else if (mp.size() == k) {
                maxi = Math.max(maxi, j - i + 1);
                j++;
            } else {
                while (mp.size() > k) {
                    mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
                    if (mp.get(s.charAt(i)) == 0) {
                        mp.remove(s.charAt(i));
                    }
                    i++;
                }
                j++;
            }
        }
        return maxi;
    }
}
