import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        //linkedlist implement Collection
        System.out.println("LinkedList");
        LinkedList<String> phone = new LinkedList<>();
        phone.add ("gnusmas");
        phone.add ("ipol");
        phone.add("motorola");
        System.out.println(phone);

        phone.addFirst("nokla");
        phone.addLast("sumsung");
        phone.add(1, "razor");
        System.out.println(phone);

        String Element = phone.get(2);
        int Index = phone.indexOf(Element);
        System.out.println(Index+": "+ Element);
        System.out.println("LL phone: "+ phone);
        System.out.println(phone.indexOf(phone.getFirst())+" first element: "+phone.getFirst());
        System.out.println(phone.indexOf(phone.getLast())+" last element: "+phone.getLast());

        //цикл переборки элементов массива
        for (String element:phone) {
            System.out.println(phone.indexOf(element)+": "+ element);
        }
        String removed = phone.get(1);
        int removedOf = phone.indexOf(removed);
        phone.remove(1);
        System.out.println("removed: "+removedOf+" "+removed);
        phone.add(3, "China");
        phone.addLast("dedovs");
        phone.addFirst("zvonilka");
        for (String element:phone) {
            System.out.println(phone.indexOf(element)+": "+ element);
        }
    }
}