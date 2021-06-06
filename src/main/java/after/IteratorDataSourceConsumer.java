package after;

public class IteratorDataSourceConsumer {

    private final IteratorDataSource iteratorDataSource;

    public IteratorDataSourceConsumer(IteratorDataSource iteratorDataSource) {
        this.iteratorDataSource = iteratorDataSource;
    }

    public void consume() {
        iteratorDataSource.getAllEntities().forEachRemaining(entity -> {
            //doStuff
            System.out.println(entity);
        });
    }
}
