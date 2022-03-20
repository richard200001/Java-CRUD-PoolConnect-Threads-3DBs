package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
   
    private final static String DB1="";
    
    private final static String DB2="";
    
    private final static String DB3="";
    
    private final static String host1="";
    
    private final static String puerto1="";
    
    private final static String host2="";
    
    private final static String puerto2="";
    
    private final static String host3="";
    
    private final static String puerto3="";
    
    private static String URL;
    public static void getDecidirDB(int num){
        if(num==1){
              URL="jdbc:mysql://"+host1+":"+puerto1+"/"+DB1+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        }
        if(num==2){
              URL="jdbc:mysql://"+host2+":"+puerto2+"/"+DB2+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        }
        if(num==3){
              URL="jdbc:mysql://"+host3+":"+puerto3+"/"+DB3+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        }
        
    }
    
    private final String USER="";
    private final String PASS="";
   
    private static Conexion dataSource;
    private BasicDataSource basicDataSource=null;
   
    private Conexion(){
     
        basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername(USER);
        basicDataSource.setPassword(PASS);
        basicDataSource.setUrl(URL);
       
        basicDataSource.setMinIdle(10);
        basicDataSource.setMaxIdle(20);
        basicDataSource.setMaxTotal(50);
        basicDataSource.setMaxWaitMillis(-1);
       
    }
    
    public static Conexion getInstance() {
        if (dataSource == null) {
            dataSource = new Conexion();
            return dataSource;
        } else {
            return dataSource;
        }
    }

    public Connection getConnection() throws SQLException{
      return this.basicDataSource.getConnection();
    }
   
    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }    
   
}