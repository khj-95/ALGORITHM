package Programmers;

import java.util.*;

public class Pokemon {
    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,4};

        int answer = nums.length/2;

        Map<Integer,Integer> numsMap = new HashMap<>();
        for (int num : nums) {
            int count = 1;
            if(numsMap.containsKey(num)){
                count += numsMap.get(num);
            }
            numsMap.put(num, count);
        }

        int difKindCount = numsMap.keySet().size();
        if(answer > difKindCount){
            answer = difKindCount;
        }

        System.out.println(answer);

    }
}
