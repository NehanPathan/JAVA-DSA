
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;
import java.util.StringJoiner;

public class StringUtils {
    public static int countVowels(String str) {
        if (str == null)
            return 0;

        int count = 0;
        String vowels = "aeiou"; // you can also use set to store

        for (var ch : str.toLowerCase().toCharArray())
            // if (vowels.contains(Character.toString(ch)))
            if (vowels.indexOf(ch) != -1)
                count++;
        return count;

    }

    public static String reverse(String str) {
        if (str == null)
            return "";
        // Stack<Character> stack = new Stack<>(); one way
        // another way where we use StringBuilder and So that easily append new ch in
        // string and loop from endIndex

        StringBuilder reversed = new StringBuilder();

        for (var i = str.length() - 1; i >= 0; i--)
            reversed.append(str.charAt(i));

        return reversed.toString();

    }

    public static String reverseWords(String sentence) {
        if (sentence == null)
            return "";
        String[] words = sentence.split(" ");

        //-----------------------------

        // StringJoiner reversed = new StringJoiner(" "); // use StringJoiner to join
        // String Array with Space/any delimiter

        // for (var i = words.length - 1; i >= 0; i--)
        // reversed.add(words[i]);

        // return reversed.toString();

        //----------------------------------
        // another way, we can use Collection inbuilt reverse method
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

}
