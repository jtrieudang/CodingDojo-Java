public class Single{
    private Node head;
    public Single(){
        this.head = null;
    }

    public Single.add(int value){
        if(this.head == null){
            this.head = new Node(value);
        } else{
            Node pointer = this.head;
            while(pointer.next != null){
                pointer = pointer.next;
            }
            pointer.next = new Node(value);
        }
        return this;
    }

    public Single.remove(){
        Node pointer = this.head;
        while(pointer.next.next != null){
            pointer = pointer.next;
        }
        pointer.next = null;
        return this;
    }

    public void printValues(){
        Node pointer = this.head;
        if(pointer == null){
            System.out.println(pointer);
        } else{
            while(pointer != null){
                System.out.println(pointer.value);
                pointer = pointer.next;
            }
        }
    }

    public Node find(int value){
        Node pointer = this.head;
        while(pointer.value != value){
            pointer = pointer.next;
        }
        return pointer;
    }

    public Single.removeAt(int index){
        Node pointer = this.head;
        if(pointer == null){
            return this;
        }
        if(index == 0){
            this.head = pointer.next;
            return this;
        }
        for (int i=0; i<index-1; i++){
            pointer = pointer.next;
        }
        pointer.next = pointer.next.next;
        return this;
    }
}