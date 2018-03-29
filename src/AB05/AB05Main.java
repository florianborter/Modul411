package AB05;
public class AB05Main {
   final static int DIM1 = 12;
   final static int DIM2 = 12;
   static boolean[][] world = new boolean[DIM1][DIM2];
   static int[][] worldNeighbours = new int[DIM1][DIM2];

   public static void initWorld() {
       for (int i = 1; i < DIM1-1; i++) {
           for (int j = 1; j < DIM2-1; j++) {
               world[i][j] = Math.random() > 0.4;
           }
       }
   }

   public static int countNeighbours(int x, int y) {
       int neighbours = 0;
       for (int i=x-1; i<=x+1; ++i) {
           for (int j=y-1; j<=y+1; ++j) {
               if (world[i][j]) {
                   neighbours ++;
               }
           }
       }
       if (world[x][y]) {
           neighbours--;
       }
       return neighbours;
   }

   public static void showWorld() {
       for (int i = 1; i < DIM1-1; i++) {
           for (int j = 1; j < DIM2-1; j++) {
               if (world[i][j]) {
                   System.out.print("\tX");
               } else {
                   System.out.print("\t-");
               }
           }
           System.out.println("");
       }
   }

   public static void main(String[] args) {
       initWorld();

       while(true) {
           showWorld();
           System.out.println("\n\n");
           try {
               Thread.sleep(2000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           prepareNextGeneration();
       }
   }

   public static void prepareNextGeneration(){
       for (int i = 1; i < DIM1-1; i++) {
           for (int j = 1; j < DIM2 - 1; j++) {
               worldNeighbours[i][j] = countNeighbours(i, j);
           }
       }

       for (int i = 1; i < DIM1-1; i++) {
           for (int j = 1; j < DIM2-1; j++) {
               int count = worldNeighbours[i][j];

               if (world[i][j] && (count < 2 || count > 3)) {
                   world[i][j] = false;
               } else if (!world[i][j] && count == 3) {
                   world[i][j] = true;
               }
           }
       }
   }
}