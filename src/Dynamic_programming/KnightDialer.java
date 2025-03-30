package Dynamic_programming;
/*
    
In the classic problem of the knight's tour, we are given a chessboard of size `N x N` 
and a knight initially positioned at any cell. The knight wants to visit every square exactly once, returning to its starting cell.

However, there is a twist: The knight must only move to squares that are adjacent horizontally, vertically, or diagonally. 
Furthermore, the knight cannot move to a square that has already been visited.

Given an integer `N`, return the number of distinct ways the knight can visit every square on the chessboard.

Example 1:
Input: N = 1
Output: 1

Example 2:
Input: N = 2

Output: 2

Explanation: There are two distinct ways to visit every square on a 2 x 2 chessboard.

Example 3:
Input: N = 3
Output: 6

Explanation: There are 6 distinct ways to visit every square on a 3 x 3 chessboard.

 */
public class KnightDialer {
    public static void main(String[] args) {
        KnightDialer sol = new KnightDialer();
        System.out.println(sol.knightDialer(3131));
    }
        int[][] memo;
        int n;
        int MOD = (int) 1e9 + 7;
        int[][] jumps = {
                {4, 6},
                {6, 8},
                {7, 9},
                {4, 8},
                {3, 9, 0},
                {},
                {1, 7, 0},
                {2, 6},
                {1, 3},
                {2, 4}
        };

        public int dp(int remain, int square) {
            if (remain == 0) {
                return 1;
            }

            if (memo[remain][square] != 0) {
                return memo[remain][square];
            }

            int ans = 0;
            for (int nextSquare : jumps[square]) {
                ans = (ans + dp(remain - 1, nextSquare)) % MOD;
            }

            memo[remain][square] = ans;
            return ans;
        }

        public int knightDialer(int n) {
            this.n = n;
            memo = new int[n + 1][10];
            int ans = 0;
            for (int square = 0; square < 10; square++) {
                ans = (ans + dp(n - 1, square)) % MOD;
            }

            return ans;
        }
    }

