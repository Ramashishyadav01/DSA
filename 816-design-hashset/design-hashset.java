class MyHashSet {
    private class Node {
        int key;
        Node next;
        
        Node(int key) {
            this.key = key;
        }
    }

    private Node[] buckets;
    private static final int BUCKET_COUNT = 769;

    public MyHashSet() {
        buckets = new Node[BUCKET_COUNT];
    }

    private int getHash(int key) {
        return key % BUCKET_COUNT;
    }

    public void add(int key) {
        int index = getHash(key);
        
        if (buckets[index] == null) {
            buckets[index] = new Node(key);
            return;
        }
        
        Node current = buckets[index];
        while (current != null) {
            if (current.key == key) {
                return; 
            }
            if (current.next == null) {
                break;
            }
            current = current.next;
        }
        
        current.next = new Node(key);
    }

    public void remove(int key) {
        int index = getHash(key);
        Node current = buckets[index];
        
        if (current == null) {
            return;
        }
        
        if (current.key == key) {
            buckets[index] = current.next;
            return;
        }
        
        while (current.next != null) {
            if (current.next.key == key) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public boolean contains(int key) {
        int index = getHash(key);
        Node current = buckets[index];
        
    
        while (current != null) {
            if (current.key == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */