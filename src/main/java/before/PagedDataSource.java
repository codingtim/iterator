package before;

import java.util.List;

public interface PagedDataSource {
    List<Entity> getEntities(Paging paging);
}
