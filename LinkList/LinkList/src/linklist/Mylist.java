/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linklist;

class Node {

    int infor;
    Node next;
    
    public Node() {
    }

    public Node(int infor, Node next) {
        this.infor = infor;
        this.next = next;
    }

}

public class Mylist {

    Node tail, head;

    public Mylist() {
    }

    Boolean isEmty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void addHead(int x) {//hỏi thầy
        Node q = new Node(x, null);
        if (isEmty()) {
            head = tail = q;
            return;
        }
        q.next = head;
        head = q;
    }

    void addManyHead(int a[]) {
        int i = 0;
        while (i < a.length) {
            addHead(a[i]);
            i++;
        }
    }

    void addTail(int x) {
        Node q = new Node(x, null);
        if (isEmty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    void addManyTail(int a[]) {
        int i = 0;
        while (i < a.length) {
            addTail(a[i]);
            i++;

        }
    }

    void traver() {
        Node p;
        p = head;
        while (p != null) {
            System.out.print("\t" + p.infor);
            p = p.next;
        }
        System.out.println();

    }

    void deleteHead() {
        if (isEmty()) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
            return;
        }
    }

    void deleteTail() {
        if (isEmty()) {
            return;
        }
        if (head == tail) {
            clear();
            return;
        }
        Node p = head;
        while (p.next != tail) {
            p = p.next;
        }
        p.next = null;
        tail = p;

    }

    void add_position(int x, int k) {
        Node p = head;
        int count = 0;
        if (k == 0) {
            addHead(x);
            return;
        }
        while (p != null) {
            count++;
            if (count == k) {
                Node q = new Node(x, null);
                q.next = p.next;
                p.next = q;
            }
            p = p.next;
        }
        if (tail.next != null) {
            tail = tail.next;
        }

    }

  /*  void Delete_posstition(int k) {
        Node p = head;
        int count = 0;
        if (k == 0) {
            Deletefirst();
            return;
        }
        while (p != null) {
            count++;
            if (count == k) {
                if (p.next != tail) {
                    p.next = p.next.next;
                } else {
                    p.next = null;
                    tail = p;
                }
            } else {
                p = p.next;
            }

        }
    }
*/
    public static void main(String[] args) {
        int a[] = {3, 4, 1, 2, 7, 5};
        Mylist l = new Mylist();
        l.addManyHead(a);
        l.traver();
        l.addManyTail(a);  l.traver();
        //l.deleteHead(); l.traver();
       // l.deleteTail();  l.traver();
        //l.add_position(99, 2);    l.traver();
      //  l.Delete_posstition(3);
        //l.traver();
    }

}
