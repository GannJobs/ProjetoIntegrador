package Class;

import java.util.List;


public class LG {
    private int Id;
    private int Code;
    private String Nome;
    private String Senha;
    
    public int getId(){
        return this.Id;
    }
    
    public void setId(int id){
        this.Id = id;
    }
    
    public int getCode(){
        return this.Code;
    }
    
    public void setCode(int code){
        this.Code = code;
    }
    
    public String getNome(){
        return this.Nome;
    }
    
    public void setNome(String nome){
        this.Nome = nome;
    }
    
    public String getSenha(){
        return this.Senha;
    }
    
    public void setSenha(String senha){
        this.Senha = senha;
    }

    void add(List<LG> log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
