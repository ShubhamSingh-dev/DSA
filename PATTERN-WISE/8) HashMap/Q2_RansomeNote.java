import java.util.HashMap;

public class Q2_RansomeNote {
    public boolean canConstruct_using2maps(String ransomNote, String magazine) {
        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> have = new HashMap<>();

        //count ransomeNote
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        //count magazine
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            have.put(c, have.getOrDefault(c, 0) + 1);
        }

        //compare freq
        for(char c : need.keySet()){
            if(have.getOrDefault(c, 0) < need.get(c)){
                return false;
            }
        }

        return true;
    }

    public boolean canConstruct_using1map(String ransomNote, String magazine) {
        HashMap<Character,Integer> map = new HashMap<>();

        // Step 1: Count magazine characters
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //check ransomnote
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);

            if(!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }
            
            map.put(c, map.get(c) - 1);
        }

        return true;
    }

    //FASTER APPROACH:
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];

        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (count[c - 'a'] == 0) return false;
            count[c - 'a']--;
        }

        return true;
    }

}
