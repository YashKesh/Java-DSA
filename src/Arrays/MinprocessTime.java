package Arrays;
import java.util.*;
/*
 * You have a certain number of processors, each having 4 cores. The number of tasks to be executed is four times the number of 
 * processors. Each task must be assigned to a unique core, and each core can only be used once.

You are given an array processorTime representing the time each processor becomes available and an array tasks representing how 
long each task takes to complete. Return the minimum time needed to complete all tasks.
Example 1:
Input: processorTime = [8,10], tasks = [2,2,3,1,8,7,4,5]

Output: 16

Explanation:

Assign the tasks at indices 4, 5, 6, 7 to the first processor which becomes available at time = 8, and the tasks at 
indices 0, 1, 2, 3 to the second processor which becomes available at time = 10. 

The time taken by the first processor to finish the execution of all tasks is max(8 + 8, 8 + 7, 8 + 4, 8 + 5) = 16.

The time taken by the second processor to finish the execution of all tasks is max(10 + 2, 10 + 2, 10 + 3, 10 + 1) = 13.
 */
public class MinprocessTime {
    public static void main(String[] args) {
        MinprocessTime sp = new MinprocessTime();
        int[] temp = {8, 10};
        int[] task = {2, 2, 3, 1, 8, 7, 4, 5};
        List<Integer> arg = new ArrayList<>();
        List<Integer> arg2 = new ArrayList<>();
// Add elements from 'temp' array directly to 'arg' list
        for (int i : temp) {
            arg.add(i);
        }

// Add elements from 'task' array directly to 'arg' list
        for (int i : task) {
            arg2.add(i);
        }
        System.out.println(sp.minProcessingTime(arg,arg2));
    }
        public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
            Collections.sort(tasks);
            Collections.reverse(tasks);
            int maxtime = Integer.MIN_VALUE;
            for(int i = 0;i<processorTime.size();i++){
                for(int j = i*4;j<(i+1)*4;j++){
                    maxtime  = Math.max(maxtime,processorTime.get(i)+tasks.get(j));
                }
            }
            return maxtime;
        }
    }

