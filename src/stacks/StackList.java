package stacks;

import sun.invoke.empty.Empty;

import java.util.*;

/**
 * StackList class manages items in a singly linked list where we can
 * only push() and pop() items from one end of the stack.
 *
 * @author Foothill College, Veronika Cabalova Joseph
 */

public class StackList<T> implements Iterable<T>
{

    //*************************** Inner Class NODE START **************************
    /**
     * inner class Node describes single Node object of singly linked LinkedList
     */
    private class Node
    {
        Node next;
        T data;

        //constructor
        Node(T dataItem)
        {
            data = dataItem;
            next = null;
        }
    }
    //**************************** Inner Class NODE END ****************************

    /**
     * Principal private data for StackList.
     */
    private int mSize;
    private Node top;
    private String name;

    /**
     * Default constructor
     */
    public StackList()
    {
        clear();
    }

    /**
     * constructor that initializes class attributes
     * @param name string name
     */
    StackList(String name)
    {
        this.name = name;
        this.top = null;
    }

    /**
     * method that checks size of the list
     * @return size of the list
     */
    public int size()
    {
        return mSize;
    }

    /**
     * method that checks if list is empty
     * @return 0 if list is empty
     */
    public boolean isEmpty()
    {
        return mSize == 0;
    }

    /**
     * Reset the linked list by resetting references mSize and top
     */
    public void clear()
    {
        mSize = 0;
        top = null;
    }

    /**
     * this method takes generic argument and adds the item to the top of the stack
     * @param itemToAdd generic argument
     */
    public void push(T itemToAdd)
    {
        //won't add null object to stack
        if(itemToAdd == null)
        {
            return;
        }
        if(isEmpty())
        {
            top = new Node(itemToAdd);
            mSize++;
            return;
        }

        Node newNodeType = new Node(itemToAdd);
        newNodeType.next = top;
        top = newNodeType;
        mSize++;
    }

    /**
     * this method removes item from top of the stack
     * @return generic item popped
     */
    public T pop()
    {
        if (isEmpty())
        {
              throw new EmptyStackException();
        }

        T value = top.data;
        top = top.next;
        mSize--;
        return value;
    }

    /**
     * this method looks at the top of the stack and returns a generic type for the
     * data seen at the top of the stack. This method does not remove item from the
     * top of the stack. If the stack is empty, method returns null.
     * @return generic type for data at the top of the stack
     */
    public T peek()
    {
        if (isEmpty())
        {
            return null;
        }
        return top.next.data;
    }

    /**
     * method prints the name of the stack passed in by the Navigator class in addition
     * to the number of links in the stack.
     * @return formatted string
     */
    public String toString()
    {
        String linksString = "";

        Iterator<T> iterator = iterator();

        while (iterator.hasNext())
        {
            linksString += iterator.next() + ", ";
        }

        return  this.name + " has " + this.mSize
                + " links: \n"
                +"[" + linksString + "]";
    }

    /**
     * mathod that returns iterator
     * @return iterator
     */
    public Iterator<T> iterator()
    {
        return new StackIterator();
    }


    //********************* Inner Class StackIterator START ************************
    /**
     * inner class StackIterator is parameterized class which implements an the Iterator interface.
     * This class provides an iterator over the outer generic StackList.
     */
    private class StackIterator implements Iterator<T>
    {
        private Node currentNode;

        /**
         * constructor, default access for package only
         */
        StackIterator()
        {
            currentNode = top;
        }

        /**
         * method that checks if there is something immediately to the right of iterator
         * @return boolean true value if there is something to the right, false if there isn't
         */
        public boolean hasNext()
        {
            return currentNode != null;
        }

        /**
         * method returns item immediately to the right of the iterator, moves iterator up one
         * @return item of generic type
         */
        public T next()
        {
            if(!hasNext())
            {
                throw new NoSuchElementException();
            }
            T tempNode = currentNode.data;
            currentNode = currentNode.next;

            return tempNode;
        }
    }
    //********************* Inner Class StackIterator END ************************
}