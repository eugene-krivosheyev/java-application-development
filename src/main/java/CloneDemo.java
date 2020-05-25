public class CloneDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep clonedSheep =
                new Sheep(1,"dolly",10).clone();

        System.out.println(
            clonedSheep.getId() +
            clonedSheep.getMessage() +
            clonedSheep.getWoolSize());

        System.out.println(clonedSheep);
    }
}

class Sheep implements Cloneable {
    private int id;
    private String message;
    private int woolSize;
    Sheep[] friends = new Sheep[10];

    public Sheep(int id, String message, int woolSize) {
        this.id = id;
        this.message = message;
        this.woolSize = woolSize;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public int getWoolSize() {
        return woolSize;
    }

    @Override
    public Sheep clone() throws CloneNotSupportedException {
        //this.friends.clone()//
        return (Sheep) super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        //db.clode();
        super.finalize();
    }
}

