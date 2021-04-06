package demo;

import java.io.Serializable;

class EncapsulationDemo {
    /**
     * Тут индус
     */
    public static void main(String[] args) {
        final DataClass object = new DataClass();
        //object.field = 0;
        object.setField(0);
        object.getField();
    }
}

/**
 * тут мы
 */
class DataClass { //OCP
    private int field; //consistency

    public int getField() { //JavaBeans -> POJO
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }
}

class Lady {
    public int getAge() {
        return 18;
    }
}