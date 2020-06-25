
import java.util.*;

public class TestLineUnion {


    public static void main(String[] args) {
        String line1 = "LINESTRING (1 1, 2 2, 2 3)";
        String line2 = "LINESTRING (2 3, 2 4, 3 4)";
        String line3 = "LINESTRING (5 5, 3 5, 3 4)";

        MyLine l1 = new MyLine(line1,"line1");
        MyLine l2 = new MyLine(line2,"line2");
        MyLine l3 = new MyLine(line3,"line3");

        // load points
        TreeSet<MyPoint> points = new TreeSet<MyPoint>(new MyPointComparator());
        List<MyPoint> pointsList = new ArrayList<MyPoint>();

        points.add(l1.myPoint1);
        points.add(l1.myPoint2);
        points.add(l2.myPoint1);
        points.add(l2.myPoint2);
        points.add(l3.myPoint1);
        points.add(l3.myPoint2);

        pointsList.add(l1.myPoint1);
        pointsList.add(l1.myPoint2);
        pointsList.add(l2.myPoint1);
        pointsList.add(l2.myPoint2);
        pointsList.add(l3.myPoint1);
        pointsList.add(l3.myPoint2);


        for(MyPoint p : pointsList){
            MyPoint q = points.floor(p);
            if(q.id.compareTo(p.id)!=0){
                //link p to q
                p.linkId=q.id;
                q.linkId=p.id;
                p.outerPoint=q;
                q.outerPoint=p;
                points.remove(q);
            }
        }

        MyPoint startPoint=null;
        int hash = Integer.MAX_VALUE;
        for(MyPoint p : pointsList) {
            if(p.outerPoint==null && p.hashCode() < hash) {
                startPoint = p;
            }
        }

        List<MyPoint> outLine=new ArrayList<MyPoint>();
        addLine(outLine,startPoint);
        //outLine.add(startPoint);
        startPoint = startPoint.innerPoint;
        while(startPoint!=null){
            //outLine.add(startPoint);
            startPoint=startPoint.outerPoint;
            if(startPoint==null)
                break;
            addLine(outLine,startPoint);
            startPoint=startPoint.innerPoint;
        }

        System.console().printf(outLine.toString());
    }

    static void addLine(List<MyPoint> line, MyPoint point){
        List<MyPoint> lineToAdd=null;
        if(point.myLine.myPointList.iterator().next().equals(point)){
            lineToAdd=point.myLine.myPointList;
        }
        else {
            lineToAdd=point.myLine.myPointListRev;
        }

        boolean first=true;
        for(MyPoint p : lineToAdd){
            if(first){
                first=false;
                if(line.size()>0)
                    continue;
            }
            line.add(p);
        }
    }

}
