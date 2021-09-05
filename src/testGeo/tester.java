package testGeo;

public class tester {

    public static void main(String[] args) {
        MySparce test = new MySparce<>(20,20);
        test.add("Sofia",1,0);
        test.add("Miguel",1,1);
        test.add("1",2,0);
        test.add("2",2,1);
        test.add("3",5,5);
        test.add("4",6,3);
        test.add("5",8,5);
        test.add("6",12,2);
        test.remove(3,1);
    }

}
