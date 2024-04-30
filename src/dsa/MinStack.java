package dsa;

import java.util.*;

public class MinStack {
  /*  PriorityQueue<Integer> pq;
    Stack<Integer> st;
    int count;
    public MinStack() {
        this.pq = new PriorityQueue<>();
        this.st = new Stack<>();
    }

    public void push(int val) {
        st.push(val);
        pq.add(val);
    }

    public void pop() {
        int item  = st.pop();
        pq.remove(item);
    }

    public int top() {
       return st.peek();
    }

    public int getMin() {
        return pq.peek();
    }
*/

    /**
     *
     * Intution :: Before every Min value put last min
     * jese ki -2 0 -3
     * abhi last min = Integr.MAX_VALUE
     * last min ko stack me daal do and curr min -2 kr do and use bhi stack me daal do
     * abhi 0, -2 se bada h toh bas 0 ko stack me daal do
     * ab -3, -2 se chota h toh -2 ko stack me daal do and -3 ko naya min bana kr stack me daal do
     *
     * ab jab bhi pop karna h toh pop kr k check karo agar vo abhi current min h toh curr min ko pop karo and pehel wala min ko pop kr k new min bana do
     * nhe toh bas pop karo
     *
     * getMin me min ko return kr do
     *
     */

   /* Stack<Integer> st;
    int min;

    public MinStack() {
        this.st = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(val <= min){
            st.push(min);
            min = val;
        }
        st.push(val);
    }

    public void pop() {
        int item = st.pop();
        if(item == min){
            min = st.pop();
        }
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min;
    }
*/

    /**
     * Intutuion :: To create a new Node with min and val
     * while push is called we will check in head is null
     * then we will create a new node and assign that to head else
     * we will create a new node with val and comparing head.min with our val for min
     * and put it before head and make head point to this new node
     *
     * now any time a pop is called we will just move to next node if we want we can remove the old node as well.
     *
     * for min and top we can return in head node .val and headNode .min
     */

    class ListNode{
        int min;
        int val;
        ListNode next;
        ListNode(int val, int min){
            this.min = min;
            this.val = val;
        }
    }

    ListNode head;

    public MinStack() {}

    public void push(int val) {
        if(this.head == null){
            head = new ListNode(val, val);
        } else{
            ListNode newNode = new ListNode(val, Math.min(head.min, val));
            newNode.next = head;
            head = newNode;
        }
    }

    public void pop() {
        ListNode temp = head;
        head = head.next;
        temp.next = null;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }


    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());

    }
}
