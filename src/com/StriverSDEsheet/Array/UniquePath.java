package com.StriverSDEsheet.Array;

import java.util.HashMap;
import java.util.Map;

public class UniquePath {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,2));
    }
     static Map<String,Integer> map = new HashMap<>();
    public static int uniquePaths(int m, int n) {
      if(m==1 || n==1)return 1;

      String cell = new String(m + "," + n);
      if(map.containsKey(cell)){
          return map.get(cell);
      }

      int down = uniquePaths(m-1,n);
      int right = uniquePaths(m,n-1);

      map.put(cell,down + right);

      return down + right;
    }
}
