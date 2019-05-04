package p11_package;

/**
 * Class manages adjacency nodes in iterator data structure
 */
public class AdjacencyList
   {
    /**
     * adjacency node data managed by array
     */
    AdjacentNode[] adjacentData;
    
    /**
     * constant left parenthesis character
     */
    private final char LEFT_PAREN = '(';
    
    /**
     * constant right parenthesis character
     */
    private final char RIGHT_PAREN = ')';
    
    /**
     * constant comma character
     */
    private final char COMMA = ',';
    
    /**
     * constant space character
     */
    private final char SPACE = ' ';
    
    /**
     * Default adjacency list capacity
     */
    private final int VERTEX_CAPACITY = 26;
    
    /**
     * iterator size
     * 
     */
    private int listSize;
    
    /**
     * iterator index
     */
    private int iteratorIndex;
    
    /**
     * Default constructor
     */
    public AdjacencyList()
       {
        adjacentData = new AdjacentNode[ VERTEX_CAPACITY ];

        listSize = 0;
       }
   
    /**
     * Copies an adjacency list object
     * 
     * @param copied AdjacencyList object to be copied
     */
    public AdjacencyList( AdjacencyList copied )
       {
        int index;
        
        listSize = copied.listSize;
        
        adjacentData = new AdjacentNode[ VERTEX_CAPACITY ];
        
        for( index = 0; index < listSize; index++ )
           {
            adjacentData[ index ] 
                           = new AdjacentNode( copied.adjacentData[ index ] );
           }
       }
   
     /**
      * Adds adjacency data, in alphabetical order
      * <p>
      * Note: Uses insertion sort strategy
      * 
      * @param vertex character vertex letter to be added
      * 
      * @param weight integer weight value to be added
      */
     public void add( char vertex, int weight )
        {
         int index = listSize;
         
         while( index > 0 && adjacentData[ index - 1 ].getVertex() > vertex )
            {
             if( adjacentData[ index ] == null )
                {
                 adjacentData[ index ] 
                             = new AdjacentNode( adjacentData[ index - 1 ] );
                }
             
             else
                {
                 adjacentData[ index ] = adjacentData[ index - 1 ];
                }
             
             index--;
            }
            
         adjacentData[ index ] = new AdjacentNode( vertex, weight );
         
         listSize++;
        }
     
     /**
      * Clears adjacency list data
      */
     public void clear()
        {
         listSize = 0;
        }
    
     /**
      * Accesses first item in list, sets current index to first
      * adjacency node
      * 
      * @return AdjacentNode data found at first element if available
      */
     public AdjacentNode getFirstItem()
        {
         if( !isEmpty() )
            {
             iteratorIndex = 0;
             
             return adjacentData[ iteratorIndex ];
            }
        
         return null;
        }
 
     /**
      * Increments index, gets next adjacency node
      * 
      * @return AdjacentNode data found at next element if available
      */
     public AdjacentNode getNextItem()
        {
         if( !isEmpty() )
            {
             iteratorIndex++;
            
             if( iteratorIndex < listSize )
                { 
                 return adjacentData[ iteratorIndex ];
                }
            }
         
         return null;
        }

     /**
      * Returns empty state
      * 
      * @return boolean result of method; true if empty, false otherwise
      */
     private boolean isEmpty()
        {
         return listSize == 0;
        }
     
     /**
      * Provides adjacency data as a string with front value to right
      */
     public String toString()
        {
         int index;
         String outString = "Adjacency: ";
         
         for( index = listSize - 1; index >= 0; index-- )
            {
             outString += adjacentData[ index ].getVertex();
             outString += LEFT_PAREN;
             outString += adjacentData[ index ].getWeight();
             outString += RIGHT_PAREN;
             outString += COMMA;
             outString += SPACE;
            }
         
         return outString;
        }

   }

