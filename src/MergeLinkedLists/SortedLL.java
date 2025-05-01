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

    protected void find(T target)
    // Searches list for an occurrence of an element e such that
    // e.equals(target). If successful, sets instance variables
    // found to true, location to node containing e, previous
    // to the node that links to location, and index to the index of
    // the location. If not successful, sets found to false.
    {
        location = front;
        found = false;
        targetIndex = -1;

        while (location != null)
        {
            targetIndex++;
            if (location.getInfo().equals(target))  // if they match
            {
                found = true;
                return;
            }
            else
            {
                previous = location;
                location = location.getLink();
            }
        }
    }


    public void add(int index, T element) {
        throw new UnsupportedOperationException("Attempted unsupported operation on sorted list");
    }


    public T set(int index, T newElement) {
        throw new UnsupportedOperationException("Attempted unsupported operation on sorted list");
    }


    public T get(int index) {
        if ((index < 0) || (index >= size()))
            throw new IndexOutOfBoundsException("Illegal index of " + index +
                                                 " passed to LBList set method.\n");

        LLNode<T> node = front;
        for (int i = 0; i < index; i++)
            node = node.getLink();
        return node.getInfo();
}


    public int indexOf(T target) {
        find(target);
        if (found)
            return targetIndex;
        else
            return -1;
    }


    public T remove(int index)
    // Throws IndexOutOfBoundsException if passed an index argument
    // such that index < 0 or index >= size().
    // Otherwise, removes element on this list at position index and
    // returns the removed element; all current elements at positions
    // higher than that index have 1 subtracted from their position.
    {
        if ((index < 0) || (index >= size()))
            throw new IndexOutOfBoundsException("Illegal index of " + index +
                                                " passed to LBList remove method.\n");

        T hold;  // holds info for return
        if (index == 0) // remove the front node
        {
            hold = front.getInfo();
            front = front.getLink();
            if (numElements == 1)   // removing only node
                rear = null;
        }
        else
        {
            // locate previous node
            LLNode<T> node = front;
            for (int i = 0; i < (index - 1); i++)
                node = node.getLink();
            hold = node.getLink().getInfo();
            if (node.getLink() == rear)  // removing rear node
                rear = node;
            node.setLink(node.getLink().getLink());
        }

        numElements--;
        return hold;
    }

    public boolean add(T element) {
        LLNode<T> newNode = new LLNode<T>(element);

        // Case 1: List is empty
        if (front == null) {
            front = rear = newNode;
        } else if (comp.compare(element, front.getInfo()) < 0) {
            // Case 2: Insert at the front
            newNode.setLink(front);
            front = newNode;
        } else {
            // Case 3: Insert somewhere in the middle or end
            LLNode<T> current = front;
            LLNode<T> previous = null;

            // Traverse to find correct position
            while (current != null && comp.compare(element, current.getInfo()) >= 0) {
                previous = current;
                current = current.getLink();
            }

            newNode.setLink(current);
            previous.setLink(newNode);

            // Update rear if inserted at the end
            if (current == null) {
                rear = newNode;
            }
        }

        numElements++;
        return true;
    }



    public T get(T target)
    // Returns an element e from this list such that e.equals(target);
    // if no such element exists, returns null.
    {
        find(target);
        if (found)
            return location.getInfo();
        else
            return null;
    }

    
    public boolean contains(T target)
    // Returns true if this list contains an element e such that
    // e.equals(target); otherwise, returns false.
    {
        find(target);
        return found;
    }

    
    public boolean remove(T target)
    // Removes an element e from this list such that e.equals(target)
    // and returns true; if no such element exists, returns false.
    {
        find(target);
        if (found)
        {
            if (front == location)
                front = front.getLink();    // remove first node
            else
                previous.setLink(location.getLink());  // remove node at location

            if (front == null) rear = null;   // removed only element

            numElements--;
        }
        return found;
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

    public SortedLL<T> merge(SortedLL<T> list1, SortedLL<T> list2) {
        SortedLL<T> result = new SortedLL<>();
        Iterator<T> it1 = list1.iterator();
        Iterator<T> it2 = list2.iterator();

        T val1 = it1.hasNext() ? it1.next() : null;
        T val2 = it2.hasNext() ? it2.next() : null;

        while (val1 != null && val2 != null) {
            if (comp.compare(val1, val2) <= 0) {
                result.add(val1);
                val1 = it1.hasNext() ? it1.next() : null;
            } else {
                result.add(val2);
                val2 = it2.hasNext() ? it2.next() : null;
            }
        }

        // Append remaining elements
        while (val1 != null) {
            result.add(val1);
            val1 = it1.hasNext() ? it1.next() : null;
        }

        while (val2 != null) {
            result.add(val2);
            val2 = it2.hasNext() ? it2.next() : null;
        }

        return result;
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
