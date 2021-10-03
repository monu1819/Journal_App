import java.io.*;
import java.util.*;
  
class GFG {
  
    // Stores the required sequence
    static int ans[];
  
    // Stores the visited and unvisited values
    static HashSet<Integer> visited;
  
    // Function to construct the array
    // according to the given conditions
    public static boolean
    constructArray(int i, int N)
    {
  
        // Base Case
        if (i == ans.length) {
            return true;
        }
  
        // If a value is already assigned
        // at current index, then recursively
        // call for the next index
        if (ans[i] != 0)
            return constructArray(i + 1, N);
  
        else {
  
            // Iterate over the range[N, 1]
            for (int val = N; val >= 1; val--) {
  
                // If the current value is
                // already visited, continue
                if (visited.contains(val))
                    continue;
  
                // Otherwise, mark this value as
                // visited and set ans[i] = val
                visited.add(val);
                ans[i] = val;
  
                // If val is equal to 1, then
                // recursively call for the
                // next index
                if (val == 1) {
                    boolean found
                        = constructArray(i + 1, N);
  
                    // If solution is found,
                    // then return true
                    if (found)
                        return true;
                }
  
                // For all other values, assign
                // ans[i + val] to val if the
                // i + val < ans.length
                else if (i + val < ans.length
                         && ans[i + val] == 0) {
                    ans[val + i] = val;
  
                    // Recursively call for
                    // next index to check if
                    // solution can be found
                    boolean found
                        = constructArray(i + 1, N);
  
                    // If solution is found then
                    // return true
                    if (found)
                        return true;
  
                    // BackTracking step
                    ans[i + val] = 0;
                }
  
                // BackTracking step
                ans[i] = 0;
                visited.remove(val);
            }
        }
  
        // In all other cases, return false
        return false;
    }
  
    // Driver Code
    public static void main(String[] args)
    {
        int N = 4;
  
        ans = new int[2 * N - 1];
        visited = new HashSet<>();
  
        // Function Call
        constructArray(0, N);
  
        // Print the resultant array
        for (int X : ans)
            System.out.print(X + " ");
    }
}
