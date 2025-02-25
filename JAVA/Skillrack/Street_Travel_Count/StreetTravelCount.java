package Skillrack.Street_Travel_Count;
import java.util.HashMap;
import java.util.Scanner;


//vedio -- https://www.youtube.com/watch?v=wdeJvXF6YRY
//vedio -- https://www.youtube.com/watch?v=2Xc955dNIys


public class StreetTravelCount {

    static int flag = 0, w = 0, pw = 0, ans = 0,count = 0;

    public int streetCount(int n, int[][] arr, int p, int p1, int i, int i1, int[] de, HashMap<String, Boolean> hash, HashMap<String, Boolean> hash1) {
        // System.out.println(i+" "+i1);
        if (i == de[0] && i1 == de[1]) {
            flag = 1;
            
            // System.out.println(i + " " + i1 + " okrok");
            // System.exit(0);
            pw = w;
            if (p == i && p1 != i1) {
                w = 0;
            } else if (p != i && p1 == i1) {
                w = 1;
            }
            // System.out.println(pw + " " + w + " " + "ijijinin");
            if (pw != w) {
                if(hash1.containsKey(i+" "+i1)){
                    hash1.remove(i+" "+i1);
                    count--;
                }
                // System.out.println("ok");
                hash1.put(i+" "+i1,true);
                count++;
            }
            ans = count;
            return count;
        }

        if (flag == 1) {
            return count;
        }

        if (i >= n || i1 >= n || i < 0 || i1 < 0 || arr[i][i1] == 0) {
            return 0;
        }

        if (hash.containsKey(i + " " + i1)) {
            return 0;
        }
        
        // if(p!=i && p1!=i1){
        // count++;
        // System.out.println(count+"okkjhkjhkhhkhkhkhkhkh");
        // }
        pw = w;
        if (p == i && p1 != i1) {
            w = 0;
        } else if (p != i && p1 == i1) {
            w = 1;
        }
        // System.out.println(pw + " " + w + " " + "ijijinin");
        if (pw != w) {
            // System.out.println(p + " " + p1 + " " + i + " " + i1);
            // System.out.println("ok");
            if(hash1.containsKey(p+" "+p1)){
                hash1.remove(p+" "+p1);
                count--;
            }
            else {
                count++;
                hash1.put(p+" "+p1,true);
            }
            System.out.print(count+ " ");
        }
        p = i;
        p1 = i1;
        hash.put(p + " " + p1, true);

        streetCount(n, arr, p, p1, i + 1, i1, de, hash, hash1);
        streetCount(n, arr, p, p1, i - 1, i1, de, hash, hash1);
        streetCount(n, arr, p, p1, i, i1 + 1, de, hash, hash1);
        streetCount(n, arr, p, p1, i, i1 - 1, de, hash, hash1);
        hash.remove(p + " " + p1);

        // System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();
        }
        int[] so = new int[2];
        int[] de = new int[2];
        for (int i = 0; i < 2; i++) {
            so[i] = sc.nextInt();
        }
        for (int i = 0; i < 2; i++) {
            de[i] = sc.nextInt();
        }
        HashMap<String, Boolean> hash = new HashMap<>();
        HashMap<String, Boolean> hash1 = new HashMap<>();
        StreetTravelCount streetTravelCount = new StreetTravelCount();
        count = 0;
        flag = 0;
        w = -1;
        pw = -1;
        ans = 0;
        streetTravelCount.streetCount(n, arr, so[0], so[1], so[0], so[1], de, hash,hash1);
        System.out.println(ans);
        sc.close();
    }
}

// 4
// 1 1 1 0
// 0 0 1 1
// 1 1 0 1
// 0 1 1 1
// 0 1
// 2 0

