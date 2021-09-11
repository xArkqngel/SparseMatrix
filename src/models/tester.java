package models;

public class tester {

    public static void main(String[] args) {
        MySparceMatrixx test = new MySparceMatrixx<>(20, 20);
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
//                test.add(i+"-"+j,i,j);
            }

        }
        //coordenada x,y x1,y1
        System.out.println(test.elementsRectangle(test.splitter("1,1,6,3")));
//        System.out.println(test.searchPrevious(12, 5).key + "");

//        String[][] matrix = new String[15][15];
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                if (test.distanceBetween(4,i,2,j) <= 4.5){
//                    matrix[i][j] = "O";
//                }else matrix[i][j] = "-";
//            }
//        }

//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                    matrix[i][j] = "-";
//                }
//            }

        //i = x0, length = nfilas+i
        //j = y=0 [i]length-x = ncols
//        for (int i = 2; i < 7; i++) {
//            for (int j = 3; j < matrix[i].length-3; j++) {
//                matrix[i][j] = "O";
//            }
//        }

//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.print("["+matrix[i][j]+"]");
//                }
//            System.out.println();
//        }
//        }

    }
}


