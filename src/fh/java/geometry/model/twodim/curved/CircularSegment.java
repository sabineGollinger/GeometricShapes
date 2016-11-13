package fh.java.geometry.model.twodim.curved;

/**
 * Created by Sabine on 12.11.2016.
 */
public class CircularSegment extends Circle {

    private double angleAlpha;

    public CircularSegment() {
    }

    public CircularSegment(int x, int y, double radius, double angleAlpha) {
        this.x=x;
        this.y=y;
        this.radius = radius;
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

        CircularSegment that = (CircularSegment) o;

        return Double.compare(that.angleAlpha, angleAlpha) == 0;

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
        final StringBuilder sb = new StringBuilder("CircularSegment{");
        sb.append("radius=").append(radius);
        sb.append(", angleAlpha=").append(angleAlpha);
        sb.append(", area=").append(calculateArea());
        sb.append(", perimeter=").append(calculatePerimeter());
        sb.append('}');
        return sb.toString();
    }

    public double calcHigh() {
        return radius * (1 - Math.cos(angleAlpha / 2));
    }

    public double calcL() {
        return radius * angleAlpha;
    }

    public double calcS() {
        double high = calcHigh();
        return 2 * Math.sqrt(2 * radius * high - (high * high));
    }

    @Override
    public double calculateArea() {
        return radius * calcL() / 2 - calcS() * (radius - calcHigh()) / 2;
    }

    @Override
    public double calculatePerimeter() {
        return calcL() + calcS();
    }
}
