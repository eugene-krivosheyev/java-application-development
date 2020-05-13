package streamapidemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static java.nio.file.Files.lines;
import static java.nio.file.Files.readAllLines;
import static java.nio.file.Paths.get;
import static java.util.Comparator.reverseOrder;
import static java.util.Map.Entry.comparingByValue;

public class Top3TrafficConsumersReport {
    public static void main(String[] args) throws IOException {
        Map<String,Integer> trafficConsumers = new HashMap();

        List<String> lines = readAllLines(get("target/test-classes/stream-api-test-data.log"));
        for (String currentLine : lines) {
            //todo
        }

        lines(get("target/test-classes/stream-api-test-data.log"))
                .map(lineInFile -> lineInFile.split(" "))
                .map(parsedLineInFile -> new Record(parsedLineInFile[0], parseInt(parsedLineInFile[1])))
                .collect(Collectors.toMap(
                        Record::getIp,
                        Record::getTraffic,
                        Integer::sum))
                    .entrySet().parallelStream()
                    .sorted(comparingByValue(reverseOrder()))
                    .limit(2)
                    .forEach(System.out::println);

    }
}

class Record {
    private String ip;
    private Integer traffic;

    public Record(String ip, Integer traffic) {
        this.ip = ip;
        this.traffic = traffic;
    }

    public String getIp() {
        return ip;
    }

    public Integer getTraffic() {
        return traffic;
    }
}