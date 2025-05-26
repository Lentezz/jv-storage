package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private final Node[] table = new Node[10];
    private int currentIndex = 0;

    @Override
    public void put(K key, V value) {
        if (this.get(key) == null) {
            table[currentIndex] = new Node(key, value);
            currentIndex++;
        }
        else {
            for (Node node : table) {
                if ((node != null && node.getKey() != null && node.getKey().equals(key)) || (node != null && key == null && node.getKey() == null)) {
                    node.setValue(value);
                }
            }
        }


    }

    @Override
    public V get(K key) {
        for (Node node : table) {
            if (node != null && (node.getKey() != null && node.getKey().equals(key) || (node.getKey() == null && key == null))) {
                return (V) node.value;
            }
        }

        return null;
    }

    @Override
    public int size() {
        int size = 0;
        for (Node node : table) {
            if (node != null) {
                size++;
            }
        }
        return size;
    }

    private static class Node <K, V> {
        private final K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
