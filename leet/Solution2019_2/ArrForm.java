package leet.Solution2019_2;

import java.util.LinkedList;
import java.util.List;

//989
public class ArrForm {
    /**
     * For a non-negative integer X, the array-form of X is an array of its digits in left to right order.
     * For example, if X = 1231, then the array form is [1,2,3,1].
     * <p>
     * Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: A = [1,2,0,0], K = 34
     * Output: [1,2,3,4]
     * Explanation: 1200 + 34 = 1234
     * Example 2:
     * <p>
     * Input: A = [2,7,4], K = 181
     * Output: [4,5,5]
     * Explanation: 274 + 181 = 455
     * Example 3:
     * <p>
     * Input: A = [2,1,5], K = 806
     * Output: [1,0,2,1]
     * Explanation: 215 + 806 = 1021
     * Example 4:
     * <p>
     * Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
     * Output: [1,0,0,0,0,0,0,0,0,0,0]
     * Explanation: 9999999999 + 1 = 10000000000
     */
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> list = new LinkedList<>();
        String strA = getStr(A);
        String strB = String.valueOf(K);
        String ansStr = add(strA, strB);
        for (char ch : ansStr.toCharArray())
            list.add(ch - '0');
        return list;
    }

    private String add(String strA, String strB) {
        StringBuilder sb = new StringBuilder();
        int indexA = strA.length() - 1, indexB = strB.length() - 1;
        int carry = 0;
        while (indexA >= 0 && indexB >= 0) {
            int a = strA.charAt(indexA) - '0';
            int b = strB.charAt(indexB) - '0';
            int tmpVal = (a + b + carry) % 10;
            carry = (a + b + carry) / 10;
            sb.append(tmpVal);
            --indexA;
            --indexB;
        }
        while (indexA >= 0) {
            int a = strA.charAt(indexA) - '0';
            int tmpVal = (a + carry) % 10;
            carry = (a + carry) / 10;
            sb.append(tmpVal);
            --indexA;
        }
        while (indexB >= 0) {
            int b = strB.charAt(indexB) - '0';
            int tmpVal = (b + carry) % 10;
            carry = (b + carry) / 10;
            sb.append(tmpVal);
            --indexB;
        }
        if (carry == 1)
            sb.append(carry);
        return sb.reverse().toString();
    }

    private String getStr(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int num : a)
            sb.append(num);
        return sb.toString();
    }


    public static void main(String[] args) {
        int[] A = {9, 9};
        System.out.println(new ArrForm().addToArrayForm(A, 1));
    }
}