import java.util.ArrayList;
import java.util.HashSet;

/**
 * Class Title: ArrFindDupElem.Java
 * Date Created: April 25th, 2021
 * Latest Edit: April 25th, 2021
 * Author: Frank Smith
 * Description: [pasted from techiedelight.com] Given a limited range array of size 
 * n and containing elements between 1 and n-1 with one element repeating,
 * find the duplicate number in it without using any extra space.
 * Challenge Source: https://www.techiedelight.com/find-duplicate-element-limited-range-array/
 */

public class ArrFindDupElem {
    int[] arr;
    public ArrFindDupElem(int[] arr){
        this.arr = arr;
    }

    // Simple solution I came up with using an arraylist to keep track of found elems so far. Primitive but effective for the challenge
    public Integer find(){
        ArrayList<Integer> elems = new ArrayList<Integer>();
        for(int i = 0; i < arr.length; i++){
            if(elems.contains(arr[i])){
                return arr[i];
            }
            elems.add(arr[i]);
        }
        return null;
    }

    // Another solution I generated that instead takes advantage of the no-duplicate property of Sets
    public Integer findWithSet(){
        HashSet<Integer> elems = new HashSet<Integer>();
        for(int i = 0; i < arr.length; i++){
            if(elems.add(arr[i])){
                continue;
            }
            return arr[i];
        }
        return null;
    }

    /*
    REALLY interesting solution they have! Essentially what is going on here, is that we are using the elements in the array themselves
    as a sort of key, and flipping (make negative) each value that we encounter, so that way if we encounter that element again, we'll
    know because we'll have flipped it back to positive! Very interesting stuff. Of course, it is reliant on the properties of the array:
    That it only contains positive numbers, and that it must be in order from 1 to n, where the duplicate has already been listed in the order.
    An array of {1, 2, 6, 6, 3} does not work for example, since 6 has not appeared yet.
    */

    public Integer findInPlace(){
        Integer dupe = null;
        for(int elem : arr){
            int value = (elem < 0) ? -elem : elem;

            // make element at index val-1 negative if it is positive
            if(arr[value-1] >= 0){
                arr[value-1] = -arr[value-1];
            }
            else{
                // If element is already negative, it is a duplicate
                dupe = value;
                break;
            }
        }

        // Must restore the array before returning
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < 0){
                arr[i] = -arr[i];
            }
        }

        return dupe;
    }
}