package com.company;
import java.io.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception  {              /* нахуя нужен throws Exception я так и не
                                                                               понял но без него не работает ридер   */

       /* FileReader reader = new FileReader("russian_nouns.txt");
        Scanner scan = new Scanner(reader);

        FileWriter writer = new FileWriter("words.txt");

        while (scan.hasNextLine()) {
            String word = scan.nextLine();
            if (word.length() == 5){
                writer.write(word + "\n");
            }
            else {
                continue;
            }
        }
        reader.close();
        writer.close();

        */ // этой хуйнёй я тхт словарь делал


        FileReader reader = new FileReader("words.txt");            // в reader закидываю весь words тхт
        Scanner scan = new Scanner(reader);                                 // подрубаю сканер
        String word = "";                                                   // объявляю word
        int random_number = 0 + (int) (Math.random() * 3483);               // рандомная строка выбирается
        for (int  i = 0; i < random_number; i++) {                          // цикл до строки и присваеваем слово
            word = scan.nextLine();
        }
        reader.close();                                                     // поток ридера офаем

        System.out.println(word);
        Scanner input = new Scanner(System.in);

        int g = 6;
        String guess = "";
        while (!guess.equals(word) && g > 0) {
            System.out.println("\nУ тебя " + g + " попыток");
            guess = input.nextLine();
            if (guess.length() != 5) {
                System.out.println("Долно быть 5 букв");
                continue;
            }
            for (int i = 0; i < word.length(); i++) {
                for (int j = 0; j< word.length(); j++) {
                    if (word.indexOf(guess.charAt(i)) == -1) {
                        System.out.print("?");
                        break;
                    }
                    if (guess.charAt(i) == word.charAt(i)) {
                        System.out.print("Д");
                        break;
                    }
                    else {
                        System.out.print("Н");
                        break;
                    }
                }
            }
            g--;
        }
        System.out.println("");
        if (guess.equals(word)) {
            System.out.println("Угадал!");
        } else System.out.println("Неправильно! Загаданное слово было: " + word);
    }
}