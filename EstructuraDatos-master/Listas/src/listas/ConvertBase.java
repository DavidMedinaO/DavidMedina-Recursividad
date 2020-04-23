/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *
 * @author niwdeyen
 */
public class ConvertBase {
    public String toBinary(int n){
        LinkedStack bin = new LinkedStack();
        String binary = "";
        
        while (n>0) {            
            bin.push(n%2);
            n/=2;
            
        }
        while (!bin.empty()) {            
            try {
                binary+=bin.pop();                        
            } catch (Exception e) {
                binary = "Error interno";
            }                
        }
        return binary;          
    }
}
