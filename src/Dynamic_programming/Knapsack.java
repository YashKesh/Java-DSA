package Dynamic_programming;
import java.util.*;
public class Knapsack {
    public static void main(String[] args) {

    }
    public static int solve(int[] weight,int[] value,int index,int capacity,int[][] dp){
            if(index == 0){
                if(weight[0]<=capacity){
                    return value[0];
                }
                else{
                    return 0;
                }

            }
            if(dp[index][capacity]!=-1){
                return dp[index][capacity];
            }
            int include = 0;
            if(weight[index]<=capacity){
                include = value[index]+ solve(weight, value, index-1,capacity-weight[index], dp);
            }
            int exclude =solve(weight, value, index-1,capacity, dp);
            dp[index][capacity] = Math.max(include,exclude);
            return   dp[index][capacity] ;
        }
        static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

            /* Your class should be named Solution
             * Don't write main().
             * Don't read input, it is passed as function argument.
             * Change in the given tree itself.
             * No need to return or print the output.
             * Taking input and printing output is handled automatically.
             */
            int[][] dp = new int[n+1][maxWeight+1];
            for(int i  = 0;i<=n;i++){
                Arrays.fill(dp[i],-1);
            }
            return solve(weight, value, n-1,maxWeight, dp);

        }
    }

