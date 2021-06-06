package before;

public class Paging {

    private final int from;
    private final int limit;

    public Paging(int from, int limit) {
        this.from = from;
        this.limit = limit;
    }

    public int getFrom() {
        return from;
    }

    public int getLimit() {
        return limit;
    }

    public static Paging firstPage() {
        return new Paging(0, 2);
    }

    public Paging next(int size) {
        return new Paging(from + size, limit);
    }

    @Override
    public String toString() {
        return "Paging{" +
                "from=" + from +
                ", limit=" + limit +
                '}';
    }
}
