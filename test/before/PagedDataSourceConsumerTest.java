package before;

import org.junit.jupiter.api.Test;

class PagedDataSourceConsumerTest {

    @Test
    void consume() {
        DummyPagedDataSource pagedDataSource = new DummyPagedDataSource();
        PagedDataSourceConsumer consumer = new PagedDataSourceConsumer(pagedDataSource);
        consumer.consume();
        System.out.println(pagedDataSource.getRequests());
    }

}