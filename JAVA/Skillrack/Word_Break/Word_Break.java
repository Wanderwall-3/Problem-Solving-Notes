package Word_Break;   //Completed

import java.util.*;

//REFERENCE ----

public class Word_Break {

    public static void answer(String str,HashSet<String> hash,List<String> arr,int i){
        if(i==str.length()){
            System.out.println(String.join(" ", arr));
            return;
        }
        for(int j=i;j<str.length();j++){
            String sub=str.substring(i,j+1);
            if(hash.contains(sub)){
                arr.add(sub);
                answer(str, hash, arr, j+1);
                arr.remove(arr.size()-1);
            }
        }
    }

    

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashSet<String> hash=new HashSet<>(Arrays.asList(sc.nextLine().split("\\s+")));
        String str=sc.nextLine();
        List<String> arr=new ArrayList<>();
        answer(str, hash, arr, 0);
        sc.close();
    }
}

//INPUT:
// t h i s th hi is thi his this
// this
//OUTPUT:
// t h i s t h is t hi s t his th i s th is thi s this