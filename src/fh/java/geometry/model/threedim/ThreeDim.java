package fh.java.geometry.model.threedim;

import fh.java.geometry.model.GeometricShape;

/**
 * Created by Sabine on 12.11.2016.
 */
public abstract class ThreeDim extends GeometricShape {

    protected int z;

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public abstract double calculateVolume();

    public abstract double calculateSurfaceArea();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ThreeDim threeDim = (ThreeDim) o;

        return z == threeDim.z;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + z;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ThreeDim{");
        sb.append("z=").append(z);
        sb.append('}');
        return sb.toString();
    }
}
