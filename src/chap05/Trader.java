package chap05;

public class Trader {

    private String name;
    private String city;

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return String.format("Trader:%s in %s", name, city);
    }
}
