/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplorecursividad;

/**
 *
 * @author samaniw
 */
public class Recursividad {

    private int a, b, c;

    public Recursividad() {
        a = 0;
        b = 1;
    }

    public int Sumatoria(int n) {
        //caso base
        if (n == 1) {
            return 1;
        } else {
            return Sumatoria(n - 1) + n;
        }
    }

    public double Factorial(double n) {
        //caso base
        if (n == 0) {
            n=1;
        } else {
            n=n*Factorial(n - 1);
        }
        return n;
    }

    public int Fibo1(int n) {
        //caso base
        /*
      if(n==0){
          return 0;
      }else if(n==1){
          return 1;
      }
         */
        if (n < 2) {
            return n;     
        }else{
            return Fibo1(n - 1) + Fibo1(n - 2);
        }
    }

    public void Fibo2(int n) {
        //condicion de finalizacion
        if (n >= 1) {
            c = a + b;
            System.out.print(a + " ");
            a = b;
            b = c;
            Fibo2(n - 1);
        }
    }

    public void FibR(int n) {
        Fib3(n, 0, 1);
    }

    private void Fib3(int n, int aa, int bb) {
        //caso baso
        if (n == 0) {
            return;
        } else {
            System.out.print(aa + " ");
            Fib3(n - 1, bb, aa + bb);
        }
    }

}
