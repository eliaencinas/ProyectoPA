/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica;

import java.io.Serializable;

/**
 *
 * @author elia3
 */
public class HiloSuperior implements Serializable{
    private boolean reanudar;
    
    public HiloSuperior(){
        reanudar = true;
    }
    
    public synchronized void esperar(){
       try{
           while(!reanudar){
                wait();
            }
        }catch (InterruptedException e){}
        
    }
    
    public synchronized boolean estaEjecutando(){
        return reanudar;
    }
    
    
    public synchronized void detener(){
        reanudar = false;
    }
    
    
    public synchronized void reanudar(){
        reanudar = true;
        notifyAll();
    }
    
}
