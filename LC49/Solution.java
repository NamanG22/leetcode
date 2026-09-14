import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ll = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char ch[] = strs[i].toCharArray();
            Arrays.sort(ch);
            String toSearch = new String(ch);
            if(!map.containsKey(toSearch)){
                ll.add(new ArrayList<>());
                map.put(toSearch,ll.size()-1);
            }
            ll.get(map.get(toSearch)).add(strs[i]);
        }
        return ll;
    }
}
