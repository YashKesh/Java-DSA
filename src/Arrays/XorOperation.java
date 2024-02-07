package Arrays;

public class XorOperation {
    public static void main(String[] args) {
        XorOperation sol = new XorOperation();
        System.out.println(sol.findArray(new int[]{5,2,0,3,1}));
    }
//    class Solution {
        public int[] findArray(int[] pref) {
            int i = 0;
            int j = pref.length-1;
            int[] res = new int[pref.length];
            int prev = pref[0];
            res[0] = prev;
            i++;
            while(i<j){
                prev = prev ^ pref[i];
                res[i] = prev;
                i++;
            }
            return res;
        }
    }
//}
