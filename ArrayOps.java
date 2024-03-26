public class ArrayOps {
    public static void main(String[] args) {


        //test code for second max val
        int x = 7; //array length
        int[] array = new int[x];

        // randomizes elements of array in given range
        int range = 100;
        for(int i = 0; i < x; i++){
            int signAssigner = (int) (Math.random() * 10);
            int newVal = (int) (Math.random() * range);
            //assigns sign on 50-50 chance
            if(signAssigner < 5){
                newVal = newVal * -1; 
            }
            array[i] = newVal;
            System.out.print(array[i] + ", ");
        }
        secondMaxValue(array);

    
         
    }
    
    public static int findMissingInt (int [] array) {
        System.out.println();
        //declares new boolean array of length of given array
        int n = array.length; 
        int[] check = new int[n]; 
        //runs through array and assigns the inex in check to true
        for(int i = 0; i < n; i++){
            int boolIndx = array[i];
            System.out.print(boolIndx + ", ");
            //check[boolIndx] = true; 
            check[boolIndx] = 1;
        }
        //after assigning true to whatever it could
        //we run through the new array and find the false val
        for( int i = 0; i < n; i++){
            if(check[i] == 0){
                System.out.println("missing numebr is " + i);
                return i;
            }
        }
        return 0;
    }

    public static int secondMaxValue(int [] array) {
        // variables for stats of given
        int n = array.length;
        int largest = array[0];
        int secondLargest = array[0];

        // finds largest
        for(int i = 1; i < n; i++){
            if(array[i] > largest){
                largest = array[i];

            }
        }
        //uses info gotten about largest to find second largest
        for(int j = 0; j < n; j++){
            if(array[j] > secondLargest && array[j] < largest){
                secondLargest = array[j];
            }
        }
//in a case where they both came out the same
        if(largest == secondLargest){
            int checker = array[1];
            for(int k = 1; k < n; k++){
                if(array[k] > checker){
                    checker = array[k];
                    secondLargest = checker;
                }
            }
        }
    
            //System.out.println("largest: " + largest);
           // System.out.println("Second largest: " + secondLargest);
        return secondLargest;
    }
    

    public static boolean containsTheSameElements(int [] array1,int [] array2) {
        //val to be retrned
        boolean returner = false;
        //variables used to check containment
        boolean oneIntwo = false;
        boolean twoInone = false;
        //array to store values of is contained/is not
        boolean[] checker = new boolean[array1.length];

        //checks if array 2 contained in array 1
        for(int i = 0; i < array1.length; i++){
            for(int j = 0; j < array2.length; j++){
                if(array1[i] == array2[j]){
                    checker[i] = true;
                    break;
                }
            }
        }
        //loops through checker to see if all indecies are true
        for(int k = 0; k < checker.length; k++){
            //creates boolean variable storing if contained
            if(checker[k] == true){
                oneIntwo = true;
            }
            else{
                oneIntwo = false;
                break;
            }
        }


        //new checker array
        boolean[] checkerTwo = new boolean[array2.length];

        //checks for array1 contained in array2
        for(int l = 0; l < array2.length; l++){
            for(int m = 0; m < array1.length; m++){
                if(array2[l] == array1[m]){
                    checkerTwo[l] = true;
                    break;
                }
            }
        }
             //loops through checker to see if all indecies are true
        for(int p = 0; p < checkerTwo.length; p++){
            //creates boolean variable storing if contained
            if(checkerTwo[p] == true){
                twoInone = true;
            }
            else{
                twoInone = false;
                break;
                }
            }

        //checks double sided containment and modifies the returner
        if(oneIntwo == true && twoInone == true){
            returner = true;
        }
        //System.out.println("the sets have the same elements " + returner);

        return returner;
        }


    public static boolean isSorted(int [] array) {
        boolean rising = true;
        boolean falling = true;
        //check for rising
        for(int i = 0; i < (array.length - 1); i++){
            if(array[i] > array[i+1]){
                rising = false;
            }
            else{
                break;
            }
        }
        //check for falling
        for(int i = 0; i < (array.length - 1); i++){
            if(array[i] < array[i+1]){
                falling = false;
            }
            else{
                break;
            }
        }
        
        //check for case the array is all the same elements
        if(array[0] == array[(array.length - 1)]){
            rising = false;
            falling = false;
        }

        System.out.println("rising: " + rising);
        System.out.println("falling: " + falling);
        return rising || falling;
    }

}
