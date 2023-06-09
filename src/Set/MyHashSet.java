package Set;

import Interface_form.Set;

import java.util.Arrays;

public class MyHashSet<E> implements Set<E> {

    private final static int DEFAULT_CAPACITY = 1 << 4;

    // 3/4 이상 채워질 경우 resize하기 위함
    private final static float LOAD_FACTOR = 0.75f;

    Node<E>[] table;    // 요소의 정보를 담고있는 Node를 저장할 Node타입 배열
    private int size;    // 요소의 개수


    @SuppressWarnings("unchecked")
    public MyHashSet() {
        table = (Node<E>[]) new Node[DEFAULT_CAPACITY];
        size = 0;
    }


    // 보조 해시 함수 (상속 방지를 위해 private static final 선언)
    private static final int hash(Object key) {
        int hash;
        if (key == null) {
            return 0;
        } else {
            // hashCode()의 경우 음수가 나올 수 있으므로 절댓값을 통해 양수로 변환해준다.
            return Math.abs(hash = key.hashCode()) ^ (hash >>> 16);
        }
    }
    @Override
    public boolean add(E e) {

        return add(hash(e), e) == null;
    }

    @Override
    public void resize() {
        if(LOAD_FACTOR > table.length / size)
            return;

        Node[] newArray = new Node[table.length * 2];
        Node<E> node;
        for(int i = 0; i < table.length; i++){
            if(table[i] != null){
                node = table[i];

                while(node!= null) {
                    int hash = node.hash;
                    E data = node.key;
                    if (newArray[hash % newArray.length] == null) {
                        newArray[hash % newArray.length] = new Node(hash, data, null);
                    }
                    else {
                        Node<E> sameHash = newArray[hash % newArray.length];
                        while (sameHash.next != null)
                            sameHash = sameHash.next;

                        sameHash.next = new Node<E>(hash, data, null);
                    }
                    if(node.next != null)
                        node = node.next;
                }
            }
        }
    }

    @Override
    public E add(int hash, E key) {

        Node<E> node = new Node(hash, key, null);
        Node<E> search = table[hash % table.length];
        if(search == null) {
            table[hash % table.length] = node;
            size++;
            return null;
        }

        while(search != null){
            if(search.hash == hash && search.key.equals(key))
                return key;

            search = search.next;
        }
        search.next = node;
        size++;
        return null;
    }

    @Override
    public Object remove(int hash, Object key) {
        Node<E> node = table[hash % table.length];
        Node<E> prev = null;
        while(node != null){
            if(node.hash == hash && node.key.equals(key)){
                E returnData = node.key;
                if(prev == null)
                    table[hash % table.length] = null;

                else
                    prev.next = node.next;

                size--;
                return returnData;
            }
            prev = node;
            if(node.next != null)
                node = node.next;
            else
                break;
        }
        return null;
    }

    @Override
    public Object[] toArray() {

        if (table == null) {
            return null;
        }
        Object[] ret = new Object[size];
        int index = 0;	// 인덱스 변수를 따로 둔다.

        for (int i = 0; i < table.length; i++) {

            Node<E> node = table[i];

            // 해당 인덱스에 연결 된 모든 노드를 하나씩 담는다.
            while (node != null) {
                ret[index] = node.key;
                index++;
                node = node.next;
            }
        }

        return ret;
    }

    @Override
    public <T> T[] toArray(T[] a) {

        Object[] copy = toArray();	// toArray()통해 먼저 배열을 얻는다.

        // 들어온 배열이 copy된 요소 개수보다 작을경우 size에 맞게 늘려주면서 복사한다.
        if (a.length < size)
            return (T[]) Arrays.copyOf(copy, size, a.getClass());

        // 그 외에는 copy 배열을 a에 0번째부터 채운다.
        System.arraycopy(copy, 0, a, 0, size);

        return a;
    }

    @Override
    public boolean remove(Object o) {
        return remove(hash(o), o) != null;
    }

    @Override
    public boolean contains(Object o) {
        int hash = hash(o);
        Node<E> node = table[hash % table.length];
        while(node != null){
            if(node.key.equals(o) && node.hash == hash)
                return true;

            if(node.next != null)
                node = node.next;
        }

        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {

    }

    class Node<E> {

        /*
         * hash와 key값은 변하지 않으므로
         * final로 선언해준다.
         */
        final int hash;
        final E key;
        Node<E> next;

        public Node(int hash, E key, Node<E> next) {
            this.hash = hash;
            this.key = key;
            this.next = next;
        }

    }
}
