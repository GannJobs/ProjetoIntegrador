package Class;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import Class.LG;
import Telas.TMenu;


public class LGDAO {
    
    boolean v = false;

public void Cadastro(LG lg) throws ClassNotFoundException, SQLException{
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INDO Users (code,nome,senha) VALUES (?,?,?)");
            stmt.setInt(1,lg.getCode());
            stmt.setString(2,lg.getNome());
            stmt.setString(3,lg.getSenha());
            stmt.executeUpdate();
        } catch (SQLException ex){
            ex.printStackTrace();
            throw new RuntimeException("Erro ao inserir informação no banco de dados");
        } finally {
            Conexao.Encerrarcon(con);
        }
    }

public List<LG> consulta() throws ClassNotFoundException, SQLException{
       Connection con = Conexao.getConexao();
       PreparedStatement stmt = null;  
       ResultSet rs = null;
       List<LG> logs = new ArrayList<LG>();
       try{
           stmt = con.prepareStatement("select * from Users");
           rs = stmt.executeQuery();  
           while (rs.next()){
               LG log =  new LG();         
               log.setId(rs.getInt("Id"));
               log.setCode(rs.getInt("Code"));
               log.setNome(rs.getString("Nome"));
               log.setSenha(rs.getString("Senha"));
               logs.add(log);     
           }
       }catch (SQLException s){
           s.printStackTrace();
       }
        finally {
            Conexao.Encerrarcon(con);
        }
      return logs;      
   }

public void excluir(LG lg) throws ClassNotFoundException, SQLException {
        
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE from Users WHERE id = ?");
            stmt.setInt(1, lg.getId());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Erro ao apagar informação no banco de dados");
        } finally {
            Conexao.Encerrarcon(con);

        }
    }
     public void verificar(String nome, String senha) throws SQLException, ClassNotFoundException{
       String Nome = nome;
       String Senha = senha;
       Connection con = Conexao.getConexao();
       PreparedStatement stmt = null;  
       ResultSet rs = null;
       List<LG> logs = new ArrayList<LG>();
       try{
           stmt = con.prepareStatement("select * from Users");
           rs = stmt.executeQuery();  
           while (rs.next()){
               LG log =  new LG();         
               log.setId(rs.getInt("Id"));
               log.setCode(rs.getInt("Code"));
               log.setNome(rs.getString("Nome"));
               log.setSenha(rs.getString("Senha"));
               logs.add(log);  
               if(log.getNome() == Nome && log.getSenha() == Senha){
               TMenu.loginStatus = true;
               }
           }
       }catch (SQLException s){
           s.printStackTrace();
       }
        finally {    
               Conexao.Encerrarcon(con);  
        }
     }
     public void verificarCode(int code,String nome, String senha) throws SQLException, ClassNotFoundException{
       String Nome = nome;
       String Senha = senha;
       int Code = code;
       Connection con = Conexao.getConexao();
       PreparedStatement stmt = null;  
       ResultSet rs = null;
       List<LG> logs = new ArrayList<LG>();
       try{
           stmt = con.prepareStatement("select * from Users WHERE Code LIKE %?%");
           rs = stmt.executeQuery();  
           while (rs.next()){
               LG log =  new LG();         
               log.setId(rs.getInt("Id"));
               log.setCode(rs.getInt("Code"));
               log.setNome(rs.getString("Nome"));
               log.setSenha(rs.getString("Senha"));
               logs.add(log);               
               int c = log.getCode();
               this.v = c == Code;
           }
       }catch (SQLException s){
           s.printStackTrace();
       }
        finally {      
               Conexao.Encerrarcon(con);
        }   
     }
}
