package maps.myapplication;

import java.util.Date;

/**
 * Created by Wen on 5/7/2017.
 */

public class Incident {

    private Date mdate;
    private String mdesc;
    private String mtitle;

    public Incident(){


    }

    public Incident(Date date, String desc, String title)
    {
        mdate=date;
        mdesc=desc;
        mtitle=title;

    }

    public Date getDate()
    {
        return mdate;
    }

    public void setDate(Date date)
    {
        mdate=date;
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
