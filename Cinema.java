package cinema;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        System.out.println("Enter the number of rows:");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int j = scanner.nextInt();
        int ic;
        int jc;
        int tickets= 0;
        int income= 0;
        int Tincome;
        if(i*j <= 60) {
            Tincome= i*j*10;
        }else {
            Tincome= (i/2)*j*10 + (i-i/2)*j*8;
        }
        double seats= i*j;
        boolean exit= true;
        String[][] Menu= new String[i+1][j+1];
        for (int k = 0; k <= i; ++k) {
            for (int l = 0; l <= j; ++l) {
                Menu[0][0]= " ";
                Menu[0][l]= ""+l;
                Menu[k][0]= ""+k;
                Menu[k][l]= "S";
            }
        }
        do {
            System.out.println("1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");
            int option= scanner.nextInt();
            switch(option) {
                case 1:
                    System.out.println("Cinema:");
                    for (int k=0; k<Menu.length; ++k) {
                        for (int l=0; l<Menu[k].length; ++l) {
                            System.out.print(Menu[k][l]+" ");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    do {
                        System.out.println("Enter a row number:");
                        ic = scanner.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        jc = scanner.nextInt();
                        if(ic>i || jc>j) {
                            System.out.println("Wrong input!");
                        }else if(Menu[ic][jc]== "B") {
                            System.out.println("That ticket has already been purchased!");
                        }
                    }while(ic>i || jc>j || Menu[ic][jc] == "B");
                    price(i, j, ic);
                    Menu[ic][jc]= "B";
                    tickets++;
                    if(seats<= 60) {
                        income += 10;
                    }else {
                        if(ic <= i/2) {
                            income += 10;
                        }else {
                            income += 8;
                        }
                    }


                    break;
                case 3:
                    System.out.println("Number of purchased tickets: "+tickets);
                    System.out.printf("Percentage: %.2f", (tickets/(seats))*100);
                    System.out.println("%");
                    System.out.println("Current income: $"+income);
                    System.out.println("Total income: $"+Tincome);
                    break;
                case 0:
                    boolean exit1= false;
                    exit= exit1;
                    break;
            }
        }while (exit);
    }
    public static void price(int i, int j, int ic) {
        if (i*j <= 60){
            System.out.println("Ticket price: $10");
        } else {
            if (ic <= i/2){
                System.out.println("Ticket price: $10");
            }
            else{
                System.out.println("Ticket price: $8");
            }
        }
    }
}