package dsa;

import java.util.*;

public class StrobogrammaticNumber {
        public boolean isStrobogrammatic(String num) {
            int i = 0, j = num.length()-1;
            while(i <= j){
                if((i>0 && num.charAt(i)=='0' && num.charAt(j)=='0')
                        || (num.charAt(i)=='1' && num.charAt(j)=='1')
                        || (num.charAt(i)=='6' && num.charAt(j)=='9')
                        || (num.charAt(i)=='9' && num.charAt(j)=='6')
                        || (num.charAt(i)=='8' && num.charAt(j)=='8')
                        || (num.charAt(i)=='5' && num.charAt(j)=='2')
                        || (num.charAt(i)=='2' && num.charAt(j)=='5')){
                    i++;
                    j--;
                }else{
                    return false;
                }
            }
            return true;
        }

   /********************StrobogrammaticII***********************/

    Map<Character, Character> map = new HashMap<>();
    private Map<Character, Character> initializeMap() {
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        return map;
    }
    public List<String> findStrobogrammaticII(int n) {
        initializeMap();
        return getNumber(n, n);
    }

    private List<String> getNumber(int n, int m){
        List<String> res = new ArrayList<>();
        if(n == 0){
            res.add("");
            return res;
        }

        if(n == 1){
            res.add("0");
            res.add("1");
            res.add("8");
            return res;
        }

        List<String> n2 = getNumber(n-2, m);
        int i = 0;

        while(i < n2.size()){
            for(Character key : map.keySet()){
                if (n == m && key == '0' ){ // If this is the outermost layer and we're adding '0' as the first digit, skip
                    // because '0' as the first digit is not allowed.
                    continue;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(key).append(n2.get(i)).append(map.get(key));
                res.add(sb.toString());
            }
            i++;
        }
        return res;
    }

    //Time complexity: N⋅5^(⌊N/2⌋+1) , check its time complexity and space complexity in leetcode
    // .

    public static void main(String[] args) {
        StrobogrammaticNumber s = new StrobogrammaticNumber();
        s.isStrobogrammatic("69");
        List<String> res = s.findStrobogrammaticII(4);
        res.forEach(i -> System.out.println(i));
    }
}
