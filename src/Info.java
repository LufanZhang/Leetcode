
public class Info {
	public String getName() {
        return name;
    }
 
 
    public int getAge() {
        return age;
    }
    public synchronized void setNameAndAge(String name,int age) {
        this.name = name;
        this.age = age;
    }
 
    private String name = "Rollen";
    private int age = 20;
}
