import java.util.*;

//REFERENCE ---- https://www.youtube.com/watch?v=QQHndo3l_lU  https://www.youtube.com/watch?v=WRim5PcB6gs

class FoodItem implements Comparable<FoodItem>{
    String name;
    List<Integer> customer;

    @Override
    public int compareTo(FoodItem other){
        return this.customer.size() - other.customer.size();
    }
}


public class IntelligentChef {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        HashMap<String,FoodItem> map=new HashMap<>();
        List<Integer> user=new ArrayList<>();
        for(int i=1;i<=n;i++){
            user.add(i);
            
            String[] items=sc.nextLine().split("\\s+");
            for(String food:items){
                
                if(!map.containsKey(food)){
                    FoodItem item=new FoodItem();
                    item.name=food;
                    item.customer=new ArrayList<>();
                    map.put(food,item);
                }
                map.get(food).customer.add(i);
            }
        }
        sc.close();
        int count=0;

        while(!user.isEmpty()){
            List<FoodItem> foodList=new ArrayList<>(map.values());
            Collections.sort(foodList,Collections.reverseOrder());
            FoodItem food=foodList.get(0);
            count++;
            user.removeAll(food.customer);
            map.remove(food.name);
            for(String item:map.keySet()){
                map.get(item).customer.removeAll(food.customer);
            }
        }
        System.out.println(count);
    }
}
// 10
// Chapati Idli Pongal Poori Dosa    
// Poori Dosa Chapati
// Idli Dosa Poori
// Pongal
// dosa Pongal Poori Chapati  
// Idli Pongal Poori  
// Idli Pongal Chapati Dosa   
// Dosa Chapati 
// Chapati Idli Pongal Poori Dosa    
// Chapati