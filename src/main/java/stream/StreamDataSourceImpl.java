package stream;

import after.IteratorDataSourceImpl;
import before.Entity;
import before.PagedDataSource;
import before.Paging;

import java.util.Iterator;
import java.util.Spliterators;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamDataSourceImpl implements StreamDataSource {

    private final PagedDataSource pagedDataSource;

    public StreamDataSourceImpl(PagedDataSource pagedDataSource) {
        this.pagedDataSource = pagedDataSource;
    }

    @Override
    public Stream<Entity> getAllEntities() {
        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(
                        new IteratorDataSourceImpl.PagedIterator(Paging.firstPage(), (Paging paging) -> pagedDataSource.getEntities(paging).iterator())
                        , 0
                ),
                false
        );
    }

}
