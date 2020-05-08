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

//        List<String> listStrings = null;
//        listStrings.add(0, null);
//        listStrings.get(0);
//        listStrings.listIterator().previous();
//        listStrings.get(10);

//        Map<String, Cat> cats = null; //new Properties();//new Hashtable<>();
//        cats.keySet();
//        cats.values();
//        cats.entrySet();
//        cats.get("cat1").getName();


        System.out.println("================================");


        //add 2 hashset
        Set<Cat> catss = new HashSet<Cat>(1_000) {{
                add(new Cat("cat1"));
                add(new Cat("cat2"));
                add(new Cat("cat3"));
                add(new Cat("cat4"));
        }};

        //muatble objects 2 hasheste
        Set<Cat> catz = new HashSet<>();
        Cat murik = new Cat("murik");
        catz.add(murik);
        murik.setName("murik2");

        catz.add(new Cat("murik2"));
        catz.forEach(System.out::println);

        //============================================
        Set<Cat> treeCats = new TreeSet<>((cat, t1) -> cat.getName().compareTo(t1.getName()));

        //==============================================
        List<String> listOfStrings = new ArrayList<>(1_000);
        listOfStrings.add("");
        listOfStrings.add("");
        listOfStrings.add("");
        listOfStrings.add("");
        listOfStrings.add("");
        listOfStrings.add("");
        listOfStrings.add("");

        listOfStrings = new LinkedList<>();


        Collections.sort(listOfStrings);
    }
}

class Cat implements Comparable<Cat> {
    private int id;
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

        if (id != cat.id) return false;
        return name != null ? name.equals(cat.name) : cat.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


    @Override
    public int compareTo(Cat cat) {
        return this.getName().compareTo(cat.getName());
    }
}
