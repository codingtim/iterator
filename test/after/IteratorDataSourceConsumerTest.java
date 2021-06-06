package after;

import before.DummyPagedDataSource;
import org.junit.jupiter.api.Test;

class IteratorDataSourceConsumerTest {

    @Test
    void consume() {
        DummyPagedDataSource pagedDataSource = new DummyPagedDataSource();
        IteratorDataSourceConsumer consumer = new IteratorDataSourceConsumer(new IteratorDataSourceImpl(pagedDataSource));
        consumer.consume();
        System.out.println(pagedDataSource.getRequests());
    }

}