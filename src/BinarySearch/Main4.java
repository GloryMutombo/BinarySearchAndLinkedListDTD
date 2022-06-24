package BinarySearch;

public class Main4 {
    public static void main(String[] args) {
        BinarySearch1 obj = new BinarySearch1();
        obj.add(6);
        obj.add(4);
        obj.add(8);
        obj.add(3);
        obj.add(5);
        obj.add(7);
        obj.add(9);

        obj.containsNode(9);

        System.out.println("Pre-order");
        obj.PreOrder();
        System.out.println("Post-order");
        obj.traversePostOrder();
        System.out.println("In-Order");
        obj.InOrder();
    }
}
