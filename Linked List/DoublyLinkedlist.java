/* Functions created :
        1. insert
        2. insertStart
        3. delete
        4. print
        5. printReverse
        6. reverse
        7. insertSorted
        8. selectionSort
        9. bubbleSort
        
        */
class LinkedList{
    class Node{
        int data;
        Node prev;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
    private Node head;
    private Node tail;
    public int length = 0;
    public void insert(int data){
        Node tmp = new Node(data);
        Node p = head;
        if(head == null){
            head = tmp;
            tmp.next = null;
            tmp.prev = null;
            tail = tmp;
            length++;
            return;
        }
        while(p.next != null){
            p = p.next;
        }
        tail = tmp;
        tmp.next = null;
        tmp.prev = p;
        p.next = tmp;
        length++;
        return;
    }
    
    public void insertStart(int data){
        Node tmp = new Node(data);
        tmp.next = head;
        tmp.prev = null;
        if(head != null){
            head.prev = tmp;
        }
        if(head == null){
            tail = tmp;
        }
        head = tmp;
        length++;
        return;
    }
    public void print(){
        Node p = head;
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        p = head;
        while(p!= null){
            System.out.println(p.data+" ");
            p = p.next;
        }
    }
    public void printReverse(){
        Node p = tail;
        while(p != null){
            System.out.println(p.data);
            p = p.prev;
        }
    }
    public void delete(int data){
        Node p,tmp;
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        if(head.data ==  data){
            if(head.next != null){
                 head.next.prev = null;
            }
            head = head.next;
            if(head == null){
                tail = null;
            }
            length--;
            return;
        }
        p = head.next;
        while(p.next!= null){
            if(p.data == data){
                p.prev.next = p.next;
                p.next.prev = p.prev;
                length--;
                return;
            }
            p = p.next;
        }
        if(p.data == data){
            p.prev.next = null;
            tail = p.prev;
            length--;
            return;
        }
        else{
            System.out.println("Element not found");
            return;
        }
    }
    
    public void reverse(){
        Node curr,p,n;
        curr = head;
        tail = curr;
        p = null;
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        while(curr != null){
            n = curr.next;
            curr.next = curr.prev;
            curr.prev = n;
            p = curr;
            curr = n;
        }
        head = p;
        
        return;
    }
    
    public void insertSorted(int data){
        Node tmp = new Node(data);
        if(head == null || head.data > data){
            tmp.next = head;
            tmp.prev = null;
            head.prev = tmp;
            head = tmp;
            if(head.next == null){
                tail = tmp;
            }
            return;
        }
        Node p = head.next;
        while(p.data < data && p.next != null){
            p = p.next;
        }
        if(tmp.data <= p.data){
            tmp.next = p;
            tmp.prev = p.prev;
            p.prev.next= tmp;
            p.prev = tmp;
            return;
        }
        if(tmp.data > p.data){
            tmp.next = null;
            tmp.prev = p;
            p.next = tmp;
            tail = tmp;
            return;
        }
    }
    public void selectionSort(){
        Node p;
        Node q;
        int tmp;
        for(p = head;p.next != null;p = p.next){
            for(q = p.next;q!=null;q=q.next){
                if(p.data > q.data){
                    tmp = p.data;
                    p.data = q.data;
                    q.data = tmp;
                }
            }
        }
        return;
    }
    public void bubbleSort(){
        Node p,q = null,end;
        int tmp;
        for(end = null;end != head.next;end = q){
            for(p = head;p.next != end;p=p.next){
                q = p.next;
                if(p.data > q.data){
                    tmp = p.data;
                    p.data = q.data;
                    q.data = tmp;
                }
            }
        }
        return;
    }
}
public class Main{
    public static void main(String args[]){
        LinkedList l = new LinkedList();
        l.insert(10);
        l.insert(2);
        l.insert(4);
        l.insert(0);
        l.bubbleSort();
        l.print();
    }
}
