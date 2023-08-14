/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;


/**
 *
 * @author ar948052
 */
public class NivSommet {
    private int num;
    private int cout;
    
    public NivSommet(int numero, int cost){
        num = numero;
        cout = cost;
    }
    
    public int GetNum(){
        return num;
    }
    
    public void setNum(int numero){
        num = numero;
    }
    
    public int GetCout(){
        return cout;
    }
    
    public void setCout(int cost){
        cout = cost;
    }
}
