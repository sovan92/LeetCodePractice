
## Color Island DFS Java

```java
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i =0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    colorIsland(grid, i, j);
                }
            }
        }

        return count;

    }
    public void colorIsland(char[][] grid , int row, int colm){
        
        int[][] deltaMatrix = getDeltaMatrix();
        
        if(grid[row][colm]=='1'){
            grid[row][colm] = '0';
        }
        else{
            return;
        }

        int rowMin = 0;
        int colMin = 0;
        int rowMax = grid.length-1;
        int colMax = grid[0].length-1;
        for(int i =0;i < deltaMatrix.length;i++){
            int nextRow = row+deltaMatrix[i][0];
            int nextCol = colm+deltaMatrix[i][1];

            if(nextRow>=rowMin && nextRow<=rowMax && nextCol>=colMin && nextCol<=colMax && grid[nextRow][nextCol]=='1'){
                colorIsland(grid, nextRow, nextCol);
            }

        }
    }
    public int[][] getDeltaMatrix(){

        int [][] deltaMatrix = new int[4][];
        
        deltaMatrix[0] = new int[]{0, 1};
        deltaMatrix[1] = new int[]{1, 0};
        deltaMatrix[2] = new int[]{0, -1};
        deltaMatrix[3] = new int[]{-1, 0};

        return deltaMatrix;

    }
}
```
## Color Island BFS Java

```java

class Solution {
    public int numIslands(char[][] grid) {
        
        int count = 0;

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for(int i = 0;i < grid.length;i++){
            for(int j = 0; j < grid[0].length;j++){

                if(grid[i][j]=='1'){
                    count++;
                    bfsFloodFill(i, j, grid, dir);
                }
            }
        }
        return count;

    }

    public void bfsFloodFill(int row, int col , char [][] grid , int [][] directions){

       if(grid[row][col] == '0'){
            return;
        }
        int [] row_col = new int[]{row, col};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(row_col);
        int [] curr = null;
        int [] next = null;
        grid[row_col[0]][row_col[1]] = '0';
        while(!queue.isEmpty()){
            curr = queue.poll();
            grid[curr[0]][curr[1]] = '0';

            for(int i = 0;i < 4;i++){

                int nextRow = curr[0]+ directions[i][0];
                int nextCol = curr[1] + directions[i][1];

                if(nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length && grid[nextRow][nextCol]== '1'){
                    next = new int[]{nextRow, nextCol};
                    grid[next[0]][next[1]] = '0';
                    queue.offer(next);
                }

            }

        }


    }

}
```


