package demo.streamapi;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.nio.file.Paths.get;
import static java.util.Comparator.reverseOrder;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static org.junit.Assert.assertEquals;

public class AggregationAnalyzerTest {
    @Test
    public void shouldGetTop4IpsByItsConsumptionSum() throws IOException {
        List<String> aggregatedSortedTop4Ips =
                Files.lines(get("target/test-classes/stream-api-test-data.log"))
                    .map(this::parseLineToRecord)
                    .collect(toMap(Record::getIp, Record::getConsumption, Integer::sum))
                        .entrySet().stream()
                        .sorted(comparingByValue(reverseOrder()))
                        .map(Map.Entry::getKey)
                        .limit(4)
                            .collect(toList());

        assertEquals("[4.4.4.4, 6.6.6.6, 5.5.5.5, 3.3.3.3]", aggregatedSortedTop4Ips.toString());
    }

    private Record parseLineToRecord(String line) {
        String[] parts = line.split(" ");
        return new Record(parts[0], Integer.parseInt(parts[1]));
    }
}

class Record {
    private final String ip;
    private final Integer consumption;

    public Record(String ip, Integer consumption) {
        this.ip = ip;
        this.consumption = consumption;
    }

    public String getIp() {
        return ip;
    }

    public Integer getConsumption() {
        return consumption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return getIp().equals(record.getIp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIp());
    }
}