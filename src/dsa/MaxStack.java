package dsa;

import java.util.*;

class MaxStack {
    Stack<Pair<Integer, Integer>> st;
    PriorityQueue<Pair<Integer, Integer>> pq;
    Set<Integer> removed;
    int count;
    public MaxStack() {
        this.st = new Stack<>();
        this.pq = new PriorityQueue<>((a, b) -> {
            if (a.getKey() - b.getKey() == 0){
                return b.getValue() - a.getValue();
            }else{
                return b.getKey() - a.getKey();
            }
        });
        this.removed = new HashSet<>();
    }

    public void push(int x) {
        st.push(new Pair<>(x, count));
        pq.add(new Pair<>(x, count));
        count++;
    }

    public int pop() {
        while(removed.contains(st.peek().getValue())){
            st.pop();
        }
        Pair<Integer, Integer> temp = st.pop();
        removed.add(temp.getValue());
        return temp.getKey();
    }

    public int top() {
        while(removed.contains(st.peek().getValue())){
            st.pop();
        }
        return st.peek().getKey();
    }

    public int peekMax() {
        return 0;
    }

    public int popMax() {
        return 0;
    }

    public static void main(String[] args) {
        MaxStack obj = new MaxStack();
        obj.push(5);
        obj.push(1);
        obj.push(5);
        System.out.println(obj.top());
        System.out.println(obj.popMax());
        System.out.println(obj.top());
        System.out.println(obj.peekMax());
        System.out.println(obj.pop());
        System.out.println(obj.top());
    }
}



