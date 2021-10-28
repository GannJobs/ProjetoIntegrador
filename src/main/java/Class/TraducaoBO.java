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

public class TraducaoBO {
    
    static String trad;
    
    public TraducaoBO(){
        
        
    }
        
    public List<Traducao> consulta(){
       TraducaoDAO dao = new TraducaoDAO();
       List<Traducao> traducoes = new ArrayList<Traducao>();      
       try{   
           traducoes =  dao.consulta();
        }catch(Exception e){
            throw new RuntimeException("Erro ao recuperar no banco de dados");
        }
       return traducoes; 
    }
    
    public String Translate () throws ClassNotFoundException, SQLException{
        TraducaoDAO dao = new TraducaoDAO();
        String TRAD = null;
        try{
        TRAD = dao.Translate();
    }catch(Exception e){
        throw new RuntimeException("Erro ao traduzir");
    }
    return TRAD;
    }
    
    public void incluir(Traducao traducao){  
        TraducaoDAO dao = new TraducaoDAO(); 
        try{
            dao.Incluir(traducao);
        }catch(Exception e){
            throw new RuntimeException("Erro ao inserir informação no banco de dados");
        }
    }
    
     public void excluir(Traducao traducao){
        TraducaoDAO dao = new TraducaoDAO();
        try{
            dao.excluir(traducao);
        
        }catch(Exception e){
            throw new RuntimeException("Erro ao excluir a informação no banco de dados");
        } 
    }
    
    public void alterar(Traducao traducao){
        TraducaoDAO dao = new TraducaoDAO();
        try{
            dao.Atualizar(traducao);
        }catch(Exception e){
            throw new RuntimeException("Erro ao alterar a informação no banco de dados");
        }
    }
    
     
}
