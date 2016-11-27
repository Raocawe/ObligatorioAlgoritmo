package ayed2obligatorio2016.Grafo;


import ayed2obligatorio2016.Grafo.Enumerado;
import ayed2obligatorio2016.Grafo.NodoGrafo;

/**
 *
 * @author Ezequiel
 */
public class CHash{

    private static NodoGrafo[] array;
    
    public CHash()
    {
        array = new NodoGrafo[100];
    }
    
    public void insertarEstacion(NodoGrafo pEstacion) {
         
         NodoGrafo n = new NodoGrafo();
         int Indice = hash(StringAInt(pEstacion.getNombre()));
         if(array[Indice] ==null)
         {
             pEstacion.setEstado(Enumerado.O);
             array[Indice] = pEstacion;
         }
         else
         {
             if(array[Indice].getEstado().equals(Enumerado.O) || !pEstacion.getNombre().equals(array[Indice].getNombre()))
             {
                 boolean ver = false;
                int contador = 1;
                while(!ver)
                {
                    if(array[Indice+contador]==null)
                    {
                        pEstacion.setEstado(Enumerado.O);
                        array[Indice+contador] = pEstacion;
                        ver = true;
                    }
                    contador++;
                }
             }
         }
                  
    }

    public int StringAInt(String pChar)
    {
        char[] Charr = pChar.toCharArray();
        int retorno=0;
        for(int i=0; i<Charr.length;i++)
        {
            retorno = retorno + (int)Charr[i];
        }
        return retorno;
    }
    
    public NodoGrafo BuscarHash(String pNombre) {
       
        int num = hash(StringAInt(pNombre));
        if(array[num]!=null)
        {
            if(array[num].getEstado().equals(Enumerado.O))
            {
        if(array[num].getNombre().equals(pNombre))
        return array[num];
           else
           {
               int i = num+1;
               NodoGrafo n = array[i];
               while(n!=null)
               {
                   if(n.getNombre().equals(pNombre))
                       return n;
                   else 
                   {
                       i++;
                       n = array[i];
                   }
               }
               return null;
           }
        }
            else
            {
                return null;
            }
        }
        else
        {
            return null;
        }
    }
    
    public int hash(int i){
        return i%97;
    }
    
    public void imprimir(){
        for(NodoGrafo n : array)
        {
            if(n!=null && n.getEstado()==Enumerado.O)
            {
                while(n!=null)
                {
                System.out.print("--> "+n.getNombre());
                }
             System.out.println();
            }
            else{
                System.out.println("__");
            }
                
        }
    }
    
    
    
    /*public int menorDist(String Principio, String Destino){
    NodoGrafo actual = this.BuscarHash(Principio, 0);
    NodoGrafo destino = this.BuscarHash(Destino, 0);
    int indice = indiceHash(Destino, 0);
    int indiceP = indiceHash(Principio, 0);
    ObjetoTabla[] t = new ObjetoTabla[100];
    for(int i = 0; i<100; i++){
        ObjetoTabla o = new ObjetoTabla();
        if(i==indiceP){
        o.setVisitado(Visitado.FUE_VISITADOOO);
        o.setDist(0);
        o.setAnterior(null);  }
        else
        {
            o.setVisitado(Visitado.no_Visitado);
            o.setDist(Integer.MAX_VALUE);
            o.setAnterior(null);
        }
        t[i]=o;
    }
   t=menorDist(destino, actual, null, 0,t);
   for(int j = 0; j<100; j++){
       if(t[j].getVisitado()==Visitado.FUE_VISITADOOO) {
    System.out.println("INDICE:"+j);
    System.out.println("Visitado:"+t[j].getVisitado().toString());
    System.out.println("dist:"+t[j].getDist());
    System.out.println(lstVertices[j].getEstacion());
    System.out.println("********");}}
   
    return t[indice].getDist();

}    */
}
