import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param arr1 int整型一维数组
     * @param arr2 int整型一维数组
     * @return int整型
     */
    public int getUpMedian(int[] arr1, int[] arr2) {
        // write code here
        int len1 = arr1.length, len2 = arr2.length;
        int pos;
        if ((len1 + len2) % 2 == 0) {
            pos = (len1 + len2) / 2 - 1;
        } else {
            pos = (len1 + len2) / 2;
        }
        int i = 0, j = 0, loc = 0;
        while (i < len1 && j < len2) {
            int item;
            if (arr1[i] > arr2[j]) {
                item = arr2[j];
                j++;
            } else {
                item = arr1[i];
                i++;
            }
            if (loc == pos) {
                return item;
            }
            loc++;
        }
        while (i < len1) {
            int item = arr1[i];
            i++;
            if (loc == pos) {
                return item;
            }
            loc++;
        }
        while (j < len2) {
            int item = arr2[j];
            j++;
            if (loc == pos) {
                return item;
            }
            loc++;
        }
        return -1;
    }
}