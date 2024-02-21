import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {

    public char findFirstNonRepeatedChar(String str) {
        Map<Character, Integer> charMap = new HashMap<>();

        var charArray = str.toCharArray();
        for( var ch: charArray ){
            var count = charMap.containsKey(ch) ? charMap.get(ch) : 0;
            charMap.put(ch, count + 1);
        }
        for( var ch: charArray){
            if(charMap.get(ch) == 1)
            return ch;
        }
     return Character.MIN_VALUE;
        
    };

    public char findFirstRepeatedChar(String str) {
        Set<Character> charSet = new HashSet<>();

        var charArray = str.toCharArray();
        for( var ch: charArray ){
            if(charSet.contains(ch))
            return ch;
            charSet.add(ch);
        }
     return Character.MIN_VALUE;
        
    };

}