/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica;

import java.io.Serializable;

/**
 * Clase que representa un hilo superior.
 * Este hilo controla la ejecución de otros hilos en el programa.
 * @author Elia y Noelia
 */
public class HiloSuperior implements Serializable{
    private boolean reanudar; //Indica si el hilo debe reanudar la ejecución
    
    /**
     * Constructor de la clase HiloSuperior.
     * Inicializa el estado de reanudación como verdadero.
     */
    public HiloSuperior(){
        reanudar = true;
    }
    
    /**
     * Método para hacer que el hilo espere.
     * Este método sincronizado hace que el hilo espere mientras la ejecución está pausada.
     */
    public synchronized void esperar(){
       try{
           // Mientras la ejecución esté pausada, el hilo espera
           while(!reanudar){
                wait(); //El hilo se queda en espera
            }
        }catch (InterruptedException e){}
        //Manejo de excepción en caso de interrupción del hilo
    }
    
    /**
     * Método para verificar si el hilo está ejecutándose.
     * @return true si el hilo está en ejecución, false si está pausado.
     */
    public synchronized boolean estaEjecutando(){
        return reanudar; // Devuelve el estado de reanudación
    }
    
    /**
     * Método para detener la ejecución del hilo.
     * Este método pone el estado de reanudación como falso, pausando la ejecución del hilo.
     */
    public synchronized void detener(){
        reanudar = false; // Pone el estado de reanudación como falso
    }
    
    /**
     * Método para reanudar la ejecución del hilo.
     * Este método pone el estado de reanudación como verdadero y notifica a todos los hilos en espera.
     */
    public synchronized void reanudar(){
        reanudar = true; // Pone el estado de reanudación como verdadero
        notifyAll(); // Notifica a todos los hilos en espera que pueden continuar la ejecución
    }
    
}
