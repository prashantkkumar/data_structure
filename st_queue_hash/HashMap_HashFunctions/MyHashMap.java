package week3_assignment2;


import java.util.*;

class MyHashMap<K, V> {
    private static final int SIZE = 16;
    private LinkedList<Entry<K, V>>[] map;

    static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        map = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            map[i] = new LinkedList<>();
        }
    }

    private int getHash(K key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    public void put(K key, V value) {
        int hash = getHash(key);
        for (Entry<K, V> entry : map[hash]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        map[hash].add(new Entry<>(key, value));
    }

    public V get(K key) {
        int hash = getHash(key);
        for (Entry<K, V> entry : map[hash]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int hash = getHash(key);
        map[hash].removeIf(entry -> entry.key.equals(key));
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> myMap = new MyHashMap<>();
        myMap.put("one", 1);
        myMap.put("two", 2);
        System.out.println(myMap.get("one"));
        myMap.remove("one");
        System.out.println(myMap.get("one"));
    }
}

