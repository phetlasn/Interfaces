import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class BigRectLister {
    public static void main(String[] args) {
        BigRectangleFilter bigRectangleFilter = new BigRectangleFilter();
        ArrayList<Object> rect = new ArrayList<>();

        rect.add(new Rectangle(8, 9));
        rect.add(new Rectangle(3, 1));
        rect.add(new Rectangle(8, 10));
        rect.add(new Rectangle(7, 3));
        rect.add(new Rectangle(3, 6));
        rect.add(new Rectangle(1, 1));
        rect.add(new Rectangle(2, 3));
        rect.add(new Rectangle(3, 1));
        rect.add(new Rectangle(4, 3));
        rect.add(new Rectangle(2, 1));

        rect = BigRectangleFilter.collectAll(rect, new BigRectangleFilter());
        System.out.println("Rectangles that have a perimeter over 10: ");

        for (Object x : rect) {
            System.out.println(x);

            if (bigRectangleFilter.accept(rect)) {
                System.out.println(rect);
            }
        }
    }
}
