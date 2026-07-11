import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        boolean arr[] = new boolean[n];
        List<Integer> ll[] = new ArrayList[n];
        Arrays.setAll(ll,l->new ArrayList<>());
        int res = 0;
        for(int i=0;i<edges.length;i++){
            ll[edges[i][0]].add(edges[i][1]);
            ll[edges[i][1]].add(edges[i][0]);
        }
        for(int i=0;i<n;i++){
            if(!arr[i]){
                int vertices = 0;
                int degreeSum = 0;
                Queue<Integer> q = new ArrayDeque<>();
                q.offer(i);
                arr[i] = true;
                while(!q.isEmpty()){
                    int curr = q.poll();
                    vertices++;
                    List<Integer> neighbors = ll[curr];
                    degreeSum+=neighbors.size();
                    for(int j:neighbors){
                        if(!arr[j]){
                            arr[j] = true;
                            q.offer(j);
                        }
                    }
                }
                if((vertices*(vertices-1))==degreeSum) res++;
            }
        }
        return res;
    }
}
