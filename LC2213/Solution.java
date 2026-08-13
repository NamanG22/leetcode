import java.util.Arrays;
import java.util.TreeMap;

public class Solution {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int k = queryIndices.length;
        int lengths[] = new int[k];
        TreeMap<Integer,Integer> freqMap = new TreeMap<>();
        TreeMap<Integer,Integer> startCountMap = new TreeMap<>();
        char ch[] = s.toCharArray();
        for(int i=0;i<s.length();){
            int count = 1;
            int j = i+1;
            while(j<s.length()){
                if(s.charAt(j)==s.charAt(i)) count++;
                else break;
                j++;
            }
            freqMap.put(count,freqMap.getOrDefault(count,0)+1);
            startCountMap.put(i,count);
            i = j;
        }
        // System.out.println("ch: "+Arrays.toString(ch));
        // System.out.println("freqMap: "+freqMap);
        // System.out.println("startCountMap: "+startCountMap);
        for(int i=0;i<k;i++){
            int indexToChange = queryIndices[i];
            if(ch[indexToChange]!=queryCharacters.charAt(i)){
                if(indexToChange==0){
                    // System.out.println(1);
                    if(ch.length>1){
                        if(ch[indexToChange]==ch[indexToChange+1]){
                            // System.out.println(11);
                            // aa -> ba
                            int count = startCountMap.get(0);
                            freqMap.put(count,freqMap.get(count)-1);
                            if(freqMap.get(count)==0) freqMap.remove(count);
                            startCountMap.put(1,count-1);
                            startCountMap.put(0,1);
                            freqMap.put(count-1,freqMap.getOrDefault(count-1,0)+1);
                            freqMap.put(1,freqMap.getOrDefault(1,0)+1);
                        }
                        else if(queryCharacters.charAt(i)==ch[indexToChange+1]){
                            // System.out.println(12);
                            // ab -> bb
                            int count = startCountMap.get(indexToChange+1);
                            freqMap.put(count,freqMap.get(count)-1);
                            if(freqMap.get(count)==0) freqMap.remove(count);
                            freqMap.put(1,freqMap.get(1)-1);
                            if(freqMap.get(1)==0) freqMap.remove(1);
                            freqMap.put(count+1,freqMap.getOrDefault(count+1,0)+1);
                            startCountMap.put(indexToChange,startCountMap.get(indexToChange+1)+1);
                            startCountMap.remove(indexToChange+1);
                        } 
                    }
                }
                else if(indexToChange==ch.length-1){
                    // System.out.println(2);
                    if(ch[indexToChange]==ch[indexToChange-1]){
                        // System.out.println(21);
                        // aa -> ab
                        int start = startCountMap.lastEntry().getKey();
                        int count = startCountMap.get(start);
                        freqMap.put(count,freqMap.get(count)-1);
                        if(freqMap.get(count)==0) freqMap.remove(count);
                        startCountMap.put(indexToChange,1);
                        startCountMap.put(start,count-1);
                        freqMap.put(count-1,freqMap.getOrDefault(count-1,0)+1);
                        freqMap.put(1,freqMap.getOrDefault(1,0)+1);
                    }
                    else if(queryCharacters.charAt(i)==ch[indexToChange-1]){
                        // System.out.println(22);
                        // ab -> aa
                        startCountMap.remove(ch.length-1);
                        int start = startCountMap.lastEntry().getKey();
                        int count = startCountMap.get(start);
                        startCountMap.put(start,count+1);
                        freqMap.put(1,freqMap.get(1)-1);
                        if(freqMap.get(1)==0) freqMap.remove(1);
                        freqMap.put(count,freqMap.get(count)-1);
                        if(freqMap.get(count)==0) freqMap.remove(count);
                        freqMap.put(count+1,freqMap.getOrDefault(count+1,0)+1);
                    } 
                }
                else{
                    if(ch[indexToChange]==ch[indexToChange-1]){
                        // System.out.println(31);
                        if(ch[indexToChange]==ch[indexToChange+1]){
                            // System.out.println(311);
                            //aaa -> aba
                            int start = startCountMap.lowerEntry(indexToChange).getKey();
                            int count = startCountMap.get(start);
                            startCountMap.put(start,indexToChange-start);
                            startCountMap.put(indexToChange+1,count-indexToChange+start-1);
                            startCountMap.put(indexToChange,1);
                            freqMap.put(indexToChange-start,freqMap.getOrDefault(indexToChange-start,0)+1);
                            freqMap.put(count-indexToChange+start-1,freqMap.getOrDefault(count-indexToChange+start-1,0)+1);
                            freqMap.put(count,freqMap.get(count)-1);
                            if(freqMap.get(count)==0) freqMap.remove(count);
                            freqMap.put(1,freqMap.getOrDefault(1,0)+1);
                        }
                        else if(queryCharacters.charAt(i)==ch[indexToChange+1]){
                            // System.out.println(312);
                            //aab -> abb
                            int start = startCountMap.lowerEntry(indexToChange).getKey();
                            int count = startCountMap.get(start);
                            int count2 = startCountMap.get(indexToChange+1);
                            startCountMap.put(start,count-1);
                            startCountMap.remove(indexToChange+1);
                            startCountMap.put(indexToChange,count2+1);
                            freqMap.put(count-1,freqMap.getOrDefault(count-1,0)+1);
                            freqMap.put(count,freqMap.get(count)-1);
                            if(freqMap.get(count)==0) freqMap.remove(count);
                            freqMap.put(count2+1,freqMap.getOrDefault(count2+1,0)+1);
                            freqMap.put(count2,freqMap.get(count2)-1);
                            if(freqMap.get(count2)==0) freqMap.remove(count2);
                        }
                        else{
                            // System.out.println(313);
                            //aab -> acb
                            int start = startCountMap.lowerEntry(indexToChange).getKey();
                            int count = startCountMap.get(start);
                            startCountMap.put(start,count-1);
                            startCountMap.put(indexToChange,1);
                            freqMap.put(count-1,freqMap.getOrDefault(count-1,0)+1);
                            freqMap.put(count,freqMap.get(count)-1);
                            if(freqMap.get(count)==0) freqMap.remove(count);
                            freqMap.put(1,freqMap.getOrDefault(1,0)+1);
                        }
                    }
                    else if(ch[indexToChange]==ch[indexToChange+1]){
                        // System.out.println(32);
                        if(queryCharacters.charAt(i)==ch[indexToChange-1]){
                            // System.out.println(321);
                            //abb -> aab
                            int start = startCountMap.lowerEntry(indexToChange).getKey();
                            int count = startCountMap.get(start);
                            int count2 = startCountMap.get(indexToChange);
                            startCountMap.put(start,count+1);
                            startCountMap.remove(indexToChange);
                            startCountMap.put(indexToChange+1,count2-1);
                            freqMap.put(count+1,freqMap.getOrDefault(count+1,0)+1);
                            freqMap.put(count,freqMap.get(count)-1);
                            if(freqMap.get(count)==0) freqMap.remove(count);
                            freqMap.put(count2,freqMap.get(count2)-1);
                            if(freqMap.get(count2)==0) freqMap.remove(count2);
                            freqMap.put(startCountMap.get(indexToChange+1),freqMap.getOrDefault(startCountMap.get(indexToChange+1),0)+1);
                        }
                        else{
                            // System.out.println(322);
                            //abb -> acb
                            int count = startCountMap.get(indexToChange);
                            int start = indexToChange;
                            startCountMap.put(start+1,count-1);
                            startCountMap.put(start,1);
                            freqMap.put(count-1,freqMap.getOrDefault(count-1,0)+1);
                            freqMap.put(count,freqMap.get(count)-1);
                            if(freqMap.get(count)==0) freqMap.remove(count);
                            freqMap.put(1,freqMap.getOrDefault(1,0)+1);
                        }
                    }
                    else if(ch[indexToChange-1]==ch[indexToChange+1]){
                        // System.out.println(33);
                        if(queryCharacters.charAt(i)==ch[indexToChange-1]){
                            //aba -> aaa
                            int start = startCountMap.lowerEntry(indexToChange).getKey();
                            int count1 = startCountMap.get(start);
                            int count2 = startCountMap.get(indexToChange+1);
                            startCountMap.put(start,count1+count2+1);
                            startCountMap.remove(indexToChange);
                            startCountMap.remove(indexToChange+1);
                            freqMap.put(count2,freqMap.get(count2)-1);
                            freqMap.put(count1,freqMap.get(count1)-1);
                            if(freqMap.get(count1)==0) freqMap.remove(count1);
                            if(freqMap.containsKey(count2) && freqMap.get(count2)==0) freqMap.remove(count2);
                            freqMap.put(count1+count2+1,freqMap.getOrDefault(count1+count2+1,0)+1);
                            freqMap.put(1,freqMap.get(1)-1);
                            if(freqMap.get(1)==0) freqMap.remove(1);
                        }
                    }
                    else{
                        // System.out.println(34);
                        if(queryCharacters.charAt(i)==ch[indexToChange-1]){
                            // System.out.println(341);
                            //abc -> aac
                            int start = startCountMap.lowerEntry(indexToChange).getKey();
                            int count = startCountMap.get(start);
                            startCountMap.put(start,count+1);
                            startCountMap.remove(indexToChange);
                            freqMap.put(count+1,freqMap.getOrDefault(count+1,0)+1);
                            freqMap.put(count,freqMap.get(count)-1);
                            if(freqMap.get(count)==0) freqMap.remove(count);
                            freqMap.put(1,freqMap.get(1)-1);
                            if(freqMap.get(1)==0) freqMap.remove(1);
                        }
                        else if(queryCharacters.charAt(i)==ch[indexToChange+1]){
                            // System.out.println(342);
                            //abc -> acc
                            int count = startCountMap.get(indexToChange+1);
                            int start = indexToChange+1;
                            startCountMap.remove(start);
                            startCountMap.put(indexToChange,count+1);
                            freqMap.put(count+1,freqMap.getOrDefault(count+1,0)+1);
                            freqMap.put(count,freqMap.get(count)-1);
                            freqMap.put(1,freqMap.get(1)-1);
                            if(freqMap.get(1)==0) freqMap.remove(1);
                        }
                    }
                }
            }
            ch[indexToChange] = queryCharacters.charAt(i);
            lengths[i] = freqMap.lastEntry().getKey();
            // System.out.println(Arrays.toString(ch));
            // System.out.println("freqMap: "+freqMap);
            // System.out.println("startCountMap: "+startCountMap);
        }
        return lengths;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        // System.out.println(Arrays.toString(solution.longestRepeating("babacc", "bcb", new int[]{1,3,3})));
        // System.out.println(Arrays.toString(solution.longestRepeating("abyzz", "aa", new int[]{2,1})));
        // System.out.println(Arrays.toString(solution.longestRepeating("mm", "bfviuwsr", new int[]{0,0,1,0,0,1,1,0})));
        // System.out.println(Arrays.toString(solution.longestRepeating("d", "voeleb", new int[]{0,0,0,0,0,0})));
        System.out.println(Arrays.toString(solution.longestRepeating("aabaa", "a", new int[]{2})));
        // System.out.println(Arrays.toString(solution.longestRepeating("geuqjmt", "bgemoegklm", new int[]{3,4,2,6,5,6,5,4,3,2})));
        // System.out.println(Arrays.toString(solution.longestRepeating("exjwgrh", "qreuu", new int[]{5,4,0,1,5})));
        // System.out.println(Arrays.toString(solution.longestRepeating("rhligdsofdobfhtbpmwjloajbujaeszafevhwokqbye", "yuzhjlvvzeipohsaywjcsrlxwroivincjceyeaxxdtffhslswschsqfpdgvkaledlesu", new int[]{4,23,41,21,21,18,23,40,35,32,21,22,31,24,32,32,8,29,25,33,26,23,41,21,9,2,15,5,3,1,27,22,7,8,2,35,23,7,19,40,20,4,29,11,23,25,32,1,42,42,1,0,35,29,11,4,41,17,41,2,1,10,3,15,25,1,27,36})));
        // System.out.println(Arrays.toString(solution.longestRepeating("rhligdsofdobfhtbpmwjloajbujaeszafevhwokqbye", "yuzhjlvvzeipohsaywjcsrlxwroivincjceyeaxxdtffhslswschsqfpdgvkaledlesu", new int[]{4,23,41,21,21,18,23,40,35,32,21,22,31,24,32,32,8,29,25,33,26,23,41,21,9,2,15,5,3,1,27,22,7,8,2,35,23,7,19,40,20,4,29,11,23,25,32,1,42,42,1,0,35,29,11,4,41,17,41,2,1,10,3,15,25,1,27,36})));
        // System.out.println(Arrays.toString(solution.longestRepeating("iiiiiccmmmmmmmmggghhhhhhhbbzzzzzzztttaaaagggcccccccccccccckkkkkkkfuuuuuuuuiiiiiiiqqqqqwwwwwwwddddrvvvvttttttttkkkkkkfffddmmmmmxxxxxxxxmmmmmeeeeeefffssssssissxddddddpppppppzzzccnzzzxxxxxxxrrrrmmpppvvvvvvuuuuuuussssssssyyyynnnnnnnnffffoovvvvvvvvqqqqqqqkkkdddddddkppppppt", "gbbbbbbbbbbbbbbbbqccccccccccddddddddddddddddddddooooooooooooooggggggggggggggffffffffffffffffffffgggggggggggggggghhhiiiiiwwwwwwbbbbbbbbbbbbbbbbbbbbbbbbzzzz", new int[]{130,69,76,73,71,67,81,70,74,68,75,72,78,82,80,79,77,225,222,217,215,218,219,224,221,220,216,223,117,115,129,127,121,134,124,122,123,131,128,118,116,126,130,133,120,125,119,132,195,196,184,190,193,186,189,188,187,183,191,192,185,194,93,96,95,99,89,88,97,87,90,92,98,94,86,91,95,97,101,88,106,105,90,102,96,104,94,87,99,100,91,103,92,89,98,93,89,92,91,81,84,79,85,93,87,82,90,78,83,86,80,88,81,83,82,74,75,73,72,71,206,208,210,205,207,209,135,118,119,127,129,128,122,136,117,123,134,126,120,133,125,115,132,116,131,137,114,124,121,130,142,143,140,147})));
    }
}
