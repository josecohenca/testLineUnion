import java.io.Serializable;

public class MyPoint implements Serializable {
    Float lat;
    Float lon;
    //Long hash;
    String id;
    String linkId;
    MyPoint innerPoint=null;
    MyPoint outerPoint=null;
    MyLine myLine=null;

/*
    public long Hash(float lat, float lon)
    {
        int a = (int)Math.floor(lat*10000);
        int b = (int)Math.floor(lon*10000);
        long A = (long)(a >= 0 ? 2 * (long)a : -2 * (long)a - 1);
        long B = (long)(b >= 0 ? 2 * (long)b : -2 * (long)b - 1);
        long C = (long)((A >= B ? A * A + A + B : A + B * B) / 2);
        return a < 0 && b < 0 || a >= 0 && b >= 0 ? C : -C - 1;
    }
*/

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((lat == null) ? 0 : lat.hashCode());
        result = prime * result + ((lon == null) ? 0 : lon.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MyPoint other = (MyPoint) obj;

        if (lat == null) {
            if (other.lat != null)
                return false;
        } else if (!lat.equals(other.lat))
            return false;

        if (lon == null) {
            if (other.lon != null)
                return false;
        } else if (!lon.equals(other.lon))
            return false;

        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;

        return true;
    }

    public int compareTo(MyPoint that) {
        int result = 0;
        result = this.lat.compareTo(that.lat);
        if(result != 0) return result;
        result = this.lon.compareTo(that.lon);
        //if(result != 0) return result;
        //result = this.id.compareTo(that.id);
        return result;
    }

    public MyPoint(Float lat, Float lon, String id){
        this.lat=lat;
        this.lon=lon;
        this.id=id;
    }
}
