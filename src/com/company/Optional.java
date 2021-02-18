package com.company;

import java.util.Arrays;

public class Optional {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        if (args.length < 1) {
            System.out.println("Lipseste argumentul");
            System.exit(-1);
        }

        try {
           int n = Integer.parseInt(args[0]);
            if (n % 2 != 1) {
                System.out.println("nu este impar");
                System.exit(-1);
            }

            int[][] a = new int[n][n];
            Optional app1 = new Optional();
            app1.generare(n, a);
            app1.afisareUnicode(n, a);
            app1.componenteConexe(n, a);
            long finish = System.currentTimeMillis();
            long timp = finish - start;
            System.out.println("Timpul in nanosecunde este " + timp);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public void componenteConexe(int n, int[][] a) {
        //facem dfs ca sa aflam cc
        int[] viz = new int[n];
        Arrays.fill(viz, 0);
        int nr = 1;
        for (int i = 0; i < n; i++) {
            if (viz[i] == 0) {
                System.out.print("Componenta conexa " + nr + ": ");
                nr = nr + 1;
                Optional app = new Optional();
                app.dfs(i, a, n, viz);
                System.out.println();
            }
        }
        // daca avem o sg cc dfs ne da un arbore partial !!!
        if (nr - 1 == 1) {
            Arrays.fill(viz, 0);
            Optional app = new Optional();
            int[][] b = new int[n][n];
            app.dfsArborePartial(0, a, n, viz, b);
            afisare(n, b);
        }
    }

    public void dfs(int nod, int[][] a, int n, int[] viz) {
        System.out.print(nod + ",");
        viz[nod] = 1;
        for (int k = 0; k < n; k++)
            if (a[nod][k] == 1 && viz[k] == 0)
                dfs(k, a, n, viz);
    }

    public void dfsArborePartial(int nod, int[][] a, int n, int[] viz, int[][] b) {

        viz[nod] = 1;
        for (int k = 0; k < n; k++)
            if (a[nod][k] == 1 && viz[k] == 0) {
                b[nod][k] = b[k][nod] = 1;
                dfsArborePartial(k, a, n, viz, b);
            }
    }


    public void generare(int n, int[][] a) {
        for (int i = 0; i <= n / 2; i++) {
            a[i][i] = 0;
            for (int j = i + 1; j < n; j++) {
                double x = Math.random();
                a[i][j] = a[j][i] = (int) Math.round(x);
            }
        }
    }

    public void afisareUnicode(int n, int[][] a) {
        if (n <= 100) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (a[i][j] == 0)
                        System.out.print("\u00A7");
                    else
                        System.out.print("\u00A1");
                }
                System.out.println();
            }
        }
    }

    public void afisare(int n, int[][] b) {
        if (n <= 100) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    System.out.print(b[i][j] + " ");
                System.out.println();
            }
        }
    }


}
