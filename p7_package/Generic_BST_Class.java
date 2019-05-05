package p7_package;


public class Generic_BST_Class<GenericData extends Comparable<GenericData>>
{

    private BST_Node BST_Root;

    /**
     * Default class constructor, initializes BST
     */
    Generic_BST_Class()
    {
        BST_Root = null;
    }

    /**
     * Clears tree
     */
    public void clearTree()
    {
        BST_Root = null;
    }

    /**
     * Provides inOrder traversal action
     * Note: Calls displayInOrderHelper
     */
    public void displayInOrder()
    {
        displayInOrderHelper(BST_Root);
    }

    /**
     * Provides inOrder traversal action using recursion
     */
    private void displayInOrderHelper(BST_Node localRoot)
    {
        if(localRoot != null)
        {
            displayInOrderHelper(localRoot.leftChildRef);
            System.out.print(localRoot.nodeData);
            displayInOrderHelper(localRoot.rightChildRef);
        }
    }

    /**
     * Provides postOrder traversal action
     */
    public void displayPostOrder()
    {
        displayPostOrderHelper(BST_Root);
    }

    /**
     * Provides postOrder traversal action using recursion
     * @param localRoot BST_Node tree root reference at the current recursion level
     */
    private void displayPostOrderHelper(BST_Node localRoot)
    {
        if(localRoot != null)
        {
            displayInOrderHelper(localRoot.leftChildRef);
            displayInOrderHelper(localRoot.rightChildRef);
            System.out.print(localRoot.nodeData);

        }

    }

    /**
     * Provides preOrder traversal action
     */
    public void displayPreOrder()
    {
        displayPreOrderHelper(BST_Root);
    }

    /**
     * Provides preOrder traversal action using recursion
     * @param localRoot BST_Node tree root reference at the current recursion level
     */
    private void displayPreOrderHelper(BST_Node localRoot)
    {
        if(localRoot != null)
        {
            System.out.print(localRoot);
            displayInOrderHelper(localRoot.leftChildRef);
            displayInOrderHelper(localRoot.rightChildRef);
        }
    }

    /**
     * Insert method for BST
     * Note: uses insert helper method which returns root reference
     *
     * Note: uses search to verify that key is not already in tree; if key is
     * already in tree, insert is not conducted
     *
     * @param inData
     */
    public void insert(GenericData inData)
    {
        if(BST_Root == null)
        {
            BST_Root = new BST_Node(inData);
        }
        else
        {
            if(search(inData) != inData)
            {
                insertHelper(BST_Root,inData);
            }
        }
    }

    /**
     * Insert helper method for BST insert action
     * Note: Recursive method returns updated local root to maintain tree
     * linkage
     */
    private BST_Node insertHelper(BST_Node localRoot, GenericData inData)
    {
        BST_Node newNode = new BST_Node(inData);
        if(localRoot != null)
        {
            if(inData.compareTo(newNode.nodeData) < 0)
            {
                if(BST_Root.leftChildRef.nodeData == null)
                {
                    localRoot.leftChildRef = new BST_Node(inData);
                }
                return insertHelper(localRoot.leftChildRef,inData);
            }
            if(BST_Root.rightChildRef.nodeData == null)
            {
                localRoot.rightChildRef = new BST_Node(inData);
            }
            return insertHelper(localRoot.rightChildRef,inData);
        }
       return null;
    }

    /**
     * this checks if the tree is empty
     * @return
     */
    public boolean isEmpty()
    {
        return BST_Root == null;
    }

    /**
     * Searches tree from given node to maximum value node below it,
     * stores data value found, and then unlinks the node
     * @param maxParent
     * @param maxLoc
     * @return
     */
    private BST_Node removeFromMax(BST_Node maxParent, BST_Node maxLoc)
    {
       if(maxLoc.rightChildRef.nodeData == null )
       {
           if(maxLoc.leftChildRef.nodeData != null)
           {
               maxParent.rightChildRef = maxLoc.leftChildRef;
           }
           return maxLoc;
       }

       return removeFromMax(maxLoc.rightChildRef,maxLoc);

    }

    /**
     * Removes data node from tree using given key
     * Note: uses remove helper method
     *
     * Note: uses search initially to get value, if it is in tree;
     * if value found, remove helper method is called, otherwise returns null
     * @param inData
     * @return
     */
    public GenericData removeItem(GenericData inData)
    {
        GenericData searchData = search(inData);
        if(searchData != null && BST_Root != null)
        {
            return removeItemHelper(BST_Root,inData).nodeData;
        }

        return null;
    }

    /**
     * Remove helper for BST remove action
     * Note: Recursive method returns updated local root to maintain tree
     * linkage
     *
     * Note: uses removeFromMax method
     * @param localRoot
     * @param outData
     * @return
     */
    private BST_Node removeItemHelper(BST_Node localRoot, GenericData outData)
    {

        if(localRoot.nodeData.compareTo(outData) < 0)
        {
            removeItemHelper(localRoot.leftChildRef,outData);
        }
        if(localRoot.nodeData.compareTo(outData) > 0)
        {
            removeItemHelper(localRoot.rightChildRef, outData);
        }


            if(localRoot.nodeData.compareTo(outData) == 0)
            {
                BST_Node replacementNode = removeFromMax(localRoot, localRoot.leftChildRef);
                BST_Node returnNode = localRoot;
                localRoot.nodeData = replacementNode.nodeData;
                return returnNode;
            }

        return null;
    }

    /**
     * Searches for data in BST given GenericData with necessary key
     * @param searchData
     * @return
     */
    public GenericData search(GenericData searchData)
    {
        return searchHelper(BST_Root,searchData);
    }

    /**
     * Helper method for BST search action
     * @param localRoot
     * @param searchData
     * @return
     */
    private GenericData searchHelper(BST_Node localRoot,GenericData searchData)
    {
        if( localRoot != null)
        {
            if(localRoot.nodeData == searchData)
            {
                return localRoot.nodeData;
            }

            if(localRoot.nodeData.compareTo(searchData) < 0)
            {
                return searchHelper(localRoot.leftChildRef,searchData);
            }
            else
            {
                return searchHelper(localRoot.rightChildRef, searchData);
            }
        }
        return null;
    }



    private class BST_Node
    {

        private GenericData nodeData;
        BST_Node leftChildRef;
        BST_Node rightChildRef;

        BST_Node(BST_Node copied)
        {
            leftChildRef = copied.leftChildRef;
            rightChildRef = copied.rightChildRef;
            nodeData = copied.nodeData;
        }

        BST_Node(GenericData inData)
        {
            nodeData = inData;
            leftChildRef = null;
            rightChildRef = null;
        }


    }


}
