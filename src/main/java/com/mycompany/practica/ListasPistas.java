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
    private boolean pt1, pt2, pt3, pt4; 
    private int numPistas;

    public ListasPistas(JTextField p1, JTextField p2, JTextField p3, JTextField p4) {
        lista = new ArrayList<>(4);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        pt1 = true;
        pt2 = true;
        pt3 = true;
        pt4 = true;
        numPistas = 4;
    }
    
    public synchronized void meter(Avion av){
        try{
            while (lista.size() > numPistas){
                av.wait(1000);
            }
            lista.add(av);
            imprimir();
        }catch (InterruptedException e){}
          
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
    public synchronized void cerrada(int numPista){

        for(int i = 0; i < lista.size(); i++){
            if(i == 0 && i == numPista - 1){
                pt1 = false;
                actualizarPlazas(true);
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
    
    public synchronized void abierta(int numPista){

        for(int i = 0; i < lista.size(); i++){
            if(i == 0 && i == numPista - 1){
                pt1 = true;
                actualizarPlazas(false);
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
    
    public void imprimir(){
        String contenido;
        for(int i = 0; i < lista.size(); i++){
            
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
    
    public void actualizarPlazas(boolean seCierra){
        if (seCierra){
            numPistas--;
        }else { numPistas++;}
    }
    
    public int getNumPistas(){
        return numPistas;
    }
}
