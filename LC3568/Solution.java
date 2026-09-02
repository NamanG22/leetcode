import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int startx = 0;
        int starty = 0;
        int toClean = 0;
        int litter[][] = new int[m][n];
        int k = 0;
        for(int i=0;i<classroom.length;i++){
            for(int j=0;j<classroom[0].length();j++){
                if(classroom[i].charAt(j)=='S'){
                    startx = i;
                    starty = j;
                }
                else if(classroom[i].charAt(j)=='L'){
                    litter[i][j] = k++;
                    toClean++;
                }
            }
        }
        if(toClean==0) return 0;
        Queue<int[]> queue = new LinkedList<int[]>();
        int mask = 0;
        queue.offer(new int[]{startx, starty, energy, mask});
        queue.offer(null);
        boolean[][][][] visited = new boolean[classroom.length][classroom[0].length()][energy+1][2047];
        visited[startx][starty][energy][0] = true;
        int steps = 0;
        int res = Integer.MAX_VALUE;
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()){
            if(queue.peek()==null){
                queue.poll();
                if(queue.isEmpty()) break;
                steps++;
                queue.offer(null);
                continue;
            }
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int currEnergy = cur[2];
            int currMask = cur[3];
            if(classroom[x].charAt(y)=='L'){
                int index = litter[x][y];
                currMask |= 1 << index;
            }
            if(currMask==(1<<(toClean))-1){  // all Lpos are cleaned
                res = Math.min(res, steps);
                continue;
            }
            if(classroom[x].charAt(y)=='R'){
                currEnergy = energy;
            }
            if(currEnergy<=0) continue;
            for(int[] dir : directions){
                int nx = x + dir[0];
                int ny = y + dir[1];
                if(nx<0 || nx>=classroom.length || ny<0 || ny>=classroom[0].length() || classroom[nx].charAt(ny)=='X') continue;
                if(visited[nx][ny][currEnergy][currMask]) continue;
                visited[nx][ny][currEnergy][currMask] = true;
                if(classroom[nx].charAt(ny)=='S' || classroom[nx].charAt(ny)=='.'){
                    for(int i=0;i<currEnergy;i++){
                        visited[nx][ny][i][currMask] = true;
                    }
                }
                queue.offer(new int[]{nx, ny, currEnergy-1, currMask});
            }
        }
        return res>=10000?-1:res;
    }
}
