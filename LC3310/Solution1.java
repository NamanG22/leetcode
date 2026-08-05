import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution1 {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] callTo = new ArrayList[n];
        List<Integer>[] calledFrom = new ArrayList[n];
        boolean suspiciousArr[] = new boolean[n+1];
        List<Integer> remainingNodes = new ArrayList<>();
        boolean flag = false;
        suspiciousArr[k] = true;
        for(int i=0;i<n;i++){
            callTo[i] = new ArrayList<>();
            calledFrom[i] = new ArrayList<>();
        }
        for(int i=0;i<invocations.length;i++){
            callTo[invocations[i][0]].add(invocations[i][1]);
            calledFrom[invocations[i][1]].add(invocations[i][0]);
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(k);
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int i:callTo[curr]){
                if(!suspiciousArr[i]){
                    suspiciousArr[i]=true;
                    q.offer(i);
                }
            }
        }

        q:for(int i=0;i<n;i++){
            if(!suspiciousArr[i]) continue;
            for(int j:calledFrom[i]){
                if(!suspiciousArr[j]){
                    flag = true;
                    break q;
                }
            }
        }
        if(!flag){
            for(int i=0;i<n;i++){
                if(!suspiciousArr[i]) remainingNodes.add(i);
            }
        }
        else{
            for(int i=0;i<n;i++){
                remainingNodes.add(i);
            }
        }
        return remainingNodes;
    }
}
