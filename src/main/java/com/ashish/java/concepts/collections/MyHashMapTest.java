package com.ashish.java.concepts.collections;

import java.util.Objects;

class Entry<K, V> {
    K key;
    V value;
    Entry<K, V> next;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class MyHashMap<K, V> {
    private Entry<K, V>[] buckets;
    private static final int INITIAL_CAPACITY = 16;
    private int size = 0;

    public MyHashMap() {
        this.buckets = new Entry[INITIAL_CAPACITY];
    }

    // Hash function to compute index for a key
    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    // method to add or update key-value pair
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        Entry<K, V> newEntry = new Entry<>(key, value);

        // If bucket is empty, insert directly
        if (buckets[index] == null) {
            buckets[index] = newEntry;
            size++;
        } else {
            // Traverse the bucket to find the key or the end of the chain and insert/update accordingly
            Entry<K, V> current = buckets[index];
            Entry<K, V> prev = null;
            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                prev = current;
                current = current.next;
            }
            Objects.requireNonNull(prev).next = newEntry;
            size++;
        }
    }

    // method to retrieve value by key
    public V get(K key) {
        int index = getBucketIndex(key);
        Entry<K, V> current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    //Remove a key-value pair by key
    public V remove(K key) {
        int index = getBucketIndex(key);
        Entry<K, V> current = buckets[index];
        Entry<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return current.value;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }

    // method to get the size of the map
    public int size() {
        return size;
    }

    // method to check if a key exists
    public boolean containsKey(K key) {
        int index = getBucketIndex(key);
        Entry<K, V> current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // method to check if a value exists
    public boolean containsValue(V value) {
        for (Entry<K, V> bucket : buckets) {
            Entry<K, V> current = bucket;
            while (current != null) {
                if (current.value.equals(value)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    // method to check if the map is empty
    public boolean isEmpty() {
        return size == 0;
    }
}

public class MyHashMapTest {
    static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        System.out.println("Size: " + map.size()); // Output: Size: 3
        System.out.println("Get 'Two': " + map.get("Two")); // Output: Get 'Two': 2

        map.put("Two", 22);
        System.out.println("Updated 'Two': " + map.get("Two")); // Output: Updated 'Two': 22

        System.out.println("Contains key 'Three': " + map.containsKey("Three")); // Output: Contains key 'Three': true
        System.out.println("Contains value 3: " + map.containsValue(3)); // Output: Contains value 3: true

        map.remove("One");
        System.out.println("Size after removing 'One': " + map.size()); // Output: Size after removing 'One': 2
    }
}
