package hashTable;
/*
 *  A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list. 
 */
public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)
        return null;
        RandomListNode begin = new RandomListNode(0);
        begin.next = head;
        while(head.next!=null){
            RandomListNode cur = new RandomListNode(head.label);
            cur.next = head.next;
            head.next = cur;
            head = head.next.next;
        }
        head.next = new RandomListNode(head.label);
        head = begin.next;
        while(head!=null){
            if(head.random==null){
                head.next.random = null;
            }
            else
            head.next.random = head.random.next;
            head = head.next.next;
        }
        RandomListNode oldNode = begin.next;
        RandomListNode newNode = oldNode.next;
        RandomListNode runner = newNode;
        while(runner.next!=null){
            oldNode.next = oldNode.next.next;
            oldNode = oldNode.next;
            runner.next = oldNode.next;
            runner = runner.next;
        }
        oldNode.next = null;
        return newNode;
    }
}
