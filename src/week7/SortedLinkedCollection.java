package week7;

import ch05.collections.CollectionInterface;
import support.LLNode;

public class SortedLinkedCollection<T extends Comparable<T>> implements CollectionInterface<T>
{
    protected LLNode<T> head;       // head of the linked list
    protected int numElements = 0;  // number of elements in this collection

    // set by find method
    protected boolean found;        // true if target found, else false
    protected LLNode<T> location;   // node containing target, if found
    protected LLNode<T> previous;   // node preceding location

    public SortedLinkedCollection()
    {
        numElements = 0;
        head = null;
    }

    public boolean add(T element)
    // Adds element to this collection.
    {
        LLNode<T> newNode = new LLNode<T>(element);
        if (head == null || element.compareTo(head.getInfo()) < 0){
            newNode.setLink(head);
            head = newNode;
        }
        else{
            LLNode<T> current = head;
            while (current.getLink() != null && element.compareTo(current.getLink().getInfo()) > 0){
                current = current.getLink();
            }
            newNode.setLink(current.getLink());
            current.setLink(newNode);
        }
        numElements++;
        return true;
    }

    protected void find(T target)
    // Searches the collection for an occurence of an element e such that
    // e.equals(target). If successful, sets instance variables
    // found to true, location to node containing e, and previous
    // to the node that links to location. If not successful, sets
    // found to false.
    {
        location = head;
        found = false;

        while (location != null)
        {
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

    public int size()
    // Returns the number of elements on this collection.
    {
        return numElements;
    }

    public boolean contains (T target)
    // Returns true if this collection contains an element e such that
    // e.equals(target); otherwise, returns false.
    {
        find(target);
        return found;
    }

    public boolean remove (T target)
    // Removes an element e from this collection such that e.equals(target)
    // and returns true; if no such element exists, returns false.
    {
        find(target);
        if (found)
        {
            if (head == location)
                head = head.getLink();    // remove first node
            else
                previous.setLink(location.getLink());  // remove node at location

            numElements--;
        }
        return found;
    }

    public T get(T target)
    // Returns an element e from this collection such that e.equals(target);
    // if no such element exists, returns null.
    {
        find(target);
        if (found)
            return location.getInfo();
        else
            return null;
    }

    public boolean isEmpty()
    // Returns true if this collection is empty; otherwise, returns false.
    {
        return (numElements == 0);
    }

    public boolean isFull()
    // Returns true if this collection is full; otherwise, returns false.
    {
        return false;  // Linked implementation is never full
    }

    @Override
    public String toString(){
        String result = "";
        LLNode<T> current = head;

        while (current != null){
            result += current.getInfo() + " ";
            current = current.getLink();
        }
        return result;
    }

    public T smallest(){
        if (numElements == 0){
            return null;
        }
        return head.getInfo();
    }

    public int greater(T element) throws Exception {
        int numGreater = 0;

        // Find the target element in the collection
        find(element);

        // If the element was found
        if (found) {
            // Start from the next node of the found element
            LLNode<T> current = location.getLink();

            // Traverse the list and count the nodes where element.compareTo(node's value) > 0
            while (current != null) {
                // Check if the current node's value is greater than the input element
                if (element.compareTo(current.getInfo()) < 0) { // means current node's value is greater
                    numGreater++;
                }
                current = current.getLink();
            }
        } else {
            // If element is not found in the collection, throw an exception
            throw new Exception("Item not in collection");
        }

        return numGreater;
    }

    public SortedLinkedCollection combine(SortedLinkedCollection other){
        SortedLinkedCollection<T> combined = new SortedLinkedCollection<>();

        LLNode<T> thisCurrent = head;
        LLNode<T> otherCurrent = other.head;

        //Traverse both collections and add elements in sorted order
        while (thisCurrent != null && otherCurrent != null) {
            if (thisCurrent.getInfo().compareTo(otherCurrent.getInfo()) <= 0) {
                combined.add(thisCurrent.getInfo());
                thisCurrent = thisCurrent.getLink();
            } else {
                combined.add(otherCurrent.getInfo());
                otherCurrent = otherCurrent.getLink();
            }
        }

        // If there are remaining elements in this collection
        while (thisCurrent != null) {
            combined.add(thisCurrent.getInfo());
            thisCurrent = thisCurrent.getLink();
        }

        // If there are remaining elements in the other collection
        while (otherCurrent != null) {
            combined.add(otherCurrent.getInfo());
            otherCurrent = otherCurrent.getLink();
        }

        // Return the combined collection
        return combined;
    }

}