
public class App {
    public static void main(String[] args) throws Exception {
     var trie = new Trie();

     trie.insert("care");
     trie.insert("car");
     trie.insert("card");
     trie.insert("carefull");

     var words = trie.findWords("carg");

     System.out.println(words);



    }
}
