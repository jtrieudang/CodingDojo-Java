public class DLL {
    public Node head;
    public Node tail;
    
    public DLL() {
        this.head = null;
        this.tail = null;
    }
    
    public void printValuesBackward() {
        Node runner = this.tail;
    	while(runner != null) {
            System.out.println(runner.value);
    		runner = runner.previous;
    	}
    }
    
    public Node pop() {
        if(this.tail == null) {
            System.out.println("None.");
    	}
    	Node lastNode = this.tail;
    	this.tail = lastNode.previous;
    	return lastNode;    	
    }
    
    public void printValuesForward() {
        Node runner = this.head;
        while(runner != null) {
            System.out.println(runner.value);
            runner = runner.next;
        }
    }
		
	public int size() {
		if(this.head == null);
			System.out.println("None.");
		Node runner = this.head;
		int count = 0;
		while(runner != null) {
			count ++;
			runner = runner.next;
		}
		System.out.println(count + " node(s) found!");
		return count;
	}