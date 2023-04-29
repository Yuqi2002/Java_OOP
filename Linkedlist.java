public class Linkedlist
{
    private Node2 head;
    private Node2 tail;

    public void tailInsert(int data)
    {
        if(head == null)
        {
            head = new Node2(data);
            tail = head;
        }
        else
        {
            tail.next = new Node2(data);
            tail = tail.next;
        }
    }

    public void printLL()
    {
        Node2 temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void deleteNode(int val)
    {
        Node2 temp = head;
        if(head == null)
            return;
        if(head.data == val)
        {
            head = head.next;
        }
        while(temp.next.data != val)
        {
            
            temp = temp.next;
        }
        




    }









}