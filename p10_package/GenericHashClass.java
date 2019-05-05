package p10_package;

public class GenericHashClass<GenericData extends Comparable<GenericData>>
{
    private final int DEFAULT_TABLE_SIZE = 10;

    public final int ITEM_NOT_FOUND = -1;

    public static final int LINEAR_PROBING = 101;

    public static final int QUADRATIC_PROBING = 102;

    private int tableSize;

    private int probeFlag;

    private Object[] tableArray;

    /**
     * Default constructor
     * Initializes to default table size with probe flag set to linear probing
     */
    public GenericHashClass()
    {
        int hashIndex = 0;
        tableArray = new Object[DEFAULT_TABLE_SIZE];
        while(hashIndex < DEFAULT_TABLE_SIZE)
        {
            tableArray[hashIndex] = null;
            hashIndex++;
        }
        probeFlag = LINEAR_PROBING;
        tableSize = DEFAULT_TABLE_SIZE;
    }

    /**
     * Initialization constructor
     * Initializes to default table size with probe flag set
     * to probe flag parameter
     * @param inProbeFlag inProbeFlag - sets linear or quadratic probing
     */
    public GenericHashClass(int inProbeFlag)
    {
        int hashIndex = 0;
        tableArray = new Object[DEFAULT_TABLE_SIZE];
        while(hashIndex < DEFAULT_TABLE_SIZE)
        {
            tableArray[hashIndex] = null;
            hashIndex++;
        }
        probeFlag = inProbeFlag;
        tableSize = DEFAULT_TABLE_SIZE;
    }

    /**
     * Initialization constructor
     * @param inTableSize inTableSize - sets table size (capacity)
     *                    but does not allow table size to be
     *                    less than default capacity
     * @param inProbeFlag inProbeFlag - sets linear or quadratic probing
     */
    public GenericHashClass(int inTableSize,
                            int inProbeFlag)
    {
        int hashIndex = 0;
        tableArray = new Object[inTableSize];
        while(hashIndex < inTableSize)
        {
            tableArray[hashIndex] = null;
            hashIndex++;
        }
        tableSize = inTableSize;
        probeFlag = inProbeFlag;
    }

    /**
     * Adds GenericData item to hash table
     * Note: Uses hash index value from generateHash
     *
     * Note: Shows probed index with data at the point of insertion
     *
     * Note: Probe attempts are limited to the current size (capacity)
     * of the table
     *
     * @param newItem
     * @return
     */
    public boolean addItem(GenericData newItem)
    {
        int attempt;
        int hashValue = generateHash(newItem);
        if(hashValue > tableSize)
        {
            for(attempt = 0; attempt < tableSize; attempt++)
            {
                if(tableArray[attempt] == null)
                {
                    tableArray[attempt] = newItem;
                    return true;
                }
                attempt++;

                if(attempt >= tableSize)
                {
                    attempt = 0;
                }
            }
        }

        return false;
    }

    /**
     * Clears hash table by setting all bins to null
     */
    public void clearHashTable()
    {
        int hashIndex = 0;
        while(hashIndex < tableSize)
        {
            tableArray[hashIndex] = null;
            hashIndex++;
        }
    }

    /**
     * Returns item found
     * @param searchItem
     * @return
     */
    public GenericData findItem(GenericData searchItem)
    {
        int hashIndex;
        for(hashIndex = 0; hashIndex < tableSize; hashIndex++)
        {
            if(searchItem.compareTo( (GenericData) tableArray[hashIndex]) == 0)
            {
                return (GenericData) tableArray[hashIndex];
            }
        }
        return null;
    }

    /**
     * Searches for item index in hash table
     * Uses linear or quadratic probing as configured
     * @param searchItem
     * @return
     */
    private int findItemIndex(GenericData searchItem)
    {
        int hashIndex;
        for(hashIndex = 0; hashIndex<tableSize;hashIndex++)
        {
            if(searchItem.compareTo((GenericData)tableArray[hashIndex]) == 0 )
            {
                return hashIndex;
            }
        }
        return ITEM_NOT_FOUND;
    }

    /**
     * Method converts GenericData hash value to index for use in hash table
     * @param item
     *
     * Note: gets data from object via hashCode, then calculates index
     *
     * Note: Uses hashCode from object
     * @return
     */
    public int generateHash(GenericData item)
    {
        return item.hashCode() % tableSize;
    }

    /**
     * Removes item from hash table
     * @param toBeRemoved
     * @return
     */
    public GenericData removeItem(GenericData toBeRemoved)
    {
        int hashIndex = findItemIndex(toBeRemoved);
        if( hashIndex != ITEM_NOT_FOUND)
        {
            Object Removed = tableArray[hashIndex];
            tableArray[hashIndex] = null;
            return (GenericData) Removed;
        }
        return null;
    }

    /**
     * traverses through all array bins, finds min and max number of contiguous
     * elements, and number of empty nodes; also shows table loading
     * NOTE: Generates string of used and unused bins in addition to
     * displaying results on screen
     * @return
     */
    public String showHashTableStatus()
    {
        int hashIndex;
        String printString = "";
        int emptyNodes = 0;
        int contValue = 0;
        int maxValue = 0;
        int minValue = tableSize;

        for(hashIndex = 0; hashIndex <= tableSize; hashIndex++)
        {
            if(tableArray[hashIndex] == null)
            {
                emptyNodes++;
                printString = printString + 'N';
            }
            else
            {
                printString = printString + "D";
            }

            if(tableArray[hashIndex] == tableArray[hashIndex - 1])
            {
                contValue++;

                if(contValue > maxValue)
                {
                    maxValue = contValue;
                }
                if(contValue < minValue)
                {
                    minValue = contValue;
                }
            }

        }
        printString = printString + ( "\n \t Empty Nodes: " + emptyNodes);
        printString = printString + ("\n \t Min Continuous Values: " + minValue);
        printString = printString + ("\n \t Max Continuous Values: " + maxValue);
        System.out.println(printString);

        return printString;
    }

    /**
     * Local recursive method to calculate exponentiation with integers
     * @param base
     * @param exponent
     * @return
     */
    private int toPower(int base,
                        int exponent)
    {
        if (exponent != 0)
            return (base * toPower(base, exponent - 1));
        else
            return 1;
    }
}
