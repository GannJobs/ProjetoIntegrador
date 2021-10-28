package Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Class.Conexao;
import Telas.TMenu;


public class LGBO {
    
    boolean v = false;
    
    public boolean getV (){
        return this.v;
    }
    
    public void setV(boolean a){
        this.v = a;
    }
    
    private int c;
    public void incluir(LG lg){  
        LGDAO dao = new LGDAO(); 
        try{
            if(dao.v == true){
            dao.Cadastro(lg);
            }
        }catch(Exception e){
            throw new RuntimeException("Erro ao inserir informação no banco de dados");
        }
    }
    
     public void excluir(LG lg){
        LGDAO dao = new LGDAO();
        try{
            dao.excluir(lg);
        }catch(Exception e){
            throw new RuntimeException("Erro ao excluir a informação no banco de dados");
        } 
    }
     
     public void verify(String nome, String senha) throws SQLException, ClassNotFoundException{
       String Nome = nome;
       String Senha = senha;
       LGDAO lgdao = new LGDAO();
       try{
           lgdao.verificar(Nome, Senha);
       }catch (Exception e){
           throw new RuntimeException("Erro ao verificar a informação no banco de dados");
       }
     }

     public void verificarC(int code,String nome, String senha) throws SQLException, ClassNotFoundException{
       String Nome = nome;
       String Senha = senha;
       int Code = code;
       LGDAO lgdao = new LGDAO();
       if(lgdao.v == true){
           this.setV(v);
       }
       try{
         lgdao.verificarCode(Code, Nome, Senha);
       }catch (Exception e){
           throw new RuntimeException("Erro ao verificar a informação no banco de dados");
       }  
     } 
}
