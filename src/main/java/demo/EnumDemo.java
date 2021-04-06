package demo;

public class EnumDemo {
    public static void main(String[] args) {
        SeverityEnum sev1 = SeverityEnum.ERROR;
        switch (sev1) {
            case ERROR:
            case WARNING:
        }

        SeverityClass sev2 = SeverityClass.ERROR;

        SeverityEnum.values();
        SeverityEnum.valueOf("ERROR");

        SeverityEnum.ERROR.ordinal();
        SeverityEnum.ERROR.name();
    }
}

/**
 * java.lang.Enum
 */
enum SeverityEnum {
    ERROR(1000), WARNING(2000);

    private int any;

    SeverityEnum(int any) {
        this.any = any;
    }

    public int getAny() {
        return any;
    }
}

final class SeverityClass {
    public static final SeverityClass ERROR = new SeverityClass(0);
    public static final SeverityClass WARNING = new SeverityClass(1);

    private int ordinal;

    private SeverityClass(int ordinal) {
        this.ordinal = ordinal;
    }

    public int getOrdinal() {
        return ordinal;
    }
}
