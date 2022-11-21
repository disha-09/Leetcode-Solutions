class Solution {
    class Node{
        int row;
        int col;
        int dist;
        Node(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        //Adding the entrance element to Queue and marking as visisted
        q.add(new Node(entrance[0],entrance[1],0));
        visited[entrance[0]][entrance[1]] = true;

        //can set it to any MAX value, here the value will always be less than m*n
        int result = m*n;

        while(!q.isEmpty()){
            Node tmp = q.remove();
            
            //checking if the cell is border cell. 
            //If it is then we will save the distance if is less than result
            //tmp.dist!=0 is because the entrance can also be the border cell and we need to avoid it.
            if((tmp.row == 0 || tmp.row == m - 1 || tmp.col == 0 || tmp.col == n - 1)){
                if(tmp.dist < result && tmp.dist!=0){
                    result = tmp.dist;                    
                }
            }

            //MOVING UP
            if(isValidCell(tmp.row - 1, tmp.col, visited, maze)){
                q.add(new Node(tmp.row - 1, tmp.col, tmp.dist+1));
                visited[tmp.row - 1][tmp.col]=true;
            }

            //MOVING DOWN
            if(isValidCell(tmp.row + 1, tmp.col, visited, maze)){
                q.add(new Node(tmp.row + 1, tmp.col, tmp.dist+1));
                visited[tmp.row + 1][tmp.col]=true;
            }

            //MOVING LEFT
            if(isValidCell(tmp.row, tmp.col - 1, visited, maze)){
                q.add(new Node(tmp.row, tmp.col - 1, tmp.dist+1));
                visited[tmp.row][tmp.col - 1]=true;
            }

            //MOVING RIGHT
            if(isValidCell(tmp.row, tmp.col + 1, visited, maze)){
                q.add(new Node(tmp.row, tmp.col + 1, tmp.dist+1));
                visited[tmp.row][tmp.col + 1]=true;
            }
        }
        return result==m*n?-1:result;
    }

    public boolean isValidCell(int row, int col, boolean[][] visited, char[][] maze){
        if(row >=0 && row < maze.length && col >= 0 && col < maze[0].length 
            && !visited[row][col] && maze[row][col] == '.')
            return true;
        else
            return false;
    }
}