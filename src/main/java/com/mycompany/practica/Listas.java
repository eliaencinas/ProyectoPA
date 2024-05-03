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
        imprimirAv();
    }
    
    public synchronized void sacar(Thread t){
        lista.remove(t);
        imprimirAv();
    }
    
    public void imprimirAv(){
        String contenido = "";
        for (int i = 0; i<lista.size(); i++) {
            System.out.println("-----se imprime: " +((Avion)lista.get(i)).miId());
            contenido += ((Avion)lista.get(i)).miId() + " "; // Muestra ID del avión
        }
        tf.setText(contenido);
    }
}
