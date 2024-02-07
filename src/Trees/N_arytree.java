package Trees;
import java.util.*;
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
public class N_arytree {
    /*
// Definition for a Node.

*/

//    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> res = new ArrayList<>();
            if(root==null){
                return res;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                int size =  q.size();
                List<Integer> list1 = new ArrayList<>();
                for(int i =  0;i<size;i++){
                    Node cur = q.poll();
                    list1.add(cur.val);
                    int child = cur.children.size();
                    for(int j = 0;j<child;j++){
                        if(cur.children.get(j)!=null){
                            q.add(cur.children.get(j));
                        }
                    }
                }
                res.add(list1);
            }
            return res;
        }
//    }
}
