package week9;

public class Week9Driver {

    public static void main(String[] args){

        BSTMap<Integer,String> map = new BSTMap<>();
        map.put(1, "Bat");
        map.put(1, "Rat");
        map.put(1, "Dog");

        System.out.println(map.get(1));
        System.out.println(map.size());
        map.remove(1);

    }
}
