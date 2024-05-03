/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica;

import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author elia3
 */
public class ListaPuertas {
    ArrayList<String> lista;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6;
    
    public ListaPuertas(JTextField tf1, JTextField tf2, JTextField tf3, JTextField tf4, JTextField tf5, JTextField tf6){
        lista = new ArrayList<>(6);
        this.tf1 = tf1;
        this.tf2 = tf2;
        this.tf3 = tf3;
        this.tf4 = tf4;
        this.tf5 = tf5;
        this.tf6 = tf6;
    }
    
    public synchronized void meter(Avion av, boolean embarca){
        String contenido;
        if(embarca){
            contenido = "embarcando: " + av.miId();
        }else{
            contenido = "desembarcando: " + av.miId();
        }
        lista.add(contenido);
        imprimir();
    }
    
    public synchronized void sacar(Avion av, boolean embarca){
        String contenido;
        if(embarca){
            contenido = "embarcando: " + av.miId();
        }else{
            contenido = "desembarcando: " + av.miId();
        }
        lista.remove(contenido);
        imprimir();
    }
    
    public void imprimir(){
        String contenido;
        for (int i = 0; i < lista.size(); i++){
            
            if ( i == 0){
                contenido = lista.get(i);
                tf1.setText(contenido);
            } 
            if (i == 1){
                contenido = lista.get(i);
                tf2.setText(contenido);
            } 
            if ( i == 2){
                contenido = lista.get(i);
                tf3.setText(contenido);
            } 
            if ( i == 3){
                contenido = lista.get(i);
                tf4.setText(contenido);
            } 
            if ( i == 4){
                contenido = lista.get(i);
                tf5.setText(contenido);
            }
            if ( i == 5){
                contenido = lista.get(i);
                tf6.setText(contenido);
            }        
        }
    }
}
