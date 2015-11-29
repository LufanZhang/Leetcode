package array;

public class RectangleArea {
	 public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
	        int up = Math.min(D,H);
	        int down = Math.max(F,B);
	        int left = Math.max(A,E);
	        int right = Math.min(C,G);
	        System.out.println("up="+up+"  down="+down+"  left"+left+"  right="+right);
	        long intersection = 0;
	        if(up > down && right > left){
	            intersection  = (up - down) * (right - left);
	        }
	        long area1 = (D-B)*(C-A);
	        long area2 = (H-F)*(G-E);
	        return (int)(area1 + area2 - intersection);
	    }
	 public static void main(String args[]){
		 int A = -1500000001;
		 int B = 0;
		 int C = -1500000000;
		 int D = 1;
		 int E = 1500000000;
		 int F = 0;
		 int G = 1500000001;
		 int H =1;
		 int res = computeArea(A,B,C,D,E,F,G,H);
	 } 
}
