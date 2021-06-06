package stream;

import before.Entity;

import java.util.Iterator;
import java.util.stream.Stream;

public interface StreamDataSource {
    Stream<Entity> getAllEntities();
}
