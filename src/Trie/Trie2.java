package Trie;
class Node{
    Node[] links = new Node[26];
    int ew = 0;
    int cp = 0;
    public boolean containsKey(char ch){
        return links[ch -'a']!=null;
    }
    public void put(char ch , Node node){
        links[ch - 'a'] = node;
    }
    public Node get(char ch){
        return links[ch - 'a'];
    }
    public void setew(){
        ew++;
    }
    public void decew(){
        ew--;
    }
    public void setcp(){
        cp++;
    }
    public void decp(){
        cp--;
    }
    public int getEnd(){
        return ew;
    }
    public int getPrefix(){
        return cp;
    }
}
public class Trie2 {
    public static void main(String[] args) {
        Trie2 trie = new Trie2();
        trie.insert("apple");
        System.out.println(trie.countWordsEqualTo("apple")); // returns 1
        System.out.println(trie.countWordsStartingWith("app")); // returns 1
        trie.insert("app");
        System.out.println(trie.countWordsEqualTo("apple")); // returns 1
        System.out.println(trie.countWordsStartingWith("app")); // returns 2
        trie.erase("apple");
        System.out.println(trie.countWordsEqualTo("apple")); // returns 0
        System.out.println(trie.countWordsStartingWith("app")); // returns 1
    }
    private static Node root;
    public Trie2() {
        // Write your code here.
        root = new Node();
    }

    public void insert(String word) {
        // Write your code here.
        Node node = root;
        for(int i = 0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new Node());
            }
            node = node.get(word.charAt(i));
            node.setcp();
        }
        node.setew();
    }

    public int countWordsEqualTo(String word) {
        // Write your code here.
        Node node = root;
        for(int i = 0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return 0;
            }
            node = node.get(word.charAt(i));
        }
        return node.getEnd();
    }

    public int countWordsStartingWith(String word) {
        // Write your code here.
        Node node = root;
        for(int i = 0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return 0;
            }
            node = node.get(word.charAt(i));
        }
        return node.getPrefix();
    }

    public void erase(String word) {
        // Write your code here.
        Node node = root;
        for(int i = 0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return;
            }
            node = node.get(word.charAt(i));
            node.decp();
        }
        node.decew();
    }

}
