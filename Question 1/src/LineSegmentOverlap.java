
  
public class LineSegmentOverlap {

     public static boolean isOverlap(int x1, int x2, int x3, int x4) {
        // Check if the first line segment (x1, x2) overlaps with the second (x3, x4)
        return (x1 <= x4 && x2 >= x3) || (x3 <= x2 && x4 >= x1);
    }
        

    public static void main(String[] args) {
        int x1 = 1, x2 = 5;
        int x3 = 6, x4 = 8;
        
        boolean overlap = isOverlap(x1, x2, x3, x4);
        
        if (overlap) {
            System.out.println("The line segments overlap.");
        } else {
            System.out.println("The line segments do not overlap.");
        }
    }
}
