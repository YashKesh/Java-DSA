package Trie;
class Node{
  Node[] links = new Node[26];
  boolean flag = false;
  public boolean containsKey(char ch){
    return links[ch -  'a']!=null;
  }
  public void put(char ch , Node node){
    links[ch - 'a'] = node;
  }
  public Node get(char ch){
    return links[ch - 'a'];
  }
  public void setEnd(){
    flag = true;
  }
  public boolean isEnd(){
    return flag;
  }
}
class Trie{
    private Node root;
    Trie(){
      root = new Node();
    }
    public void insert(String word){
      Node node = root;
      for(int i = 0;i<word.length();i++){
          if(!node.containsKey(word.charAt(i))){
            node.put(word.charAt(i), new Node());
          }
          node = node.get(word.charAt(i));
      }
      node.setEnd();
    }
    public boolean countAllPRefix(String word){
      Node node = root;
      boolean flag = true;
      for(int i =0;i<word.length();i++){
        if(node.containsKey(word.charAt(i))){
          node = node.get(word.charAt(i));
          flag = flag & node.isEnd();
        }else{
          return false;
        }
      }
      return flag;
    }
}
class CompleteString {

  public static String completeString(int n, String[] a) {
    // Write your code here.
    String longest = "";
    Trie obj = new Trie();
    for(String word : a)obj.insert(word);
    for(String word : a){
      if(obj.countAllPRefix(word)){
        if(longest.length() < word.length()){
          longest = word;
        }
        else if (longest.length() == word.length() && longest.compareTo(word) > 0){
          longest = word;
        }
      }
    }
    if(longest == "")return "None";
    return longest;
  }
}