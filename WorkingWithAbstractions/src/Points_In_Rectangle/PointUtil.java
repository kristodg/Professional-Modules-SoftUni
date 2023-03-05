package Points_In_Rectangle;

public class PointUtil {

    /**
     * Split " ", working with int coordinates
     * @param input
     * @return
     */
    public static Point parsePoint(String input) {
        String[] parts = input.split(" ");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);

        return new Point(x,y);
    }
}
