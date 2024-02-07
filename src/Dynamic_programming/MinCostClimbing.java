package Dynamic_programming;

public class MinCostClimbing {
    public static void main(String[] args) {
        int[] cost = new int[]{1,100,1,1,1,100,1,1,100,1};
        MinCostClimbing min = new MinCostClimbing();
        int ans  = min.minCostClimbingStairs(cost);
        System.out.print(ans);
    }

        static int[] dp;
        public static int solve(int[] cost,int n){
            if(n<0){
                return 0;
            }
            if(n==0 || n==1){
                return cost[n];
            }
            if(dp[n]!=0){
                return dp[n];

            }
            dp[n] = cost[n] + Math.min(solve(cost,n-1),solve(cost,n-2));
            return dp[n];
        }
        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;
            dp = new int[n];
            //  Arrays.fill(dp,-1);
            return Math.min(solve(cost,n-1),solve(cost,n-2));
        }
    }

