import java.util.Map;

public class Word_Pattern {
    public boolean wordPattern(String pattern, String s) {
            Map<Character, String> char_map = (Map<Character, String>) new HashMap();
            Map<String,Character> word_map = (Map<String, Character>) new HashMap();
            int n = pattern.length();
            int i=0;
            String[] words = s.split(" ");
            if(n != words.length)
                return false;
            
            while(i < n)
            {
                char c = pattern.charAt(i);
                String word = words[i];
                if(char_map.containsKey(c) != word_map.containsKey(word))
                    return false;
                if(char_map.containsKey(c))
                {
                    if((word_map.get(word) != c) || !(char_map.get(c).equals(word)))
                        return false;
                }else{
                    char_map.put(c,word);
                    word_map.put(word,c);
                }
                i++;
            }
            return i==n;
        }
    }

