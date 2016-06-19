/**
 * 
 */
package com.sigma.springgradle.demo.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.testng.annotations.Test;

/**
 * @author Omega
 *
 * @date 2016年6月19日 下午9:54:12
 *
 * @project SpringGradleDemo
 */
public class MockitoDemoTest {
    
    @Test
    public void test() {
        List<String> mockedList = mock(List.class);
        mockedList.add("one");
        mockedList.clear();
        
        verify(mockedList).add("one");
        verify(mockedList).clear();
        
        LinkedList<String> mockedLinkedList = mock(LinkedList.class);
        
        when(mockedLinkedList.get(0)).thenReturn("first");
        
        System.err.println(mockedLinkedList.get(0));
        System.err.println(mockedLinkedList.get(999));
    }
    
    // @Test
    // public void test2() {
    // LinkedList mockedList = mock(LinkedList.class);
    // when(mockedList.get(0)).thenThrow(new RuntimeException());
    // verify(mockedList).get(0);
    // }
}
