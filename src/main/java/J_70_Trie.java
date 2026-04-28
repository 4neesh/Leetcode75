import java.util.HashMap;
import java.util.Map;

public class J_70_Trie {
    public static void main(String[] args) {

        TrieArr t = new TrieArr();
        t.insert("Hello");
        System.out.println(t.search("Hello"));
        System.out.println(t.search("world"));
        t.insert("world");
        System.out.println(t.search("world"));

    }
}
class Trie {

    private Map<Character, Trie> map = new HashMap<>();
    public boolean isWord = false;

    public Trie() {
    }

    public void insert(String word) {
        Trie root = this;
        for(char c: word.toCharArray()){
            if(!root.getMap().containsKey(c)){
                root.map.put(c, new Trie());
            }
            root = root.map.get(c);
        }
        root.isWord = true;
    }

    public boolean search(String word) {
        Trie root = this;
        for(char c: word.toCharArray()){
            if(root.getMap().containsKey(c)){
                root = root.getMap().get(c);
            }
            else{
                return false;
            }
        }

        return root.isWord;
    }

    public boolean startsWith(String prefix) {
        Trie root = this;
        for(char c: prefix.toCharArray()){
            if(root.getMap().containsKey(c)){
                root = root.getMap().get(c);
            }
            else{
                return false;
            }
        }
        return true;
    }

    public Map<Character, Trie> getMap(){
        return this.map;
    }
}


class TrieArr{

    TrieArr[] arr = new TrieArr[26];
    boolean isWord = false;

    public void insert(String word){
        TrieArr root = this;
        word = word.toLowerCase();
        for(int i = 0; i<word.length(); i++){

            char c = word.charAt(i);
            int index = c - 'a';
            if(root.arr[index] == null){
                root.arr[index] = new TrieArr();
            }
            root = root.arr[index];
        }
        root.isWord = true;
    }

    public boolean search(String word){

        TrieArr root = this;
        word = word.toLowerCase();

        for(int i = 0; i<word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(root.arr[index] == null){
                return false;
            }
            root = root.arr[index];
        }

        return root.isWord;
    }

    public boolean startsWith(String word){

        TrieArr root = this;
        word = word.toLowerCase();

        for(int i = 0;i < word.length(); i++){

            int index = word.charAt(i) - 'a';
            if(root.arr[index] == null){
                return false;
            }
            root = root.arr[index];
        }
        return true;
    }

}