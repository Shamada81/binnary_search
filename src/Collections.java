import java.util.Comparator;
import java.util.List;

public class Collections {
    public static <T extends Comparable<? super T>> int binarySearch(List<? extends T> list, T key) {
        return binarySearch(list, key, Comparable::compareTo);
    }

    public static <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> c) {
        int fromIndex = 0;
        int toIndex = list.size();
        while (fromIndex < toIndex) {
            int mid = (fromIndex + toIndex) / 2;
            int cmp = c.compare(list.get(mid), key);
            if (cmp < 0) {
                fromIndex = mid + 1;
            } else if (cmp > 0) {
                toIndex = mid;
            } else {
                return mid;
            }
        }
        return -(fromIndex + 1);
    }
}

