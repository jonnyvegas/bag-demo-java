package bag;

/**
 * Ch 4 HW #3 Pg 235 #5
 * COMP 182
 * Prof. Putnam
 * 10/13/14
 * The interface bag specifies methods to insert, remove the last item,
 * remove a random item, get the number of items, see if the bag is empty,
 * see if it is full, and empty the bag.
 * @author Jonathan Villegas
 */
public interface Bag 
{
    //Inserts an object into the bag.
    void insert(Object item);
    //Removes the last item from the bag.
    Object removeLast();
    //Removes a random item from the bag.
    Object removeRandom();
    //Returns the number of items in the bag.
    int getNumItems();
    //Returns true if the bag is empty, false if not.
    boolean isEmpty();
    //Returns true if the bag is full, false if not.
    boolean isFull();
    //Empties the bag.
    void emptyBag();
}
