package com.example.android.quakereport;

public class earthquake {
    private Double mMag;
    private String mLocation;
    private String mDate;
    private  String mTime;
    private  String mURL;

    public earthquake(  Double Mag, String Location, String Date, String Timr, String url)
    {
        mMag=Mag;
        mLocation=Location;
        mDate=Date;
        mTime=Timr;
        mURL=url;
    }

    public double getmMag() {
        return mMag;
    }

    public String getmDate() {
        return mDate;
    }

    public String getmLocation() {
        return mLocation;
    }

    public String getmTime() {
        return mTime;
    }

    public String getmURL() {
        return mURL;
    }
}
