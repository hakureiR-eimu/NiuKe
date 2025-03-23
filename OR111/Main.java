import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strs = in.nextLine().replace("[", "").replace("]", "").split(",");
        //第三大的元素 使用最小堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (String str : strs) {
            int num = Integer.parseInt(str);
            if (pq.size() < 3) {
                pq.add(num);
            } else {
                if (num > pq.peek()) {
                    pq.remove();
                    pq.add(num);
                } else {
                    continue;
                }
            }
        }
        System.out.println(pq.peek());
    }
}