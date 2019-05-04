package p11_package;

/**
 * Class manages characters in queue data structure
 */
public class VertexQueue
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
     * Default queue capacity
     */
    private final int QUEUE_CAPACITY = 26;
    
    /**
     * queue data managed by array
     */
    private VertexNode[] queueData;
    
    /**
     * queue size 
     */
    private int queueSize;
    
    /**
     * Default constructor
     */
    public VertexQueue()
       {
        queueData = new VertexNode[ QUEUE_CAPACITY ];

        queueSize = 0;
       }
   
    /**
     * Copy constructor
     * 
     * @param copied QueueClass object to be copied
     */
    public VertexQueue( VertexQueue copied )
       {
        int index;
        
        queueSize = copied.queueSize;
        
        queueData = new VertexNode[ QUEUE_CAPACITY ];
        
        for( index = 0; index < queueSize; index++ )
           {
            queueData[ index ] = new VertexNode( copied.queueData[ index ] );
           }
       }
   
    /**
     * Clears queue data
     */
    public void clear()
       {
        queueSize = 0;
       }
   
    /**
     * Dequeues data from queue
     * 
     * @return VertexNode data removed from queue
     */
    public VertexNode dequeue()
       {
        VertexNode returnVal;
        int index;
        
        if( !isEmpty() )
           {
            returnVal = queueData[ 0 ];
        
            queueSize--;
        
            for( index = 0; index < queueSize; index++ )
               {
                queueData[ index ] = queueData[ index + 1 ];
               }
            
            return returnVal;
           }
        
        return null;
       }

     /**
      * Enqueues data to queue
      * 
      * @param value VertexNode data to be enqueued
      * 
      * @return boolean result of operation success,
      * false if array is full, true otherwise
      */
     public boolean enqueue( VertexNode value )
        {
         if( queueSize < QUEUE_CAPACITY )
            {
             queueData[ queueSize ] = value;
         
             queueSize++;
             
             return true;
            }
         
         return false;
        }
     
     /**
      * Reports empty statw
      * 
      * @return boolean result of method, true if empty, false otherwise
      */
     public boolean isEmpty()
        {
         return queueSize == 0;
        }
     
     /**
      * Views data at front of queue
      * 
      * @return VertexNode value found at front of queue
      */
     public VertexNode peekFront()
        {
         if( !isEmpty() )
            {
             return queueData[ 0 ];
            }
        
         return null;
        }
 
     /**
      * Provides queue data as a string with front value to right
      */
     public String toString()
        {
         int index;
         String outString = "Vertex Queue: ";
         
         if( queueSize == 0 )
            {
             outString += DASH;
            }
         
         for( index = queueSize - 1; index >= 0; index-- )
            {
             outString += queueData[ index ].getVertex();
             
             if( index > 0 )
                {
                 outString += SPACE;
                }
            }
         
         return outString;
        }

   }

