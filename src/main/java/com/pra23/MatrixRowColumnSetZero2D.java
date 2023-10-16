package com.pra23;

public class MatrixRowColumnSetZero2D {

    public static void main(String[] args) {

         int [][] matrix=   new int [][]{{1,2,0},{12,3,0},{343,4,1}};
//        Stream.of(matrix)
//                .flatMap(Stream::of)
//                .forEach(System.out::println);
          int[][]res=  Solution.setZeros(matrix);

        for (int i=0;i< res.length;i++){
            for (int j=0;j<res[0].length;j++){
                System.out.println(res[i][j]);
            }
        }

    }
}



 class Solution {
    public static int [][] setZeros(int matrix[][]) {
        // Write your code here..



        int rowCount = matrix.length;
        int columnCount = matrix[0].length;
        boolean rows[] = new boolean[rowCount];
        boolean cols[] = new boolean[columnCount];
        for (int i=0;i< rowCount;i++){
            for (int j=0;j<columnCount;j++){
                if(matrix[i][j] == 0){
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        for(int i=0;i<rowCount;i++){
            for(int j=0;j<columnCount;j++){
                if(rows[i] == true || cols[j] == true)
                    matrix[i][j] = 0;
            }
        }
    return matrix;
    }

}

/*Matrix       2,      3.     4
             [0,0].  [0,1] [0,2]
               5,      6,     7
             [1,0]   [1,1]   [1,2]
               4,      7,      8
             [2,0]   [2,1]   [2,2]

		*/