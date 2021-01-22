/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leo.apicodechallenge.mappers;

/**
 *
 * @author Omistaja
 * @param <T1>
 * @param <T2>
 */
public interface RequestResponseMapper<T1, T2> {
    public void map(T1 requestObject, T2 responseObject);
}
