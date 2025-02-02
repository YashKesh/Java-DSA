package Trie;
class Node{
	Node[] links = new Node[26];
	boolean flag = false;
	public boolean containsKey(char ch){
		return links[ch - 'a']!=null;
	}
	public Node get(char ch){
		return links[ch - 'a'];
	}
	public void put(char ch , Node node){
		links[ch - 'a'] = node;
	}
	public void setEnd(){
		flag = true;
	}
	public boolean isEnd(){
		return flag ;
	}
}

public class CountOfDisrtinctSubStrings 
{
    public static void main(String[] args) {
        System.out.println(countDistinctSubstrings("ababa"));
        
    }
	public static int countDistinctSubstrings(String s) 
	{
		//	  Write your code here.
		Node root = new Node();
		int ans = 0;
		for(int i = 0;i<s.length();i++){
			Node node = root;
			for(int j = i;j<s.length();j++){
				if(!node.containsKey(s.charAt(j))){
					ans++;
					node.put(s.charAt(j), new Node());
				}
				node = node.get(s.charAt(j));
			}
		}
		return ans+1;
	}
}