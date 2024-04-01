
import java.util.*;


/**
 * There are n buildings in a line. You are given an integer array heights of size n that represents the heights of the
 * buildings in the line.
 *
 * The ocean is to the right of the buildings. A building has an ocean view if the building can see the ocean without
 * obstructions. Formally, a building has an ocean view if all the buildings to its right have a smaller height.
 *
 * Return a list of indices (0-indexed) of buildings that have an ocean view, sorted in increasing order.
 *
 *
 *
 * Example 1:
 *
 * Input: heights = [4,2,3,1]
 * Output: [0,2,3]
 * Explanation: Building 1 (0-indexed) does not have an ocean view because building 2 is taller.
 * Example 2:
 *
 * Input: heights = [4,3,2,1]
 * Output: [0,1,2,3]
 * Explanation: All the buildings have an ocean view.
 * Example 3:
 *
 * Input: heights = [1,3,2,4]
 * Output: [3]
 * Explanation: Only building 3 has an ocean view.
 *
 *
 * Constraints:
 *
 * 1 <= heights.length <= 105
 * 1 <= heights[i] <= 109
 */

public class BuildingsWithOceanView {
    public int[] findBuildings(int[] heights) {
        int tallest = 0;
        List<Integer> res = new ArrayList<>();
        for(int i=heights.length-1; i>=0; --i){
            if(tallest < heights[i]){
                res.add(i);
                tallest = heights[i];
            }
        }
        int[] ans = new int[res.size()];
        int j = 0;
        for(int i=res.size()-1; i>=0; --i){
            ans[j++] = res.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        BuildingsWithOceanView buildings = new BuildingsWithOceanView();
        int[] arr = {4,2,3,1};
        int[] arr1 = {4,3,2,1};
        int[] arr2 = {1,3,2,4};
        System.out.println(Arrays.toString(buildings.findBuildings(arr)));
        System.out.println(Arrays.toString(buildings.findBuildings(arr1)));
        System.out.println(Arrays.toString(buildings.findBuildings(arr2)));
    }
}
