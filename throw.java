public class throw {

    private double y0;
    private double v0;

    private double alpha;

    private double yMax;
    private double xMax;
    private double tMax;

    private double v0X;
    private double v0Y;

    private double[] vertex = new double[2];

    private double g = 9.81;
    private double aY = -g;

    Wurf(double y0, double v0, double alpha) {
        this.y0 = y0;
        this.v0 = v0;
        this.alpha = alpha * (Math.PI / 180);
    }

    public double[][] calculate(double dt) {

        /**
         * Calculate the overall time
         */
        this.v0X = this.v0 * Math.cos(this.alpha);
        this.v0Y = this.v0 * Math.sin(this.alpha);
        this.tMax = (this.v0Y + Math.sqrt(this.v0Y * this.v0Y + 2 * g * this.y0)) / g;

        double _tMax = this.tMax + (dt - (this.tMax % dt));

        double[][] result = new double[3][((int) (_tMax / dt) + 1)];
        double i = 0.0;
        for (int j = 0; j < result[0].length; j++) {
            result[0][j] = i;
            result[1][j] = v0X * i;
            result[2][j] = (this.aY / 2) * (i * i) + this.v0Y * i + y0;

            if (result[2][j] < 0) {
                result[0][j] = this.tMax;
                result[1][j] = v0X * this.tMax;
                result[2][j] = (this.aY / 2) * (this.tMax * this.tMax) + this.v0Y * this.tMax + y0;
            }

            double x = Math.pow(10, 2.0);
            i = (Math.round(i * x) + Math.round(dt * x)) / x;
        }

        this.xMax = result[1][result[1].length - 1];
        this.yMax = result[2][result[2].length - 1];

        return result;
    }

    public void setVertex(double x, double y) {
        this.vertex[0] = x;
        this.vertex[1] = y;
    }

    public double getY0() {
        return this.y0;
    }

    public double getV0() {
        return this.v0;
    }

    public double getAlpha() {
        return this.alpha;
    }

    public double getyMax() {
        return this.yMax;
    }

    public double getxMax() {
        return this.xMax;
    }

    public double gettMax() {
        return this.tMax;
    }

    public double[] getVertex() {
        return this.vertex;
    }
}
