/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayed1obligatorio2016.ListaDoble;

/**
 *
 * @author Maxi
 */
public interface IListaDobleEnc <T> {
    public void insertarInicio(T n);
    public void RemoveNodo(T n);
    public boolean esVacia();
    public void imprimir(T n);
    public void borrarInicio();
    public void vaciarLista();
    public int LengthListaDoble(T n);
}
