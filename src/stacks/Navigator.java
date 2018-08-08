package stacks;

import java.util.EmptyStackException;

/**
 *  Navigator​ class provides the navigation features of class BrowserNavigation.
 *  This class can navigate between forward and back links in stacks of links.
 *  It sets the current link and also sends old links to appropriate stack.
 *
 *  @author Foothill College, Veronika Cabalova Joseph
 */

public class Navigator
{
    String currentLink;
    StackList<String> backLinks;
    StackList<String> forwardLinks;

    // TODO: Define the class Navigator that provides three navigation options where the user can:
    //       1. Set the current link via setCurrentLink(linkName) method.
    //       2. Replace the current link by going back one link via goBack() method.
    //       3. Replace the current link by going forward one link via goForward() method.


    // TODO: Define the constructor of Navigator class so that it sets the currentLink to the empty String and
    //       initializes two objects of type StackList(name) called backLinks and forwardLinks.

    /**
     * Constructor sets current link to empty string and initializes two objects of type StackList
     */
    Navigator()
    {
        currentLink = null;
        backLinks = new StackList<String>("Back");
        forwardLinks = new StackList<String>("Forward");
    }

    /**
     * this method sets current link
     * @input string link name
     */
    public void setCurrentLink(String linkName)
    {
        //sets current link to link name if there is no current link
        if((currentLink == null))
        {
            currentLink = linkName;
        }
        else
        {
            //adds currentLink to backList and sets current link to a new link
            backLinks.push(currentLink);
            forwardLinks.clear();
            currentLink = linkName;
        }
    }


    // TODO: If there is a link on the backLinks stack, goes to the top link on the
    //       backLinks stack. Pushes the old currentLink onto the forwardLinks stack.
    //      Remember to check for boundary conditions.
    /**
     * this method updates the currentLink to the link at the top of the backLinks stack
     */
    public void goBack()
    {
        try
        {
            //checking if forward link stack is empty, if so throw exception and catch it later
            if (backLinks.isEmpty())
            {
                throw new EmptyStackException();
            }
            //push current link to stack of forward links
            forwardLinks.push(currentLink);
            //set current link to back link on top of stack
            currentLink = backLinks.pop();
        }
        //catching exception if backLinks stack is empty to notify user
        catch(EmptyStackException e)
        {
            System.out.println("\n--------------------------------------------------"
                    + "\n****** ALERT: There are no more back links! ******"
                    + "\n--------------------------------------------------");
        }
    }

    /* TODO: If there is a link on the forwardLinks stack, goes to the top link on the
     *       forwardLinks stack. Pushes the old currentLink onto the backLinks stack.
     *       Remember to check for boundary conditions.
     */

    /**
     * method updates the currentLink to the link at the top of the forwardlinks stack
     */
    public void goForward()
    {
        try
        {
            //checking if forward link stack is empty, if so throw exception and catch it later
            if (forwardLinks.isEmpty())
            {
                throw new EmptyStackException();
            }
            //push current link to the stack of back links
            backLinks.push(currentLink);
            //set current link to forward link on top of forward stack
            currentLink = forwardLinks.pop();
        }
        //catching exception if backLinks stack is empty to notify user
        catch (EmptyStackException e)
        {
            System.out.println("\n-----------------------------------------------------"
                    + "\n****** ALERT: There are no more forward links! ******"
                    + "\n-----------------------------------------------------");
        }
    }


    //---------- getters for Navigation class:----------

    /**
     * getter method that gets current link
     * @return string with current link info
     */
    public String getCurrentLink()
    {
        return currentLink;
    }

    /**
     * getter method gets back link
     * @return string with back link info
     */
    public StackList<String> getBackLinks()
    {
        return backLinks;
    }

    /**
     * getter method gets forward link
     * @return string with forward link info
     */
    public StackList<String> getForwardLinks()
    {
        return forwardLinks;
    }
}