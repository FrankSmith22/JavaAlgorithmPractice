import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class Title: ArrFindZeroSum
 * Date Created: April 11th, 2021
 * Latest Edit: April 11th, 2021
 * Author: Frank Smith
 * Description: [pasted from techiedelight.com] Given an integer array, print all subarrays with zero-sum
 * Challenge Source: https://www.techiedelight.com/find-sub-array-with-0-sum/
 */

// A rather difficult challenge, this will be largely based on the provided solution. Clever solution!

public class ArrPrintZeroSum {
    
    int[] arr;
    public ArrPrintZeroSum(int[] arr){
        this.arr = arr;
    }

    public void bruteForceFind(){
        //Considering subarrays that start from i
        for(int i = 0; i < arr.length; i++){
            int currentSum = 0;

            //Considering subarrays that end at j
            for(int j = i; j < arr.length; j++){

                //Sum of elements so far
                currentSum += arr[j];

                //If sum ends up being zero, we know between current i and j lies the elements with a zero-sum
                if(currentSum == 0){
                    System.out.println(String.format("Subarray [%d...%d]", i, j));
                }
            }
        }
    }

    public void multimapFind(){
        // Create empty multimap to store ending index of subarrays with same sum
        Map<Integer, List<Integer>> hashMap = new HashMap<>();

        // This line handles the case that a sub-array with zero sum starts at index 0
        insert(hashMap, 0, -1);

        int currentSum = 0;

        for(int i = 0; i < arr.length; i++){
            currentSum += arr[i];

            // If sum has been seen before, there is at least one subarray with zero-sum
            if(hashMap.containsKey(currentSum)){
                List<Integer> list = hashMap.get(currentSum);

                // Find subarrays with same sum
                for(Integer value : list){
                    System.out.println("Subarray [" + (value + 1) + "..." + i + "]");
                }
            }
            // Insert sum and current index pair into the multimap
            insert(hashMap, currentSum, i);
        }
    }
    /*
        Method comments: Interesting solution indeed! The way this seems to work is by adding subarrays with a zero-sum to a map as the value,
        with that iteration's current sum itself being the key. That way, if a repeat sum comes along, we know to take what we've got so far
        and put it in the multimap, and print it out to the console. The utility method "insert" seems fairly self-explanatory too; If the 
        mapping doesnt exist yet with that key (sum) then create it. Regardless, add the value to that key.

        What I find to be interesting is that both this method and the brute force method give subarrays that have values in sequence, meaning
        it will only detect subarrays where the numbers occur in order as neighbors. For example, neither method will detect the array {5, 20, -5}
        as having a subarray of elements whose sum is 0 (the first and last elements: {5, -5}) because the twenty is 'in the way' so to speak.
        Will require further research
    */
    // utility method used by multimapFind
    private <K, V> void insert(Map<K, List<V>> hashMap, K key, V value){

        //If key is new, init list
        hashMap.putIfAbsent(key, new ArrayList<>());
        //Otherwise, add to the list that's already there
        hashMap.get(key).add(value);
    }
}
