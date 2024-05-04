/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica;

import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author NoeliaUni
 */
public class ListasPistas {
    ArrayList<Thread> lista;
    JTextField p1,p2,p3,p4;

    public ListasPistas(JTextField p1, JTextField p2, JTextField p3, JTextField p4) {
        lista = new ArrayList<>(4);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }
    
    public synchronized void meter(Avion av){
        lista.add(av);
        imprimir();  
    }
    
    public synchronized void sacar(Avion av){
        lista.remove(av);
        imprimir();
    }
    
    public synchronized boolean estaOcupada(int numPista, Avion av){
        boolean ocupada = false;
        for(int i = 0; i < lista.size(); i++){
            if(i == 0 && lista.contains(av)){
                numPista = 1;
                ocupada = true;
            } else if( i == 1 && lista.contains(av)){
                numPista = 2;
                ocupada = true;
            } else if( i == 2 && lista.contains(av)){
                numPista = 3;
                ocupada = true;
            } else if(i == 3 && lista.contains(av)){
                numPista = 4;
                ocupada = true;
            }else{
                ocupada = false;
            }
        }
        return ocupada;
    }
    
    public void imprimir(){
        String contenido;
        for(int i = 0; i < lista.size(); i++){
            
            if(i == 0){
                contenido = ((Avion)lista.get(i)).miId();
                p1.setText(contenido);
            }
            if(i == 1){
                contenido = ((Avion)lista.get(i)).miId();
                p2.setText(contenido);
            }
            if(i == 2){
                contenido = ((Avion)lista.get(i)).miId();
                p3.setText(contenido);
            }
            if(i == 3){
                contenido = ((Avion)lista.get(i)).miId();
                p4.setText(contenido);
            }
        }
    }
}
