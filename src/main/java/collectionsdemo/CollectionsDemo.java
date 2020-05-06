package collectionsdemo;

import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {

        Collection<String> strings = new ArrayList<>();//new Vector();
        strings.add("a");
//
//        Iterator<String> it;
//        for(it = strings.iterator(); it.hasNext(); ;) {
//            it.next();
//        }
//
        for (String current : strings) {

        }

        Set<String> setStrings = new HashSet<>(); // TreeSet();
        setStrings.add("a");
        setStrings.add("a");

        List<String> listStrings = null;
        listStrings.add(0, null);
        listStrings.get(0);
//        listStrings.listIterator().previous();
        listStrings.get(10);

        Map<String, Cat> cats = null; //new Properties();//new Hashtable<>();
        cats.keySet();
        cats.values();
        cats.entrySet();
        cats.get("cat1").getName();
    }
}

class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(name, cat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
