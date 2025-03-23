import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = sc.nextInt();
        int[] arr = new int[n];
        HashSet<Integer> map = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
            map.add(arr[i]);
        }
        Arrays.sort(arr);
        int ans = 0;
        int max = arr[n - 1];
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    int num = arr[i] * arr[j] * arr[k];
                    if (map.contains(num))
                        ans++;

                    else if (num > max) {
                        break;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}