
import entity.Account;
import entity.Employee;
import entity.News;
import entity.Transaction;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

public class OnlineBank extends UnicastRemoteObject implements ONLINEBANKING {

    Statement st = null;
    Connection con = null;

    public OnlineBank() throws RemoteException {
        super();
        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private Connection getConnection() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String Url = "jdbc:sqlserver://LAPTOP-LC4FOIS7;DatabaseName=bank;user=sa;Password=123";
        Connection con = DriverManager.getConnection(Url);
        return con;
    }

    @Override
    public int createAccount(String FNAME, String MNAME, String LNAME, String ADDRESS, String ACCTYPE, String OCCUPTION, String DISTRICT, String BRANCH, int BALANCE, String PNUM, String PHOTO, String GENDER, String NATIONALITY, int STATUS) throws RemoteException {
        int value = 0;
        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            String date = new Date().toString();
            String query = "INSERT INTO account_info(firstname, middlename, lastname, address, nationality, occupation, photo, date, district, branch, phone_no, account_type, gender, balance, empid,status) "
                    + "VALUES('" + FNAME + "','" + MNAME + "','" + LNAME + "','" + ADDRESS + "','" + NATIONALITY + "','" + OCCUPTION + "','" + PHOTO
                    + "','" + date + "','" + DISTRICT + "','" + BRANCH + "','" + PNUM + "','" + ACCTYPE + "','" + GENDER + "'," + BALANCE + ",'3',1)";
            st.execute(query);

            ResultSet rs = st.executeQuery("select account_no from account_info order by account_no desc");
            rs.next();
            value = rs.getInt("account_no");
            
            con = getConnection();
            Statement ts = con.createStatement();
            query = "INSERT INTO login (accnum, username, password, role) VALUES ("+value+", '"+FNAME+"', '123456', 'client')";
            ts.executeUpdate(query);

            st.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return value;
    }

    @Override
    public boolean checkBalance(int acNumber, int amount) throws RemoteException {
        boolean rt = false;
        ResultSet rs = null;

        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            rs = st.executeQuery("select * from account_info where account_no=" + acNumber);
            if (rs.next()) {
                int bal = rs.getInt("balance");
                if (bal >= amount) {
                    rt = true;
                }
            }

            st.close();
            con.close();
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rt;
    }

    /**
     *
     * @param acNumber
     * @return
     * @throws RemoteException
     */
    @Override
    public boolean checkAccount(int acNumber) throws RemoteException {

        boolean rt = false;
        ResultSet rs = null;

        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            rs = st.executeQuery("select * from account_info where account_no=" + acNumber);
            if (rs.next()) {
                rt = true;
            }

            st.close();
            con.close();
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rt;
    }

