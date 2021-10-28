package Class;

import Class.FeedDAO;
import java.util.ArrayList;
import java.util.List;

public class FeedBO {
    
   public List<Feed> consultaF(){
       FeedDAO dao = new FeedDAO();     
       List<Feed> feeds = new ArrayList<Feed>();       
       try{       
           feeds =  dao.consultaF();       
        }catch(Exception e){
            throw new RuntimeException("Erro ao recuperar no banco de dados");
        }
       return feeds;       
    }
    
    public void incluirF(Feed feed){      
        FeedDAO dao = new FeedDAO();       
        try{       
            dao.incluirF(feed);      
        }catch(Exception e){
            throw new RuntimeException("Erro ao inserir informação no banco de dados");
        }        
    }
    
     public void excluirF(Feed feed){      
        FeedDAO dao = new FeedDAO();       
        try{     
            dao.excluirF(feed);     
        }catch(Exception e){
            throw new RuntimeException("Erro ao excluir a informação no banco de dados");    
        }
    }
   public List<Feed> consultaE(){
       FeedDAO dao = new FeedDAO();     
       List<Feed> feeds = new ArrayList<Feed>();       
       try{       
           feeds =  dao.consultaE();       
        }catch(Exception e){
            throw new RuntimeException("Erro ao recuperar no banco de dados");
        }
       return feeds;       
    }
    
    public void incluirE(Feed feed){      
        FeedDAO dao = new FeedDAO();       
        try{       
            dao.incluirE(feed);      
        }catch(Exception e){
            throw new RuntimeException("Erro ao inserir informação no banco de dados");
        }        
    }
    
     public void excluirE(Feed feed){      
        FeedDAO dao = new FeedDAO();       
        try{     
            dao.excluirE(feed);     
        }catch(Exception e){
            throw new RuntimeException("Erro ao excluir a informação no banco de dados");    
        }
    }

}