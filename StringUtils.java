
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
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
        String[] words = sentence.trim().split(" "); // add trim to remove extra white space around string

        // -----------------------------

        // StringJoiner reversed = new StringJoiner(" "); // use StringJoiner to join
        // String Array with Space/any delimiter

        // for (var i = words.length - 1; i >= 0; i--)
        // reversed.add(words[i]);

        // return reversed.toString();

        // ----------------------------------
        // another way, we can use Collection inbuilt reverse method
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public static boolean areRotations(String str1, String str2) {
        if (str1 == null || str2 == null)
            return false;
        return (str1.length() == str2.length() && (str1 + str1).contains(str2));
        // above concatenation is good for small strings
    }

    public static String removeDuplicates(String str) {
        if (str == null)
            return "";

        StringBuilder output = new StringBuilder();
        Set<Character> seen = new HashSet<>();

        for (var ch : str.toCharArray()) {
            if (!seen.contains(ch)) {
                seen.add(ch);
                output.append(ch);
            }
        }
        return output.toString();

    }

}
