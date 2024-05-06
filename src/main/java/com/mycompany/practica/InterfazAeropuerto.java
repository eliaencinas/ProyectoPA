/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.practica;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interfaz remota para el aeropuerto.
 * @author Noelia y Elia
 */
public interface InterfazAeropuerto extends Remote {
    
    void obtenerAeropuerto(Aeropuerto aeropuerto) throws RemoteException;   // Método para obtener una referencia al objeto Aeropuerto.
    int obtenerNumPasajeros() throws RemoteException; // Método para obtener el número de pasajeros en el aeropuerto.
    int obtenerNumAvionesHangar() throws RemoteException; // Método para obtener el número de aviones en el hangar del aeropuerto.
    int obtenerNumAvionesTaller() throws RemoteException;     // Método para obtener el número de aviones en el taller del aeropuerto.
    int obtenerNumAvionesAreaEst() throws RemoteException;     // Método para obtener el número de aviones en el área de estacionamiento del aeropuerto.
    int obtenerNumAvionesAreaRod() throws RemoteException; // Método para obtener el número de aviones en el área de rodaje del aeropuerto.
    Listas obtenerColaAvionesAerovia() throws RemoteException;     // Método para obtener la lista de aviones en la aerovía del aeropuerto.
    void cerrarPista( int numPista) throws RemoteException; // Método para cerrar una pista específica del aeropuerto.
    void abrirPista( int numPista) throws RemoteException; // Método para abrir una pista específica del aeropuerto.
}
