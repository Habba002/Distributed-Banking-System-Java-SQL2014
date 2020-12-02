
package thealeke;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for account complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="account">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ACCNO" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ACCTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ADDRESS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BALANCE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="BRANCH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DISTRICT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GENDER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NATIONALITY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OCCUPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PHOTO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PNUM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STATUS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "account", propOrder = {
    "accno",
    "acctype",
    "address",
    "balance",
    "branch",
    "date",
    "district",
    "fname",
    "gender",
    "lname",
    "mname",
    "nationality",
    "occuption",
    "photo",
    "pnum",
    "status"
})
public class Account {

    @XmlElement(name = "ACCNO")
    protected int accno;
    @XmlElement(name = "ACCTYPE")
    protected String acctype;
    @XmlElement(name = "ADDRESS")
    protected String address;
    @XmlElement(name = "BALANCE")
    protected int balance;
    @XmlElement(name = "BRANCH")
    protected String branch;
    @XmlElement(name = "DATE")
    protected String date;
    @XmlElement(name = "DISTRICT")
    protected String district;
    @XmlElement(name = "FNAME")
    protected String fname;
    @XmlElement(name = "GENDER")
    protected String gender;
    @XmlElement(name = "LNAME")
    protected String lname;
    @XmlElement(name = "MNAME")
    protected String mname;
    @XmlElement(name = "NATIONALITY")
    protected String nationality;
    @XmlElement(name = "OCCUPTION")
    protected String occuption;
    @XmlElement(name = "PHOTO")
    protected String photo;
    @XmlElement(name = "PNUM")
    protected String pnum;
    @XmlElement(name = "STATUS")
    protected int status;

    /**
     * Gets the value of the accno property.
     * 
     */
    public int getACCNO() {
        return accno;
    }

    /**
     * Sets the value of the accno property.
     * 
     */
    public void setACCNO(int value) {
        this.accno = value;
    }

    /**
     * Gets the value of the acctype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACCTYPE() {
        return acctype;
    }

    /**
     * Sets the value of the acctype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACCTYPE(String value) {
        this.acctype = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getADDRESS() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setADDRESS(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the balance property.
     * 
     */
    public int getBALANCE() {
        return balance;
    }

    /**
     * Sets the value of the balance property.
     * 
     */
    public void setBALANCE(int value) {
        this.balance = value;
    }

    /**
     * Gets the value of the branch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBRANCH() {
        return branch;
    }

    /**
     * Sets the value of the branch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBRANCH(String value) {
        this.branch = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDATE() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDATE(String value) {
        this.date = value;
    }

    /**
     * Gets the value of the district property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDISTRICT() {
        return district;
    }

    /**
     * Sets the value of the district property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDISTRICT(String value) {
        this.district = value;
    }

    /**
     * Gets the value of the fname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFNAME() {
        return fname;
    }

    /**
     * Sets the value of the fname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFNAME(String value) {
        this.fname = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGENDER() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGENDER(String value) {
        this.gender = value;
    }

    /**
     * Gets the value of the lname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLNAME() {
        return lname;
    }

    /**
     * Sets the value of the lname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLNAME(String value) {
        this.lname = value;
    }

    /**
     * Gets the value of the mname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMNAME() {
        return mname;
    }

    /**
     * Sets the value of the mname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMNAME(String value) {
        this.mname = value;
    }

    /**
     * Gets the value of the nationality property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNATIONALITY() {
        return nationality;
    }

    /**
     * Sets the value of the nationality property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNATIONALITY(String value) {
        this.nationality = value;
    }

    /**
     * Gets the value of the occuption property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOCCUPTION() {
        return occuption;
    }

    /**
     * Sets the value of the occuption property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOCCUPTION(String value) {
        this.occuption = value;
    }

    /**
     * Gets the value of the photo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPHOTO() {
        return photo;
    }

    /**
     * Sets the value of the photo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPHOTO(String value) {
        this.photo = value;
    }

    /**
     * Gets the value of the pnum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPNUM() {
        return pnum;
    }

    /**
     * Sets the value of the pnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPNUM(String value) {
        this.pnum = value;
    }

    /**
     * Gets the value of the status property.
     * 
     */
    public int getSTATUS() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     */
    public void setSTATUS(int value) {
        this.status = value;
    }

}
