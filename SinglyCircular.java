import java.util.*;

class Node
{
    public int data;
    public Node next;

    public Node(int no)
    {
        this.data = no;
        this.next = null;
    }
}

class SinglyCL
{
    public Node first;
    public Node last;
    public int iCount;

    public SinglyCL()
    {
        this.first = null;
        this.last = null;
        this.iCount = 0;
    }
    public void Display()
    {
      System.out.println("Elements of Singly circular Linked list are :");

    if(first != null && last != null)
    {
        do
        {
            System.out.print(" | "+first.data+" | ->");
            first = first.next;
        } while (first != last.next);
        System.out.println();
    }
    else
    {
        System.out.println("Linked list is empty");
    }
    }

    public int Count()
    {
        return this.iCount;
    }

    public void InsertFirst(int no)
    {
      Node newn = new Node(no);

       if((first == null) && (last == null))
    {
        first = newn;
        last = newn;
    }
    else
    {
        newn.next = first;
        first = newn;
    }
    last.next = first;

    iCount++;
    }

    public void InsertLast(int no)
    {
        Node newn = new Node(no);

       if(first == null && last == null)
    {
        first = newn;
        last = newn;
    }
    else
    {
        last.next = newn;
        last = last.next;
    }
    last.next = first;

    iCount++;
    }

    public void DeleteFirst()
    {
       if((first == null) && (last == null))
    {
        return;
    }
    else if(first == last)
    {
        first = null;
        last = null;
    }
    else
    {
        first = first.next;
        last.next = first;

    }
    
    iCount--;
    }

    public void DeleteLast()
    {
         if((first == null) && (last == null))
    {
        return;
    }
    else if(first == last)
    {
        first = null;
        last = null;
    }
    else
    {
        Node temp = first;

        while(temp.next != last)
        {
            temp = temp.next;
        }
        last = temp;

        last.next = first;
    }
     iCount--;
    }

    public void InsertAtPos(int iPos, int no)
    {
         int iCount = Count();

    if((iPos < 1) || (iPos > iCount+1))
    {
        System.out.println("Invalid position");
        return;
    }

    if(iPos == 1)
    {
        InsertFirst(no);
    }
    else if(iPos == iCount+1)
    {
        InsertLast(no);
    }
    else
    {
        Node temp = first;
        Node newn = new Node(no);

        for(int iCnt = 1; iCnt < iPos -1; iCnt++)
        {
            temp = temp.next;
        }

        newn.next = temp.next;
        temp.next = newn;

         last.next = first;
        
        iCount++;
    }

    }

    public void DeleteAtPos(int iPos)
    {
        int iCount = Count();

    if((iPos < 1) || (iPos > iCount))
    {
        System.out.println("Invalid position");
        return;
    }

    if(iPos == 1)
    {
        DeleteFirst();
    }
    else if(iPos == iCount)
    {
        DeleteLast();
    }
    else
    {
        Node temp1 = first;
        Node temp2 = null;

        for(int iCnt = 1; iCnt < iPos -1; iCnt++)
        {
            temp1 = temp1.next;
        }

        temp2 = temp1.next;
        temp1.next = temp1.next.next;
        
        last.next = first;
        
        iCount--;
    }
    }
}
class SinglyCircular
{
    public static void main(String Arg[])
    {
        SinglyCL obj = new SinglyCL();

        obj.InsertFirst(51);
        obj.InsertFirst(21);
        obj.InsertFirst(11);

        obj.InsertLast(101);
        obj.InsertLast(111);
        obj.InsertLast(121);

        obj.InsertAtPos(55,4);

        obj.Display();

        System.out.println("Number of elements are:"+obj.Count());

        obj.DeleteAtPos(4);

        obj.Display();

        System.out.println("Number of elements are:"+obj.Count());


        obj.DeleteFirst();
        obj.DeleteLast();

        obj.Display();

        System.out.println("Number of elements are:"+obj.Count());
    }
}