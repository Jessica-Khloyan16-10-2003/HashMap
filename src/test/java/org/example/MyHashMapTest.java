package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyHashMapTest<K, V> {
    MyHashMap<Integer,String> map = new MyHashMap<>();
    @Test
    public void putAndGet() {
        map.put(1,"Jessica");
        assertEquals("Jessica",map.get(1));
    }
    @Test
    public void putWithReplace() {
        map.put(1,"Jessica");
        map.put(1,"Khloyan");
        assertEquals("Khloyan",map.get(1));
    }
    @Test
    public void removeIfTrue() {
        map.put(1,"Jessica");
        assertTrue(map.remove(1));
    }
    @Test
    public void removeIfFalse() {
        map.put(1,"Jessica");
        assertFalse(map.remove(2));
    }
    @Test
    public void nodeEqualsIfTrue() {
        MyHashMap.Node<Integer,String> node1 = new MyHashMap.Node<>(1,"A",null);
        MyHashMap.Node<Integer,String> node2 = new MyHashMap.Node<>(1,"A",null);
        assertEquals(node1, node2);
    }
    @Test
    public void nodeEqualsIfFalse() {
        MyHashMap.Node<Integer,String> node1 = new MyHashMap.Node<>(1,"A",null);
        MyHashMap.Node<Integer,String> node2 = new MyHashMap.Node<>(1,"a",null);
        assertNotEquals(node1, node2);
    }
    @Test
    public void resizeCheck() {
        map.put(1,"Jessica");
        map.put(2,"Khloyan");
        map.put(3,"A");
        map.put(4,"P");
        map.put(5,"K");
        map.put(6,"S");
        map.put(7,"F");
        map.put(8,"AF");
        map.put(9,"GH");
        map.put(10,"FG");
        map.put(11,"L");
        map.put(12,"PKS");
        assertEquals(32,map.getCapacity());
    }
}