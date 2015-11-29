package test;

class Outer {
	public void doSomething(){
		final int a =10;
		class Inner{
			public void seeOuter(){
				System.out.println(a);
			}
		}
		Inner in = new Inner();
		in.seeOuter();
	}
	public static void main(String[] args) {
		Outer out = new Outer();
		out.doSomething();
	}
}
