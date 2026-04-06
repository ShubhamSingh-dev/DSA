import java.util.HashMap;

public class Q3_MaxBallons {
    public int maxNumberOfBalloons_2maps(String text) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> have = new HashMap<>();

        // Step 1: Build "need" map for "balloon"
        String target = "balloon";
        for(char c : target.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // Step 2: Build "have" map from input
        for (char c : text.toCharArray()) {
            have.put(c, have.getOrDefault(c, 0) + 1);
        }

        int result = Integer.MAX_VALUE;

        for(char c : need.keySet()){
            int available = have.getOrDefault(c, 0);
            int required = need.get(c);

            result = Math.min(result, available / required);
        }

        return result;
    }

    public int maxNumberOfBalloons_1maps(String text) {
        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency of each character
        for (char c : text.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Calculate how many "balloon" we can form
        int b = map.getOrDefault('b', 0);
        int a = map.getOrDefault('a', 0);
        int l = map.getOrDefault('l', 0) / 2;
        int o = map.getOrDefault('o', 0) / 2;
        int n = map.getOrDefault('n', 0);

        return Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
        
    }

    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];
        
        // Count frequency
        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }
        
        // Extract required counts
        int b = count['b' - 'a'];
        int a = count['a' - 'a'];
        int l = count['l' - 'a'] / 2;
        int o = count['o' - 'a'] / 2;
        int n = count['n' - 'a'];
        
        // Return minimum
        return Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
        
    }


}