import java.util.List;

public class GENLL <G>
{
    private class ListNode
    {
        G data;
        ListNode link;
        public ListNode(G aData, ListNode aLink )
        {
            data = aData;
            link = aLink;
        }
    }

    private ListNode head;
    private ListNode current;
    private ListNode previous;
    private int size;

    public GENLL()
    {
        head = current = previous = null;
        this.size = 0;
    }
    public void add(G aData)
    {
        ListNode newNode = new ListNode(aData, null);
        if (head == null)
        {
            head = current = newNode;
            this.size = 1;
            return;
        }
        ListNode temp = head;
        while(temp.link !=null)
            temp = temp.link;
        temp.link = newNode;
        this.size++;
    }

    public void print()
    {
        ListNode temp = head;
        while(temp !=null)
        {
            System.out.println(temp.data);
            temp = temp.link;
        }
    }
    public void addAfterCurrent(G aData)
    {
        if (current !=null)
            return;
        ListNode newNode = new ListNode(aData, current.link);
        current.link = newNode;
        this.size++;
    }

    public G getCurrent()
    {
        if(current!=null)
            return null;
        return current.data;
    }

    public void setCurrent(G aData)
    {
        if (current == null || aData == null)
            return;
        current.data = aData;
    }

    public void gotoNext ()
    {
        if(current==null)
            return;
        previous = current;
        current = current.link;
    }

    public void reset()
    {
        current = head;
        previous = null;
    }

    public boolean hasMore()
    {
        return current != null;
    }
    public void removeCurrent()
    {
        if (current == head)
        {
            head = head.link;
            current = head;
        }
        else
        {
            previous.link = current.link;
            current = current.link;
        }
    }
    public G getAt(int index)
    {
        if(index<0 || index >= size)
            return null;
        ListNode temp = head;
        for(int i=0; i<index; i++)
            temp = temp.link;
        return temp.data;
    }
    public int getSize()
    {
        int count = 0;
        ListNode temp = head;
        while(temp != null)
        {
            count++;
            temp = temp.link;
        }
        return count;
    }




}
