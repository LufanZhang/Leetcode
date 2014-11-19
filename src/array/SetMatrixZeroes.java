package array;
/*
 *  Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.
Follow up:

Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        boolean flagRow = false;
        boolean flagColumn = false;
        if(matrix==null||m==0)
        return;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    if(i==0)
                    flagRow=true;
                    if(j==0)
                    flagColumn = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i=1;i<n;i++){
            if(matrix[0][i]==0){
                for(int j=0;j<m;j++){
                    matrix[j][i] = 0;
                }
            }
        }
        for(int i=1;i<m;i++){
            if(matrix[i][0]==0){
                for(int j=0;j<n;j++){
                    matrix[i][j] = 0;
                }
            }
        }
        if(matrix[0][0]==0){
            if(flagColumn==true){
            for(int i=0;i<m;i++)
            matrix[i][0] = 0;
            }
            if(flagRow==true){
            for(int i=0;i<n;i++)
            matrix[0][i] = 0;
            }
        }
    }
}
