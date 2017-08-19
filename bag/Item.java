package bag;

/**
 * Project 3 Chapter 4
 * COMP 182
 * Prof. Putnam
 * 10/15/14
 * This class works with ArrayBag to create items and allow them to be
 * used in the bag.
 * @author Jonathan Villegas
 */
public class Item 
{
    //The name of the item.
    String name;
    //Constructor.
    public Item(String theName)
    {
        name = theName;
    }
    //Sets the name.
    public void setName(String theName)
    {
        name = theName;
    }
    //Returns the name.
    public String getName()
    {
        return name;
    }
    //Override of toString. Returns name.
    @Override
    public String toString()
    {
        return name;
    }
}
