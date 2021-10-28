package Class;

import Class.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Class.Feed;


public class FeedDAO {
    
    public void incluirF(Feed feed) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO ADCFEED (Eg, Pt) VALUES (?,?)");
            stmt.setString(1, feed.getEg());
            stmt.setString(2, feed.getPt());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Erro ao inserir informação no banco de dados");
        } finally {
            Conexao.Encerrarcon(con);
        }
    }

    public void incluirE(Feed feed) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO EXCERROR (Eror) VALUES (?)");
            stmt.setString(1, feed.getFed());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Erro ao inserir informação no banco de dados");
        } finally {
            Conexao.Encerrarcon(con);
        }
    }
    
    public void excluirF(Feed feed) throws ClassNotFoundException, SQLException {  
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE from ADCFEED WHERE id = ?");
            stmt.setInt(1, feed.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Erro ao deletar informação no banco de dados");
        } finally {
            Conexao.Encerrarcon(con);
        }
    }

    public void excluirE(Feed feed) throws ClassNotFoundException, SQLException {  
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE from EXCERROR WHERE id = ?");
            stmt.setInt(1, feed.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Erro ao deletar informação no banco de dados");
        } finally {
            Conexao.Encerrarcon(con);
        }
    }
 
   public List<Feed> consultaE() throws ClassNotFoundException, SQLException{
       Connection con = Conexao.getConexao();
       PreparedStatement stmt = null;
       ResultSet rs = null;
       List<Feed> feeds = new ArrayList<Feed>();
       try{   
           stmt = con.prepareStatement("select id, fed from disciplina");
           rs = stmt.executeQuery();        
           while (rs.next()){
               Feed feed =  new Feed();            
               feed.setId(rs.getInt("Id"));
               feed.setFed(rs.getString("Fed"));    
               feeds.add(feed);    
           }    
       }catch (SQLException s){
           s.printStackTrace();    
       }finally {
            Conexao.Encerrarcon(con);
        }     
      return feeds;   
   }
   
   public List<Feed> consultaF() throws ClassNotFoundException, SQLException{
       Connection con = Conexao.getConexao();
       PreparedStatement stmt = null;
       ResultSet rs = null;
       List<Feed> feeds = new ArrayList<Feed>();
       try{   
           stmt = con.prepareStatement("select id, Eg, Ig from ADCFEED");
           rs = stmt.executeQuery();        
           while (rs.next()){
               Feed feed =  new Feed();            
               feed.setId(rs.getInt("Id"));
               feed.setEg(rs.getString("Eg"));
               feed.setPt(rs.getString("Pt"));    
               feeds.add(feed);    
           }    
       }catch (SQLException s){
           s.printStackTrace();    
       }finally {
            Conexao.Encerrarcon(con);
        }     
      return feeds;  
   }
}
