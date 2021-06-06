package stream;

import before.DummyPagedDataSource;
import org.junit.jupiter.api.Test;

class StreamDataSourceConsumerTest {

    @Test
    void consume() {
        DummyPagedDataSource pagedDataSource = new DummyPagedDataSource();
        StreamDataSourceConsumer consumer = new StreamDataSourceConsumer(new StreamDataSourceImpl(pagedDataSource));
        consumer.consume();
        System.out.println(pagedDataSource.getRequests());
    }

}