package com.company;

public class Main {

    public static void main(String[] args) {
        // Madalina Spiridon B2
        System.out.println("Hello World !");
        String[] lang={"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n= (int) (Math.random()*1_000_000);
        // Math.random =>  un nr de tip double de la 0.0 la 1.0... il  inmultim cu 1 mil- cat tine int
        System.out.println(n);
        n=n*3;
        System.out.println(n);
        n=n+Integer.parseInt("10101",2);
        n=n+Integer.parseInt("FF",16);
        n=n*6;
        System.out.println(n);

        // cifra de control
         while(n>=10){
        int s = 0;
        while(n!=0){
            s += n%10;
            n /= 10;
        }
        n = s;
    }

        System.out.println("Willy-nilly, this semester I will learn " + lang[n]);
    }
}
