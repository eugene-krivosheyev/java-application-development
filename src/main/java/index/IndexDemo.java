package index;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Collectors;

public class IndexDemo {
    public static void main(String[] args) throws IOException {
        compile Patern

        Files.lines(Paths.get("data.txt"))
            .map(line -> parseRecord(line))
            .collect(Collectors.toMap(Record::equals, Math::sum))

                .entrySet().stream()
            .sorted((e1,e2) -> e1.getValue() > e2.getValue())
            .map(e -> e.getKey())
            .limit(10)
        .forEach(System.out::println);
    }


    private static Recored parseRecord(String line) {
        PAtern, MAthcher
        return new Record(1, line.substring(3))
    }
}

class Record {
    private Integer i;
    private String s;

    public Record(Integer i, String s) {
        this.i = i;
        this.s = s;
    }

    public Integer getI() {
        return i;
    }

    public String getS() {
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return Objects.equals(getI(), record.getI());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getI());
    }
}