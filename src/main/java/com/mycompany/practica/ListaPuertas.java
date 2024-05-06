/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica;

import java.util.ArrayList;
import javax.swing.JTextField;

/**
 * Clase que representa una lista de puertas de embarque o desembarque en un aeropuerto.
 * @author Elia y Noelia
 */
public class ListaPuertas {
    ArrayList<String> lista; // Lista que contiene información sobre las puertas
    JTextField tf1, tf2, tf3, tf4, tf5, tf6; // Campos de texto para mostrar la información
    
    /**
    * Constructor de la clase ListaPuertas.
     * @param tf1 JTextField para la primera puerta
     * @param tf2 JTextField para la segunda puerta
     * @param tf3 JTextField para la tercera puerta
     * @param tf4 JTextField para la cuarta puerta
     * @param tf5 JTextField para la quinta puerta
     * @param tf6 JTextField para la sexta puerta
     */
    public ListaPuertas(JTextField tf1, JTextField tf2, JTextField tf3, JTextField tf4, JTextField tf5, JTextField tf6){
        //Inicialización de la lista y de los campos de texto
        lista = new ArrayList<>(6);
        this.tf1 = tf1;
        this.tf2 = tf2;
        this.tf3 = tf3;
        this.tf4 = tf4;
        this.tf5 = tf5;
        this.tf6 = tf6;
    }
    
    /**
     * Método sincronizado para agregar información sobre un avión a la lista de puertas.
     * @param av Avión relacionado
     * @param embarca true si el avión está embarcando, false si está desembarcando
     */
    public synchronized void meter(Avion av, boolean embarca){
        //Agreaga información sobre el avión a la lista y actualiza la visualización 
        String contenido;
        if(embarca){
            contenido = "embarcando: " + av.miId();
        }else{
            contenido = "desembarcando: " + av.miId();
        }
        lista.add(contenido);
        imprimir();
    }
    
    /**
     * Método sincronizado para eliminar información sobre un avión de la lista de puertas.
     * @param av Avión relacionado
     * @param embarca true si el avión estaba embarcando, false si estaba desembarcando

     */
    public synchronized void sacar(Avion av, boolean embarca){
        // Elimina información sobre el avión de la lista y actualiza la visualización
        String contenido;
        if(embarca){
            contenido = "embarcando: " + av.miId();
        }else{
            contenido = "desembarcando: " + av.miId();
        }
        lista.remove(contenido);
        imprimir();
    }
    
    /**
     * Método para imprimir la lista de puertas en los campos de texto correspondientes.
     */
    public void imprimir(){
        String contenido;
        // Itera sobre la lista y actualiza los campos de texto según corresponda
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
