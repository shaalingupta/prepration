package dsa;

import org.junit.Assert;

import java.util.*;
import java.util.List;

/**
 * You are given a nested list of integers nestedList. Each element is either an integer or a list whose
 * elements may also be integers or other lists.
 *
 * The depth of an integer is the number of lists that it is inside of. For example, the nested list [1,[2,2],[[3],2],1]
 * has each integer's value set to its depth.
 *
 * Return the sum of each integer in nestedList multiplied by its depth.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: nestedList = [[1,1],2,[1,1]]
 * Output: 10
 * Explanation: Four 1's at depth 2, one 2 at depth 1. 1*2 + 1*2 + 2*1 + 1*2 + 1*2 = 10.
 * Example 2:
 *
 *
 * Input: nestedList = [1,[4,[6]]]
 * Output: 27
 * Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3. 1*1 + 4*2 + 6*3 = 27.
 * Example 3:
 *
 * Input: nestedList = [0]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nestedList.length <= 50
 * The values of the integers in the nested list is in the range [-100, 100].
 * The maximum depth of any integer is less than or equal to 50.
 */

// This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
   class NestedInteger {
       Integer value;
       List<NestedInteger> nestedIntegers;
      // Constructor initializes an empty nested list.
      public NestedInteger(){
          this.nestedIntegers = new ArrayList<>();
      }
      // Constructor initializes a single integer.
      public NestedInteger(int value){
          this.value = value;
      }
      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger(){
          if ((Objects.isNull(nestedIntegers) || nestedIntegers.isEmpty()) && value!=null){
              return true;
          }
          return false;
      }
 
      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger(){
          return value;
      }
 
      // Set this NestedInteger to hold a single integer.
      public void setInteger(int value){
          this.value = value;
      }
 
      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
      public void add(NestedInteger ni){
          this.nestedIntegers.add(ni);
      }
 
      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return empty list if this NestedInteger holds a single integer
      public List<NestedInteger> getList(){
          return this.nestedIntegers;
      }
  }
 
public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        Queue<Pair<NestedInteger, Integer>> q = new LinkedList<>();
        int level = 1;
        for(NestedInteger nestedInteger : nestedList){
            q.offer(new Pair<>(nestedInteger, level));
        }
        int sum = 0;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            NestedInteger temp = (NestedInteger) curr.getKey();
            level = (int) curr.getValue();
            if (temp.isInteger()){
                sum += temp.getInteger() * level;
            } else {
               for(NestedInteger nI : temp.getList()){
                   q.offer(new Pair<>(nI, level+1));
               }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        List<NestedInteger> list = new ArrayList<>();
        list.add(new NestedInteger(1));
        list.add(new NestedInteger(1));
        list.add(new NestedInteger());
        list.get(2).add(new NestedInteger(2));
        NestedListWeightSum nestedListWeightSum = new NestedListWeightSum();
        Assert.assertEquals(4, nestedListWeightSum.depthSum(list));
    }
}
