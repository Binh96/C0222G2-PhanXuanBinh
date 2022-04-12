package ss7_abstract_and_interface.thuc_hanh.interfacecomparator;

import java.util.Comparator;

public class ComparatorCircle implements Comparator<Circle> {
    public int compare(Circle c1, Circle c2) {
        if (c1.getRadius() > c2.getRadius()) return 1;
        else if (c1.getRadius() < c2.getRadius()) return -1;
        else return 0;
    }
}