    @Override
    public boolean updateAccount(Account acount) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Account> getAccounts() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deposite(int AMOUNT, String AMOUNT2, int FROM, int TO, String BRANCH, String PNUM, String date, String role) throws RemoteException {

        boolean bool = false;
        String query = "INSERT INTO deposite( amount, amount2, r_account_no,"
                + " s_account_no, branch, s_phone_no, date, role) VALUES "
                + "(" + AMOUNT + ",'" + AMOUNT2 + "'," + TO + "," + FROM + ","
                + "'" + BRANCH + "','" + PNUM + "','" + date + "','" + role + "')";

        try {
            Connection con = getConnection();
            Statement st = con.createStatement();

            st.execute(query);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        String quer2 = "select * from account_info where account_no=" + TO;
        try {
            Connection con = getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(quer2);
            rs.next();
            int val = rs.getInt("balance") + AMOUNT;
            String query3 = "UPDATE account_info SET balance=" + val + " where account_no=" + TO;
            st.executeUpdate(query3);

            String query4 = "select * from account_info where account_no=" + FROM;
            rs = st.executeQuery(query4);
            rs.next();
            int value2 = rs.getInt("balance") - AMOUNT;
            String query5 = "UPDATE account_info SET balance=" + value2 + " where account_no=" + FROM;
            st.executeUpdate(query5);
            bool = true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return bool;

    }

    @Override
    public boolean withdrawRMI(int ACNUMBER, int AMOUNT, String AMOUNT2, String EMP) throws RemoteException {

        boolean return_value = false;
        ResultSet rs = null;
        String date = new Date().toString();
        String query = "INSERT INTO withdraw(account_no, amount, date, emp_id,amount2) VALUES (" + ACNUMBER + "," + AMOUNT + ",'" + date + "','" + EMP + "','" + AMOUNT2 + "')";
        String query1 = "select * from account_info where account_no=" + ACNUMBER;

        try {
            Connection con = getConnection();
            Statement st = con.createStatement();

            rs = st.executeQuery(query1);//get the current balance from account_info table
            rs.next();

            int balance = rs.getInt("balance") - AMOUNT;
            if (balance > 0) {
                String update = "UPDATE account_info SET balance=" + balance + "  WHERE account_no=" + ACNUMBER;
                int executeUpdate = st.executeUpdate(update); //update the current balalnce
                boolean execute = st.execute(query);//insert the withdraw info
                return_value = true;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return return_value;

    }

    @Override
    public int transfer(int amount, String amount2, String s_branch, String s_firstname, String s_middlename, String s_lastname, String s_address, String date, String r_firstname, String r_middlename, String r_lastname, String r_address, String r_phone, String r_branch, String emp_id, int status) throws RemoteException {

        int bool = 0;

        String query = "INSERT INTO transfer(s_branch, s_firstname, s_middlename, s_lastname, "
                + "s_address, amount, amount2, date, r_firstname, r_middlename, r_lastname, "
                + "r_address, r_phone, r_branch, emp_id,status) VALUES ('" + s_branch + "',"
                + "'" + s_firstname + "','" + s_middlename + "','" + s_lastname + "'"
                + ",'" + s_address + "'," + amount + ",'" + amount2 + "','" + date + "'"
                + ",'" + r_firstname + "','" + r_middlename + "','" + r_lastname + "',"
                + "'" + r_address + "','" + r_phone + "','" + r_branch + "'," + emp_id + ",1)";

        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            st.execute(query);
            String q = "select * from transfer order by id desc ";
            ResultSet Rs = st.executeQuery(q);
            Rs.next();
            bool = Rs.getInt("id");

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return bool;
    }

    @Override
    public List<Transaction> transaction(String acNumber) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean manageEmployee(Employee emp) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employee getEmployee(String empId) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Employee> getEmployees() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean manageNews(String newsId) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public News getSingleNews(String newsId) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String addNews(News news) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<News> getNews() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int addEmployee(String FNAME, String MNAME, String LNAME, String GENDER, String ADDRESS, String NATIONALITY, String DISTRICT, String BRANCH, String PNUM, String PHOTO, String Date, String ROLE, String STATUS) throws RemoteException {
        int emp = 0;
        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            String query = "INSERT INTO employee(firstname, middlename, lastname, address, gender, date, role, status, photo, district, branch, pnum, nationality) "
                    + "VALUES ('" + FNAME + "','" + MNAME + "','" + LNAME + "','" + ADDRESS + "','" + GENDER + "','" + Date + "','" + ROLE + "','" + STATUS + "','" + PHOTO + "','" + DISTRICT + "','" + BRANCH + "','" + PNUM + "','" + NATIONALITY + "')";
            st.execute(query);
           
            ResultSet rs = st.executeQuery("select empid from employee order by empid desc");
            rs.next();
            emp = rs.getInt("empid");
            
            con = getConnection();
            Statement ts = con.createStatement();
            query = "INSERT INTO login (accnum, username, password, role) VALUES ("+emp+", '"+FNAME+"', '123456', 'teller')";
            ts.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return emp;
    }

    @Override
    public int updateEmployee(String FNAME, String MNAME, String LNAME, String GENDER, String ADDRESS, String NATIONALITY, String DISTRICT, String BRANCH, String PNUM, String PHOTO, String Date, String ROLE, String STATUS, int empid) throws RemoteException {
        int i = 0;
        try {
            Connection con = getConnection();
            Statement ts = con.createStatement();

            String query = "UPDATE employee SET firstname='" + FNAME + "',middlename='" + MNAME + "',lastname='" + LNAME + "',address='" + ADDRESS + "',nationality='" + NATIONALITY + "',date='" + Date + "',district='" + DISTRICT + "',branch='" + BRANCH + "',pnum='" + PNUM + "',gender='" + GENDER + "',status='" + STATUS + "' WHERE empid=" + empid;
            ts.executeUpdate(query);
            i = 1;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return i;
    }

    @Override
    public boolean activateemp(int empid) throws RemoteException {
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

    @Override
    public boolean deactivateemp(int empid) throws RemoteException {
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
}
