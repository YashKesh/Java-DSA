package Graph;
import java.util.*;
/**Alien Dictionary
 HardAccuracy: 47.81%Submissions: 95K+Points: 8
 Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary.
 Find the order of characters in the alien language.
 Note: Many orders may be possible for a particular test case,
 thus you may return any valid order and output will be 1 if the order of string returned by the function is correct
 else 0 denoting incorrect string returned.**/
public class AlienDict {
    public static void main(String[] args) {
        AlienDict sol = new AlienDict();
        System.out.println(sol.findOrder(new String[]{"bcadd","abcd","abcb"},4,3));
    }
        public static List<Integer> topo(List<List<Integer>> adj ,int K,int N){
            int[] indegree = new int[K];
            for(int i = 0;i<adj.size();i++){
                for(int num : adj.get(i)){
                    indegree[num]++;
                }
            }
            Queue<Integer> q = new LinkedList<>();
            for(int i = 0;i<indegree.length;i++){
                if(indegree[i]==0){
                    q.add(i);
                }
            }
            List<Integer> ans = new ArrayList<>();
            while(!q.isEmpty()){
                int number = q.poll();
                ans.add(number);
                for(int num : adj.get(number)){
                    indegree[num]--;
                    if(indegree[num]==0){
                        q.add(num);
                    }
                }
            }
            return ans;
        }
        public String findOrder(String [] dict, int N, int K)
        {
            // Write your code here
            List<List<Integer>> adj = new ArrayList<>();
            for(int i = 0;i<K;i++){
                adj.add(new ArrayList<>());
            }
            for(int i = 0;i<dict.length-1;i++){
                String s1 = dict[i];
                String s2 = dict[i+1];
                int len = Math.min(s1.length(),s2.length());
                for(int j = 0;j<len;j++){
                    if(s1.charAt(j)!=s2.charAt(j)){
                        adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                        break;
                    }
                }

            }
            List<Integer> toposort = topo(adj,K,N);
            StringBuilder res = new StringBuilder();
            for(int cha : toposort){
                res.append((char)(cha + (int)('a')));
            }
            return res.toString();

        }

}
