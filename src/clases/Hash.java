/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import ayed2obligatorio2016.Grafo.NodoGrafo;

/**
 *
 * @author cristian castro
 */
public interface Hash {
    
    NodoGrafo BuscarHash(String s);
    int ObtenerIndice(String s);
    NodoGrafo[] getArray();
    
}
