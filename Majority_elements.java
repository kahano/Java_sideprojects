import java.util.*;

class Majority_elements{

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        Integer cand1 = null;
        Integer cand2 = null;
        int count1 = 0;
        int count2 = 0;

        for(int v : nums){

            if(cand1 != null && cand1 == v){
                count1++;
            }

            else if(cand2 != null && cand2 == v){
                count2++;

            }


            else if (count1 == 0){
                cand1 = v;
                count1++;
            }

            else if(count2 == 0){
                cand2 = v;
                count2++;
            }



            else{

                  count1--;
                  count2--;

            }
        }

        count1 = 0;
        count2 = 0;


        for(int v : nums){

            if(cand1 != null && cand1 == v){
                count1++;
            }

            if(cand2 != null && cand2 == v){
                count2++;
            }




        }

         if(count1 > nums.length/3){
                      arr.add(cand1);
         }
         if(count2 > nums.length/3){
                    arr.add(cand2);
         }
         return arr;


    }
}
