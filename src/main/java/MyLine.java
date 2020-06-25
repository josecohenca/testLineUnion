import java.util.ArrayList;
import java.util.List;

public class MyLine {
    String fullString;
    String id;
    MyPoint myPoint1;
    MyPoint myPoint2;
    List<MyPoint> myPointList;
    List<MyPoint> myPointListRev;

    public MyLine(String fullString, String id){
        this.fullString=fullString;
        String[] lineSplit = this.fullString.replace("LINESTRING (","").replace(")","").split(",");
        String[] p1Str = lineSplit[0].trim().split(" ");
        String[] p2Str = lineSplit[lineSplit.length-1].trim().split(" ");
        this.myPoint1 = new MyPoint(Float.parseFloat(p1Str[1]), Float.parseFloat(p1Str[0]),id);
        this.myPoint2 = new MyPoint(Float.parseFloat(p2Str[1]), Float.parseFloat(p2Str[0]),id);

        this.myPoint1.innerPoint=this.myPoint2;
        this.myPoint2.innerPoint=this.myPoint1;
        this.myPoint1.myLine=this;
        this.myPoint2.myLine=this;
        this.id=id;

        this.myPointList = new ArrayList<MyPoint>();
        for(int i=0;i<lineSplit.length;i++){
            String[] p = lineSplit[i].trim().split(" ");
            this.myPointList.add(new MyPoint(Float.parseFloat(p[1]), Float.parseFloat(p[0]),id));
        }
        this.myPointListRev = new ArrayList<MyPoint>();
        for(int i=lineSplit.length-1;i>=0;i--){
            String[] p = lineSplit[i].trim().split(" ");
            this.myPointListRev.add(new MyPoint(Float.parseFloat(p[1]), Float.parseFloat(p[0]),id));
        }
    }
}