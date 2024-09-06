package Graph;
import  java.util.*;
public class AccountsMerged {
    static List<List<String>> accountsMerge(List<List<String>> accounts) {
        // code here
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String,Integer> mapmailnode = new HashMap<>();;
        for(int i = 0;i<accounts.size();i++){
            for(int j = 1;j<accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);
                if(!mapmailnode.containsKey(mail)){
                    mapmailnode.put(mail,i);
                }else{
                    ds.unionBySize(i,mapmailnode.get(mail));
                }
            }
        }
        ArrayList<String>[] mergedmail = new ArrayList[n];
        for(int i = 0;i<n;i++){
            mergedmail[i] = new ArrayList<String>();
        }
        for(Map.Entry<String,Integer> entry : mapmailnode.entrySet()){
            String mail = entry.getKey();
            int node =  ds.findParent(entry.getValue());
            mergedmail[node].add(mail);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(mergedmail[i].size()==0)continue;
            Collections.sort(mergedmail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String st : mergedmail[i]){
                temp.add(st);
            }
            ans.add(temp);
        }
        return ans;

    }
}
