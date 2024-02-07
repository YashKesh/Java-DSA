package Arrays;
import java.util.*;
//interface MountainArray {
//    public int get(int index) {}
//    public int length() {}
//}
public class FindInMoutainArray {

      // This is MountainArray's API interface.
      // You should not implement it, or speculate about its implementation
//    class Solution {
        public int findInMountainArray(int target, int[] mountainArr) {
            int length = mountainArr.length;
            int low = 1;
            int high = length-2;
            while(low!=high){
                int index = (low + high)/2;
                if(mountainArr[index]<mountainArr[index+1]){
                    low = index+1;
                }else{
                    high = index;
                }
            }
            int peakindex = low;
            low = 0;
            high = peakindex;
            while(low!=high){
                int index = (low + high)/2;
                if(mountainArr[index]<target){
                    low = index+1;
                }else{
                    high = index;
                }
            }
            if(mountainArr[low]==target){
                return low;
            }
            low = peakindex+1;
            high  = length-1;
            while(low!=high){
                int index = (low + high)/2;
                if(mountainArr[index]>target){
                    low = index+1;

                }else{
                    high = index;
                }
            }
            if(mountainArr[low]==target){
                return low;
            }
            return -1;
        }
    }
//}
