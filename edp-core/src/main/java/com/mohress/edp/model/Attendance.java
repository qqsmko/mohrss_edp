package com.mohress.edp.model;

import java.util.Date;

public class Attendance {
    private Integer id;

    private Integer deviceid;

    private String carno;

    private Date datatime;

    private Integer studentid;

    private String fingernum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(Integer deviceid) {
        this.deviceid = deviceid;
    }

    public String getCarno() {
        return carno;
    }

    public void setCarno(String carno) {
        this.carno = carno == null ? null : carno.trim();
    }

    public Date getDatatime() {
        return datatime;
    }

    public void setDatatime(Date datatime) {
        this.datatime = datatime;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getFingernum() {
        return fingernum;
    }

    public void setFingernum(String fingernum) {
        this.fingernum = fingernum == null ? null : fingernum.trim();
    }
}