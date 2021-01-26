public class ui {

    public static void main(String[] args) {
        Throw th = new Throw(1, 10, 45);
        print(th, 0.05);
    }

    public static void print(Throw th, double dt) {
        double[][] parabola = th.calculate(dt);

        System.out.println("Oblique throw");
        System.out.println("Discharge height   y0    = " + th.getY0() + " m");
        System.out.println("Discharge speed    v0    = " + th.getV0() + " m/s");
        System.out.println("Drop angle         alpha = " + th.getAlpha() + "°");
        System.out.println("Throw height       yMax  = " + th.getyMax() + " m");
        System.out.println("Throwing distance  xMax  = " + th.getxMax() + " m");
        System.out.println("Throwing time      y0    = " + th.gettMax() + " s\n");
        System.out.printf("%10s %10s %10s\n", "t/s", "x/m", "y/m");
        for (int i = 0; i < parabola[0].length; i++) {
            System.out.printf("%10s %10s %10s\n", ((Math.floor(parabola[0][i] * 100)) / 100) + "", ((Math.floor(parabola[1][i] * 100)) / 100) + "", ((Math.floor(parabola[2][i] * 100)) / 100) + "");
        }
    }
}
