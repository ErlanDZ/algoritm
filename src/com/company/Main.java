package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	int [] banknotes = {1, 3, 5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000};
	int [] quantities = {10, 5, 5, 3, 2, 1, 2, 3, 3, 2, 0, 2};//величины
	int totalAvailable =0; //итого Доступно
    String result =" ";

        for (int i = 0; i < banknotes.length  ; i++) {
            totalAvailable = totalAvailable + banknotes[i] * quantities[i];
        }
        Scanner scanner = new Scanner(System.in);
        int withdraw = scanner.nextInt();
        int remains = 0;
        int remainingAmountToGive = withdraw;
        if (remainingAmountToGive > totalAvailable){
            System.out.println("Вы можете снять только" + totalAvailable);

        }else{
            for (int i = banknotes.length - 1; i >= 0; i--) {
                if (quantities[i] >0){
                    int quantity = remainingAmountToGive / banknotes[i];
                    if (quantity > 0){
                        if(quantity > quantities[i]){
                           quantity = quantities[i];
                        }
                        result = result  + quantity + " X " + banknotes[i] + ", ";
                        quantities[i] = quantities[i] - quantity;
                        remainingAmountToGive = remainingAmountToGive - quantity * banknotes[i];
                        remains = remains + banknotes[i] * quantity;
                        if (remainingAmountToGive ==  0){
                            break;
                        }
                    }
                }
            }
        }
        if (remainingAmountToGive ==0){
            System.out.println("Вы получили " + result + ",  Всего " + withdraw);
        }else {
            System.out.println("Вы можете снять только " + remains);
        }
    }
}
