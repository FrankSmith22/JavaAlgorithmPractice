import java.util.HashSet;
import java.util.Set;

/**
 * Class Title: ArrFindZeroSum
 * Date Created: April 11th, 2021
 * Latest Edit: April 11th, 2021
 * Author: Frank Smith
 * Description: [pasted from techiedelight.com] Given an integer array, check if it contains a subarray having zero-sum
 * Challenge Source: https://www.techiedelight.com/check-subarray-with-0-sum-exists-not/
 */

// A rather difficult challenge, this will be largely based on the provided solution. Clever solution!

public class ArrFindZeroSum {
    // Travel through array
    // Keep track of sums encountered so far in a set
    // If the new sum is seen before, then there is a zero sum at the current index
    // else, add sum to set of encountered sums
    int[] arr;

    public ArrFindZeroSum(int[] arr){
        this.arr = arr;
    }

    public boolean find(){

        Set<Integer> setOfSums = new HashSet<Integer>();
        setOfSums.add(0);
        int currentSum = 0;

        for(int i = 0; i < arr.length; i++){
            currentSum += arr[i];
            if(setOfSums.contains(currentSum)){
                return true;
            }

            setOfSums.add(currentSum);
        }
        return false;
    }
}
