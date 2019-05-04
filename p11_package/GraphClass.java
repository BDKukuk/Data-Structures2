package p11_package;

import p6_package.QueueClass;

/**
 * Simple class for managing vertices and edges in a graph
 * 
 * @author MichaelL
 *
 */
public class GraphClass
   {
    /**
     * default vertex capacity
     * <p>
     * Note: Limited to number of upper case letters in alphabet
     */
    private final int VERTEX_CAPACITY = 26;
    
    /**
     * constant indication of vertex not in list
     */
    private final int NOT_IN_LIST = -1;
    
    /**
     * constant space character
     * 
     */
    private final char SPACE = ' ';
    
    /**
     * constant dash character
     * 
     */
    private final char DASH = '-';
    
    /**
     * size of vertex array
     */
    private int vertexListSize;
    
    /**
     * array of vertices
     */
    private VertexNode[] vertexList;
    
    /**
     * Default constructor
     */
    public GraphClass()
       {
        vertexListSize = VERTEX_CAPACITY;
       }
    
    /**
     * Gets complete vertex node and data using the adjacent node data
     * 
     * @param adjNode AdjacentNode data provided
     * 
     * @return VertexNode data found in array
     */
    private VertexNode adjToVertex( AdjacentNode adjNode )
       {
            char searchVertex = adjNode.getVertex();
            int graphIndex;


            for(graphIndex = 0; graphIndex < vertexListSize; graphIndex++)
            {
                if(vertexList[graphIndex].getVertex() == searchVertex)
                {
                    return vertexList[graphIndex];
                }
            }
            return null;
       }
    
    /**
     * Breadth-First Search (BFS), is actually just a traversal
     * 
     * @param startVertex character vertex to start with
     * 
     * @param showQueue boolean flag to control display
     * of queue during operations
     * 
     * @return String result of traversal process
     * showing each visited vertex in the order it was visited
     */
    public String BFS( char startVertex, boolean showQueue )
       {
           VertexQueue myQueue = new VertexQueue();
           int Weight = vertexList[vertexInList(startVertex)]
                   .getFirstAdjacency().getWeight();
           int queueIndex;

           VertexNode startingNode =
                   new VertexNode(vertexList[vertexInList(startVertex)]
                           .getVertex(),
                   vertexList[vertexInList(startVertex)].getFirstAdjacency()
                           .getVertex(),Weight);

           AdjacentNode adjacentNode = new AdjacentNode(startingNode.getVertex()
                   ,startingNode.getFirstAdjacency().getWeight());

           myQueue.enqueue(startingNode);

           while(myQueue.isEmpty() == false)
           {
               for(queueIndex = 0; queueIndex < vertexListSize; queueIndex++)
               {

               }


           }

            return myQueue.toString();

       }
    
    /**
     * Clears all vertex visited flags; for use after completion of BFS, DFS
     */
    public void clearVisitedFlags()
       {
            int graphIndex = 0;
            while(graphIndex < vertexListSize)
            {
                vertexList[graphIndex].unSetVisited();
                graphIndex++;
            }
       }
    
    /**
     * Depth-First Search (DFS), is actually just a traversal
     * 
     * @param startVertex character vertex to start with
     * 
     * @param showStack boolean flag to control display
     * of stack during operations
     * 
     * @return String result of traversal process
     * showing each visited vertex in the order it was visited
     */
    public String DFS( char startVertex, boolean showStack )
       {

           VertexStack myStack = new VertexStack();
           int Weight = vertexList[vertexInList(startVertex)]
                   .getFirstAdjacency().getWeight();
           int queueIndex;

           VertexNode startingNode =
                   new VertexNode(vertexList[vertexInList(startVertex)]
                           .getVertex(),
                           vertexList[vertexInList(startVertex)].getFirstAdjacency()
                                   .getVertex(),Weight);

           AdjacentNode adjacentNode = new AdjacentNode(startingNode.getVertex()
                   ,startingNode.getFirstAdjacency().getWeight());

           myStack.push(startingNode);

           while(myStack.isEmpty() == false)
           {
               for(queueIndex = 0; queueIndex < vertexListSize; queueIndex++)
               {

               }


           }

           return myStack.toString();
       }
    
    /**
     * Generates a list of the vertices with their adjacent vertices
     */
    public void generateAdjacencyLists()
       {
            int graphIndex = 0;
            while(graphIndex < vertexListSize)
            {
                System.out.println("Adjacent to Vertex " +
                        vertexList[graphIndex]+ ": " +
                        vertexList[graphIndex].getFirstAdjacency()
                        + " , " +  vertexList[graphIndex].getNextAdjacency());
            }
       }
    
    /**
     * Generates an adjacency matrix table 
     * that displays weights between vertices
     */
    public void generateAdjacencyMatrix()
       {
           char[][] myMatrix = new char[0][];
           int matrixIndex1;
           int matrixIndex2;

           for(matrixIndex1 = 0; matrixIndex1 < vertexListSize; matrixIndex1++)
           {
               for(matrixIndex2 = 0; matrixIndex2 < vertexListSize;
                   matrixIndex2++)
               {

               }



           }
       }
    
    /**
     * Inserts vertex, adjacent vertex, and weight into array alphabetically
     * <p>
     * Note: Uses insertion sort strategy
     * 
     * @param vertex character vertex letter
     * 
     * @param adjVertex character adjacent vertex letter
     * 
     * @param weight integer weight between vertices
     * 
     * @return boolean result of insertion;
     * false if vertex array is full, true otherwise
     */
    private boolean insertVertex( char vertex, char adjVertex, int weight )
       {
           int graphIndex;
           for(graphIndex = 0; graphIndex < vertexListSize; graphIndex++)
           {
               VertexNode[] tempArray = new VertexNode[vertexListSize];
               tempArray[graphIndex] = vertexList[graphIndex];

               if(vertex > vertexList[graphIndex].getVertex())
               {
                   tempArray[graphIndex] = vertexList[vertex];
                   tempArray[graphIndex].addAdjacentVertex(adjVertex, weight);


                   while (graphIndex < vertexListSize)
                   {
                       tempArray[graphIndex + 1] = tempArray[graphIndex];
                   }
                   vertexList = tempArray;
                   return true;
               }
           }
           return false;
       }
    
    /**
     * Recursive method that prints
     * a specified number of specified characters
     * 
     * @param numChars integer number of characters to print
     * 
     * @param outChar character value to be printed
     */
    void printChars( int numChars, char outChar )
       {
           System.out.println(outChar);
           printChars(numChars - 1, outChar);
       }
    
    /**
     * Sets vertex with adjacency
     * <p>
     * Note: Adds new vertex as needed;
     * otherwise adds adjacent vertex and weight to existing vertex
     * <p>
     * Note: Adds vertices in both directions (e.g., A with B as adjacency,
     * and B with A as adjacency)
     * <p>
     * Uses insertVertex to minimize excessive coding
     * 
     * @param vertex character vertex letter
     * 
     * @param adjVertex character adjacent vertex letter
     * 
     * @param weight integer weight between vertices
     * 
     * @return boolean result of action,
     * false if vertex array is full, true otherwise
     */
    public boolean setVertex( char vertex, char adjVertex, int weight )
       {
        int graphIndex = 0;

        while(graphIndex < vertexListSize)
        {
            if(vertex == vertexList[graphIndex].getVertex())
            {
                vertexList[graphIndex].addAdjacentVertex(adjVertex, weight);
                return true;
            }
            else
            {
                insertVertex(vertex,adjVertex,weight);
                return true;
            }
        }
        
        return false;
       }          

    /**
     * Tests for vertex in list
     * 
     * @param testVertex character vertex to search for
     * 
     * @return integer index if vertex found,
     * constant NOT_IN_LIST otherwise
     */
    private int vertexInList( char testVertex )
       {
            int graphIndex;

            for(graphIndex = 0; graphIndex < vertexListSize; graphIndex++)
            {
                if(testVertex == vertexList[graphIndex].getVertex())
                {
                    return graphIndex;
                }
            }
            return NOT_IN_LIST;
       }
      
   }


