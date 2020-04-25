/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasnolineales;
import java.util.LinkedList; 
import java.util.Queue; 

/**
 *
 * @author samaniw
 */
public class BinarySearchTree {

    private BinaryNode root;
    private BinaryNode father;
    private boolean position;
    private int contadorHojas=0;
    private int contNodos = 0;
    private int size=0;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(int data) {
        root = new BinaryNode(data);
    }

    //Punto 1
    public void InOrden() {
        InOrden(root);
    }

    private void InOrden(BinaryNode currentRoot) {
        if (currentRoot != null) {
            InOrden(currentRoot.getLeft());
            System.out.print(currentRoot.getData() + " ");
            InOrden(currentRoot.getRight());
        }
    }
    
   //Punto 2
   public void Postorden() {
        Postorden(root);
    }
 
    private void Postorden(BinaryNode currentRoot){
        if (currentRoot != null) {
            Postorden(currentRoot.getLeft());
            Postorden(currentRoot.getRight());
            System.out.print(currentRoot.getData() + " ");
        }
    }
   
    //Punto 3
    public void PreOrden() {
       PreOrden(root);
    }
   
     private void PreOrden(BinaryNode currentRoot){
        if (currentRoot != null) {
            System.out.print(currentRoot.getData() + " ");
            PreOrden(currentRoot.getLeft());
            PreOrden(currentRoot.getRight());
           
        }
    }  

    //Punto 4
     public int CountNodes(){
     
         return CountNodes(root);
     
     }
     
     
     
     
    private int CountNodes(BinaryNode currentRoot) {
        
         if (currentRoot != null) {
            CountNodes(currentRoot.getLeft());
            CountNodes(currentRoot.getRight());
            contNodos++;
        } 
        
        return contNodos;
    }

    //Punto 5
    public int CountLeafs(){
        return CountLeafs(root);
    }
   
    private int CountLeafs(BinaryNode currentRoot) {
        if(currentRoot != null){
            if(currentRoot.getLeft() == null && currentRoot.getRight() == null){
                contadorHojas++;
            }
            CountLeafs(currentRoot.getLeft());
            CountLeafs(currentRoot.getRight());
        }
        return contadorHojas;
    }


    
    

    public void Add(int data) {
        if (root == null) {
            root = new BinaryNode(data);
        } else //validar si el dato ya existe
        {
            if (Search(data) != null) {
                System.out.println("Dato repetido, no se puede insertar");
            } else {
                Add(data, root);

            }
        }
    }

    private void Add(int data, BinaryNode currentRoot) {
        if (data < currentRoot.getData()) {
            if (currentRoot.getLeft() == null ) {
                currentRoot.setLeft(new BinaryNode(data));
            } else {
                Add(data, currentRoot.getLeft());
            }

        } else if (currentRoot.getRight() == null) {
            currentRoot.setRight(new BinaryNode(data));
        } else {
            Add(data, currentRoot.getRight());
        }
    }

    public BinaryNode Search(int data) {
        return Search(data, root);
    }

    private BinaryNode Search(int data, BinaryNode currentRoot) {
        if (currentRoot == null) {
            return null;
        }
        if (data == currentRoot.getData()) {
            return currentRoot;
        }

        father = currentRoot;

        if (data < currentRoot.getData()) {
            position = false;
            return Search(data, currentRoot.getLeft());
        } else {
            position = true;
            return Search(data, currentRoot.getRight());
        }
    }

    //Punto 6
    public void Delete(int data) {
        if (root == null) {
            System.out.print("Árbol vacío");
        } else {
            Delete(data, root);
        }
    }

