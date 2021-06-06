package after;

import before.Entity;
import before.Paging;

import java.util.Iterator;
import java.util.List;

public interface IteratorDataSource {
    Iterator<Entity> getAllEntities();
}
