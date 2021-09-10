package models;

public class tester {

    public static void main(String[] args) {
        MySparceMatrixx test = new MySparceMatrixx<>(20,20);
//        test.add("Sofia",1,0);
//        test.add("Miguel",1,1);
//        test.add("1",3,0);
//        test.add("2",0,1);
//        test.add("3",5,5);
//        test.add("4",2,0);
//        test.add("5",12,5);
//        test.add("6",0,2);
//        System.out.println(test.searchPrevious(12,5).key+"");

        String[][] matrix = new String[15][15];
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                if (test.distanceBetween(4,i,2,j) <= 4.5){
//                    matrix[i][j] = "O";
//                }else matrix[i][j] = "-";
//            }
//        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = "-";
                }
            }



        for (int i = 2; i < 7; i++) {
            for (int j = 3; j < matrix[i].length-3; j++) {
                matrix[i][j] = "O";
            }

        }




        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("["+matrix[i][j]+"]");
                }
            System.out.println();
        }
        }

    }


