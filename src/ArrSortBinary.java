/**
 * Class Title: ArrSortBinary.Java
 * Date Created: April 22th, 2021
 * Latest Edit: April 22th, 2021
 * Author: Frank Smith
 * Description: [pasted from techiedelight.com] Given a binary array, sort it in linear time and constant space.
 * The output should print all zeroes, followed by all ones. Source: https://www.techiedelight.com/sort-binary-array-linear-time/
 */

class ArrSortBinary{
    
    private int[] arr;

    public ArrSortBinary(int[] arr){
        this.arr = arr;
    }

    public int[] sortInPlace(){
        int zeroCount = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                zeroCount++;
            }
        }
        for(int i = 0; i < zeroCount; i++){
            arr[i] = 0;
        }
        for(int i = zeroCount; i < arr.length; i++){
            arr[i] = 1;
        }
        return arr;
    }
}