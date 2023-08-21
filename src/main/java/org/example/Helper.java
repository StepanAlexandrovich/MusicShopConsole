package org.example;

import java.util.Scanner;

public class Helper {
    public static void printLine(String... text){
        String newText = "";

        for (int i = 0; i < text.length; i++) {
            newText += text[i];
            if(i<text.length - 1){
                newText += "\n";
            }
        }

        System.out.println("----------------------");
        System.out.println(newText);
        System.out.println("----------------------");
    }

    public static void inputIncorrect(){
        Scanner scanner = new Scanner(System.in);

        Helper.printLine("неверный ввод,введите любой символ что бы вернуться на страницу" );
        if(scanner.hasNext()){
            scanner.next();
        }

    }
    public static int[] arrayStringToInt(String[] arrayString){
        int[] array = new int[arrayString.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(arrayString[i]);
        }

        return array;
    }

}
