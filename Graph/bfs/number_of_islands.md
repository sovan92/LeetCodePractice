
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
