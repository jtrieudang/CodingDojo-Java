public class DLLTest {
    public static void main(String[] args) {
        DLL dll = new DLL();
        
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        
        dll.printValuesBackward();
        dll.pop();
        dll.printValuesForward();
        dll.size();
        dll.contains(20);
    }
}