package Strings;

public class LengthLongestPath {
    public static void main(String[] args) {
        LengthLongestPath sol = new LengthLongestPath();
        System.out.println(sol.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    }
    public int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        int[] stack = new int[paths.length+1];
        int maxLen = 0;
        for(String s:paths){
            int level = s.lastIndexOf("\t")+1;
            int len = s.substring(level).length();
            if(s.contains(".")){
                maxLen = Math.max(maxLen,stack[level]+len);
            }else{
                stack[level+1] = stack[level]+len+1;
            }
        }
        return maxLen;
    }
    
}
