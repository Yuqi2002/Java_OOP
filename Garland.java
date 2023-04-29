// Yuqi Zhou
// COP 3330
// Spring 2023
// yu894053
import java.util.Arrays;

public class Garland
{
    private Node head; // Reference to the top-left node in this garland.
    private Node tail;
    private int size;  

    // constructors
    Garland()
    {
        return;
    }

    Garland(String [] strings)
    {
        // loop through the given strings and call addString on each
        for(int i = 0; i < strings.length; i++)
        {
            addString(strings[i]);
        }
    }

    private static int getListLength(Node head)
    {
        // loop through the string until we hit null
        int len = 0;
        while(head != null)
        {
            head = head.down;
            len++;
        }
        return len;
    }

    private boolean validIndex(int index)
    {
        if (index < 0 || index >= size())
        {
            return false;
        }
        return true;
    }

    private static void printString(Node head)
    {
        // print null if LL is empty
        if(head == null)
        {
            System.out.println("(null)");
            return;
        }
        // loop through the LL and print each char
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data);
            temp = temp.down;
        }
    }

    public static Node stringToLinkedList(String s)
    {
        // check for null or empty string
        if(s == null || s.length() == 0)
        {   
            return null;
        } 
        // initialize head node and copy over each char of the string in its following nodes
        Node head = new Node(s.charAt(0));
        Node ptr = head;
        for(int i = 1; i < s.length(); i++)
        {
            ptr.down = new Node(s.charAt(i));
            ptr = ptr.down;
        }
        return head;
    }

    public static String linkedListToString(Node head)
    {
        // initialize char array to store each node's value
        char[] arr = new char[getListLength(head)];
        int i = 0; // variable to index array
        // loop through LL to add each node's data to arr
        while(head != null)
        {
            arr[i] = head.data;
            head = head.down;
            i++;
        }
        // cast our char array into a string
        String s = new String(arr);
        return s;
    }

    public Node head()
    {
        return this.head;
    }

    public int size()
    {
        return this.size;
    }

    public void addString(String s)
    {
        // add the string to the correct location of Garland
        if(head == null)
        {
            head = stringToLinkedList(s);
            tail = head;
        }
        else
        {
            tail.next = stringToLinkedList(s);
            tail = tail.next;
        }
        // increment size of garland when string added isn't empty
        if(s != null && s.length() != 0)
            size ++;
    }

    public Node getNode(int index)
    {
        if(validIndex(index) == false)
        {
            return null;
        }
        Node ptr = head();
        // loop until the index is reached
        for(int i = 0; i < index; i++)
        {
            ptr = ptr.next;
        }
        return ptr;
    }

    public String getString(int index)
    {
        Node currNode = getNode(index);
        return linkedListToString(currNode);
    }

    public boolean removeString(int index)
    {
        if(validIndex(index) == false)
        {
            return false;
        }
        // handle the case where we need to remove from the head
        if(index == 0)
        {
            head = head.next;
            size -= 1;
            return true;
        }
        // handle the case where we need to remove from the tail
        if(index == size() - 1)
        {
            tail = head;
            while(tail.next.next != null)
            {
                tail = tail.next;
            }
            tail.next = null;
            size -= 1;
            return true;
        }
        // delete string
        Node currNode = getNode(index-1);
        currNode.next = currNode.next.next;
        size -= 1;
        return true;
    }

    public boolean printString(int index)
    {
        if(validIndex(index) == false)
        {
            System.out.println("(invalid index)");
            return false;
        }
    
        System.out.println(getString(index));
        return true;
    }

    public void printStrings()
    {
        if(head == null || size() == 0)
        {
            System.out.println("(empty list)");
        }
        for(int i = 0; i < size(); i++)
        {
            printString(i);
        }
    }

    public static double difficultyRating()
    {
        return 2.0;
    }

    public static double hoursSpent()
    {
        return 6.0;
    }
}