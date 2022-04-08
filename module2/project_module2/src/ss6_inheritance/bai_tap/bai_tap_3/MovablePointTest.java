package ss6_inheritance.bai_tap.bai_tap_3;

public class MovablePointTest {
    public static void main(String[] args) {
        MovablePoint movablePoint = new MovablePoint();
        System.out.println(movablePoint);

        MovablePoint movablePoint1 = new MovablePoint(3.2f, 2.1f, 3f, 4f);
        System.out.println(movablePoint1);

        MovablePoint movablePoint2 = new MovablePoint(12f, 32f);
        System.out.println(movablePoint2);
    }
}
