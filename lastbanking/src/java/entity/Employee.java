package entity;

import java.io.Serializable;

public class Employee implements Serializable{
    
    String FNAME,MNAME,LNAME,GENDER,ADDRESS,NATIONALITY,DISTRICT,BRANCH,PNUM,PHOTO,Date,ROLE,STATUS;
    int EMPID;

    public Employee(String FNAME, String MNAME, String LNAME, String GENDER, String ADDRESS, String NATIONALITY, String DISTRICT, String BRANCH, String PNUM, String PHOTO, String Date, String ROLE, String STATUS, int EMPID) {
        this.FNAME = FNAME;
        this.MNAME = MNAME;
        this.LNAME = LNAME;
        this.GENDER = GENDER;
        this.ADDRESS = ADDRESS;
        this.NATIONALITY = NATIONALITY;
        this.DISTRICT = DISTRICT;
        this.BRANCH = BRANCH;
        this.PNUM = PNUM;
        this.PHOTO = PHOTO;
        this.Date = Date;
        this.ROLE = ROLE;
        this.STATUS = STATUS;
        this.EMPID = EMPID;
    }

    public int getEMPID() {
        return EMPID;
    }

    public void setEMPID(int EMPID) {
        this.EMPID = EMPID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getROLE() {
        return ROLE;
    }

    public void setROLE(String ROLE) {
        this.ROLE = ROLE;
    }
  

    public Employee() {
         
    }


    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getFNAME() {
        return FNAME;
    }

    public void setFNAME(String FNAME) {
        this.FNAME = FNAME;
    }

    public String getMNAME() {
        return MNAME;
    }

    public void setMNAME(String MNAME) {
        this.MNAME = MNAME;
    }

    public String getLNAME() {
        return LNAME;
    }

    public void setLNAME(String LNAME) {
        this.LNAME = LNAME;
    }

    public String getGENDER() {
        return GENDER;
    }

    public void setGENDER(String GENDER) {
        this.GENDER = GENDER;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getNATIONALITY() {
        return NATIONALITY;
    }

    public void setNATIONALITY(String NATIONALITY) {
        this.NATIONALITY = NATIONALITY;
    }

    public String getDISTRICT() {
        return DISTRICT;
    }

    public void setDISTRICT(String DISTRICT) {
        this.DISTRICT = DISTRICT;
    }

    public String getBRANCH() {
        return BRANCH;
    }

    public void setBRANCH(String BRANCH) {
        this.BRANCH = BRANCH;
    }


    public String getPNUM() {
        return PNUM;
    }

    public void setPNUM(String PNUM) {
        this.PNUM = PNUM;
    }

    public String getPHOTO() {
        return PHOTO;
    }

    public void setPHOTO(String PHOTO) {
        this.PHOTO = PHOTO;
    }
    
            }
