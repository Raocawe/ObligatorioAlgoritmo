/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayed2obligatorio2016.Pila;

/**
 *
 * @author Maxi
 */
public interface IPila <T> {
    public void Empty();
    public void push(T elem);
    public boolean IsEmpty();
    public T Pop();
    public T Top();
}
