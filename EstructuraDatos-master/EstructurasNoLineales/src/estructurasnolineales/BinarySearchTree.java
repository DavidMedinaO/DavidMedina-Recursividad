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
public class BinarySearchTree {

    private BinaryNode root;
    private BinaryNode father;
    private boolean position;

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
        //...
    }

    //Punto 3
    public void PreOrden() {
        //...
    }

    //Punto 4
    public int CountNodes() {
        //...
        return 0;
    }

    //Punto 5
    public int CountLeafs() {
        //...
        return 0;
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
            if (currentRoot.getLeft() == null) {
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
        if (v.isLeaf()) {
            if (position) {
                father.setRight(null);
            } else {
                father.setLeft(null);
            }
        } else if (v.hasOneChild()) {
            if (v.isChildPosition()) {
                father.setRight(v.getRight());
            } else {
                father.setLeft(v.getLeft());
            }
        } else {
            BinaryNode minimum = getMinor(v.getRight());
            Delete(minimum.getData());
            v.setData(minimum.getData());
        }
    }

    //Punto 7
    public int LastLevel() {
        //...
        return 0;
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
    }

    public BinaryNode getMinor(BinaryNode currentRoot) {
        if (currentRoot.getLeft() == null) {
            return currentRoot;
        } else {
            return getMinor(currentRoot.getLeft());
        }
    }
}
