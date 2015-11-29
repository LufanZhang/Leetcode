package test;

public class Derived extends Base{
	int y;
//	  Derived(int _x,int _y) {
//	   // super(_x);
//		  
//	    y = _y;
//	  }
//	  Derived(){
//		  System.out.println("constructor of derived class");
//	  }
	  Derived(int x, int y){
		  super(x);
		  //this.x = x;
		  this.y = y;
		  System.out.println("get y");
	  }
	  void display() {
	    System.out.println("x = "+x+", y = "+y);
	  }
}
