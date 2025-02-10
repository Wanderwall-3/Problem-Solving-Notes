package Corona; //SUCESSFULL

import java.util.HashMap;
import java.util.Scanner;

public class Corona {

    static int w = 0, ans = 0, count = 0;

    public static void change(int[][] arr, int i, int j, int n, int m, HashMap<String, Integer> map) {
        if ((i + 1 >= 0 && i + 1 < n && arr[i + 1][j] == 2 && map.getOrDefault((i + 1) + " " + j, ans - 1) != ans)
                || (i - 1 >= 0 && i - 1 < n && arr[i - 1][j] == 2
                        && map.getOrDefault((i - 1) + " " + j, ans - 1) != ans)
                || (j + 1 >= 0 && j + 1 < m && arr[i][j + 1] == 2
                        && map.getOrDefault(i + " " + (j + 1), ans - 1) != ans)
                || (j - 1 >= 0 && j - 1 < m && arr[i][j - 1] == 2
                        && map.getOrDefault(i + " " + (j - 1), ans - 1) != ans)) {
            count--;
            arr[i][j] = 2;
            w = 1;
            map.put(i + " " + j, ans);
            return;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        count = 0;
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1)
                    count++;
            }
        }
        HashMap<String, Integer> map = new HashMap<>();
        ans = 0;
        w = 0;
        while (true) {
            w = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (arr[i][j] == 1) {
                        change(arr, i, j, r, c, map);
                    }
                }
            }

            if (w == 1)
                ans++;

            else
                break;

        }
        if (count != 0)
            System.out.println(-1);
        else
            System.out.println(ans);
        sc.close();
    }
}
// 3 5 2 1 0 2 1 1 0 1 2 1 1 0 0 2 1