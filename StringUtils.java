
import java.util.Stack;

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

}
