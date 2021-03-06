/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasnolineales;

/**
 *
 * @author samaniw
 */
public class EstructurasNoLineales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Graph g1 = new Graph(4);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 0);
        g1.addEdge(3, 0);
        g1.addEdge(3, 1);
        g1.addEdge(3, 2);
        //...
        g1.deleteEdge(0, 1);
        g1.deleteEdge(1, 2);
        System.out.println("Matriz de adyacencias");
        System.out.println(g1.showAMatrix());
        System.out.println("Lista de adyacencias");
        System.out.println(g1.showAList());
        
        MaxHeap maxData = new MaxHeap();
        //31,51,53,28,47,22
        maxData.insert(31);
        maxData.insert(51);
        maxData.insert(53);
        maxData.insert(28);
        maxData.insert(47);
        maxData.insert(22);
        System.out.println(maxData.getDataHeap());
        maxData.ExtractMax();
        System.out.println(maxData.getDataHeap());
        System.out.println("--------------------------TALLER------------------------------");
        BinarySearchTree pino = new BinarySearchTree(10);
        try {
            pino.Add(5);
            pino.Add(3);
            pino.Add(8);
            pino.Add(7);
           //pino.Add(18);
            pino.Add(20);
            pino.Add(18);
            pino.Add(25);
            pino.Add(23);
            pino.Add(21);
            pino.Add(24);
            pino.Add(30);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

       
        
       System.out.println("INORDEN"); 
       pino.InOrden();//Punto 1
       System.out.println("");
       System.out.println("POSTORDEN");
       pino.Postorden(); // Punto 2
       System.out.println("");
       System.out.println("PREORDEN");
       pino.PreOrden();// Punto 3
       System.out.println("");
       System.out.println("NUMERO DE HOJAS: " + pino.CountLeafs());//Punto 4
       System.out.println("NUMERO DE NODOS: " + pino.CountNodes());//Punto 5
        BinaryNode k2 =pino.Search(10);
       
       
       System.out.println("");
       pino.LevelOrder();
      
       pino.LastLevel();
       
       
       //System.out.println(pino.Search(88));
    }

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
}
