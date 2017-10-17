package 商汤科技;

import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            solve(str);
        }
    }

    public static void solve(String s) {
        int len = s.length();
        if (len == 0 || s.charAt(0) == '0' || (len > 1 && s.substring(len - 2, len).equals("00"))) {
            System.out.println(0);
            return;
        }
        int[] a = new int[len + 1];
        a[0] = 1;
        a[1] = 1;
        for (int i = 2; i <= len; i++) {
            char c = s.charAt(i - 1);
            a[i] = a[i - 1];
            if (c != '0' && s.charAt(i - 2) != '0') {
                String sub = s.substring(i - 2, i);
                int t = Integer.valueOf(sub);
                if (t < 27) {
                    a[i] += a[i - 2];
                }
            }
        }
        char c = s.charAt(len - 1);
        if (c == '0') {
            System.out.println(a[len - 1]);
        } else {
            System.out.println(a[len]);
        }
    }
}
