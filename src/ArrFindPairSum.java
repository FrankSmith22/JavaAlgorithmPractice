import java.util.ArrayList;
import java.util.List;

/**
 * Class Title: ArrFindPairSum
 * Date Created: April 4th, 2021
 * Latest Edit: April 5th, 2021
 * Author: Frank Smith
 * Description: [pasted from techiedelight.com] Given an unsorted integer array, find a pair with the given sum in it
 */

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

    // public ArrayList<Integer[]> find(){
    //     // TODO Add logic here
    // }
}