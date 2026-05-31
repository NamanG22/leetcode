package LeetCode.LC2126;

import java.util.Arrays;

public class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long val = mass;
        Arrays.sort(asteroids);
        for(int i=0;i<asteroids.length;i++){
            if(val<asteroids[i]) return false;;
            val+=asteroids[i];
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] asteroids = {3, 9, 19, 5, 21};
        int mass = 10;
        System.out.println(solution.asteroidsDestroyed(mass, asteroids));
    }
}
