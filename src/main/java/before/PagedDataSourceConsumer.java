package before;

import java.util.List;

public class PagedDataSourceConsumer {

    private PagedDataSource pagedDataSource;

    public PagedDataSourceConsumer(PagedDataSource pagedDataSource) {
        this.pagedDataSource = pagedDataSource;
    }

    public void consume() {
        List<Entity> entities;
        Paging nextPage = Paging.firstPage();
        for(entities = pagedDataSource.getEntities(nextPage); !entities.isEmpty(); entities = pagedDataSource.getEntities(nextPage)) {
            for(Entity entity: entities) {
                //doStuff
                System.out.println(entity);
            }
            nextPage = nextPage.next(entities.size());
        }
    }
}
