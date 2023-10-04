class MyHashMap {
    /**
    Bucket[1000]
    Bucket {
        List<Node>
    }
    Node {
        int key
        int value
    }
     */
    class Bucket {
        List<Node> nodes;
        public Bucket() {
            this.nodes = new ArrayList<>();
        }
        public boolean isEmpty() {
            return this.nodes.isEmpty();
        }
    }

    class Node {
        int key;
        int value;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Bucket[] buckets;
    public MyHashMap() {
        this.buckets = new Bucket[1000];
    }
    
    public void put(int key, int value) {        
        int hash = key % 1000;
        Bucket bucket = buckets[hash];
        if (bucket == null) {
            bucket = new Bucket();
            bucket.nodes.add(new Node(key, value));
            buckets[hash] = bucket;
        }            
        else {
            for (int i = 0; i < bucket.nodes.size(); i++) {
                if (bucket.nodes.get(i).key == key) {
                    Node node = bucket.nodes.get(i);
                    node.value = value;
                    bucket.nodes.set(i, node);
                    return;
                }
                else if (i == bucket.nodes.size() - 1) {
                    bucket.nodes.add(new Node(key, value));
                    return;
                }
                else if (bucket.nodes.get(i).key < key && bucket.nodes.get(i + 1).key > key) {
                    bucket.nodes.add(i + 1, new Node(key, value));
                    return;
                }
            }
        }
    }
    
    public int get(int key) {
        int hash = key % 1000;
        Bucket bucket = buckets[hash];
        if (bucket == null)
            return -1;
        for (int i = 0; i < bucket.nodes.size(); i++) {
            if (bucket.nodes.get(i).key == key) {
                return bucket.nodes.get(i).value;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int hash = key % 1000;
        Bucket bucket = buckets[hash];
        if (bucket == null)
            return;
        for (int i = 0; i < bucket.nodes.size(); i++) {
            if (bucket.nodes.get(i).key == key) {
                bucket.nodes.get(i).value = -1;
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */