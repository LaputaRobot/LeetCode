package wangyi;

import java.util.Scanner;

public class Dayin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < 4 * n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            if (i < n) {
                for (int k = 0; k < 4 * n; k++) {
                    if (k < n - i || k >= 4 * n - (n - i))
                        stringBuilder.append(".");
                    else stringBuilder.append("*");
                }
            } else if (i >= 4 * n - n) {
                for (int k = 0; k < 4 * n; k++) {
                    if (k <= n-(4 * n - i) || k > (4 * n -(n- (4 * n - i)))-2)
                        stringBuilder.append(".");
                    else stringBuilder.append("*");
                }
            } else {
                for (int k = 0; k < 4 * n; k++) {
                    if (k < n || k >= 4 * n - n) {
                        stringBuilder.append("*");
                    } else stringBuilder.append(".");
                }
            }
            System.out.println(stringBuilder);
        }
    }
}
