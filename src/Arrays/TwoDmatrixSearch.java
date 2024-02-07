package Arrays;

public class TwoDmatrixSearch {
    public static void main(String[] args) {
        TwoDmatrixSearch sol = new TwoDmatrixSearch();
        System.out.println(sol.searchMatrix(new int[][]{{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
    } ,12));
    }
        public boolean searchMatrix(int[][] matrix, int target) {
            int left = 0;
            int right = matrix.length;
            int mid = 0;
            while(left<right){
                mid = (left+right)/2;
                if(matrix[mid][0]<=target && target<=matrix[mid][matrix[0].length-1]){
                    left=right;
                }
                else if(target<matrix[mid][0]){
                    right = mid;
                }
                else{
                    left = mid+1;
                }
            }
            int a = mid;

            left = 0;
            right = matrix[0].length;
            while(left<right){
                mid = (left+right)/2;
                if(matrix[a][mid]==target){
                    return true;
                }
                else if(target<matrix[a][mid]){
                    right = mid;
                }
                else{
                    left = mid+1;
                }
            }
            return false;

        }
    }

