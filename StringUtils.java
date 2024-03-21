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
}
