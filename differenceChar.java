import java.util.HashMap;
public class differenceChar {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        System.out.println("Not present element is : "+findTheDifference(s,t));
    }

    public static char findTheDifference(String s, String t) {
        HashMap<Character, Integer> hmap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (hmap.containsKey(key))
                hmap.put(key, hmap.get(key) + 1);
            
            else hmap.put(key, 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            if (!hmap.containsKey(key))
                return key;
            
            else if (hmap.get(key) == 0)
                return key;
            // for this condition
                //Input:
                        // "a"
                        // "aa"
                //Output: "n"         
            else hmap.put(key, hmap.get(key) - 1);
        }
        return 'n';
       
    }
}
