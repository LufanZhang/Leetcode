
public class Customer implements Runnable{
	private Info info=null;
    public Customer(Info info){
        this.info=info;
    }
     
    public void run(){
        for(int i=0;i<25;++i){
            try{
                Thread.sleep(100);
            }catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(this.info.getName()+"<---->"+this.info.getAge());
        }
    }
}
