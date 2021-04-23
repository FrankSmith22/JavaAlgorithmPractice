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

    /*
        After reading the one sentence english explanation of their first solution,
        I was able to construct it in code. Not bad, could be refactored.
    */
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

    /*
        Really interesting solution! this one is straight from their site, and makes a lot of sense.
        Essentially, we have defined our pivot to check against as 1, so that if we ever encounter a zero,
        we'll know, and swap with position j. Position j starts at 0, and increments by 1 whenever we encounter a swap.
    */
    public int[] sortInPlacePivot(){
        int pivot = 1;
        int j = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] < pivot){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                j++;
            }
        }
        return arr;
    }
}