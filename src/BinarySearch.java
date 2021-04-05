/**
 * Class Title: BinarySearch
 * Date Created: April 1st, 2021
 * Latest Edit: April 1st, 2021
 * Author: Frank Smith
 * Description: Accomplishes an integer search through a range of integers using the binary search algorithm
 */
public class BinarySearch {

    private int min;
    private int max;
    public BinarySearch(int min, int max){
        if(!(min >= max)){
            this.min = min;
            this.max = max;
        }
        else {
            System.out.println("Invalid range, defaulting to a min of 1, and a max of 100");
            this.min = 1;
            this.max = 100;
        }
    }

    public int search(int searchNum){
        if(searchNum < min || searchNum > max){
            System.out.println(String.format("Invalid search number. Please enter a number between %d and %d.", min, max));
            return 0;
        }

        searchAlgorithm(searchNum, min, max, 0);

        return searchNum;
    }

    private int searchAlgorithm(int searchNum, int min, int max, int guesses){
        guesses++;
        //Generate guess between min and max
        int guessNum = (min + max)/2;
        System.out.println(String.format("Guess number: %d; Trying this number: %d", guesses, guessNum));
        //Check searchNum against this guess
        if(searchNum == guessNum){
            System.out.println(String.format("Congrats, the computer was able to guess your number in %d tries", guesses));
            return guesses;
        }
        //Determine if searchNum is higher or lower than guess
        if(searchNum < guessNum){
            //Adjust min or max accordingly to match guess
            max = guessNum;
        }
        else{
            //Adjust min or max accordingly to match guess
            min = guessNum;
        }
        //Recursively call this function again to start over
        searchAlgorithm(searchNum, min, max, guesses);
        return 0;
    }
}