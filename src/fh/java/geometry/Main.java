package fh.java.geometry;

import fh.java.geometry.model.GeometricShape;
import fh.java.geometry.model.threedim.ThreeDim;
import fh.java.geometry.model.threedim.curved.Ball;
import fh.java.geometry.model.threedim.quadrilateral.Cube;
import fh.java.geometry.model.threedim.quadrilateral.Pyramid;
import fh.java.geometry.model.twodim.TwoDim;
import fh.java.geometry.model.twodim.curved.Circle;
import fh.java.geometry.model.twodim.curved.CircularSegment;
import fh.java.geometry.model.twodim.quadrilateral.Diamond;
import fh.java.geometry.model.twodim.quadrilateral.Trapeze;



import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.doIt();
    }

    private void doIt() {

        List<TwoDim> twoDimShapeList = new ArrayList<>();
        List<ThreeDim> threeDimShapeList = new ArrayList<>();

        fillListWithTwoDim(twoDimShapeList);
        fillListWithThreeDim(threeDimShapeList);

        calculateTwoDims(twoDimShapeList);
        calculateThreeDims(threeDimShapeList);
    }

    public void fillListWithTwoDim(List<TwoDim> shapeList) {
        shapeList.add(new Diamond(1, 2, 5.0, 90.0));

        shapeList.add(new Trapeze(1, 2, 5.0, 2.5, 3.5, 2.0, 90.0));

        shapeList.add(new CircularSegment(1, 2, 5.0, 90.0));

    }

    public void fillListWithThreeDim(List<ThreeDim> shapeList) {
        shapeList.add(new Ball(1, 2, 3, 5.0));

        shapeList.add(new Cube(1, 2, 3, 5.0));

        shapeList.add(new Pyramid(1, 2, 3, 5.0, 6.0, 9.0));
    }

    public void calculateTwoDims(List<TwoDim> twoDimShapeList) {
        double allArea = 0.00;
        double allPerimeter = 0.00;
        double tmpArea;
        double tmpPerimeter;
        for (int pos = 0; pos < twoDimShapeList.size(); pos++) {
            tmpArea = twoDimShapeList.get(pos).calculateArea();
            tmpPerimeter = twoDimShapeList.get(pos).calculatePerimeter();
            allArea += tmpArea;
            allPerimeter += tmpPerimeter;
        }
        System.out.println("2-dimensional shapes");
        System.out.println("Sum of all areas is " + allArea);
        System.out.println("Sum of all perimeters is " + allPerimeter);
    }

    public void calculateThreeDims(List<ThreeDim> threeDimShapeList) {
        double allVolume = 0.00;
        double allSurface = 0.00;
        double tmpVolume;
        double tmpSurface;
        for (int pos = 0; pos < threeDimShapeList.size(); pos++) {
            //System.out.println(threeDimShapeList.get(pos).toString());

            tmpVolume = threeDimShapeList.get(pos).calculateVolume();
            tmpSurface = threeDimShapeList.get(pos).calculateSurfaceArea();
            allVolume += tmpVolume++;
            allSurface += tmpSurface;
        }
        System.out.println("---------------------------------------");
        System.out.println("3-dimensional shapes");
        System.out.println("Sum of all volumes is " + allVolume);
        System.out.println("Sum of all surface is " + allSurface);
    }
}
