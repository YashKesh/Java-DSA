package Arrays;
import java.util.*;
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

