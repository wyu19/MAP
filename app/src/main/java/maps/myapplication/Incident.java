package maps.myapplication;

import com.google.android.gms.maps.model.LatLng;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Wen on 5/7/2017.
 */

public class Incident {

    private Date mdate;
    private String mdesc;
    private String mtitle;
    private LatLng mloc;

    private final String dateFormat = "yyyy-MM-dd'T'HH:mm:ss";
    private final String dateHuman = "EEE, d MMM yyyy, hh:mm aaa";

    public Incident(){
        mloc = new LatLng(0, 0);
    }

    public Incident(Date date, String desc, double lat, double lng, String title)
    {
        mdate=date;
        mdesc=desc;
        mloc = new LatLng(lat, lng);
        mtitle=title;

    }

    public String makeHumanDate() {
        return mdate != null ? new SimpleDateFormat(dateHuman).format(mdate) : "(unknown)";
    }

    public String makeHumanLoc() {
        return this.mloc.toString();
    }

    public void putLoc(LatLng loc) {
        this.mloc = loc;
    }


    public String getDate()
    {
        return mdate != null ? new SimpleDateFormat(dateFormat).format(mdate) : "";
    }

    public void setDate(String date) throws ParseException {

        if(date.length() > 0) {
            mdate = new SimpleDateFormat(dateFormat).parse(date);
        }
    }

    public void putDate(Date date)
    {
        this.mdate = date;
    }

    public String getDesc()
    {
        return mdesc;
    }

    public void setDesc(String desc)
    {
        mdesc=desc;
    }

    public double getLat() {
        return this.mloc.latitude;
    }

    public void setLat(double lat) {
        double lng = mloc.longitude;
        this.mloc = new LatLng(lat, lng);
    }

    public double getLng() {
        return this.mloc.longitude;
    }

    public void setLng(double lng) {
        double lat = mloc.latitude;
        this.mloc = new LatLng(lat, lng);
    }

    public String getTitle()
    {
        return mtitle;
    }

    public void setTitle(String title)
    {
        mtitle=title;
    }
}
