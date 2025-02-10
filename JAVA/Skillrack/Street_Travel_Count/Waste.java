// package JAVA.Skillrack.Street_Travel_Count;

// import java.util.LinkedList;
// import java.util.List;
// import java.util.Queue;
// import java.util.Scanner;

// public class Waste {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         int n=sc.nextInt();
//         int arr[][]=new int[n][n];
//         for(int i=0;i<n;i++)
//         {
//             for(int j=0;j<n;j++)
//             {
//                 arr[i][j]=sc.nextInt();
//             }
//         }
//         int s=sc.nextInt()*n+sc.nextInt();
//         int de=sc.nextInt()*n+sc.nextInt();
//         boolean visited[]=new boolean[n*n];
//         Queue<Integer> q=new LinkedList<>();
//         q.add(s);
//         visited[s]=true;
//         int[] street=new int[n*n];
//         street[s]=0;
//         while(!q.isEmpty()){
//             int node=q.poll();
//             List<Integer> relate=getRelated(arr,node,n);
//             for(Integer relNode:relate){
//                 if(!visited[relNode]){
//                     q.add(relNode);
//                     visited[relNode]=true;
//                     street[relNode]=street[node]+1;
//                     if(relNode==de){
//                         System.out.println(street[relNode]);
//                         return;
//                     }
//                 }
//             }
//         }
//         sc.close();
//     }
// }
