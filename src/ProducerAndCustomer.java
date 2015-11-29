
public class ProducerAndCustomer {
	public static void main(String[] args) {
        Info info=new Info();
        Producer pro=new Producer(info);
        Customer con=new Customer(info);
        new Thread(pro).start();
        new Thread(con).start();
    }
}
