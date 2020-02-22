/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leo.apicodechallenge.businesslogic;

/**
 *
 * @author Omistaja
 * @param <T>
 * @param <R>
 */
public interface Analyzer<T, R> {
    public R process(T data);
}
