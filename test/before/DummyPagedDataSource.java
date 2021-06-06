package before;

import before.Entity;
import before.PagedDataSource;
import before.Paging;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DummyPagedDataSource implements PagedDataSource {

    private List<Paging> requests = new ArrayList<>();

    public List<Paging> getRequests() {
        return requests;
    }

    @Override
    public List<Entity> getEntities(Paging paging) {
        requests.add(paging);
        if (paging.getFrom() == 0) {
            return Arrays.asList(new Entity(1), new Entity(2));
        } else if (paging.getFrom() == 2) {
            return Arrays.asList(new Entity(3));
        } else {
            return Collections.emptyList();
        }
    }
}
