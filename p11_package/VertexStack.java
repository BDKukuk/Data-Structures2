package p11_package;

/**
 * Class manages VertexNode data in stack data structure
 */
public class VertexStack
   {
    /**
     * constant space character
     */
    private final char SPACE = ' ';
    
    /**
     * constant dash character
     * 
     */
    private final char DASH = '-';
    
    /**
     * Default stack capacity
     */
    private final int STACK_CAPACITY = 26;
    
    /**
     * stack data managed by array
     */
    private VertexNode[] stackData;
    
    /**
     * stack size
     */
    private int stackSize;
    
    /**
     * Default constructor
     */
    public VertexStack()
       {
        stackData = new VertexNode[ STACK_CAPACITY ];

        stackSize = 0;
       }
   
    /**
     * Copy constructor
     * 
     * @param copied StackClass object to be copied
     */
    public VertexStack( VertexStack copied )
       {
        int index;
        
        stackSize = copied.stackSize;
        
        stackData = new VertexNode[ STACK_CAPACITY ];
        
        for( index = 0; index < stackSize; index++ )
           {
            stackData[ index ] = new VertexNode( copied.stackData[ index ] );
           }
       }

    /**
     * Clears stack data
     */
    public void clear()
       {
        stackSize = 0;
       }
 
    /**
     * Returns empty state
     * 
     * @return boolean result of method; true if empty, false otherwise
     */
    public boolean isEmpty()
       {
        return stackSize == 0;
       }
    
    /**
     * Views data at front of stack
     * 
     * @return VertexNode value found at front of stack
     */
    public VertexNode peekTop()
       {
        if( !isEmpty() )
           {
            return stackData[ stackSize - 1 ];
           }
       
        return null;
       }

     /**
      * Pops data from stack
      * 
      * @return VertexNode value removed from stack
      */
     public VertexNode pop()
        {
         if( !isEmpty() )
            {
             stackSize--;
             
             return stackData[ stackSize ];
            }
         
         return null;
        }

     /**
      * Pushes data onto stack
      * 
      * @param value VertexNode data to be pushed
      * 
      * @return boolean result of operation success,
      * false if array is full, true otherwise
      */
     public boolean push( VertexNode value )
        {
         if( stackSize < STACK_CAPACITY )
            {
             stackData[ stackSize ] = value;
             
             stackSize++;
             
             return true;
            }
         
         return false;
        }
     
     /**
      * Provides stack data as a string with top value to right
      */
     public String toString()
        {
         int index;
         String outString = "Vertex Stack: ";
         
         if( isEmpty() )
            {
             outString += DASH;
            }
         
         for( index = 0; index < stackSize; index++ )
            {
             outString += stackData[ index ].getVertex();
             
             if( index < stackSize - 1 )
                {
                 outString += SPACE;
                }
            }
         
         return outString;
        }

   }

