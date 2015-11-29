package google;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PathGenerate {

	        public static void main(String[] args){
	                int[][] matrix = new int[10][10];
	                List<Integer> result = new ArrayList<Integer>();
	                if(fill(result, matrix, 0, 0))
	                        System.out.print(result);
	        }

	        static boolean fill(List<Integer> result, int[][] matrix, int i, int j){
	                int [] dx = {0,1,1,1,0,-1,-1,-1};
	                int [] dy = {1,1,0,-1,-1,-1,0,1};
	                if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length || matrix[i][j] != 0)
	                        return false;
	                
	                matrix[i][j] = 1;
	                result.add(matrix[0].length*i+j);
	                if(i == matrix.length-1 && j == matrix[0].length-1)
	                        return true;
	                int [] directions = new int [8];
	                Random randomGenerator = new Random();
	                int count = 0;
	                while(count != 8){
	                        int random = randomGenerator.nextInt(8);
	                        if(directions[random] == 1)
	                                continue;
	                        else{
	                                directions[random] = 1;
	                                count++;
	                                if(fill(result, matrix, i+dx[random], j+dy[random]))
	                                        return true;
	                        }
	                }
	                result.remove(result.size()-1);
	                matrix[i][j] = 0;
	                return false;
	        }
	}

