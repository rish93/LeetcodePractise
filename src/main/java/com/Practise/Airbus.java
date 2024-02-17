package com.Practise;

import java.util.*;

public class Airbus {
    //https://stackoverflow.com/questions/1669190/find-the-min-max-element-of-an-array-in-javascript
    public static void main(String[] args) {
        outputEntrySetComparator();

      int  N = 4;
      int  M = 4;
//      String[]  flow = {"..##", "...#", "#...", "##.."};
        String[] flow = {"..##", "...#", "#...", "##.."};

        /*
        *
        * . . .# #
        * . . . #
        * # . . .
        * # # . .
        *
        * */
        String[][] flow2D = {{".",".","#","#"},{".",".",".","#"},{"#",".",".","."},{"#","#",".","."}};
        int [][] cost = {{4,6,5,3}, {5,2,5,1}, {5,5,3,9}, {9,5,5,4}};
        System.out.println(Arrays.deepToString(flow2D));
        System.out.println(Arrays.deepToString(buildDam(N, M, flow2D, cost)));
    }


    static String[][] buildDam(int N, int M, String[][]flow, int[][] cost) {

        String color = flow[N/2][M/2];
        if (!color.equals("D")) {
            dfs(flow, N/2, M/2, ".", "D");
        }
        return flow;
    }

    public static void dfs(String[][] image, int sr, int sc, String color, String newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc].equals( newColor) || image[sr][sc].equals("#")) {
            return;
        }
        image[sr][sc] = newColor;
        dfs(image, sr + 1, sc, color, newColor);
        dfs(image, sr - 1, sc, color, newColor);
        dfs(image, sr, sc + 1, color, newColor);
        dfs(image, sr, sc - 1, color, newColor);
    }
/*
* class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color)  {

        if(image [sr][sc]==color) return image;
            fill(image, sr,sc, image[sr][sc],color);
            return image;
    }

    public void fill(int[][] image, int sr, int sc, int color, int newColor){

         if(sr<0
            || sc< 0
            || sr>=image.length
            || sc>=image[0].length
            || image[sr][sc]!=color){
                return;
            }

            image[sr][sc] =color;
            fill(image, sr-1, sc, color,newColor);
            fill(image, sr+1, sc, color,newColor);
            fill(image, sr, sc-1, color,newColor);
            fill(image, sr, sc+1, color,newColor);
    }
}*/

    static void outputEntrySetComparator(){
        Map<String, Integer> map= new HashMap<String,Integer>();
        map.put("G",34);
        map.put("A",3);
        map.put("S",43);
        Set<Map.Entry<String,Integer>> set= map.entrySet();
        List<Map.Entry<String,Integer>> list1=new ArrayList<>(set);
        Collections.sort(list1,
                (o1, o2) -> o2.getKey().compareTo(o1.getKey()));
        System.out.println(list1);
    }
}
