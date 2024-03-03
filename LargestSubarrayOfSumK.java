import java.util.*;

public class LargestSubarrayOfSumK {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        System.out.print(slidingWindowsolve(n, m, arr));

    }

    public static int slidingWindowsolve(int n, int k, int arr[]) {
        int i = 0, j = 0;
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        while (j < n) {
            sum += arr[j];
            if (sum < k) {
                j++;
            } else if (sum == k) {
                maxi = Math.max(maxi, j - i + 1);
                j++;
            } else if (sum > k) {
                while (sum > k) {
                    sum -= arr[i];
                    i++;
                 if (sum == k) {
                        maxi = Math.max(maxi, j - i + 1);
                       
                }
            }
            j++;
        }
       
    }
    return maxi;
    }
}
