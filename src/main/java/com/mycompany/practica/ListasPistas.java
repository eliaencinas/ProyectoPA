/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica;

import java.util.ArrayList;
import javax.swing.JTextField;

/**
 * Clase que gestiona la lista de pistas de un aeropuerto.
 * Permite realizar operaciones como añadir aviones a una pista, sacar aviones de una pista,
 * cerrar o abrir una pista y actualizar el estado de las pistas.

 * @author Noelia y Elia
 */
public class ListasPistas {
    ArrayList<Thread> lista; // Lista de aviones en las pistas
    JTextField p1,p2,p3,p4; // Campos de texto para mostrar el estado de las pistas
    private boolean pt1, pt2, pt3, pt4;  // Estado de ocupación de cada pista
    private int numPistas; // Número total de pistas disponibles

    /**
     * Constructor de la clase ListasPistas.
     * Inicializa la lista de aviones en las pistas, los campos de texto y el estado de las pistas.
     * @param p1 JTextField para la pista 1
     * @param p2 JTextField para la pista 2
     * @param p3 JTextField para la pista 3
     * @param p4 JTextField para la pista 4
     */
    public ListasPistas(JTextField p1, JTextField p2, JTextField p3, JTextField p4) {
        lista = new ArrayList<>(4); // Inicializa la lista con capacidad para 4 elementos 
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        // Inicializa todas las pistas como disponibles
        pt1 = true;
        pt2 = true;
        pt3 = true;
        pt4 = true;
        numPistas = 4;//Establece el número total de pistas
    }
    
    /**
     * Método para añadir un avión a una pista.
     * @param av Avión a añadir a la pista
     */
    public synchronized void meter(Avion av){
        try{
            // Espera hasta que haya una pista disponible para el avión
            while (lista.size() > numPistas){
                av.wait(1000); // Espera 1 segundo antes de volver a comprobar
            }
            lista.add(av); // Añade el avión a la lista de aviones en las pistas
            imprimir(); // Actualiza la visualización del estado de las pistas
        }catch (InterruptedException e){}
          
    }
    
    /**
     * Método para sacar un avión de una pista.
     * @param av Avión a sacar de la pista
     */
    public synchronized void sacar(Avion av){
        lista.remove(av); // Elimina el avión de la lista de aviones en las pistas
        imprimir(); // Actualiza la visualización del estado de las pistas
    }
    
    /**
     * Método para marcar una pista como cerrada.
     * @param numPista Número de la pista a cerrar
     */
    public synchronized void cerrada(int numPista){
        // Itera sobre la lista de aviones en las pistas
        for(int i = 0; i < lista.size(); i++){
            // Verifica si la pista actual coincide con la pista a cerrar
            if(i == 0 && i == numPista - 1){
                pt1 = false; // Marca la pista como cerrada
                actualizarPlazas(true); // Actualiza el número de pistas disponibles
            } else if( i == 1 && i == numPista - 1){
                pt2 = false;
                actualizarPlazas(true);
            } else if( i == 2 && i == numPista - 1){
                pt3 = false;
                actualizarPlazas(true);
            } else if(i == 3 && i == numPista - 1){
                pt4 = false;
                actualizarPlazas(true);
            }
        }

    }
    
    /**
     * Método para marcar una pista como abierta.
     * @param numPista Número de la pista a abrir
     */
    public synchronized void abierta(int numPista){
        // Itera sobre la lista de aviones en las pistas
        for(int i = 0; i < lista.size(); i++){
            // Verifica si la pista actual coincide con la pista a abrir
            if(i == 0 && i == numPista - 1){
                pt1 = true; // Marca la pista como abierta
                actualizarPlazas(false); // Actualiza el número de pistas disponibles
            } else if( i == 1 && i == numPista - 1){
                pt2 = true;
                actualizarPlazas(false);
            } else if( i == 2 && i == numPista - 1){
                pt3 = true;
                actualizarPlazas(false);
            } else if(i == 3 && i == numPista - 1){
                pt4 = true;
                actualizarPlazas(false);
            }
        }

    }
    
    /**
     * Método para imprimir el estado de las pistas en los campos de texto.
     */
    public void imprimir(){
        String contenido;
        // Itera sobre la lista de aviones en las pistas
        for(int i = 0; i < lista.size(); i++){
            // Muestra el avión en el campo de texto correspondiente si la pista está abierta
            if(i == 0 && pt1){
                contenido = ((Avion)lista.get(0)).miId();
                p1.setText(contenido);
            }
            if(i == 1 && pt2){
                contenido = ((Avion)lista.get(1)).miId();
                p2.setText(contenido);
            }
            if(i == 2 && pt3){
                contenido = ((Avion)lista.get(2)).miId();
                p3.setText(contenido);
            }
            if(i == 3 && pt4){
                contenido = ((Avion)lista.get(3)).miId();
                p4.setText(contenido);
            }
        }
    }
    
    /**
     * Método para actualizar el número de pistas disponibles.
     * @param seCierra true si se cierra una pista, false si se abre una pista
     */
    public void actualizarPlazas(boolean seCierra){
         // Decrementa el número de pistas disponibles si se cierra una pista
        if (seCierra){
            numPistas--;
        }else { numPistas++;} // Incrementa el número de pistas disponibles si se abre una pista
    }
    
    /**
     * Método para obtener el número de pistas disponibles.
     * @return Número de pistas disponibles
     */
    public int getNumPistas(){
        return numPistas;
    }
}
