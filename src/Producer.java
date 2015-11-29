
public class Producer implements Runnable{
	 private Info info=null;
	 public Producer(Info info){
	        this.info=info;
	 }
	 public void run(){
		 boolean flag = false;
		 for(int i=0;i<25;i++){
		 if(flag == false){
			 flag = true;
			 synchronized(this){
				 try{
					Thread.sleep(100); 
				 }
				 catch(Exception e){
					 e.printStackTrace();
				 }
				 this.info.setNameAndAge("Alice",0);
			 }
		 }
		 else{
			 flag = false;
			 synchronized(this){
				 try{
					Thread.sleep(100); 
				 }
				 catch(Exception e){
					 e.printStackTrace();
				 }
				 this.info.setNameAndAge("Rollen",20);
			 }
		 }
		 }
	 }
}
