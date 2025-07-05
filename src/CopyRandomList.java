import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CopyRandomList {

    static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

        }

        static Map<Node, Node> cachedNode = new HashMap<Node, Node>();
//使用哈希表（Map）缓存原节点与新节点之间的映射关系，防止重复构造
        public static Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            if (!cachedNode.containsKey(head)) {
                Node headNew = new Node(head.val);//新建一个节点，值为原节点的值
                cachedNode.put(head, headNew);//将原节点和新节点的映射关系存入哈希表
                headNew.next = copyRandomList(head.next);//递归调用，复制原节点的下一个节点
                headNew.random = copyRandomList(head.random);//递归调用，复制原节点的随机指针指向的节点

            }
            return cachedNode.get(head);//返回原节点对应的新节点
        }
    }
}
