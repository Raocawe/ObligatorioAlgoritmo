package ayed2obligatorio2016.Grafo;


import ayed2obligatorio2016.Grafo.Enumerado;
import ayed2obligatorio2016.Grafo.NodoGrafo;

/**
 *
 * @author Ezequiel
 */
public class CHash{

     private static NodoGrafo[] array = new NodoGrafo[100];
    
    public void insertarEstacion(NodoGrafo pEstacion) {
         
         NodoGrafo n = new NodoGrafo();
         
         
         if(array[hash(num)]==null || array[hash(num)].getEstado()==Enumerado.O ){
             n.setNextNodo(array[hash(num)]); 
         }
         array[hash(num)]=n;
    }

    public int StringAInt(String pChar)
    {
        char[] Charr = pChar.toCharArray();
        int retorno=0;
        for(int i=0; i<Charr.length;i++)
        {
            retorno =+  (int)Charr[i];
        }
        return retorno;
    }
    
    public NodoGrafo BuscarHash(String pNombre) {
       
        int num = StringAInt(pNombre);
        if(array[hash(num)].getEstado() == Enumerado.O)
         {
         if(array[hash(num)].getNombre().equals(pNombre))
         return array[hash(num)];
            else
            {
                NodoGrafo n = array[hash(num)+1];
                while(n!=null)
                {
                    if(n.getNombre() == pNombre)
                        return n;
                    else 
                    {
                        n= array[StringAInt(n.getNombre())+1];
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
    
    public int hash(int i){
        return i%101;
    }
    
    public CHash(){}
    
    public void imprimir(){
        for(NodoGrafo n : array)
        {
            if(n!=null && n.getEstado()==Enumerado.O)
            {
                while(n!=null)
                {
                System.out.print("--> "+n.getNombre());
                StringAInt(n.getNombre());
                n=array[StringAInt(n.getNombre())+1];
                }
             System.out.println();
            }
            else{
                System.out.println("__");
            }
                
        }
    }
    
    public int menorDist(String Principio, String Destino){
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

}    
}
