package fh.java.geometry.model.twodim.quadrilateral;

/**
 * Created by Sabine on 12.11.2016.
 */
public class Trapeze extends Square  {

    private double sideB;
    private double sideC;
    private double sideD;
    private double angleAlpha;

    public Trapeze() {
    }

    public Trapeze(int x, int y, double sideA, double sideB, double sideC, double sideD, double angleAlpha) {
        this.x = x;
        this.y = y;
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.sideD = sideD;
        this.angleAlpha = angleAlpha;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    public double getSideD() {
        return sideD;
    }

    public void setSideD(double sideD) {
        this.sideD = sideD;
    }

    public double getAngleAlpha() {
        return angleAlpha;
    }

    public void setAngleAlpha(double highA) {
        this.angleAlpha = highA;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Trapeze trapeze = (Trapeze) o;

        if (Double.compare(trapeze.sideB, sideB) != 0) return false;
        if (Double.compare(trapeze.sideC, sideC) != 0) return false;
        if (Double.compare(trapeze.sideD, sideD) != 0) return false;
        return Double.compare(trapeze.angleAlpha, angleAlpha) == 0;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(sideB);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(sideC);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(sideD);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(angleAlpha);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Trapeze{");
        sb.append("sideA=").append(sideA);
        sb.append(", sideB=").append(sideB);
        sb.append(", sideC=").append(sideC);
        sb.append(", sideD=").append(sideD);
        sb.append(", angleAlpha=").append(angleAlpha);
        sb.append(", area=").append(calculateArea());
        sb.append(", perimeter=").append(calculatePerimeter());
        sb.append('}');
        return sb.toString();
    }

    public double calcHigh() {
        return sideB * Math.sin(angleAlpha);
    }

    @Override
    public double calculateArea() {
        return (sideA + sideC) / 2 * calcHigh();
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC + sideD;
    }
}
