import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class Title: Main
 * Date Created: April 1st, 2021
 * Latest Edit: April 11th, 2021
 * Author: Frank Smith
 * Description: Entry point to application
 */
public class Main {
    public static void main(String[] args) throws Exception {
        //testBinarySearch();
        //testArrFindPairSum();
        testArrFindZeroSum();
    }

    public static void testBinarySearch(){
        BinarySearch search = new BinarySearch(1, 10000);
        search.search(17);
    }
    public static void testArrFindPairSum(){
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(5, 7, 20, 4, 19, 6, 2, 10));
        int sum = 24;
        ArrFindPairSum search = new ArrFindPairSum(arr, sum);

        // ArrayList<Integer> result = search.findFirst();
        // if(result == null){
        //     System.out.println("Sorry, that sum as a pair couldn't be found in the provided list of values!");
        //     return;
        // }
        // System.out.println(result);
        
        ArrayList<int[]> results = search.find();
        if(results.isEmpty()){
            System.out.println("Sorry, that sum as a pair couldn't be found in the provided list of values!");
            return;
        }
        System.out.print("Results: ");
        for (int i=0; i<results.size(); i++){
            int[] tmp = results.get(i);

            System.out.print("[ ");
            for (int j=0; j<tmp.length; j++) {
                 System.out.print(String.format("%d, ", tmp[j]));
            }
            System.out.print(" ]");
        }
    }
    public static void testArrFindZeroSum(){
        int[] arr = {5, 3, -6, -1, 4};
        ArrFindZeroSum search = new ArrFindZeroSum(arr);
        boolean found = search.find();
        if(found){
            System.out.println("Sub-array with a sum of zero found");
        }
        else {
            System.out.println("Sub-array with a sum of zero NOT found");
        }
    }
}
