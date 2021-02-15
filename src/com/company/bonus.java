package com.company;
import java.util.Arrays;
public class bonus {
    public static void main(String []args)
    {  // Madalina Spiridon B2
        // generam un nr random n care sa reprezinte nr de noduri din arbore;
        int n= (int) ( Math.random()*8+ 1);
        // nodurile sunt de la 1 la n si vom construi vector de tati
        // nodul pentru care tatal este 0 va fi radacina
        int r=(int )( Math.random()*n); // radacina este aleasa random
        while(r==0)
            r=(int )( Math.random()*n);
        int []t=new int[n+1];
        Arrays.fill(t,-1);
        t[r]=0;
        // pt nodurile care nu au inca tata sa da un tata random dar a.i la fiecare pas am arbore
        for(int i=1;i<=n;i++)
        {
            if(t[i]==-1)
            {
                int x = (int) ( Math.random()*n);
                while(t[x]==-1)
                    x = (int) ( Math.random()*n);
                t[i]=x;
            }
        }
        for(int i=1;i<=n;i++)
            System.out.print(t[i] + " ");
    }
}
