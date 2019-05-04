package p5_package;

public class BasicArrayClass
{
    /**
     * Constant for our array Capacity
     */

    private static final int DEFAULT_CAPACITY = 10;
    /**
     * Value used to signafy a failure
     */

    public static final int FAILED_ACCESS = -999999;
    /**
     * constant used when we replace a value
     */

    public static final int REPLACE = 1001;
    /**
     * constant value for insert before
     */

    public static final int INSERT_BEFORE = 1002;

    /**
     * constant value for insert after
     */

    public static final int INSERT_AFTER = 1003;

    /**
     * constant for remove
     */

    public static final int REMOVE = 1004;

    /**
     * constant for retrieve
     */

    public static final int RETRIEVE = 1005;

    /**
     * Local array initialization
     */

    private int[] localArray;

    /**
     * value for array size
     */

    private int arraySize;
    /**
     * value for an array capacity
     */

    private int arrayCapacity;


    /**
     * Constructors for this class
     */
    protected BasicArrayClass()
    {
        localArray = new int[DEFAULT_CAPACITY];
        this.arrayCapacity = DEFAULT_CAPACITY;
        this.arraySize = 0;

    }

    protected BasicArrayClass(int capacity)
    {
        localArray = new int[capacity];
        arrayCapacity = capacity;
        arraySize = 0;
    }

    protected BasicArrayClass(BasicArrayClass copied)
    {
        int arrayIndex = 0;
        arrayCapacity = copied.arrayCapacity;
        arraySize = copied.arraySize;

        while(arrayIndex < arraySize)
        {
            localArray[arrayIndex] = copied.localArray[arrayIndex];
            arrayIndex++;
        }
    }

    /**
     * This method takes in control code and an index and if the control
     * code is remove then it calls remove at index, and if it is
     * retrieve then it uses getAtIndex
     * @param controlCode
     * @param index
     * @return
     */
    private int accessAtIndex(int controlCode,
                              int index)
    {
        if(controlCode == REMOVE)
        {
            this.removeAtIndex(index);
        }

        if(controlCode == RETRIEVE)
        {
            return this.getAtIndex(index);
        }
        else
        {
            return FAILED_ACCESS;
        }
    }

    /**
     * This method checks if size is equivalent to capacity.
     * if it is it doubles
     * the size of the array.
     */

    protected void checkForResize()
    {
        int arrayIndex = 0;
        int newArrayCapacity = (arrayCapacity * 2);
        if(this.arraySize == this.arrayCapacity)
        {
            int[] newArray = new int[newArrayCapacity];

            while(arrayIndex < arraySize)
            {
                newArray[arrayIndex] = this.localArray[arrayIndex];
            }



        }
    }

    /**
     * This method changes the size back to 0
     */

    protected void clear()
    {
        this.arraySize = 0;
    }

    /**
     * This method retrieves a character from the "accessIndex"
     * @param accessIndex
     * @return said character
     */

    protected int getAtIndex(int accessIndex)
    {
       return this.accessAtIndex(RETRIEVE,accessIndex);
    }

    /**
     * This method retrieves the array capacity
     * @return currentCapacity
     */

    protected int getCurrentCapacity()
    {
        return this.arrayCapacity;
    }

    /**
     * This method returns the array size
     * @return arraySize
     */

    protected int getCurrentSize()
    {
        return this.arraySize;
    }

    /**
     * Checks if the array is empty
     * @return true if empty
     */

    protected boolean isEmpty()
    {
        if(this.arraySize == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * This method removes an item from said index
     * @param removeIndex
     * @return removed item
     */

    protected int removeAtIndex(int removeIndex)
    {
        arraySize = arraySize - 1;
        return this.accessAtIndex(REMOVE,removeIndex);

    }

    /**
     * This method is used to mutate the whole array and
     * is called by may other methods
     * @param setIndex
     * @param newValue
     * @param replaceFlag
     * @return true if task is accomplished
     */

    protected boolean setAtIndex(int setIndex,
                                 int newValue,
                                 int replaceFlag)
    {
        int placeholder;
        int indexInArray;

        if(replaceFlag == REPLACE)
        {
            localArray[setIndex] = newValue;
        }

        // Check arrayCapacity first
        if(replaceFlag == INSERT_AFTER)
        {
            for(indexInArray = setIndex; indexInArray <
                    this.arrayCapacity; indexInArray++)
            {
                placeholder = localArray[setIndex];
                localArray[setIndex] = newValue;
                localArray[setIndex+1] = placeholder;
            }
            return true;
        }
        if(replaceFlag == INSERT_BEFORE)
        {
            for(indexInArray = setIndex; indexInArray <
                    this.arrayCapacity; indexInArray--)
            {
                placeholder = localArray[setIndex];
                localArray[setIndex] = newValue;
                localArray[setIndex-1] = placeholder;
            }
            return true;
        }

        return false;
    }

}