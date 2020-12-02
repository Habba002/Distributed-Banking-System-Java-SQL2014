/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thealeke;

import entity.Account;
import entity.Employee;
import entity.News;
import entity.Transaction;
import entity.Transfer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author ashen
 */
@WebService(serviceName = "thealekeweb")
@Stateless()
public class thealekeweb {
    
    private Connection getConnection() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String Url = "jdbc:sqlserver://LAPTOP-LC4FOIS7;DatabaseName=bank;user=sa;Password=123";
        Connection connection = DriverManager.getConnection(Url);
            return connection;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "check")
    public Account check(@WebParam(name = "accnum") int accnum) {
        Account ac = null;
        try {
            //getting all data from the database using account number attribute
            Connection con = getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from account_info where account_no=" + accnum);
            if(rs.next()){
                ac = new Account();
                ac.setACCNO(accnum);
                ac.setFNAME(rs.getString("firstname"));
                ac.setMNAME(rs.getString("middlename"));
                ac.setLNAME(rs.getString("lastname"));
                ac.setADDRESS(rs.getString("address"));
                ac.setNATIONALITY(rs.getString("nationality"));
                ac.setOCCUPTION(rs.getString("occupation"));
                ac.setPHOTO(rs.getString("photo"));
                ac.setDATE(rs.getString("date"));
                ac.setDISTRICT(rs.getString("district"));
                ac.setBRANCH(rs.getString("branch"));
                ac.setPNUM(rs.getString("phone_no"));
                ac.setACCTYPE(rs.getString("account_type"));
                ac.setGENDER(rs.getString("gender"));
                ac.setBALANCE(rs.getInt("balance"));
                ac.setSTATUS(rs.getInt("status"));
            }
            st.close();
            con.close();
            rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ac;
    }
    
    @WebMethod(operationName = "check_acc")
    public Account check_acc(@WebParam(name = "username") String username, @WebParam(name = "password") String password){
        Account ac = null;
        try {
            //getting all data from the database using account number attribute
            Connection con = getConnection();
            Statement st = con.createStatement();

            String query = "select * from login where username='" + username + "' and password='" + password + "'";
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                int accnum = Integer.parseInt(rs.getString("accnum")); 
                
                con = getConnection();
                st = con.createStatement();

                rs = st.executeQuery("select * from account_info where account_no="+accnum);
                if(rs.next()){
                    ac = new Account();
                    ac.setACCNO(accnum);
                    ac.setFNAME(rs.getString("firstname"));
                    ac.setMNAME(rs.getString("middlename"));
                    ac.setLNAME(rs.getString("lastname"));
                    ac.setADDRESS(rs.getString("address"));
                    ac.setNATIONALITY(rs.getString("nationality"));
                    ac.setOCCUPTION(rs.getString("occupation"));
                    ac.setPHOTO(rs.getString("photo"));
                    ac.setDATE(rs.getString("date"));
                    ac.setDISTRICT(rs.getString("district"));
                    ac.setBRANCH(rs.getString("branch"));
                    ac.setPNUM(rs.getString("phone_no"));
                    ac.setACCTYPE(rs.getString("account_type"));
                    ac.setGENDER(rs.getString("gender"));
                    ac.setBALANCE(rs.getInt("balance"));
                    ac.setSTATUS(rs.getInt("status"));
                }
                st.close();
                con.close();
                rs.close();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ac;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "transaction1")
    public ArrayList<Transaction> transaction1(@WebParam(name = "role1") String role1, @WebParam(name = "id1") int id1, @WebParam(name = "accnum1") int accnum1) {
        ArrayList<Transaction> array = null;
        try {

            Connection con = getConnection();
            Statement st = con.createStatement();

            ResultSet rs0, rs, rs1;

            Transaction trans = new Transaction();
            if (role1.equals("admin") || role1.equals("teller"))//if the role is either teller or admin
            {
                array = new ArrayList<Transaction>();
            } else if (role1.equals("client"))//if the transaction is made by client
            {
                array = new ArrayList<Transaction>();//creating arraylist to save any transaction related to this account or id

                rs = st.executeQuery("SELECT * FROM transaction WHERE accnum=" + accnum1);
                while (rs.next()) {

                    trans.setAccnum(accnum1);
                    trans.setType(rs.getString("type"));
                    trans.setExecutedby(rs.getString("executedby"));
                    trans.setAmount(rs.getInt("amount"));
                    trans.setDate(rs.getString("date"));
                    rs1 = st.executeQuery("select firstname,middlename from account_info where account_no=" + accnum1);
                    rs1.next();
                    trans.setName(rs1.getString("firstname") + " " + rs1.getString("middlename"));
                    array.add(trans);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return array;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Addnews")
    public boolean Addnews(@WebParam(name = "news") String news, @WebParam(name = "image") String image) {

        boolean bool = false;

        try {

            Connection con = getConnection();
            Statement ts = con.createStatement();
            String date1 = (new Date()) + "";
            String query = "insert into news(date,news,image,status) VALUES('" + date1 + "','" + news + "','" + image + "',1)";

            ts.execute(query);
            bool = true;
            con.close();
        } catch (Exception e) {
            e.printStackTrace();

        }

        return bool;

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Viewnews")
    public ArrayList<News> Viewnews() {
        ArrayList<News> news = new ArrayList();

        try {

            Connection con = getConnection();
            Statement ts = con.createStatement();
            ResultSet rs = ts.executeQuery("select * from news where Status=1 order by id desc");
            int i = 0;
            while (rs.next()) {
                News nw = new News();
                nw.setText(rs.getString("news"));
                nw.setImage(rs.getString("image"));
                nw.setDate(rs.getString("date"));
                news.add(i, nw);
                i++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return news;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "login")
    public String login(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        String bool = null;
        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            String user = username, pass = password;
            String query = "select * from login where username='" + user + "' and password='" + pass + "'";
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                bool = rs.getString("role"); // getting the id from login table it is primary key
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bool;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "get_accounts")
    public ArrayList<Account> get_accounts() {
        ArrayList<Account> acount = new ArrayList();

        try {

            Connection con = getConnection();
            Statement ts = con.createStatement();
            ResultSet rs = ts.executeQuery("select * from account_info order by firstname");
            int i = 0;
            while (rs.next()) {
                Account ac = new Account();
                ac.setACCNO(rs.getInt("account_no"));
                ac.setFNAME(rs.getString("firstname"));
                ac.setMNAME(rs.getString("middlename"));
                ac.setLNAME(rs.getString("lastname"));
                ac.setADDRESS(rs.getString("address"));
                ac.setNATIONALITY(rs.getString("nationality"));
                ac.setOCCUPTION(rs.getString("occupation"));
                ac.setPHOTO(rs.getString("photo"));
                ac.setDATE(rs.getString("date"));
                ac.setDISTRICT(rs.getString("district"));
                ac.setBRANCH(rs.getString("branch"));
                ac.setPNUM(rs.getString("phone_no"));
                ac.setACCTYPE(rs.getString("account_type"));
                ac.setGENDER(rs.getString("gender"));
                ac.setBALANCE(rs.getInt("balance"));
                ac.setSTATUS(rs.getInt("status"));
                acount.add(i, ac);
                i++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return acount;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateAccount")
    public Account updateAccount(@WebParam(name = "a") Account a) {
        try {
            Connection con = getConnection();
            Statement ts = con.createStatement();
            String empid = "3";
            String query = "UPDATE account_info SET firstname='" + a.getFNAME() + "',middlename='" + a.getMNAME() + "',lastname='" + a.getLNAME() + "',address='" + a.getADDRESS() + "',nationality='" + a.getNATIONALITY() + "',occupation='" + a.getOCCUPTION() + "',photo='" + a.getPHOTO() + "',date='" + a.getDATE() + "',district='" + a.getDISTRICT() + "',branch='" + a.getBRANCH() + "',phone_no='" + a.getPNUM() + "',account_type='" + a.getACCTYPE() + "',gender='" + a.getGENDER() + "',balance=" + a.getBALANCE() + ",empid='" + empid + "',status=" + a.getSTATUS() + " WHERE account_no=" + a.getACCNO();
            ts.executeUpdate(query);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return check(a.getACCNO());
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "activate")
    public boolean activate(@WebParam(name = "accnum") int accnum) {
        boolean bool = false;
        try {
            Connection con = getConnection();
            Statement ts = con.createStatement();
            String query = "UPDATE account_info SET status=1 where account_no=" + accnum;
            ts.executeUpdate(query);
            bool = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bool;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deactivate")
    public boolean deactivate(@WebParam(name = "accnum") int accnum) {
        boolean bool = false;
        try {
            Connection con = getConnection();
            Statement ts = con.createStatement();
            String query = "UPDATE account_info SET status=0 where account_no=" + accnum;
            ts.executeUpdate(query);
            bool = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bool;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "checkTransfer")
    public Transfer checkTransfer(@WebParam(name = "id") int id) {

        Transfer tr = new Transfer();
        try {
            //getting all data from the database using account number attribute
            Connection con = getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from transfer where id=" + id);
            rs.next();
            tr.setAmount(rs.getInt("amount"));
            tr.setAmount2(rs.getString("amount2"));
            tr.setDate(rs.getString("date"));
            tr.setEmp_id(rs.getInt("emp_id"));
            tr.setR_address(rs.getString("r_address"));
            tr.setR_branch(rs.getString("r_branch"));
            tr.setR_firstname(rs.getString("r_firstname"));
            tr.setR_lastname(rs.getString("r_lastname"));
            tr.setR_middlename(rs.getString("r_middlename"));
            tr.setR_phone(rs.getString("r_phone"));
            tr.setS_address(rs.getString("s_address"));
            tr.setS_branch(rs.getString("s_branch"));
            tr.setS_firstname(rs.getString("s_firstname"));
            tr.setS_lastname(rs.getString("s_lastname"));
            tr.setS_middlename(rs.getString("s_middlename"));
            tr.setId(rs.getInt("id"));
            st.close();
            con.close();
            rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return tr;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "get_transfers")
    public ArrayList<Transfer> get_transfers() {
        ArrayList<Transfer> tarray = new ArrayList();
        Transfer tr = new Transfer();
        try {

            Connection con = getConnection();
            Statement ts = con.createStatement();
            ResultSet rs = ts.executeQuery("select * from transfer order by id");

            while (rs.next()) {
                tr = checkTransfer(rs.getInt("id"));
                tarray.add(tr);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return tarray;
    }

    /**
     * Web service operation
     */
    /**
     * Web service operation
     */
    @WebMethod(operationName = "GrantTranfer")
    public boolean GrantTranfer(@WebParam(name = "id") int id, @WebParam(name = "emp_id") String emp_id) {
        boolean bool = false;
        try {
            Connection con = getConnection();
            Statement ts = con.createStatement();
            
            String query = "UPDATE transfer SET status=0 where id=" + id;
            ts.executeUpdate(query);
            
            String query2 = "select * from transfer where id=" + id;
            con = getConnection();
            ts = con.createStatement();
            ResultSet rs = ts.executeQuery(query2);
            rs.next();            
            
            String date=new Date().toString();
            String query3 = "insert into recieve (tr_id,rs_branch,date,emp_id) values("+id+",'"+rs.getString("r_branch")+"','"+date+"','"+emp_id+"')";
            con = getConnection();
            ts = con.createStatement();
            ts.execute(query3);
            bool = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bool;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "checkEmployee")
    public Employee checkEmployee(@WebParam(name = "id") int id) {
        Employee tr = new Employee();
        try {
            //getting all data from the database using account number attribute
            Connection con = getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from employee where empid=" + id);
            rs.next();
            tr.setFNAME(rs.getString("firstname"));
            tr.setMNAME(rs.getString("middlename"));
            tr.setLNAME(rs.getString("lastname"));
            tr.setGENDER(rs.getString("gender"));
            tr.setADDRESS(rs.getString("address"));
            tr.setNATIONALITY(rs.getString("nationality"));
            tr.setDISTRICT(rs.getString("district"));
            tr.setBRANCH(rs.getString("branch"));
            tr.setPNUM(rs.getString("pnum"));
            tr.setROLE(rs.getString("role"));
            tr.setSTATUS(rs.getString("status"));
            tr.setDate(rs.getString("date"));
            st.close();
            con.close();
            rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return tr;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "get_employees")
    public ArrayList<Employee> get_employees() {
        ArrayList<Employee> emp = new ArrayList();

        try {

            Connection con = getConnection();
            Statement ts = con.createStatement();
            ResultSet rs = ts.executeQuery("select * from employee");
            int i = 0;
            while (rs.next()) {
                Employee tr = new Employee();
                tr.setFNAME(rs.getString("firstname"));
                tr.setMNAME(rs.getString("middlename"));
                tr.setLNAME(rs.getString("lastname"));
                tr.setGENDER(rs.getString("gender"));
                tr.setADDRESS(rs.getString("address"));
                tr.setNATIONALITY(rs.getString("nationality"));
                tr.setDISTRICT(rs.getString("district"));
                tr.setBRANCH(rs.getString("branch"));
                tr.setPNUM(rs.getString("pnum"));
                tr.setROLE(rs.getString("role"));
                tr.setSTATUS(rs.getString("status"));
                tr.setDate(rs.getString("date"));
                tr.setEMPID(rs.getInt("empid"));
                emp.add(i, tr);
                i++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return emp;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deactivateemp")
    public boolean deactivateemp(@WebParam(name = "empid") int empid) {
        boolean bool = false;
        try {
            Connection con = getConnection();
            Statement ts = con.createStatement();
            String query = "UPDATE employee SET status=0 where empid=" + empid;
            ts.executeUpdate(query);
            bool = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bool;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "activateemp")
    public boolean activateemp(@WebParam(name = "empid") int empid) {
        boolean bool = false;
        try {
            Connection con = getConnection();
            Statement ts = con.createStatement();
            String query = "UPDATE employee SET status=1 where empid=" + empid;
            ts.executeUpdate(query);
            bool = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bool;
    }

}
