/**
 * Definition for singly-linked list.
 public class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 */

class Node {
    Node next ;
    int data ;
    Node(int d){
        data = d ;
        next = null;
    }
}

class MergeLists{

    Node head ;


    public void addToTheLast(Node node){

        if (head == null){
            head = node;
        }

        else{

            Node temp = head ;
            while(temp.next != null){
                temp = temp.next;

            }
            temp.next = node;
        }
    }

    void printList(){
        Node temp = head ;

        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[]){
    /* Let us create two sorted linked
       lists to test the methods
       Created lists:
           llist1: 5->10->15,
           llist2: 2->3->20
    */
    MergeLists llist1 = new MergeLists();
    MergeLists llist2 = new MergeLists();

    // Node head1 = new Node(5);
    llist1.addToTheLast(new Node(5));
    llist1.addToTheLast(new Node(10));
    llist1.addToTheLast(new Node(15));

    // Node head2 = new Node(2);
    llist2.addToTheLast(new Node(2));
    llist2.addToTheLast(new Node(3));
    llist2.addToTheLast(new Node(20));


    llist1.head = new Solution().mergeTwoLists(llist1.head,
                                        llist2.head);
    llist1.printList();

    }


}





class Solution {
    public Node mergeTwoLists(Node list1, Node list2) {

        Node front = new Node(0);
        Node tail = front ;

        while(true){

            if(list1 == null){
                tail.next = list2;
                break;
            }

            if(list2 == null){
                tail.next = list1;
                break;
            }

            if(list1.data < list2.data){
                tail.next = list1;
                list1 = list1.next;
            }
            else{
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        return front.next;


    }
}
