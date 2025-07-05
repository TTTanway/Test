import mylinkedlist.ListNode;

import java.util.Scanner;

public class ReverseList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 读取节点数量
        ListNode head = null, tail = null;
        for(int i=0;i<n;i++){
            int val = sc.nextInt();
            ListNode node = new ListNode(val);
            if(head == null){
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }
        printList(reverseList(head));
    }
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
