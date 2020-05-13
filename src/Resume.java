public class Resume {
    private int uuid;
    private String name;
    private int age;
    public Resume (int uuid, String name, int age){
        this.uuid = uuid;
        this.name = name;
        this.age = age;
    }
    public String toString()
    {
        return uuid + " " + name + " " + age;
    }
}
