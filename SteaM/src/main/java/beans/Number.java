/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author marvinpieper
 */
@Named(value = "addTwoNumber")
@SessionScoped
public class Number implements Serializable{
    private int b; 
  
    
    public int getB(){
        return b;
    }
    
    public void setB(int b){
        this.b = b;
    }
    
    public void addTwoB(){
        this.b = b+2;
    }
}
