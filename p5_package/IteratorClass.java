package p5_package;

/**
 * Put main outside p5_package
 */

public class IteratorClass extends BasicArrayClass
{
    /**
     * current index for iterator class
     */
    private int currentIndex;

    /**
     * Constant for SPACE
     */

    private final char SPACE = 32;

    /**
     * Constant for Left Bracket
     */

    private final char LEFT_BRACKET = 91;

    /**
     * Constant for Right Bracket
     */
    private final char RIGHT_BRACKET= 93;

    /**
     * Constructors for the iterator class
     */

    public IteratorClass()
    {
        super();
        currentIndex = 0;
    }

    public IteratorClass(int initCapacity)
    {
        super(initCapacity);
        currentIndex = 0;
    }

    public IteratorClass(IteratorClass copied)
    {
        super(copied);
        currentIndex = copied.currentIndex;
    }

    /**
     * A method that calls clear from BasicArrayClass
     */
    public void clear()
    {
        super.clear();
    }

    /**
     * Calls get at index of current index
     * @return the int returned from getAtIndex
     */
    public int getAtCurrent()
    {
        return super.getAtIndex(currentIndex);
    }

    /**
     * This method checks if the iterator is at the end of an array
     */
    public boolean isAtEnd()
    {
        if(currentIndex == super.getCurrentSize())
        {
            return true;
        }
        return false;
    }

    /**
     * This method checks if the array is empty
     * @return true if the array is empty
     */
    public boolean isEmpty()
    {
        return super.isEmpty();
    }

    /**
     * moves the iterator to the next index
     * @return true if accomplished
     */
    public boolean moveNext()
    {
        if(currentIndex < super.getCurrentCapacity())
        {
            currentIndex++;
            return true;
        }
        return false;
    }

    /**
     * moves the iterator to the previous index
     * @return true if accomplished
     */
    public boolean movePrev()
    {
        if(currentIndex > 0)
        {
            currentIndex--;
            return true;
        }

        return false;
    }

    /**
     * removes item at index
     * @return the item that was removed
     */
    public int removeAtCurrent()
    {
        return super.removeAtIndex(currentIndex);
    }

    /**
     * replaces item at current index
     * @param newValue
     * @return true if accomplished
     */
    public boolean replaceAtCurrent(int newValue)
    {
        if(super.setAtIndex(currentIndex,newValue,REPLACE))
        {
            return true;
        }

        return false;
    }

    /**
     * This method prints out the array and the iterator position
     */
    public void runDiagnosticDisplay()
    {
        int arrayIndex;
        for(arrayIndex = 0; arrayIndex < currentIndex; arrayIndex++)
        {
            System.out.print(super.getAtIndex(arrayIndex));

        }

        System.out.print(SPACE + LEFT_BRACKET + SPACE +
                super.getAtIndex(arrayIndex) + SPACE +
                RIGHT_BRACKET + SPACE);


        for(arrayIndex = arrayIndex + 1; arrayIndex <= super.getCurrentSize();
            arrayIndex++ )
        {
            System.out.print(super.getAtIndex(arrayIndex));
        }

    }

    /**
     * this method inserts a value after current index
     * @param newValue
     * @return true if accomplished
     */
    public boolean setAfterCurrent(int newValue)
    {
        if(super.setAtIndex(currentIndex+1,newValue,INSERT_AFTER))
        {
            return true;
        }

        return false;
    }

    /**
     * this method inserts a value before current index
     * @param newValue
     * @return true if accomplished
     */
    public boolean setBeforeCurrent(int newValue)
    {
        if(super.setAtIndex(currentIndex-1,newValue,INSERT_BEFORE))
        {
            return true;
        }

        return false;
    }

    /**
     * This method puts the iterator at the beginning of the array
     * @return true if accomplished
     */
    public boolean setToBeginning()
    {
        if(currentIndex != 0)
        {
            currentIndex = 0;
            return true;
        }

        return false;
    }

    /**
     * This method puts the iterator at the end of the array
     * @return true if accomplished
     */
    public boolean setToEnd()
    {
        if(currentIndex != super.getCurrentSize())
        {
            currentIndex = super.getCurrentSize();
            return true;
        }
        return false;
    }
}
