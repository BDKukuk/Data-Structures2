package p5_package;


/**
 * Put main outside p5_package
 */

public class StackClass
{
    /**
     * The data type we use for this class
     */
    private BasicArrayClass stackData;

    /**
     * These are the three constructors for this class
     */
    public StackClass()
    {
        BasicArrayClass stackData = new BasicArrayClass();
    }

    public StackClass(int capacitySetting)
    {
        BasicArrayClass stackData = new BasicArrayClass(capacitySetting);
    }

    public StackClass(StackClass copied)
    {
        int arrayIndex;
        stackData = new BasicArrayClass(copied.stackData.getCurrentCapacity());

        for(arrayIndex = 0; arrayIndex <
                stackData.getCurrentSize();arrayIndex++)
        {
            stackData.setAtIndex(arrayIndex,
                    copied.stackData.getAtIndex(arrayIndex),
                    BasicArrayClass.REPLACE);
        }

    }

    /**
     * This is the method used to clear the stack
     */
    public void clear()
    {
        stackData.clear();
    }

    /**
     * This method displays the stack
     */
    public void displayStack()
    {
        System.out.println(stackData);
    }

    /**
     * This method checks if the array is empty
     * @return true if accomplished
     */
    public boolean isEmpty()
    {
        return stackData.isEmpty();
    }

    /**
     * checks the first index of stack
     * @return the first item.
     */

    public int peekTop()
    {
        return stackData.getAtIndex(0);
    }

    /**
     * This removes the top item off the top
     * @return the int
     */
    public int pop()
    {
        return stackData.removeAtIndex(0);
    }

    /**
     * This adds a new item to the top of the array
     * @param newVal
     */
    public void push(int newVal)
    {
        stackData.setAtIndex(0,newVal,BasicArrayClass.INSERT_BEFORE);
    }
}

