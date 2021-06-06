package stream;

public class StreamDataSourceConsumer {

    private final StreamDataSource streamDataSource;

    public StreamDataSourceConsumer(StreamDataSource streamDataSource) {
        this.streamDataSource = streamDataSource;
    }

    public void consume() {
        streamDataSource.getAllEntities().filter(entity -> entity.getId() % 2 == 1).forEach(entity -> {
            //doStuff
            System.out.println(entity);
        });
    }

}
