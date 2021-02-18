package com.company;

import java.util.Arrays;

public class Bonus {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Lipseste argumentul");
            System.exit(-1);
        }
        try {
            int nr = Integer.parseInt(args[0]);
            int n = (int) (Math.random() * nr + 1); // generam un nr random n care sa reprezinte nr de noduri din arbore;
            // nodurile sunt de la 0 la n-1 ... vom construi vector de tati
            System.out.println("n este " + n);
            int r = 0;
            int[] t = new int[n];
            int[] frunza = new int[n];
            int[] nivel = new int[n];
            nivel[0] = 0;
            Arrays.fill(t, -1);
            Arrays.fill(frunza, 1);
            t[r] = 0;
            Bonus app = new Bonus();
            app.generare(n, t, frunza, nivel);
            int[] viz = new int[n];
            int[] ok = new int[1];
            app.constructie(n, t, frunza, nivel, r, viz, ok);
            Arrays.fill(viz, 0);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void constructie(int n, int[] t, int[] frunza, int[] nivel, int r, int[] viz, int[] ok) {
        viz[r] = 1;
        for (int i = 1; i <= nivel[r]; i++)
            System.out.print(" ");
        if (frunza[r] == 0) {
            System.out.println("+node" + ok[0]);
        } else {
            System.out.println("-node" + ok[0]);
        }

        for (int j = 0; j < n; j++) {
            if (t[j] == r && j != r && viz[j] == 0) {
                ok[0] = ok[0] + 1;
                constructie(n, t, frunza, nivel, j, viz, ok);
            }
        }
    }

    public void generare(int n, int[] t, int[] frunza, int[] nivel) {
        for (int i = 1; i <= n - 1; i++) {
            if (t[i] == -1) {
                int x = (int) (Math.random() * n);
                while (t[x] == -1)
                    x = (int) (Math.random() * n);
                t[i] = x;
                nivel[i] = nivel[x] + 1;
                frunza[x] = 0;
            }
        }
    }
}
