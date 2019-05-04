package p11_package;

/**
 * Simple vertex class that holds a vertex, its adjacent vertices,
 * and the weight between them
 * 
 * @author MichaelL
 *
 */
public class VertexNode
   {
    /**
     * Vertex value
     */
    private char vertexLetter;
 
    /**
     * visited flag for use with DFS, BFS
     */
    private boolean visited;
    
    /**
     * Adjacency list
     */
    private AdjacencyList adjacencyList;
 
    /**
     * Initialization constructor, 
     * adds vertex with first adjacent vertex data
     * 
     * @param vertex character vertex letter
     * 
     * @param adjVertex character adjacent vertex letter
     * 
     * @param adjWeight integer weight between the vertices
     */
    public VertexNode( char vertex, char adjVertex, int adjWeight )
       {
        vertexLetter = vertex;
        
        visited = false;
    
        adjacencyList = new AdjacencyList();
        
        adjacencyList.add( adjVertex, adjWeight );
       }
    
    /**
     * Copy constructor
     * 
     * @param copied VertexNode object to be copied
     */
    public VertexNode( VertexNode copied )
       {
        vertexLetter = copied.vertexLetter;
        
        visited = copied.visited;
        
        adjacencyList = new AdjacencyList( copied.adjacencyList );
       }
    
    /**
     * Adds subsequent adjacent data to VertexNode adjacency list
     * 
     * @param adjVertex character vertex to be added to vertex list
     * 
     * @param adjWeight integer weight value to be added
     */
     public void addAdjacentVertex( char adjVertex, int adjWeight )
        {
         adjacencyList.add( adjVertex, adjWeight );
        }   
     
     /**
      * Gets the first adjacent vertex data in the list if available
      * 
      * @return AdjacentNode data
      */
     public AdjacentNode getFirstAdjacency()
        {
         return adjacencyList.getFirstItem();
        }
     
     /**
      * Gets any of the remaining adjacent vertex data if available
      * 
      * @return AdjacentNode data
      */
     public AdjacentNode getNextAdjacency()
        {
         return adjacencyList.getNextItem();
        }
     
     /**
      * Gets the vertex letter
      * 
      * @return the character letter
      */
     public char getVertex()
        {
         return vertexLetter;
        }
     
     /**
      * Checks for vertex has been visited in BFS, DFS
      * 
      * @return boolean state of visited flag
      */
     public boolean hasBeenVisited()
        {
         return visited;
        }
     
     /**
      * Sets visited flag
      * 
      */
     public void setVisited()
        {
         visited = true;
        }
     
     /**
      * Unsets visited flag
      */
     public void unSetVisited()
        {
         visited = false;
        }
          
   }

