package p9_package;

public class ArrayHeapClass
{
    private int arraySize;

    private int arrayCapacity;

    public final int DEFAULT_ARRAY_CAPACITY = 10;

    private boolean displayFlag;

    private StudentClass[] heapArray;

    /**
     * Default constructor sets up array management conditions and
     * default display flag setting
     */
    public ArrayHeapClass()
    {

        arrayCapacity = DEFAULT_ARRAY_CAPACITY;
        heapArray = new StudentClass[arrayCapacity];
        arraySize = 0;
        displayFlag = false;
    }

    /**
     * Copy constructor copies array and array management conditions and
     * default display flag setting
     * @param copied
     */
    public ArrayHeapClass(ArrayHeapClass copied)
    {
        this.arrayCapacity = copied.arrayCapacity;
        this.heapArray = new StudentClass[arrayCapacity];
        this.displayFlag = copied.displayFlag;
        this.arraySize = copied.arraySize;

        int heapIndex;
        for(heapIndex = 0; heapIndex < arraySize; heapIndex++)
        {
            this.heapArray[heapIndex] = copied.heapArray[heapIndex];
        }
    }

    /**
     * Accepts StudentClass item and adds it to heap
     * Note: uses bubbleUpArrayHeap to resolve unbalanced heap after
     * data addition
     *
     * Note: Always checks for resize before adding data
     * @param newItem
     */
    public void addItem(StudentClass newItem)
    {
        checkForResize();
        arraySize++;
        heapArray[arraySize] = newItem;
        bubbleUpArrayHeap(arraySize);
    }

    /**
     * Recursive operation to reset data in the correct order for the max
     * heap after new data addition
     * @param currentIndex
     */
    private void bubbleUpArrayHeap(int currentIndex)
    {
        if(currentIndex < 0)
        {
            if(currentIndex % 2 == 0 )
            {
                if(heapArray[currentIndex].gpa > heapArray[(currentIndex/2) -1 ].gpa)
                {
                    double placeholder = heapArray[(currentIndex/2) -1 ].gpa;
                    heapArray[(currentIndex/2) -1 ].gpa = heapArray[currentIndex].gpa;
                    heapArray[currentIndex].gpa = placeholder;
                    bubbleUpArrayHeap((currentIndex/2) -1);
                }
            }
            else
            {
                if(heapArray[currentIndex].gpa > heapArray[(currentIndex/2)].gpa)
                {
                    double placeholder = heapArray[(currentIndex/2)].gpa;
                    heapArray[(currentIndex/2)].gpa = heapArray[currentIndex].gpa;
                    heapArray[currentIndex].gpa = placeholder;
                    bubbleUpArrayHeap((currentIndex/2));
                }
            }
        }
    }

    /**
     * Automatic resize operation used prior to any new data addition in the
     * heap
     * Note: Tests for full heap array, and resizes to twice the current
     * capacity as required
     */
    private void checkForResize()
    {
        int heapIndex = 0;
        StudentClass[] newArray = new StudentClass[2*arraySize];

        if(arraySize == arrayCapacity)
        {
            while(heapArray[heapIndex] != null)
            {
                while(heapIndex < arraySize)
                {
                    newArray[heapIndex] = heapArray[heapIndex];
                    heapIndex++;
                }
            }
            heapArray = newArray;
            arrayCapacity = arrayCapacity*2;
        }
    }

    /**
     * Tests for empty heap
     * @return
     */
    public boolean isEmpty()
    {
        if(arraySize == 0)
        {
            return true;
        }
        return false;
    }

    /**
     * Removes StudentClass item from top of max heap
     * Note: Uses trickleDownArrayHeap to resolve unbalanced heap after
     * data removal
     * @return
     */
    public StudentClass removeItem()
    {
        StudentClass removedItem = heapArray[0];
        heapArray[0] = heapArray[arraySize];
        trickleDownArrayHeap(0);
        arraySize--;
        return removedItem;
    }

    /**
     * Utility method to set the display flag for displaying internal
     * operations of the heap bubble and trickle
     * operations
     * @param setState
     */
    public void setDisplayFlag(boolean setState)
    {
        displayFlag = setState;
    }

    /**
     * Dumps array to screen as is, no filtering or management
     */
    public void showArray()
    {
        int heapIndex;
        for(heapIndex = 0; heapIndex < arraySize; heapIndex++)
        {
            System.out.println(heapArray[heapIndex]);
        }
    }

    /**
     * Recursive operation to reset data in the correct order for the
     * max heap after data removal
     * @param currentIndex
     */
    private void trickleDownArrayHeap(int currentIndex)
    {
        if(heapArray[currentIndex].gpa < heapArray[currentIndex*2 + 1].gpa)
        {
            StudentClass placeholder = heapArray[currentIndex*2+1];
            heapArray[currentIndex*2 + 1] = heapArray[currentIndex];
            heapArray[currentIndex] = placeholder;
            trickleDownArrayHeap(currentIndex*2+1);
        }
        else
        {
            StudentClass placeholder = heapArray[currentIndex*2+2];
            heapArray[currentIndex*2 + 2] = heapArray[currentIndex];
            heapArray[currentIndex] = placeholder;
            trickleDownArrayHeap(currentIndex*2+2);
        }
    }
}
