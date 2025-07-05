import java.util.HashSet;
import java.util.Set;

public class GetIntersectionNode {
    public static void main(String[] args) {
        // 构建相交链表
        ListNode common = new ListNode(8);
        common.next = new ListNode(10);

        ListNode headA = new ListNode(3);
        headA.next = new ListNode(7);
        headA.next.next = common;  // 链接到公共部分

        ListNode headB = new ListNode(99);
        headB.next = new ListNode(1);
        headB.next.next = common;  // 链接到公共部分

        ListNode intersection = getIntersectionNode(headA, headB);
        System.out.println(intersection != null ? intersection.val : "null");
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while(temp!=null){
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while(temp!=null){
            if(visited.contains(temp)){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
