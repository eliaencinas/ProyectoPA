/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica;

import java.util.ArrayList;
import javax.swing.JTextField;

/**
 * * Clase que gestiona una lista de objetos de tipo Thread.
 * Esta clase proporciona métodos para añadir y sacar elementos de la lista,
 * así como para imprimir el contenido de la lista en un campo de texto.
 * @author elia y noelia
 */
public class Listas {
    ArrayList<Thread> lista;
    JTextField tf;

    /**
     * Constructor de la clase Listas.
     * @param tf Campo de texto donde se mostrará el contenido de la lista
     */
    public Listas(JTextField tf) {
        lista = new ArrayList<Thread>(); //Inicializa la lista
        this.tf = tf; // Asigna el campo de texto proporcionado
    }
    
    /**
     * Método para añadir un elemento a la lista.
     * @param t Elemento a añadir a la lista
     */
    public synchronized void  meter(Thread t){
        lista.add(t); // Añade el elemento a la lista
        imprimir(); // Actualiza la información de la lista en el campo de texto
    }
    
    /**
     * Método para sacar un elemento de la lista.
     * @param t Elemento a sacar de la lista
     */
    public synchronized void sacar(Thread t){
        lista.remove(t); // Elimina el elemento de la lista
        imprimir(); // Actualiza la visualización del contenido de la lista en el campo de texto
    }
    
    /**
     * Método para imprimir el contenido de la lista en el campo de texto.
     */
    public void imprimir(){
        String contenido = ""; // String para almacenar el contenido de la lista
        // Itera sobre los elementos de la lista
        for (int i = 0; i<lista.size(); i++) {
            // Verifica el tipo de objeto y construye la representación de cadena correspondiente
            if (lista.get(i) instanceof Avion) {
            contenido += "Avion: " + ((Avion) lista.get(i)).miId() + " ";
        } else if (lista.get(i) instanceof Autobus) {
            contenido += "Bus: " + ((Autobus) lista.get(i)).miId() + " ";
        }
        }
        tf.setText(contenido);  // Muestra el contenido en el campo de texto
    }
    
    /**
     * Método para obtener una representación de cadena del contenido de la lista.
     * @return Cadena que representa el contenido de la lista
     */
    public String imprime(){
        String contenido = ""; // String para almacenar el contenido de la lista
        // Itera sobre los elementos de la lista
        for (int i = 0; i<lista.size(); i++) {
            // Verifica el tipo de objeto y construye la representación de cadena correspondiente
            if (lista.get(i) instanceof Avion) {
                contenido += "Avion: " + ((Avion) lista.get(i)).miId() + " ";
            } 
        }
        return contenido; // Devuelve la cadena que representa el contenido de la lista
    }
    
    /**
     * Método para obtener la longitud de la lista.
     * @return Longitud de la lista
     */
    public synchronized int longitud(){
       return lista.size();  // Devuelve la longitud de la lista
    }
}
