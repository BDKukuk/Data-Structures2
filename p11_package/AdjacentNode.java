package p11_package;

public class AdjacentNode
   {
    /**
     * character vertex letter
     */
    private char vertexLetter;
    
    /**
     * integer vertex weight
     */
    private int vertexWeight;
    
    /**
     * Initialization constructor
     * 
     * @param vertex character vertex letter
     * 
     * @param weight integer vertex weight
     */
    public AdjacentNode( char vertex, int weight )
       {
        vertexLetter = vertex;
        
        vertexWeight = weight;
       }
    
    /**
     * Copy constructor
     * 
     * @param copied AdjacentNode item to be copied
     */
    public AdjacentNode( AdjacentNode copied )
       {
        vertexLetter = copied.vertexLetter;
        
        vertexWeight = copied.vertexWeight;
       }
    
    /**
     * Gets vertex letter
     * 
     * @return character vertex letter
     */
    public char getVertex()
       {
        return vertexLetter;
       }
    
    /**
     * Gets vertex weight
     * 
     * @return integer vertex weight
     */
    public int getWeight()
       {
        return vertexWeight;
       }
    
   }

