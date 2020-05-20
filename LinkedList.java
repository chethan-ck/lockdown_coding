import java.io.*;
import java.util.*;

class LinkedList
{
    Node head;
    Node s_ptr,f_ptr,se_half;
    class Node
    {
        char data;
        Node next;
        Node(char d)
        {
            data=d;
            next=null;
        }
    }
    boolean ispalindrome(Node head)
    {
        s_ptr=head;
        f_ptr=head;
        Node prevofs_ptr=head;
        Node midnode=null;
        boolean res=true;
        if(head!=null&& head.next!=null)
        {
            while(f_ptr!=null && f_ptr.next!=null)
            {
                f_ptr=f_ptr.next.next;
                prevofs_ptr=s_ptr;
                s_ptr=s_ptr.next;
            }
            if(f_ptr!=null)
            {
                midnode=s_ptr;
                s_ptr=s_ptr.next;
            }
            se_half=s_ptr;
            prevofs_ptr.next=null;
            reverse();
            res=compareLists(head,se_half);
            reverse();
            if(midnode!=null)
            {
                 prevofs_ptr.next=midnode;
                 midnode.next=se_half;
            }
            else
                prevofs_ptr.next=se_half;
        }
        return res;
    }
    void reverse()
    {
        Node prev=null;
        Node current=se_half;
        Node next;
        while(current!=null)
        {
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        se_half=prev;
    }
    boolean compareLists(Node head1,Node head2)
    {
        Node temp1=head1;
        Node temp2=head2;
        while(temp1!=null && temp2!=null)
        {
            if(temp1.data==temp2.data)
            {
                temp1=temp1.next;
                temp2=temp2.next;
            }
            else
             return false;
        }
        if(temp1==null && temp2==null)
        return true;
        else
        return false;
    }
    public void push(char new_data)
    {
        Node new_node=new Node(new_data);
        new_node.next=head;
        head=new_node;
    }
    void printList(Node ptr)
    {
        while(ptr!=null)
        {
            System.out.print(ptr.data + "->");
            ptr=ptr.next;
        }
        System.out.println("NULL");
    }
    public static void main(String[] args)
    {
        LinkedList llist=new LinkedList();
        char str[]={'a','b','a','c','a','b','a'};
        String string=new String(str);
        for(int i=0;i<7;i++)
        {
            llist.push(str[i]);
            llist.printList(llist.head);
            if(llist.ispalindrome(llist.head)!=false)
            {
               System.out.println("Is Palindrome");
               System.out.print(" ");
            }
            else
            {
                System.out.println("Not Palindrome");
               System.out.print(" ");
            }
        }
    }
}