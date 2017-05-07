package maps.myapplication;

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

    private final String dateFormat = "yyyy-MM-dd'T'HH:mm:ss";

    public Incident(){


    }

    public Incident(Date date, String desc, String title)
    {
        mdate=date;
        mdesc=desc;
        mtitle=title;

    }

    public String getDate()
    {
        return new SimpleDateFormat(dateFormat).format(mdate);
    }

    public void setDate(String date) throws ParseException {
        mdate= new SimpleDateFormat(dateFormat).parse(date);
    }

    public String getDesc()
    {
        return mdesc;
    }

    public void setDesc(String desc)
    {
        mdesc=desc;
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
