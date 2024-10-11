public class XY2 {
    public static void main(String[] args) {
        int[][] cords = {
            {1, 2, 3},
            {4, 5, 6}
        };

        for(int [] row : cords) {
            for(int c : row) {
                System.out.printf("%2d", c);
            }
            System.out.println();
        }
    }
} 
