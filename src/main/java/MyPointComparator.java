import java.io.Serializable;
import java.util.Comparator;

public class MyPointComparator implements Comparator<MyPoint> {
    @Override
    public int compare(MyPoint model1, MyPoint model2) {
        return model1.compareTo(model2);
    }
}
