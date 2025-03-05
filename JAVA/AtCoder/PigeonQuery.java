package AtCoder;

import java.util.*;

public class PigeonQuery{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int pigNum=sc.nextInt();
    int q=sc.nextInt();
    // List<List<Integer>> query=new ArrayList<>();
    HashMap<Integer,Integer> pigHash=new HashMap<>();
    HashMap<Integer,Integer> nestHash=new HashMap<>();
    for(int i=1;i<pigNum+1;i++) {
      nestHash.put(i,1);
      pigHash.put(i,i);
    }
    List<Integer> nest=new ArrayList<>();
    int count=0;
    for(int i=0;i<q;i++){
      int qType=sc.nextInt();
      if(qType==2){
        // System.out.println(count);
        nest.add(count);
      }
      if(qType==1){
        int s=sc.nextInt();
        int d=sc.nextInt();
        int pigLoc=pigHash.get(s);
        pigHash.put(s,d);
        nestHash.put(pigLoc,nestHash.getOrDefault(pigLoc,0)-1);
        if(nestHash.get(pigLoc)==1) count--;
        nestHash.put(d,nestHash.getOrDefault(d,0)+1);
        if(nestHash.get(d)==2) count++;
      }
    }
    // System.out.println(nest);
    for(int i:nest){
      System.out.println(i);
    }
    sc.close();
  }
}