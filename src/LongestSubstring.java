import java.io.InputStreamReader;
import java.util.HashSet;

public class LongestSubstring {
    static int getLongestSubstring(String inputString){
        int start = 0;
        int end = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        while(end < inputString.length()){
            set.add(inputString.charAt(start));
            while(true){
                end++;
                if(end == inputString.length() || set.contains(inputString.charAt(end))){
                    set.remove(inputString.charAt(start));
                    start++;
                    break;
                }
                set.add(inputString.charAt(end));
                max = Math.max(max, set.size());
            }
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(5);
        String s = "abcabc12abd";
        System.out.println(getLongestSubstring(s));
    }
}
