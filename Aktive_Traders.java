import java.util.*;

class Aktive_Traders{



    public static List<String> traders(List<String> customers){
        int count = 0;
        double size = customers.size();


         TreeMap<String,Integer> custom = new TreeMap<>();
         List<String> order = new ArrayList<>();


        for(int i = 0; i < size;i++){
            String customerkey = customers.get(i);
            if(!custom.containsKey(customers.get(i))){
                custom.put(customerkey,1);
            }
            else{
                custom.put(customerkey,++count);
            }


        }
        Set<String> customerkeymaps = custom.keySet();

        for(String customerkey : customerkeymaps){
            double mapsize = custom.get(customerkey);
            double avg = mapsize/size;

            if (avg > 0.05){
                order.add(customerkey);
            }
        }

        return order;



    }

    public static void main(String args[]){
        //int n = 23;

        String[] arr = {"Bigcorp", "Bigcorp", "Acme", "Bigcorp", "Zork", "Abc", "Bigcorp", "Acme", "Bigcorp","Bigcorp", "Zork", "Bigcorp", "Zork", "Zork", "Bigcorp", "Acme", "Bigcorp", "Acme", "Bigcorp", "Acme", "littlecorp", "Nadircorp"};
        List<String> trader_custom = new ArrayList<>();
        for(String s : arr){
            trader_custom.add(s);
        }
        System.out.print(traders(trader_custom));


    }


}
