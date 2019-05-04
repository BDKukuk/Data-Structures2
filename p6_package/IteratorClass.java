package p6_package;

public class IteratorClass extends BasicLinkedListClass
{

    private final char LEFT_BRACKET = 91;

    private final char RIGHT_BRACKET = 93;

    private final char SPACE = 32;

    private int currentIndex;

    public IteratorClass()
    {
        super();
        this.currentIndex = 0;
    }

    public IteratorClass(IteratorClass copied)
    {
        super(copied);
        this.currentIndex = copied.currentIndex;
    }

    public void clear()
    {
        super.clear();
        currentIndex = 0;
    }

    public int getAtCurrent()
    {
        return super.getAtIndex(currentIndex);
    }

    public boolean isAtBeginning()
    {
        if(super.getCurrentSize() == 0)
        {
            return false;
        }

        if(currentIndex == 0)
        {
            return true;
        }

        return false;
    }

    public boolean isAtEnd()
    {
        if(super.getCurrentSize() == 0)
        {
            return false;
        }

        if(currentIndex == super.getCurrentSize())
        {
            return true;
        }
        return false;
    }

    public boolean isEmpty()
    {
        return super.isEmpty();
    }


    public boolean moveNext()
    {
        if(super.isEmpty())
        {
            return false;
        }

        if(!(isAtEnd()))
        {
            currentIndex = currentIndex + 1;
            return true;
        }
        return false;
    }

    public boolean movePrev()
    {
        if(super.isEmpty())
        {
            return false;
        }

        if(!(isAtBeginning()))
        {
            currentIndex = currentIndex - 1;
            return true;
        }
        return false;
    }

    public int removeAtCurrent()
    {

        if(super.getCurrentSize() == currentIndex)
        {
            int lastIndex = currentIndex;
            currentIndex--;
            return super.removeAtIndex(lastIndex);
        }
        return super.removeAtIndex(currentIndex);
    }

    public boolean replaceAtCurrent(int newValue)
    {
        return super.setAtIndex(currentIndex,newValue,REPLACE);
    }

    public void runDiagnosticDisplay()
    {
        int listIndex = 0;
        while(listIndex < currentIndex)
        {
            System.out.print(super.getAtIndex(listIndex) + " ");
        }

        System.out.print(" [ " + currentIndex + " ] ");
        listIndex++;

        while(listIndex < super.getCurrentSize())
        {
            System.out.print(super.getAtIndex(listIndex) + " ");
        }
    }

    public boolean setAfterCurrent(int newValue)
    {
        return super.setAtIndex(currentIndex,newValue,INSERT_AFTER);
    }

    public boolean setBeforeCurrent(int newValue)
    {
        moveNext();
        return super.setAtIndex(currentIndex,newValue,INSERT_BEFORE);
    }

    public boolean setToBeginning()
    {
        if(super.isEmpty())
        {
            return false;
        }
        currentIndex = 0;
        return true;
    }

    public boolean setToEnd()
    {
        if(super.isEmpty())
        {
            return false;
        }

        currentIndex = super.getCurrentSize();
        return true;
    }
}
