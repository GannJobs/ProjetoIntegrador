package Class;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
    
    private static String DRIVE_MYSQL = "/com.mysql.cj.jdbc.Driver/";
    private static String ENDERECO = null;
    private static String USUARIO = null;
    private static String PASSWORD = null;
    
  public static Properties getProp() throws IOException {
      
      Properties props = new Properties();
      FileInputStream file = new FileInputStream("/mavenproject1/Properties/Properties.properties");
      props.load(file);
      ENDERECO = props.getProperty("prop.server.host");
      USUARIO = props.getProperty("prop.server.login");
      PASSWORD = props.getProperty("prop.server.password");
    
      return props;
  }  
  
  public static Connection getConexao() throws ClassNotFoundException, SQLException{
    
    try {  
      Class.forName(DRIVE_MYSQL);
      Connection con = DriverManager.getConnection(ENDERECO,USUARIO,PASSWORD);
      return con;
    } catch (ClassNotFoundException | SQLException ex){
      ex.printStackTrace();
      throw new RuntimeException("erro ao se comunicar com o BD");
    }
  }
  
  public static void Encerrarcon(Connection con){
      try {
          if (con != null){
              con.close();
          }
      } catch (SQLException ex) {
          throw new RuntimeException("erro ao encerrar comunicacao com o BD");
      }
  } 
  
}
