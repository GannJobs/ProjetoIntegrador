package Class;

import Class.Conexao;
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
import Class.Traducao;
import static Class.TraducaoBO.trad;

public class TraducaoDAO {
    
    public void Incluir(Traducao traducao) throws ClassNotFoundException, SQLException{
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INDO traducao (eg,pt) VALUES (?,?)");
            stmt.setString(1, traducao.getEg());
            stmt.setString(2, traducao.getPt());
            stmt.executeUpdate();
        } catch (SQLException ex){
            ex.printStackTrace();
            throw new RuntimeException("Erro ao inserir informação no banco de dados");
        } finally {
            Conexao.Encerrarcon(con);
        }
    }
    
    public void Atualizar(Traducao traducao) throws ClassNotFoundException, SQLException{
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("UPDATE traducao SET Eg = ? , Pt = ? where Id = ? ");
            stmt.setString(1, traducao.getEg());
            stmt.setString(2, traducao.getPt());
            stmt.setInt(3, traducao.getId());
            stmt.executeUpdate();
        } catch (SQLException ex){
            ex.printStackTrace();
            throw new RuntimeException("Erro ao atualizar informação no banco de dados");
        } finally {
            Conexao.Encerrarcon(con);
        }
    } 
    public void excluir(Traducao traducao) throws ClassNotFoundException, SQLException {
        
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE from traducao WHERE id = ?");
            stmt.setInt(1, traducao.getId());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Erro ao apagar informação no banco de dados");
        } finally {
            Conexao.Encerrarcon(con);

        }
    }
public List<Traducao> consulta() throws ClassNotFoundException, SQLException{
       Connection con = Conexao.getConexao();
       PreparedStatement stmt = null;  
       ResultSet rs = null;
       List<Traducao> traducoes = new ArrayList<Traducao>();
       try{
           stmt = con.prepareStatement("select id, Eg, Pt from Traducao");
           rs = stmt.executeQuery();  
           while (rs.next()){
               Traducao traducao =  new Traducao();         
               traducao.setId(rs.getInt("id"));
               traducao.setEg(rs.getString("Eg"));
               traducao.setPT(rs.getString("Pt")); 
               traducoes.add(traducao);     
           }
       }catch (SQLException s){
           s.printStackTrace();
       }
        finally {
            Conexao.Encerrarcon(con);
        }
      return traducoes;      
   }
public String Translate () throws ClassNotFoundException, SQLException{
       Connection con = Conexao.getConexao();
       PreparedStatement stmt = null;  
       ResultSet rs = null;
       String trad = null;
       try{
            stmt = con.prepareStatement("select Pt from Traducao WHERE Eg LIKE %?%");
               Traducao traducao =  new Traducao();
               traducao.setId(rs.getInt("Id"));
               traducao.setPT(rs.getString("Pt"));  
               trad = traducao.getPt();
       }catch (SQLException s){
           s.printStackTrace();
       }
        finally {
            Conexao.Encerrarcon(con);
        }
        return trad;
    }
}