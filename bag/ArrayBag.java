package bag;

import java.util.Random;

/**
 * Project 3 Chapter 4
 * COMP 182
 * Prof. Putnam
 * 10/15/14
 * This uses the interface Bag and implements the methods
 * and some new methods to hold up to 100 items in the Bag.
 * @author Jonathan Villegas
 */
public class ArrayBag implements Bag
{
    private Item[] theItems;
    private int numOfItems;
    private int maxNumItems;
    //Constructor
    public ArrayBag()
    {
        //Default 100 items.
        maxNumItems = 100;
        theItems = new Item[maxNumItems];
        numOfItems = 0;
        for(int i = 0; i < maxNumItems; i++)
        {
            theItems[i] = null;
        }
    }
    //Constructor
    public ArrayBag(int items)
    {
        maxNumItems = items;
        theItems = new Item[maxNumItems];
        numOfItems = 0;
        for(int i = 0; i < maxNumItems; i++)
        {
            theItems[i] = null;
        }
    }
    //Creates the list.
    public void createBag(int items)
    {
        maxNumItems = items;
        theItems = new Item[maxNumItems];
        numOfItems = 0;
        for(int i = 0; i < maxNumItems; i++)
        {
            theItems[i] = null;
        }
    }
    /**
     * Inserts an item into the bag at the end of the list.
     * Precondition: item is an object.
     * Postcondition: item is added to theItems.
     * @param item the item to be added to the list.
     */
    @Override
    public void insert(Object item) 
    {
        Item itemToInsert = (Item) item;
        if(numOfItems < maxNumItems)
        {
            theItems[numOfItems] = itemToInsert;
            numOfItems++;
            System.out.println(itemToInsert.getName() + 
                    " added to the bag.");
        }
        else
        {
            System.out.println("Bag is full! " + itemToInsert.getName() 
                    + " was not inserted into the bag.");
        }
    }
    /**
     * Inserts an item into the bag at a specified position, unless the position
     * is too far in the list, in which case the item is added to the end.
     * Precondition: item is an object.
     * Postcondition: item is added to theItems at position, unless
     * position is greater than number of items, in which case item is added
     * to the end of the list.
     * @param theItem item the item to be inserted into theItems.
     * @param position the position for theItem to put into.
     */
    public void insertPosition(Item theItem, int position)
    {
        if(numOfItems == 100)
        {
            System.out.println("Error! Full bag!!!");
        }
        //The position is already filled. Move the items.
        else if(position < numOfItems)
        {
            //Moving the items.
            System.arraycopy(theItems, position, theItems, position + 1, 
                    numOfItems - position);
            theItems[position] = theItem;
            numOfItems++;
            System.out.println(theItem + " added to the bag.");
        }
        //The position is too far down the array.
        else if(position > numOfItems)
        {
            System.out.println(theItem.getName() + " added to position " + 
                    numOfItems + " instead.");
            //Add theItem to the end.
            theItems[numOfItems] = theItem;
            numOfItems++;
        }
        //position == numOfItems
        else
        {
            theItems[position] = theItem;
            numOfItems++;
        }
    }
    /**
     * Removes an item from a position.
     * Precondition: position is the position of the element to be removed.
     * Postcondition: the element with index position is removed.
     * @param position index of the item to be removed.
     * @return the item in theItems[position]
     */
    public Item removePosition(int position)
    {
        //There isn't an item in this position.
        if(theItems[position] == null)
        {
            System.out.println("Error! No item in this position!");
            return null;
        }
        else if(position < numOfItems)
        {
            Item theItem = theItems[position];
            //Move all of the elements after theItems[position].
            for(int i = position; i < numOfItems; i++)
            {
                theItems[i] = theItems[i + 1];
            }
            numOfItems--;
            return theItem;
        }
        else if(position > numOfItems)
        {
            System.out.println("Error! No item in that position.");
            return null;
        }
        else
        {
            Item theItem = theItems[position];
            numOfItems--;
            return theItem;
        }
    }
    /**
     * Removes the last object from the list.
     * Precondition: There is at least one item in theItems.
     * Postcondition: the last item in the array is returned.
     * @return the last item in theItems array.
     */
    @Override
    public Object removeLast() 
    {
        Item itemToRemove = theItems[numOfItems-1];
        numOfItems--;
        return itemToRemove;
    }
    /**
     * Removes a random item from the bag.
     * Precondition: There is at least one item in theItems.
     * Postcondition: A random item is removed and the array is shifted.
     * @return A random item from theItems.
     */
    @Override
    public Object removeRandom() 
    {
        if(numOfItems == 0)
        {
            System.out.println("Error! Empty list!");
            return null;
        }
        else
        {
            Random randomNum = new Random();
            int theNum = randomNum.nextInt(numOfItems);
            Item randItem = theItems[theNum];
            //Shift the items in the array.
            for(int i = theNum; i < numOfItems; i++)
            {
                theItems[i] = theItems[i + 1];
            }
            numOfItems--;
            return randItem;
        }
    }
    /**
     * Get the number of items in theItems.
     * @return the number of items in theItems.
     */
    @Override
    public int getNumItems() 
    {
        return numOfItems;
    }
    /**
     * Checks to see if the bag is empty.
     * @return true if empty, false if not.
     */
    @Override
    public boolean isEmpty() 
    {
        return numOfItems == 0;
    }
    /**
     * Checks to see if the bag is full.
     * @return true if full, false if not.
     */
    @Override
    public boolean isFull() 
    {
        return numOfItems == 100;
    }
    /**
     * Empties the bag.
     */
    @Override
    public void emptyBag() 
    {
        theItems = new Item[maxNumItems];
        numOfItems = 0;
        for(int i = 0; i < maxNumItems; i++)
        {
            theItems[i] = null;
        }
        System.out.println("The bag is now empty.");
    }
    /**
     * Overrides toString().
     * @return the bag in string form with items in order.
     */
    @Override
    public String toString()
    {
        String theString = "";
        //Bag is empty.
        if(numOfItems == 0)
        {
            theString = theString + "No items!";
            return theString;
        }
        //Bag has items in it.
        else
        {
            for(int i = 0; i < numOfItems; i++)
            {
                theString = theString + theItems[i].getName() + " ";
            }
            return theString;
        }
    }
    public static void main(String[] args)
    {
        ArrayBag theBag = new ArrayBag();
        theBag.createBag(100);
        Item banana = new Item("banana");
        Item apple = new Item("apple");
        Item pear = new Item("pear");
        Item mango = new Item("mango");
        Item eggs = new Item("eggs");
        Item steak = new Item("steak");
        Item milk = new Item("milk");
        Item broccoli = new Item("broccoli");
        Item cheese = new Item("cheese");
        Item beer = new Item("beer");
        Item bbqChips = new Item("BBQ chips");
        for(int i = 1; i <= 100; i++)
        {
            theBag.insert(beer);
        }
        System.out.println("The bag contains: " + theBag);
        System.out.println("There are " + theBag.getNumItems() + " items "
                            + "in the bag.");
        if(theBag.isFull())
        {
            System.out.println("The bag is full!");
        }
        else
        {
            System.out.println("The bag is not full.");
        }
        theBag.insert(eggs);
        theBag.emptyBag();
        if(theBag.isEmpty())
        {
            System.out.println("The bag is empty.");
        }
        else
        {
            System.out.println("There is something in the bag.");
        }
        
        System.out.println("The bag contains: " + theBag);
        System.out.println("There are " + (theBag.getNumItems() + 1) + " items "
                            + "in the bag.");
        
        theBag.insertPosition(banana, 0);
        theBag.insertPosition(apple, 1);
        theBag.insertPosition(pear, 2);
        theBag.insertPosition(mango, 3);
        theBag.insertPosition(banana, 4);
        theBag.insertPosition(pear, 5);
        theBag.insertPosition(eggs, 40);
        if(theBag.isEmpty())
        {
            System.out.println("The bag is empty.");
        }
        else
        {
            System.out.println("There is something in the bag.");
        }
        theBag.insert(banana);
        theBag.insert(apple);
        theBag.insert(pear);
        theBag.insert(mango);
        theBag.insert(banana);
        theBag.insert(apple);
        theBag.insert(pear);
        theBag.insert(steak);
        theBag.insert(eggs);
        theBag.insert(milk);
        theBag.insert(broccoli);
        theBag.insert(beer);
        theBag.insert(beer);
        theBag.insert(beer);
        theBag.insertPosition(beer, 0);
        theBag.insertPosition(beer, 0);
        theBag.insertPosition(beer, 0);
        theBag.insertPosition(bbqChips, 4);
        theBag.insert(cheese);
        if(theBag.isFull())
        {
            System.out.println("The bag is full!");
        }
        else
        {
            System.out.println("The bag is not full.");
        }
        System.out.println("The bag contains: " + theBag);
        System.out.println("There are " + theBag.getNumItems() + " items "
                            + "in the bag.");
        theBag.removePosition(0);
        System.out.println("The bag now contains: " + theBag);
        System.out.println("There are " + theBag.getNumItems() + " items "
                            + "in the bag.");
        theBag.removePosition(4);
        System.out.println("The bag now contains: " + theBag);
        System.out.println("There are " + theBag.getNumItems() + " items "
                            + "in the bag.");
        
        Object theItem = theBag.removeRandom();
        theItem = theBag.removeRandom();
        theItem = theBag.removeRandom();
        theItem = theBag.removeRandom();
        theItem = theBag.removeRandom();
        theItem = theBag.removeRandom();
        System.out.println("The bag now contains: " + theBag);
        System.out.println("There are " + theBag.getNumItems() + " items "
                            + "in the bag.");
        theBag.removePosition(50);
        theBag.removePosition(7);
        theBag.removePosition(3);
        System.out.println("The bag now contains: " + theBag);
        System.out.println("There are " + theBag.getNumItems() + " items "
                            + "in the bag.");
        theBag.emptyBag();
        System.out.println("The bag now contains: " + theBag);
        System.out.println("There are " + theBag.getNumItems() + " items "
                            + "in the bag.");
    }
}