package bean;

public class Group {
    private final String name;
    private int counter;

    public Group(String name) {
        this.name = name;
        counter = 0;
    }

    public String getName() {
        return name;
    }

    public int getCounter() {
        return counter;
    }

    public void inc() {
        counter++;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", counter=" + getCounter() +
                '}';
    }
}
