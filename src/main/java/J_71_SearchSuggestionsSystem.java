import java.util.*;

public class J_71_SearchSuggestionsSystem {

    public static void main(String[] args) {

        J_71_SearchSuggestionsSystem search = new J_71_SearchSuggestionsSystem();
        String[] products = {"mobile", "money", "monitor", "mouse"};
        System.out.println(search.suggestedProducts(products, "mouse"));

    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Arrays.sort(products);
        //initialise tree
        SearchTrie root = new SearchTrie();
        SearchTrie current;
        for(String product: products){
            current = root;
            for(Character c: product.toCharArray()){
                if(!current.children.containsKey(c)){
                    current.children.put(c, new SearchTrie());
                }
                if(current.children.get(c).products.size() < 3){
                    current.children.get(c).products.add(product);
                }
                current = current.children.get(c);
            }
        }
        //return products
        List<List<String>> result = new ArrayList<>();

        for(Character c: searchWord.toCharArray()){
            if(root == null){
                result.add(new ArrayList<>());
            }
            if(root.children.containsKey(c)){
                result.add(new ArrayList<>(root.children.get(c).products));
                root = root.children.get(c);
            }
            else{
                result.add(new ArrayList<>());
                root = null;
            }
        }

        return result;
    }

}

class SearchTrie{

    Map<Character, SearchTrie> children = new HashMap<>();
    List<String> products = new ArrayList<>();

}
