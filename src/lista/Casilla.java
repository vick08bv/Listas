/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

/**
 *
 * @author vick08bv
 */
public class Casilla {
    
    
    private char info;
    private Casilla sig;
    
    
    public Casilla(){
        super();
        this.info = '\000';
        this.sig = null;
    }
    
    
    public Casilla(char c){
    
        super();
        this.info = c;
        this.sig = null;
    
    }
    
    
    public boolean equals(Casilla c){
    
        return this.info == c.info;
    
    }
    
    
    public char getInfo(){
    
        return this.info;
    
    }
    
    
    public void setInfo(char c){
    
        this.info = c;
        
    }
    
    
    public void setSig(Casilla s){
    
        this.sig = s;
        
    }
    
    
    public String toString(){
    
        return this.info + "";
    
    }
    
}
