package dynamicProgram;

public class DungeonGame {
	 public int calculateMinimumHP(int[][] dungeon) {
	        if(dungeon == null || dungeon.length == 0){
	            return 1;
	        }
	        int m = dungeon.length;
	        int n = dungeon[0].length;
	        dungeon[m-1][n-1] = Math.max(1,1-dungeon[m-1][n-1]);
	        for(int i=m-1;i>=0;i--){
	            for(int j=n-1;j>=0;j--){
	                if(i == m-1 && j == n-1){
	                    continue;
	                }
	                if(i == m-1){
	                    dungeon[i][j] = Math.max(1,(dungeon[i][j+1]-dungeon[i][j]));
	                }
	                else if(j == n-1){
	                    dungeon[i][j] = Math.max(1,(dungeon[i+1][j]-dungeon[i][j]));
	                }
	                else{
	                    dungeon[i][j] = Math.max(1,Math.min(dungeon[i][j+1],dungeon[i+1][j])-dungeon[i][j]);
	                }
	            }
	        }
	        return dungeon[0][0];
	    }
}
