/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica;

import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author elia y noelia
 */
public class Listas {
    ArrayList<Thread> lista;
    JTextField tf;

    public Listas(JTextField tf) {
        lista = new ArrayList<Thread>();
        this.tf = tf;
    }
    
    public synchronized void  meter(Thread t){
        lista.add(t);
        imprimir();
    }
    
    public synchronized void sacar(Thread t){
        lista.remove(t);
        imprimir();
    }
    
    public void imprimir(){
        String contenido = "";
        for (int i = 0; i<lista.size(); i++) {
            if (lista.get(i) instanceof Avion) {
            contenido += "Avion: " + ((Avion) lista.get(i)).miId() + " ";
        } else if (lista.get(i) instanceof Autobus) {
            contenido += "Bus: " + ((Autobus) lista.get(i)).miId() + " ";
        }
        }
        tf.setText(contenido);
    }
    
    public int longitud(){
       return lista.size();
    }
}
