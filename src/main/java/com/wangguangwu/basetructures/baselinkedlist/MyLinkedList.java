package com.wangguangwu.basetructures.baselinkedlist;

/**
 * 自己实现链表
 *
 * @author wangguangwu
 */
public class MyLinkedList<E> implements MyCollection<E> {

    /**
     * 链表中数据的个数
     */
    private int size = 0;

    /**
     * 链表当中第一个节点
     */
    private Node<E> first;

    /**
     * 链表当中最后一个节点
     */
    private Node<E> last;

    @Override
    public boolean add(E o) {
        return append(o);
    }

    @Override
    public boolean add(int index, E o) {
        Node<E> node = findNodeByIndex(index);
        insertBeforeNode(node, o);
        size++;
        return true;
    }

    @Override
    public boolean remove(E o) {
        Node<E> start = first;
        while (start != null) {
            if (start.item.equals(o)) {
                removeNode(start);
            }
            // 节点后移
            start = start.next;
        }
        size--;
        return true;
    }

    @Override
    public boolean remove(int index) {
        // 找到 index 对应的节点
        Node<E> node = findNodeByIndex(index);
        // 删除节点
        removeNode(node);
        size--;
        return false;
    }

    @Override
    public boolean append(E o) {
        final Node<E> l = last;
        // 尾插法
        // 新增节点的 prev 指向 last 节点，next 指向 null
        final Node<E> newNode = new Node<>(o, last, null);
        // 把新节点赋值给尾节点
        last = newNode;
        if (first == null) {
            // 当前链表中没有节点，就将其作为第一个节点
            first = newNode;
        } else {
            // 当前链表中有节点，就将新增的节点连接到链表的尾部
            l.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E o) {
        Node<E> start = first;
        while (start != null) {
            if (start.item.equals(o)) {
                return true;
            }
            // 节点后移
            start = start.next;
        }
        return false;
    }

    @Override
    public String toString() {
        if (first == null) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder();
        builder.append("[");
        Node<E> start = first;
        builder.append(start.item.toString());
        start = start.next;
        while (start != null) {
            builder.append(",").append(start.item.toString());
            start = start.next;
        }
        builder.append("]");
        return builder.toString();
    }

    /**
     * 在节点数据 node 之后插入数据
     *
     * @param node node
     * @param o    o
     */
    void insertAfterNode(Node<E> node, E o) {
        if (node == null) {
            throw new NullPointerException();
        }
        // newNode 前面的节点是 node，后面的节点是 node.next
        Node<E> newNode = new Node<>(o, node, node.next);
        if (node.next != null) {
            node.next.prev = newNode;
        }
        if (node == last) {
            last = newNode;
        }
        node.next = newNode;
    }

    /**
     * 在节点数据 node 之前插入数据
     *
     * @param node node
     * @param o    o
     */
    void insertBeforeNode(Node<E> node, E o) {
        if (node == null) {
            throw new NullPointerException();
        }
        // newNode 前面的节点是 node.prev，后面的节点是 node
        Node<E> newNode = new Node<>(o, node.prev, node);
        if (node.prev != null) {
            node.prev.next = newNode;
        } else {
            first = newNode;
        }
        node.prev = newNode;
    }

    /**
     * 根据下标找节点
     *
     * @param index index
     * @return node
     */
    Node<E> findNodeByIndex(int index) {
        if (index > size || index < 0) {
            throw new RuntimeException("输入 index 不合法，链表中的数据个数为 " + size);
        }
        Node<E> x;
        // 首先看 index 和 size / 2 的关系
        // 看链表的首部和尾部谁距离 index 更近，哪头近就从哪头遍历
        // size >> 1 = size / 2
        // 位运算比除法要快
        if (index < (size >> 1)) {
            x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        } else {
            x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
        }
        return x;
    }

    void removeNode(Node<E> node) {
        if (node == null) {
            throw new NullPointerException();
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }


    private static class Node<E> {
        // 指向节点的真是存储的数据
        E item;
        // 前向指针：指向前一个数据
        Node<E> prev;
        // 后向指针：指向后一个数据
        Node<E> next;

        public Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

}
