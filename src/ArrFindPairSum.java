import java.util.ArrayList;
import java.util.List;

/**
 * Class Title: ArrFindPairSum
 * Date Created: April 4th, 2021
 * Latest Edit: April 11th, 2021
 * Author: Frank Smith
 * Description: [pasted from techiedelight.com] Given an unsorted integer array, find a pair with the given sum in it
 * Challenge Source: https://www.techiedelight.com/find-pair-with-given-sum-array/
 */

// I was able to come up with the solution on my own, and the source refers to this solution as a brute-force solution

public class ArrFindPairSum {

    ArrayList<Integer> arr;
    int sum;

    public ArrFindPairSum(ArrayList<Integer> arr, int sum){
        this.arr = arr;
        this.sum = sum;
    }

    // Returns first pair of nums with matching sum
    public ArrayList<Integer> findFirst(){
        //TODO Add logic here
        int val1;
        int val2;
        for(int i = 0; i < arr.size(); i++){
            
            val1 = arr.get(i);
            System.out.println(String.format("Current iteration in i: %d", i));
            System.out.println(String.format("Current value of val1: %d", val1));

            for(int j = 0; j < arr.size(); j++){
                val2 = arr.get(i + j + 1);
                System.out.println(String.format("Current iteration in j: %d", j));
                System.out.println(String.format("Current value of val2: %d", val2));

                if(val1 + val2 == sum){
                    return new ArrayList<Integer>(List.of(val1, val2));
                }
            }
        }
        return null;
    }

    public ArrayList<int[]> find(){
        // TODO Add logic here
        ArrayList<int[]> foundPairs = new ArrayList<int[]>();
        int val1;
        int val2;
        for(int i = 0; i < arr.size()-1; i++){
            
            val1 = arr.get(i);
            System.out.println(String.format("Current iteration in i: %d", i));
            System.out.println(String.format("Current value of val1: %d", val1));

            for(int j = (i+1); j < arr.size(); j++){
                val2 = arr.get(j);
                System.out.println(String.format("Current iteration in j: %d", j));
                System.out.println(String.format("Current value of val2: %d", val2));

                if(val1 + val2 == sum){
                    System.out.println(String.format("Found a match, adding these two values to the result list now: %d and %d", val1, val2));
                    int[] pair = {val1, val2};
                    foundPairs.add(pair);
                }
            }
        }
        return foundPairs;
    }
}