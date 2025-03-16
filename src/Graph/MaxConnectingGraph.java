package Graph;

import java.util.HashSet;
/*
 * You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
 * Return the size of the largest island in grid after applying this operation.
 * An island is a 4-directionally connected group of 1s.
 */
public class MaxConnectingGraph {
    public int MaxConnection(int grid[][]) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        // Step 1: Union all adjacent '1's in the grid
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    for (int i = 0; i < 4; i++) {
                        int newr = row + dRow[i];
                        int newc = col + dCol[i];
                        if (newr >= 0 && newr < n && newc >= 0 && newc < n && grid[newr][newc] == 1) {
                            int node = row * n + col;
                            int adjnode = newr * n + newc;
                            ds.unionBySize(node, adjnode);
                        }
                    }
                }
            }
        }

        // Step 2: Attempt to change each '0' to '1' and calculate the maximum component size
        int maxConnection = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    HashSet<Integer> componentParents = new HashSet<>();
                    for (int i = 0; i < 4; i++) {
                        int newr = row + dRow[i];
                        int newc = col + dCol[i];
                        if (newr >= 0 && newr < n && newc >= 0 && newc < n && grid[newr][newc] == 1) {
                            componentParents.add(ds.findParent(newr * n + newc));
                        }
                    }

                    // Calculate the total size if this '0' was changed to '1'
                    int sizeTotal = 1; // 1 for the new cell itself
                    for (int parent : componentParents) {
                        sizeTotal += ds.size.get(parent);
                    }
                    maxConnection = Math.max(maxConnection, sizeTotal);
                }
            }
        }

        // Step 3: Consider the case where we do not change any '0' (only existing '1's)
        for (int cell = 0; cell < n * n; cell++) {
            maxConnection = Math.max(maxConnection, ds.size.get(ds.findParent(cell)));
        }

        return maxConnection;
    }
}
