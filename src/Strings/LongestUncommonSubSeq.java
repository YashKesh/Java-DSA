package Strings;
/*
 * Given a list of strings, you need to find the longest uncommon subsequence among them. The longest uncommon subsequence is
 * defined as the longest subsequence of one of these strings and this subsequence should not be any subsequence of the other strings.
 * A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing the order of the remaining elements.
 * 
 */
public class LongestUncommonSubSeq {
    public static void main(String[] args) {
        LongestUncommonSubSeq sol = new LongestUncommonSubSeq();
        System.out.println(sol.findLUSlength(new String[]{"aba", "cdc", "eae"}));
    }
    public boolean isSubSequence(String str1,String str2){
        int i = 0, j = 0;
       while (i < str1.length() && j < str2.length()) {
           if (str1.charAt(i) == str2.charAt(j)) {
               i++;
           }
           j++;
       }
       return i == str1.length();
   }
   public int findLUSlength(String[] strs) {
    int res = -1;
    int n = strs.length;
    for(int i = 0;i<n;i++){
       if(strs[i].length() < res){
           continue;
       }
       int j = 0;
       while(j<n){
           if(i!=j && isSubSequence(strs[i], strs[j])){
               break;
           }
           j++;
       }
       if(j==n){
           res = Math.max(res,strs[i].length());
       }
    }
    return res;   
   }
}
