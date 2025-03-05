package AtCoder;

import java.util.*;

public class PigeonSwap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pigNum = sc.nextInt();
        int q = sc.nextInt();

        HashMap<Integer, Integer> pigHash = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> nestHash = new HashMap<>();
        List<Integer> nest = new ArrayList<>();
        List<Integer> nest2 = new ArrayList<>();
        int[] swapTrack = new int[pigNum+1];

        for (int i = 1; i <= pigNum; i++) {
            nestHash.put(i, new HashSet<>());
            nestHash.get(i).add(i);
            pigHash.put(i, i);
            swapTrack[i]=i;
            // was.put(i, i);
        }

        List<Integer> nest = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            int qType = sc.nextInt();
            if (qType == 3) {
                // System.out.println(pigHash.get(sc.nextInt()));
                nest.add(swapTrack[pigHash.get(sc.nextInt())]);
            } 
            
            else if (qType == 1) {
                int s = sc.nextInt();
                int d = sc.nextInt();
                int pigLoc = pigHash.get(s);
                pigHash.put(s, d);
                nestHash.get(pigLoc).remove(s);
                nestHash.get(d).add(s);
            } 
            
            else if (qType == 2) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                // System.out.println(a+" "+b+" ok");
                
                swapTrack[was.getOrDefault(a, a)]=b;
                swapTrack[was.getOrDefault(b, b)]=a;
                was.put(a,b);
                was.put(b,a);
                System.out.println(Arrays.toString(swapTrack));
            }
        }

        for (int i : nest) {
            System.out.println(i);
        }

        sc.close();
    }
}

// import java.util.*;

// public class PigeonSwap {
// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);

// // Read N (number of pigeons) and Q (number of queries)
// int N = sc.nextInt();
// int Q = sc.nextInt();

// // Pigeon array: pigeon[i] stores the current nest of pigeon i
// int[] pigeon = new int[N + 1];
// for (int i = 1; i <= N; i++) {
// pigeon[i] = i; // Initially, pigeon i is in nest i
// }

// while (Q-- > 0) {
// int type = sc.nextInt();
// int a = sc.nextInt();

// if (type == 1) {
// // Move pigeon 'a' to nest 'b'
// int b = sc.nextInt();
// pigeon[a] = b;

// } else if (type == 2) {
// // Swap all pigeons between nest 'a' and 'b'
// int b = sc.nextInt();
// for (int i = 1; i <= N; i++) {
// if (pigeon[i] == a) pigeon[i] = b;
// else if (pigeon[i] == b) pigeon[i] = a;
// }

// } else if (type == 3) {
// // Print the current nest of pigeon 'a'
// System.out.println(pigeon[a]);
// }
// }
// sc.close();
// }
// }
