public class ui {

    public static void main(String[] args) {
        Wurf wurf = new Wurf(1, 10, 45);
        printWurfparabel(wurf, 0.05);
    }

    public static void printWurfparabel(Wurf wurf, double dt) {
        double[][] parabel = wurf.berechneWurfparabel(dt);

        System.out.println("Schiefer Wurf");
        System.out.println("Abwurfhöhe            y0    = " + wurf.getY0() + " m");
        System.out.println("Abwurfgeschwindigkeit v0    = " + wurf.getV0() + " m/s");
        System.out.println("Abwurfwinkel          alpha = " + wurf.getAlpha() + "°");
        System.out.println("Wurfhöhe              yMax  = " + wurf.getyMax() + " m");
        System.out.println("Wurfweite             xMax  = " + wurf.getxMax() + " m");
        System.out.println("Wurfzeit              y0    = " + wurf.gettMax() + " s\n");
        System.out.printf("%10s %10s %10s\n", "t/s", "x/m", "y/m");
        for (int i = 0; i < parabel[0].length; i++) {
            System.out.printf("%10s %10s %10s\n", ((Math.floor(parabel[0][i] * 100)) / 100) + "", ((Math.floor(parabel[1][i] * 100)) / 100) + "", ((Math.floor(parabel[2][i] * 100)) / 100) + "");
        }
    }
}