    private void Delete(int data, BinaryNode currentRoot) {

        BinaryNode v = Search(data);
        if(v != null){
        if (v == this.root && v.getLeft() == null && v.getRight() == null) {
            this.root = null;
            return;
        }
        if (v.isLeaf()) {
            if (position) {
                this.father.setRight(null);
            } else {
                this.father.setLeft(null);
            }
        }
        else if (v.hasOneChild()) {
            if (v.isChildPosition()) {
               
                if(root == v){
                    BinaryNode minimum = getMinor(v.getRight());
                    Delete(minimum.getData());
                    v.setData(minimum.getData());
                    minimum.setLevel(v.getLevel());
                }
                else if (position) {
                    this.father.setRight(v.getRight());
                } else {
                    this.father.setLeft(v.getRight());
                }
                levelDown(v);
                v.setRight(null);

            } else {
                if(root ==v ){
                    root = v.getLeft();
                    v.setLeft(null);
                }
                else if (position) {
                    this.father.setRight(v.getLeft());
                } else {
                    this.father.setLeft(v.getLeft());
                }
                levelDown(v);
                v.setRight(null);

            }
        } else {
            BinaryNode minimum = getMinor(v.getRight());
            Delete(minimum.getData());
            v.setData(minimum.getData());
            minimum.setLevel(v.getLevel());
        }
        //contNodos--;
        }
    }
    
    
    
    private void levelDown(BinaryNode  currentRoot){
        if(currentRoot!=null){
            currentRoot.setLevel(currentRoot.getLevel()-1);
            levelDown(currentRoot.getLeft());
            levelDown(currentRoot.getRight());
        }
    }
    //Punto 7
     public int LastLevel() {
        LastLevel(root,0);
        return size;
    }
   
    private void LastLevel (BinaryNode currentRoot, int contLevel){
        if(currentRoot!= null){
          LastLevel(currentRoot.getLeft(),contLevel+1);  
          if(contLevel >size){
              size = contLevel;
          }
          LastLevel(currentRoot.getRight(), contLevel+1);
        }
    }

    //Punto 8
    public void LevelOrder() {
        //...
        /* 
        Para mostrar los datos se recomienda usar:
            System.out.print(x.getData()+" ");
        donde x representa un nodo del árbol

        Para generar un salto de linea se recomienda usar:
            System.out.print("\n");
        
         */
        if (root == null) 
      return; 
  
    Queue <BinaryNode> q = new LinkedList<>(); 
  
    // Pushing root node into the queue. 
    q.add(root); 
  
    // Pushing delimiter into the queue. 
    q.add(null); 
  
    // Executing loop till queue becomes 
    // empty 
    while (!q.isEmpty()) { 
  
      BinaryNode curr = q.poll(); 
  
      // condition to check the 
      // occurence of next level 
      if (curr == null) { 
        if (!q.isEmpty()) { 
          q.add(null); 
          System.out.print("\n"); 
        } 
      } else { 
        // Pushing left child current node 
        if (curr.getLeft() != null) 
          q.add(curr.getLeft()); 
  
        // Pushing right child current node 
        if (curr.getRight() != null) 
          q.add(curr.getRight()); 
  
        System.out.print(curr.getData() + " "); 
      } 
    }
    
    
    }
    
    

    public BinaryNode getMinor(BinaryNode currentRoot) {
        if (currentRoot.getLeft() == null) {
            return currentRoot;
        } else {
            return getMinor(currentRoot.getLeft());
        }
    }
    
    
    static void levelOrder(BinaryNode root) { 
    if (root == null) 
      return; 
  
    Queue <BinaryNode> q = new LinkedList<>(); 
  
    // Pushing root node into the queue. 
    q.add(root); 
  
    // Pushing delimiter into the queue. 
    q.add(null); 
  
    // Executing loop till queue becomes 
    // empty 
    while (!q.isEmpty()) { 
  
      BinaryNode curr = q.poll(); 
  
      // condition to check the 
      // occurence of next level 
      if (curr == null) { 
        if (!q.isEmpty()) { 
          q.add(null); 
          System.out.println(); 
        } 
      } else { 
        // Pushing left child current node 
        if (curr.getLeft() != null) 
          q.add(curr.getLeft()); 
  
        // Pushing right child current node 
        if (curr.getRight() != null) 
          q.add(curr.getRight()); 
  
        System.out.print(curr.getData() + " "); 
      } 
    }
    

}
}
