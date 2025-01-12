package Arrays;
import java.io.*;
import java.util.*;

//class Solution {
public class Mergeint {
    public int[][] merge(int[][] intervals) {
        Stack<int[]> stack = new Stack<>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        for(int[] interval : intervals){
            if(stack.isEmpty() || stack.peek()[1]<interval[0]){
                stack.push(interval);
            }
            else{
                stack.peek()[1] = Math.max(stack.peek()[1],interval[1]);
            }
        }
        return stack.toArray(new int[stack.size()][]);
    }
        public int[][] overlap(int[][] intervals){
            Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
            LinkedList<int[]> merge = new LinkedList<>();
            for(int[] interval : intervals){
                if(merge.isEmpty() || merge.getLast()[1]<interval[0]){
                    merge.add(interval);
                }
                else{
                    merge.getLast()[1] = Math.max(merge.getLast()[1],interval[1]);
                }
            }
            return merge.toArray(new int[merge.size()][]);
        }

        public static void main(String[] args) throws IOException {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String cases = br.readLine().trim();
            cases = cases.substring(1,cases.length()-1);
            // int n = Integer.parseInt(br.readLine().trim());
            Mergeint sol = new Mergeint();
            String[] intervalstr = cases.split("], \\[");
            int n = intervalstr.length;
            int[][] intervals = new int[n][2];
            int j = 0;
            for(int i = 0;i<n;i++){
                String[] sub = intervalstr[i].split(", ");
                intervals[i][0] = Integer.parseInt(sub[0]);
                intervals[i][1] = Integer.parseInt(sub[1]);
            }
            int[][] merge = sol.overlap(intervals);
            StringBuilder res = new StringBuilder("[");
            for(int i = 0;i<merge.length;i++){
                res.append("[").append(merge[i][0]).append(",").append(merge[i][1]).append("]");
                if(i<merge.length-1){
                    res.append(", ");
                }
            }
            res.append("]");
            System.out.println(res.toString());
            // sc.close();
        }
    }
//}
