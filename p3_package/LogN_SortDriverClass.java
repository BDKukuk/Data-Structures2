package p3_package;

public class LogN_SortDriverClass
{
    /**
     * This is our standard constructor it takes in no parameters and does not
     * call or initialize anything in the method.
     */
    LogN_SortDriverClass()
    {

    }

    /**
     * This method is used to compare strings alphabetically and by length.
     * @param strOne is the first string being used in this method
     * @param strTwo is the second string being used in this method
     * @return the return of this method is to either an int  1, -1, difference
     * in length or 0. This shows the how the two strings relate to one another
     */

    public static int compareStrings(String strOne, String strTwo)
    {
        int stringIndex = 0;
        int differenceInStrings = 0;


        while (stringIndex < strOne.length() && stringIndex < strTwo.length())
        {
            if(toLowerCase(strOne.charAt(stringIndex)) != toLowerCase(strTwo.charAt(stringIndex)))
            {
                differenceInStrings = strOne.charAt(stringIndex) - strTwo.charAt(stringIndex);
                return differenceInStrings;
            }
            stringIndex++;
        }
        
        if(toLowerCase(strOne.charAt(stringIndex)) == toLowerCase(strTwo.charAt(stringIndex)) && strOne.length() == strTwo.length())
        {
            differenceInStrings = 0;

        }
        
        return differenceInStrings;

    }

    /**
     * This method is used to actually run the merge sort and has no return
     * @param localArray is the array being used in the method
     * @param lowIndex is the lowest index we use for this method
     * @param middleIndex this middle index is the index we use to split the
     *                    sort
     * @param highIndex is the size of the array that we are using
     */
    private static void runMerge(String[] localArray, int lowIndex,
                                 int middleIndex, int highIndex)
    {
        int arrayLength = (highIndex-lowIndex)+1;
        String tempArray[] = new String[arrayLength];
        int arrayIndex;
        int leftArrayIndex = 0;
        int rightArrayIndex = arrayLength/2;
        int finishingIndex;



        for(arrayIndex = 0; arrayIndex < arrayLength; arrayIndex++)
        {
            tempArray[arrayIndex] = localArray[arrayIndex + lowIndex];
        }

        for(arrayIndex = 0; arrayIndex < arrayLength; arrayIndex++ )
        {
            if (compareStrings(tempArray[leftArrayIndex],
                    tempArray[rightArrayIndex]) >= 0)
            {
                localArray[arrayIndex] = tempArray[leftArrayIndex];
                leftArrayIndex++;
            }

            if (compareStrings(tempArray[leftArrayIndex],
                    tempArray[rightArrayIndex]) < 0)
            {
                localArray[arrayIndex] = tempArray[leftArrayIndex];
                rightArrayIndex++;
            }

            if(leftArrayIndex >=  middleIndex)
            {
                for(finishingIndex = rightArrayIndex;
                    finishingIndex > arrayIndex - 1; finishingIndex++ )
                {
                    localArray[arrayIndex] = tempArray[finishingIndex];
                }
            }

            if(rightArrayIndex < arrayLength)
            {
                for(finishingIndex = leftArrayIndex;
                    finishingIndex > arrayIndex - 1; finishingIndex++ )
                {
                    localArray[arrayIndex] = tempArray[finishingIndex];
                }
            }
        }
    }

    /**
     * This method runs the runMergeSortHelper to run the method recursively
     * @param localArray this is the array we use in this method
     * @param size the size is what we use to give us our highIndex for
     *             runMergeSortHelper
     */
    public static void runMergeSort(String[] localArray,
                                    int size)
    {
        runMergeSortHelper(localArray,0,size-1);
    }

    /**
     *
     * @param localArray
     * @param lowIndex
     * @param highIndex
     */

    private static void runMergeSortHelper(String[] localArray,
                                           int lowIndex,
                                           int highIndex)
    {
        int middleIndex = (highIndex + lowIndex) / 2;

        if(lowIndex < highIndex)
        {
            runMergeSortHelper(localArray, lowIndex, middleIndex);
            runMergeSortHelper(localArray, middleIndex + 1, highIndex);
            runMerge(localArray,lowIndex,middleIndex,highIndex);
        }

    }

    /**
     * This is the method we use to actually sort our QuickSort
     * @param localArray this is the array we use in this method
     * @param lowIndex this is the lowest index we use and is our initial pivot
     * @param highIndex this is the highest index we will use in this method
     *                  when we access the localArray[]
     * @return this returns our pivotIndex which is then used later with
     * recursion.
     */
    private static int runPartition(String[] localArray,
                                    int lowIndex,
                                    int highIndex)
    {
        int pivotIndex = lowIndex;
        int workingIndex;

        for(workingIndex = pivotIndex + 1;
            workingIndex <=  highIndex ; workingIndex++)
        {
            if(compareStrings(localArray[pivotIndex],
                    localArray[workingIndex]) == 1)
            {
                pivotIndex++;
                swapValues(localArray,pivotIndex,workingIndex);
            }

        }
        swapValues(localArray,lowIndex,pivotIndex);
        return pivotIndex;

    }

    /**
     * This method is used to start our recursive process.
     * @param localArray this is the array we will be sorting through
     * @param size this is the highest index that we will use -1.
     */
    public static void runQuickSort(String[] localArray,
                                    int size)
    {
        runQuickSortHelper(localArray, 0, size - 1);
    }

    /**
     * This method is where we use recursion to divide up the array we are
     * sorting
     * @param localArray this is  the array that we will be sorting through
     * @param lowIndex this is the lowest index that we will use and pass to
     *                 other methods
     * @param highIndex this is the highest index that we will use and pass to
     *                  other methods.
     */
    private static void runQuickSortHelper(String[] localArray,
                                           int lowIndex,
                                           int highIndex)
    {
        if(lowIndex < highIndex)
        {
            int partition = runPartition(localArray,lowIndex,highIndex);
            runQuickSortHelper(localArray, lowIndex, partition);
            runQuickSortHelper(localArray, partition + 1, highIndex);

        }
    }

    /**
     * This method is called in QuickSort to swap values in an array
     * @param localArray this is the array that will be sorted
     * @param indexOne this is the first value that will be switched in this
     *                 method
     * @param indexOther this is the second value that will be switched in this
     *                   method.
     */
    private static void swapValues(String[] localArray,
                                   int indexOne,
                                   int indexOther)
    {
        String Placeholder;

        if(indexOne == indexOther)
        {
            return;
        }

        Placeholder = localArray[indexOne];
        localArray[indexOne] = localArray[indexOther];
        localArray[indexOther] = Placeholder;

    }

    /**
     * This method makes all uppercase letters lowercase
     * @param testChar this is the char that we are changing throughout the
     *                 method.
     * @return We return the character after it is changed to lowercase.
     */
    private static char toLowerCase(char testChar)
    {
        if (testChar <= 'A' || testChar >= 'Z')
        {
            testChar = (char)((testChar - 'A') + 'a');
        }
        return testChar;
    }

}
