package Arrays;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//class Solution {
public class Dontknowwhat {

        public String solve(String s,String t){
            String ans = "";
            HashMap<Character,Integer> map2 = new HashMap<>();
            for(int i=0;i<t.length();i++){
                char ch = t.charAt(i);
                map2.put(ch,map2.getOrDefault(ch,0)+1);
            }

            int mct = 0;   // match count
            int dmct = t.length(); // Desired match count

            HashMap<Character,Integer> map1 = new HashMap<>();
            int i = -1;
            int j = -1;

            while(true){
                boolean f1 = false;
                boolean f2 = false;
                //Acquire
                while(i<s.length() - 1 && mct < dmct){
                    i++;
                    char ch = s.charAt(i);
                    map1.put(ch,map1.getOrDefault(ch,0)+1);

                    if(map1.getOrDefault(ch,0) <= map2.getOrDefault(ch,0)){
                        mct++;
                    }
                    f1 = true;
                }
                //collect answers and release
                while(j < i && mct == dmct){
                    String pans = s.substring(j+1,i+1);
                    if(ans.length() == 0 || pans.length() < ans.length()){
                        ans = pans;
                    }
                    j++;
                    char ch = s.charAt(j);
                    if(map1.get(ch) == 1){
                        map1.remove(ch);
                    }
                    else
                    {
                        map1.put(ch,map1.get(ch)-1);
                    }

                    if(map1.getOrDefault(ch,0) < map2.getOrDefault(ch,0)){
                        mct--;
                    }
                    f2 = true;
                }

                if(f1 == false && f2 == false){
                    break;
                }
            }
            return ans;

        }
        public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner sc = new Scanner(System.in);
            // BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
            // br = br.readLine().trim();
            String br = sc.nextLine();
//            br = br.replaceAll(" ","");
            Pattern pattern = Pattern.compile("S = \"(.*?)\", T = \"(.*?)\"");
            Matcher matcher = pattern.matcher(br);
            String svalue = "";
            String tvalue = "";
            if(matcher.find()){
                svalue = matcher.group(1);
                tvalue = matcher.group(2);
            }
            // t = t.trim();
            Dontknowwhat sol = new Dontknowwhat();
            String ans = sol.solve(svalue,tvalue);
            System.out.println(ans);
        }
    }
//}
