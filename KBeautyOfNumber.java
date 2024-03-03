
/*2269. Find the K-Beauty of a Number
The k-beauty of an integer num is defined as the number of substrings of num when it is read as a string that meet the following conditions:

It has a length of k.
It is a divisor of num.
Given integers num and k, return the k-beauty of num.

Note:

Leading zeros are allowed.
0 is not a divisor of any value.
A substring is a contiguous sequence of characters in a string.

 

Example 1:

Input: num = 240, k = 2
Output: 2
Explanation: The following are the substrings of num of length k:
- "24" from "240": 24 is a divisor of 240.
- "40" from "240": 40 is a divisor of 240.
Therefore, the k-beauty is 2.
Example 2:

Input: num = 430043, k = 2
Output: 2
Explanation: The following are the substrings of num of length k:
- "43" from "430043": 43 is a divisor of 430043.
- "30" from "430043": 30 is not a divisor of 430043.
- "00" from "430043": 0 is not a divisor of 430043.
- "04" from "430043": 4 is not a divisor of 430043.
- "43" from "430043": 43 is a divisor of 430043.
Therefore, the k-beauty is 2.
 

Constraints:

1 <= num <= 109
1 <= k <= num.length (taking num as a string) */
import java.util.*;

public class KBeautyOfNumber {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.print(solve(n, k));

    }

    public static int solve(int num, int k) {
        String s = Integer.toString(num);
        int i = 0, j = 0;
        int cnt = 0;
        while (j < s.length()) {
            String p = s.substring(i, j + 1);
            int x = Integer.parseInt(p);
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                if (x != 0 && num%x == 0) {
                    cnt++;
                }
                i++;
                j++;
            }

        }
        return cnt;
    }

}