import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCPostgreSQL {
    public static void main(String[] args) throws Exception {
    
    /*
     * 1. Import SQL package
     * 2. Load and Register Driver
     * 3. Create Connection
     * 4. Create Statement
     * 5. Execute Statement
     * 6. Process the Results
     * 7. Close the Connection
     */

     String url = "jdbc:postgresql://localhost:5432/JDBCProject";
     String uName ="postgres";
     String pswd = "abc@123";
     String sql = "select * from student";

     //Class.forName("org.postgresql.Driver");
     Connection con = DriverManager.getConnection(url, uName, pswd);
     System.out.println("Connection Established");
     Statement st = con.createStatement();

     /*
      * If you have dynamic data in your query use 'PREPARED STATEMENT'
      * or when doing insert,update delete operations in table
      * STATEMENT can be used when doing DROP/SELECT operations on table 
      */

    //  int sid = 101;
    //  String sname = "gurav";
    //  int smarks = 99;

    //  PreparedStatement pst = con.prepareStatement(sql);
    //  pst.setInt(1, sid);
    //  pst.setString(2, sname);
    //  pst.setInt(3, smarks);

    //  pst.execute();

     ResultSet rs = st.executeQuery(sql);
     System.out.println("Running the sql query: " + sql);
    //  rs.next();
    //  String name = rs.getString("sName");
    //  System.out.println("Name of a student is : " + name);

    while(rs.next()) {
        System.out.print(rs.getInt(1) + "-");
        System.out.print(rs.getString(2) + "-");
        System.out.println(rs.getInt(3));

    }

    con.close();
    System.out.println("Connection Closed...");
    

    }    

}
