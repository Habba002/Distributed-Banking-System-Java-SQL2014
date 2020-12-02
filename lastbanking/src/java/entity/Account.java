package entity;

import java.io.Serializable;

    public class Account implements Serializable
    {
        
        private String FNAME;
        private String MNAME;
        private String LNAME;
        private String ADDRESS;
        private String ACCTYPE;
        private String OCCUPTION;
        private String DISTRICT;
        private String BRANCH;
        private int BALANCE;
        private String PNUM;
        private String PHOTO;
        private String GENDER;
        private String DATE;
        private int ACCNO;
        private String NATIONALITY;
        private int STATUS;
        public Account(){}

    public Account(String FNAME, String MNAME, String LNAME, String ADDRESS, String ACCTYPE, String OCCUPTION, String DISTRICT, String BRANCH, int BALANCE, String PNUM, String PHOTO, String GENDER, String DATE, int ACCNO, String NATIONALITY, int STATUS) {
        this.FNAME = FNAME;
        this.MNAME = MNAME;
        this.LNAME = LNAME;
        this.ADDRESS = ADDRESS;
        this.ACCTYPE = ACCTYPE;
        this.OCCUPTION = OCCUPTION;
        this.DISTRICT = DISTRICT;
        this.BRANCH = BRANCH;
        this.BALANCE = BALANCE;
        this.PNUM = PNUM;
        this.PHOTO = PHOTO;
        this.GENDER = GENDER;
        this.DATE = DATE;
        this.ACCNO = ACCNO;
        this.NATIONALITY = NATIONALITY;
        this.STATUS = STATUS;
    }

    public int getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(int STATUS) {
        this.STATUS = STATUS;
    }

 

    public String getNATIONALITY() {
        return NATIONALITY;
    }

    public void setNATIONALITY(String NATIONALITY) {
        this.NATIONALITY = NATIONALITY;
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

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getACCTYPE() {
        return ACCTYPE;
    }

    public void setACCTYPE(String ACCTYPE) {
        this.ACCTYPE = ACCTYPE;
    }

    public String getOCCUPTION() {
        return OCCUPTION;
    }

    public void setOCCUPTION(String OCCUPTION) {
        this.OCCUPTION = OCCUPTION;
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

    @Override
    public String toString() {
        return "Account{" + '}';
    }

    public void setBRANCH(String BRANCH) {
        this.BRANCH = BRANCH;
    }

    public int getBALANCE() {
        return BALANCE;
    }

    public void setBALANCE(int BALANCE) {
        this.BALANCE = BALANCE;
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

    public String getGENDER() {
        return GENDER;
    }

    public void setGENDER(String GENDER) {
        this.GENDER = GENDER;
    }

    public String getDATE() {
        return DATE;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    public int getACCNO() {
        return ACCNO;
    }

    public void setACCNO(int ACCNO) {
        this.ACCNO = ACCNO;
    }   
   
}
