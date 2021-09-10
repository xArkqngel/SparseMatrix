package models;

public class tester {

    public static void main(String[] args) {
        MySparceMatrixx test = new MySparceMatrixx<>(20,20);
        test.add("Sofia",1,0);
        test.add("Miguel",1,1);
        test.add("1",3,0);
        test.add("2",0,1);
        test.add("3",5,5);
        test.add("4",2,0);
        test.add("5",12,5);
        test.add("6",0,2);
        System.out.println(test.searchPrevious(12,5).key+"");
    }

}
