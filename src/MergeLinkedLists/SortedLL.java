package MergeLinkedLists;

import ch06.lists.*;
import support.LLNode;

import java.util.Comparator;
import java.util.Iterator;


public class SortedLL<T> implements ListInterface<T> {

    protected LLNode<T> front;     // reference to the front of this list
    protected LLNode<T> rear;      // reference to the rear of this list
    protected int numElements = 0;

    protected Comparator<T> comp;

    // set by find method
    protected boolean found;        // true if target found, else false
    protected int targetIndex;      // list index of target, if found
    protected LLNode<T> location;   // node containing target, if found
    protected LLNode<T> previous;   // node preceding location

    public SortedLL()
    // Precondition: T implements Comparable
    {
        numElements = 0;
        front = null;
        rear = null;
        comp = new Comparator<T>()
        {
            public int compare(T element1, T element2)
            {
                return ((Comparable)element1).compareTo(element2);
            }
        };
    }




    public void add(int index, T element) {
        
    }


    public T set(int index, T newElement) {
        return null;
    }


    public T get(int index) {
        return null;
    }


    public int indexOf(T target) {
        return 0;
    }


    public T remove(int index) {
        return null;
    }

    
    public boolean add(T element) {
        return false;
    }

    
    public T get(T target) {
        return null;
    }

    
    public boolean contains(T target) {
        return false;
    }

    
    public boolean remove(T target) {
        return false;
    }

    
    public boolean isFull() {
        return false;   //Lists are never full
    }

    
    public boolean isEmpty() {
        return (numElements == 0);
    }

    
    public int size() {
        return numElements;
    }


    public Iterator<T> iterator()
    // Returns an Iterator over this list.
    {
        return new Iterator<T>()
        {
            private LLNode<T> prevPos = null;  // node before node just returned
            private LLNode<T> currPos = null;  // node just returned
            private LLNode<T> nextPos = front; // next node to return

            public boolean hasNext()
            // Returns true if the iteration has more elements; otherwise returns false.
            {
                return (nextPos != null);
            }

            public T next()
            // Returns the next element in the iteration.
            // Throws NoSuchElementException - if the iteration has no more elements
            {
                if (!hasNext())
                    throw new IndexOutOfBoundsException("Illegal invocation of next " +
                            " in LBList iterator.\n");

                T hold = nextPos.getInfo();              // holds info for return
                if (currPos != null) prevPos = currPos;  // in case element was removed
                currPos = nextPos;
                nextPos = nextPos.getLink();
                return hold;
            }

            public void remove()
            // Removes from the underlying representation the last element returned
            // by this iterator. This method should be called only once per call to
            // next(). The behavior of an iterator is unspecified if the underlying
            // representation is modified while the iteration is in progress in any
            // way other than by calling this method.
            {
                if (currPos == null)  // there is no last element returned by the iterator
                    return;
                else
                {
                    if (prevPos == null)  // removing front element
                    {
                        front = nextPos;
                        currPos = null;
                        if (front == null) // removed only element
                            rear = null;
                    }
                    else
                    {
                        prevPos.setLink(nextPos);
                        currPos = null;
                    }
                    numElements--;
                }
            }
        };
    }


}
