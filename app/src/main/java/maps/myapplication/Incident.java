package maps.myapplication;

import com.google.android.gms.maps.model.LatLng;

import java.text.DateFormat;
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
    private LatLng loc;

    private final String dateFormat = "yyyy-MM-dd'T'HH:mm:ss";
    private final String dateHuman = "EEE, d MMM yyyy, hh:mm aaa";

    public Incident(){
        loc = new LatLng(0, 0);
    }

    public Incident(Date date, String desc, double lat, double lng, String title)
    {
        mdate=date;
        mdesc=desc;
        loc = new LatLng(lat, lng);
        mtitle=title;

    }

    public String getHumanDate() {
        return mdate != null ? new SimpleDateFormat(dateHuman).format(mdate) : "(unknown)";
    }

    public String getHumanLoc() {
        return this.loc.toString();
    }

    public void setLoc(LatLng loc) {
        this.loc = loc;
    }

    public String getDate()
    {
        return mdate != null ? new SimpleDateFormat(dateFormat).format(mdate) : "";
    }

    public void setDate(String date) throws ParseException {
        mdate = new SimpleDateFormat(dateFormat).parse(date);
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
        return this.loc.latitude;
    }

    public void setLat(double lat) {
        double lng = loc.longitude;
        this.loc = new LatLng(lat, lng);
    }

    public double getLng() {
        return this.loc.longitude;
    }

    public void setLng(double lng) {
        double lat = loc.latitude;
        this.loc = new LatLng(lat, lng);
    }

    public String getTitle()
    {
        return mtitle;
    }

    public void setTitle( String title)
    {
        mtitle=title;
    }
}
