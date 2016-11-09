/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash;

/**
 *
 * @author Ezequiel
 */
public interface IHash {
    public void insertarNum();
    public boolean buscarNum(int i);
    public void eliminarNum();
    public int hash(int i);
    public void imprimir();
}
