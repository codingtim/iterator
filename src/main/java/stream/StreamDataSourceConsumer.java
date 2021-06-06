package stream;

public class StreamDataSourceConsumer {

    private final StreamDataSource streamDataSource;

    public StreamDataSourceConsumer(StreamDataSource streamDataSource) {
        this.streamDataSource = streamDataSource;
    }

    public void consume() {
        streamDataSource.getAllEntities()
                .sorted((o1, o2) -> Integer.compare(o2.getId(), o1.getId()))
                .filter(entity -> entity.getId() % 2 == 1)
                .forEach(entity -> {
            //doStuff
            System.out.println(entity);
        });
    }

}
