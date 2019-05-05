package p6_package;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import javax.xml.soap.Node;
import java.util.LinkedList;

public class BasicLinkedListClass
{
    /**
     * Constant for FAILED_ACCESS
     */
    public static final int FAILED_ACCESS = -999999;

    private NodeClass headref;

    /**
     * Constant for insert_after
     */
    public static final int	INSERT_AFTER = 1003;

    /**
     *
     */
    public static final int	INSERT_BEFORE = 1002;

    /**
     * Constant for insert_before
     */
    public static final int	REMOVE = 1004;

    /**
     * Constant for replace
     */
    public static final int	REPLACE = 1001;

    /**
     * Constant for retrieve
     */
    public static final int	RETRIEVE = 1005;

    protected BasicLinkedListClass()
    {
        headref = null;
    }

    protected BasicLinkedListClass(BasicLinkedListClass copied)
    {
        NodeClass localRef;
        if(copied.headref == null)
        {
            headref = null;
        }

        localRef = new NodeClass(copied.headref);
        localRef.nextRef = new NodeClass(copied.headref.nextRef);
        localRef = new NodeClass(copied.headref.nextRef);

        while(localRef.nextRef != null)
        {
            localRef.nextRef = new NodeClass(localRef.nextRef);
            localRef = new NodeClass(localRef.nextRef);
        }

    }

    private int	accessAtIndex(int controlCode, int index)
    {

        if(index <= getCurrentSize())
        {
            if(controlCode == REMOVE)
            {
                this.removeAtIndex(index);
            }

            if(controlCode == RETRIEVE)
            {
                return this.getAtIndex(index);
            }

        }

        return FAILED_ACCESS;
    }

    protected void clear()
    {
        this.headref = null;
    }

    protected int getAtIndex(int accessIndex)
    {
        return accessAtIndex(RETRIEVE,accessIndex);

    }

    // This returns size
    // (if NodeClass.nextref != null)
    protected int getCurrentSize()
    {
        if(this.headref != null)
        {
            getCurrentSizeHelper(this.headref);
        }
        return 0;
    }


    // This returns the list size
    private int	getCurrentSizeHelper(NodeClass wkgRef)
    {
        int size = 1;
        if(wkgRef != null)
        {
            getCurrentSizeHelper(wkgRef.nextRef);
            size++;
        }
        return size;
    }



    private NodeClass getRefAtIndex(NodeClass wkgRef, int requestedIndex)
    {
        int index;

        if(wkgRef != null && requestedIndex > 0)
        {
            return getRefAtIndex(wkgRef.nextRef,requestedIndex-1);
        }
        if(requestedIndex < 0 || requestedIndex < getCurrentSize() )
        {
            return null;
        }

        return wkgRef;
    }

    protected boolean isEmpty()
    {
        if(headref == null)
        {
            return true;
        }
        return false;
    }

    protected int removeAtIndex(int removeIndex)
    {
        return accessAtIndex(REMOVE,removeIndex);
    }

    protected void	runDiagnosticDisplay(boolean showIndex)
    {
        NodeClass temp = new NodeClass(headref);
        int listIndex, printIndex;
        if(showIndex)
        {
            System.out.printf("List: | ");
            for(listIndex = 0; temp != null; listIndex++)
            {
                System.out.printf(temp +  " | ");
                temp = temp.nextRef;
            }

            System.out.printf("/n");

            for(printIndex = 0; printIndex < listIndex; printIndex++ )
            {
                System.out.print(printIndex);
            }
        }
        else
        {
            System.out.printf("List: | ");
            for(listIndex = 0; temp != null; listIndex++)
            {
                System.out.printf(temp +  " | ");
                temp = temp.nextRef;
            }
        }

    }

    /**
     * Description: sets item in linked list at specified virtual index
     *
     * Note: If constant REPLACE is used, new value overwrites value at current virtual index
     *
     * Note: If constant INSERT_BEFORE is used, new value is inserted prior to the value at the current virtual index
     *
     * Note: If constant INSERT_AFTER is used, new value is inserted after the value at the current virtual index
     *
     * Note: Method must check for correct virtual array boundaries; if index requested is below zero or above list size - 1, method must take no action and return false
     *
     * Note: Method must check for correct replace flag; if it is not one of the three specified flags, it must take no action and return false
     * @param setIndex
     * @param newValue
     * @param replaceFlag
     * @return
     */
    protected boolean setAtIndex(int setIndex, int newValue, int replaceFlag)
    {
       int linkedListIndex;
       NodeClass currentNode = headref;
       for(linkedListIndex = 0; linkedListIndex < setIndex; linkedListIndex++)
       {
           currentNode = currentNode.nextRef;
       }
       if(replaceFlag == INSERT_BEFORE)
       {
           NodeClass nodeHolder = currentNode.nextRef;
           currentNode.nextRef = new NodeClass(newValue);
           currentNode.nextRef.nextRef = nodeHolder;
           return true;
       }
       currentNode = currentNode.nextRef;
       if(replaceFlag == REPLACE)
       {
           currentNode.nodeData = newValue;
           return true;
       }
       if(replaceFlag == INSERT_AFTER)
       {
           NodeClass nodeHolder = currentNode.nextRef;
           currentNode.nextRef = new NodeClass(newValue);
           currentNode.nextRef.nextRef = nodeHolder;
           return true;
       }
       return false;
    }



    private class NodeClass
    {

        int nodeData;

        NodeClass nextRef;

        private NodeClass(int newData)
        {
            this.nodeData = newData;
            this.nextRef = null;
        }

        private NodeClass(NodeClass copied)
        {
            this.nodeData = copied.nodeData;
            this.nextRef = new NodeClass(copied.nextRef);
        }

    }
}
