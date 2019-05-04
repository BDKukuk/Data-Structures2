package p7_package;

import p2_package.N2_SortDriverClass;

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
        displayInOrderHelper(localRoot.leftChildRef);
        System.out.print(localRoot);
        displayInOrderHelper(localRoot.rightChildRef);
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
        displayInOrderHelper(localRoot.rightChildRef);
        System.out.print(localRoot);
        displayInOrderHelper(localRoot.leftChildRef);
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
        System.out.print(localRoot);
        displayInOrderHelper(localRoot.leftChildRef);
        displayInOrderHelper(localRoot.rightChildRef);
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
            insertHelper(BST_Root,inData);
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

    /**
     * this checks if the tree is empty
     * @return
     */
    public boolean isEmpty()
    {
        if(BST_Root == null)
        {
            return true;
        }

        return false;
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
        if(search(inData) != null)
        {
            removeItemHelper(BST_Root,inData);
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
            removeFromMax(localRoot, localRoot.leftChildRef);
        }

        return removeFromMax(localRoot, localRoot.rightChildRef);
    }

    /**
     * Searches for data in BST given GenericData with necessary key
     * @param searchData
     * @return
     */
    public GenericData search(GenericData searchData)
    {
        if(BST_Root == null)
        {
            return null;
        }

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



    private class BST_Node
    {

        private GenericData nodeData;
        BST_Node leftChildRef;
        BST_Node rightChildRef;

        BST_Node(BST_Node copied)
        {
            leftChildRef = null;
            rightChildRef = null;
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
