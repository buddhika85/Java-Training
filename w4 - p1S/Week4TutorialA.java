public class Week4TutorialA
{
    public static void main(String[] args) {
        //Point[] points = new Point[3];

        // demo : null pointer exception
        //System.out.println(points[0].x);

        // setting (1,1) , (2,2) , (3,3)
        // for (int i = 0; i < points.length; i++) {
        //     points[i] = new Point(i + 1, i+ 1);
        // }

        // for (Point point : points) {
        //     System.out.println(point);
        // }

        // last one TA
        BunchOfPoints bunch = new BunchOfPoints(10);
        bunch.setPoint(0, 0.5, -12.0);
        bunch.setPoint(1, 5.5, 12.0);
        bunch.setPoint(2, 2.5, -12.0);
        bunch.setPoint(3, 6.5, 12.0);
        bunch.setPoint(4, -10.5, -7.0);
        bunch.setPoint(5, -9.3, 1.9);
        bunch.setPoint(6, 0.5, -4.3);
        bunch.setPoint(7, 2.5, 13.0);
        bunch.setPoint(8, 5.5, -12.0);

        System.out.println(bunch.numberFurtherThan(160.0));
        // Answer: 4
    }
}

class Point
{
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    boolean inUpperHalfPlane()
    {
        return this.y >= 0;
    }

    boolean inFirstQuadrant()
    {
        return this.y >= 0 && this.x >= 0;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    boolean isInQuadrant(int quadrantNumber)
    {
        if (quadrantNumber == 1) 
        {
            return this.x >= 0.0 && this.y >= 0.0;
        } 
        else if (quadrantNumber == 2) 
        {
            return this.x <= 0.0 && this.y >= 0.0;
        } 
        else if (quadrantNumber == 3) 
        {
            return this.x <= 0.0 && this.y <= 0.0;
        } 
            else if (quadrantNumber == 4) 
        {
            return this.x >= 0.0 && this.y <= 0.0;
        } 
        else 
        {
            return false;
        }
    }

    double squaredDistance()
    {
        return this.x * this.x + this.y * this.y;
    }
}


class BunchOfPoints 
{
    Point[] points;

    BunchOfPoints(int n) {
        points = new Point[n];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(0, 0);
        }

        // for (Point point : points) {
        //     point = new Point(0, 0);
        // }
    }

    Point getPoint(int i) {
        return this.points[i];
    }

    void setPoint(int i, double newX, double newY)
    {
        Point pointToChange = getPoint(i);
        if (pointToChange == null)
        {
            System.out.println("Error - No point in index " + i);
        }
        else
        {
            pointToChange.x = newX;
            pointToChange.y = newY;
            System.out.println("Success - Point updated");
        }
    }

    int numberFurtherThan(double squaredDistance)
    {
        int count = 0;
        for (Point point : points) {
            if (point.squaredDistance() > squaredDistance)
            {
                count++;
            }
        }
        return count;
    }
}