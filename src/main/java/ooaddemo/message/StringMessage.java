package ooaddemo.message;

import java.util.Objects;

/**
 * Record = immutable POJO
 */
public class StringMessage implements DecoratingMessage {
    private final String body;

    public StringMessage(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringMessage that = (StringMessage) o;
        return Objects.equals(getBody(), that.getBody());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBody());
    }

    @Override
    public String toString() {
        return "StringMessage{" +
                "body='" + body + '\'' +
                '}';
    }

    /**
     * JavaBeans -> POJO
     * OCP
     */
    public String getBody() {
        return body;
    }

    @Override
    public String getDecoratedMessage() {
        return "string: " + body;
    }
}
