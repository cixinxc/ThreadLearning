package Base;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
enum EnumTest {
    A, B;
    public int get() {
        return 1;
    }
    public int a = 0;
}

public class Main {
    public static void main(String[] args) {
        //EnumTest et = EnumTest.A;
        //et.get();
        //int a = et.a;
        song();
    }
    private static void luohao() {
        Scanner in = new Scanner(System.in);
        String input = in.next();

        int result =1;
        int tot =0;
        for(int i =input.length()-1; i >=0;i--)
        {
            if(input.charAt(i)==')') tot++;
            else if(input.charAt(i)=='(')
            {
                result =result*tot;
                tot--;
            }
        }
        System.out.println(result);

    }
    private static void song() {
        Object o = new Object();
        HashMap m;
        Integer p;
        ConcurrentHashMap mm;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] yf = new int[n];
        if(n<=2) {
            System.out.print(0);
            return;
        }
        for(int i = 0;i<n;i++) {
            yf[i] = in.nextInt();
        }
        int[][] nd = new int[2][n];
        nd[0][0] = yf[0];
        int yf1 = 0, yf2 = -1;
        for(int i = 1;i<n;i++) {
            if(yf[i]-nd[0][yf1]==0) {
                yf1++;
                nd[0][yf1] = yf[i];
            } else {
                break;
            }
        }
        nd[1][0] = yf[yf1+1];
        //yf1 = 0;
        yf2 = 0;
        int count = 0;
        int lxc = 0;
        for(int i = yf1+2;i<n;i++) {
            lxc+=Math.abs(yf[i]-yf[i-1]);
            if( Math.abs(yf[i]-nd[0][yf1]) < Math.abs(yf[i]-nd[1][yf2]) ) {
                count+=Math.abs(yf[i]-nd[0][yf1]);
                yf1++;
                nd[0][yf1] = yf[i];
            } else {
                count+=Math.abs(yf[i]-nd[1][yf2]);
                yf2++;
                nd[1][yf2] = yf[i];
            }
        }
        System.out.print(count);
    }
}
