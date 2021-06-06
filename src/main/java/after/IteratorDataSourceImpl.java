package after;

import before.Entity;
import before.PagedDataSource;
import before.Paging;

import java.util.Iterator;
import java.util.function.Function;

public class IteratorDataSourceImpl implements IteratorDataSource {

    private final PagedDataSource pagedDataSource;

    public IteratorDataSourceImpl(PagedDataSource pagedDataSource) {
        this.pagedDataSource = pagedDataSource;
    }

    @Override
    public Iterator<Entity> getAllEntities() {
        return new PagedIterator(Paging.firstPage(), (Paging paging) -> pagedDataSource.getEntities(paging).iterator());
    }

    public static class PagedIterator implements Iterator<Entity> {

        private final Function<Paging, Iterator<Entity>> iteratorProvider;
        private Paging currentPage;
        private Iterator<Entity> currentIterator;
        private int pageElements = 0;

        public PagedIterator(Paging initialPage, Function<Paging, Iterator<Entity>> iteratorProvider) {
            currentPage = initialPage;
            this.iteratorProvider = iteratorProvider;
            currentIterator = iteratorProvider.apply(currentPage);
        }

        @Override
        public boolean hasNext() {
            if(currentIterator.hasNext()) {
                return true;
            } else {
                currentPage = currentPage.next(pageElements);
                currentIterator = iteratorProvider.apply(currentPage);
                pageElements = 0;
                return currentIterator.hasNext();
            }
        }

        @Override
        public Entity next() {
            pageElements++;
            return currentIterator.next();
        }
    }

}
