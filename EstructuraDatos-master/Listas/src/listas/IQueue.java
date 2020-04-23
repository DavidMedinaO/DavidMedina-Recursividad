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
public interface IQueue<E> {

    public boolean add(E e) throws Exception;

    public boolean offer(E e);

    public E remove() throws Exception;

    public E poll();

    public E element() throws Exception;

    public E peek();
}
