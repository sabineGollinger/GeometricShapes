package fh.java.geometry.model.twodim.quadrilateral;

/**
 * Created by Sabine on 12.11.2016.
 */
public class Diamond extends Square  {

    private double angleAlpha;

    public Diamond() {
    }

    public Diamond(int x, int y, double sideA, double angleAlpha) {
        super(x, y, sideA);
        this.angleAlpha = angleAlpha;
    }

    public double getAngleAlpha() {
        return angleAlpha;
    }

    public void setAngleAlpha(double angleAlpha) {
        this.angleAlpha = angleAlpha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Diamond diamond = (Diamond) o;

        return Double.compare(diamond.angleAlpha, angleAlpha) == 0;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(angleAlpha);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Diamond{");
        sb.append("sideA=").append(sideA);
        sb.append(", angleAlpha=").append(angleAlpha);
        sb.append(", area=").append(calculateArea());
        sb.append(", perimeter=").append(calculatePerimeter());
        sb.append('}');
        return sb.toString();
    }

    public double calcMiddleE() {
        return 2 * sideA * Math.cos(angleAlpha / 2);
    }

    public double calcMiddleF() {
        return 2 * sideA * Math.sin(angleAlpha / 2);
    }

    @Override
    public double calculateArea() {
        return (calcMiddleE() * calcMiddleF()) /2;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * sideA;
    }
}
