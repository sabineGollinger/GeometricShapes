package fh.java.geometry.model.threedim.quadrilateral;

/**
 * Created by Sabine on 12.11.2016.
 */
public class Pyramid extends Cube {

    private double sideB;
    private double high;

    public Pyramid() {
    }

    public Pyramid(int x, int y, int z, double sideA, double sideB, double high) {
        this.x=x;
        this.y=y;
        this.z=z;
        this.sideA = sideA;
        this.sideB = sideB;
        this.high = high;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Pyramid pyramid = (Pyramid) o;

        if (Double.compare(pyramid.sideB, sideB) != 0) return false;
        return Double.compare(pyramid.high, high) == 0;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(sideB);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(high);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pyramid{");
        sb.append("sideA=").append(sideA);
        sb.append(", sideB=").append(sideB);
        sb.append(", high=").append(high);
        sb.append(", volume=").append(calculateVolume());
        sb.append(", surface=").append(calculateSurfaceArea());
        sb.append('}');
        return sb.toString();
    }

    public double calcHighA() {
        return Math.sqrt(high * high + ((sideA / 2) * (sideA / 2)));
    }

    public double calcHighB() {
        return Math.sqrt(high * high + ((sideB / 2) * (sideB / 2)));
    }


    @Override
    public double calculateVolume() {
        return (sideA * sideB * high) / 3;
    }

    @Override
    public double calculateSurfaceArea() {
        return sideA * sideB + sideA * calcHighA() + sideB * calcHighB();
    }
}
