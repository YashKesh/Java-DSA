package Greedy;

public class Candy {
    public static void main(String[] args) {
        Candy sol = new Candy();
        System.out.println(sol.candy(new int[]{1,2,1}));
    }
//    class Solution {
        public int candy(int[] ratings) {
            int n = ratings.length;
            int[] candies = new  int[n];
            for(int i = 1;i<n;i++){
                if(ratings[i-1]<ratings[i] && candies[i-1]>=candies[i]){
                    candies[i] = candies[i-1]+1;
                }
            }
            for(int i = n-2;i>=0;i--){
                if(ratings[i+1]<ratings[i] && candies[i+1]>=candies[i]){
                    candies[i] = candies[i+1]+1;
                }
            }
            int total = 0;
            for(int i:candies){
                total += i + 1;
            }
            return total;
        }
    }
//}
