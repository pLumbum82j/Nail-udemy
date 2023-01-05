package lesson4;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Reg {
    public static void main(String[] args) {
        //   \\d - обозначает цифру
        String a = "1";
        System.out.println(a.matches("\\d")); //true
        // + - 1 или более
        a = "123";
        System.out.println(a.matches("\\d+")); //true
        // * - 0 или более
        a = "";
        System.out.println(a.matches("\\d*")); //true
        // ? - 0 или 1 символов ДО (есть символ до или нет)
        a = "-123";
        System.out.println(a.matches("-?\\d+")); //true
        // (x|y|z) или (-|\\+) - одна строка или множество
        // т.е. через знак | перечисляется "может быть, а может не быть"
        String b = "+123";
        System.out.println(a.matches("(-|\\+)?\\d*")); //true
        System.out.println(b.matches("(-|\\+)?\\d*")); //true
        // [abcdef] == (a|b|c|d|e|f)
        // [a-zA-Z] - все символы лат. алфавита
        a = "a123";
        System.out.println(a.matches("[a-zA-Z]\\d+")); //true
        a = "wdwdwdwd22"; // когда несколько символом не забываем "+"
        System.out.println(a.matches("[a-zA-Z]+\\d+")); //true
        a = "wdwd3wdw7d22"; // бывает с цифрами (к примеру "3" и "7")
        System.out.println(a.matches("[a-zA-Z37]+\\d+")); //true
        // [^a-z] - отрицание (хотим все символы кроме тех, что в скобках)
        a = "hallo";
        System.out.println(a.matches("[^abc]*")); //false
        // . - точка, это любой символ (.+ - несколько символов)
        a = "http://www.e1.ru";
        b = "http://www.1tv.com";
        System.out.println(a.matches("http://www\\..+\\.(com|ru)")); //true
        System.out.println(b.matches("http://www\\..+\\.(com|ru)")); //true
        // {2} - два символа ДО (\\d{2}) - две цифры.
        // {2,} - два или более символов (\\d{2,}) - от двух до бесконечности цифр
        // {2, 4} - от двух до четырёх символов (\\d{2,4}) - от двух до четырёх цифр
        a = "123";
        b = "12";
        System.out.println(a.matches("\\d{2}")); //false
        System.out.println(b.matches("\\d{2}")); // true
        // \\w - одна латинская буква
        // эквивалент \\w == [a-zA-Z]
        a = "a222";
        System.out.println(a.matches("\\w\\d{3}")); //true

        //split - разбить
        a = "Hello My World";
        String[] words = a.split(" "); // Делим строку по пробелам
        System.out.println(Arrays.toString(words));
        b = "Hello.My.World";
        words = b.split("\\."); // Делим строку по точкам
        System.out.println(Arrays.toString(words));
        a = "Hello223My1313World";
        words = a.split("\\d+"); // Делим строку по разделителю "цифры"
        System.out.println(Arrays.toString(words));
        //replace - заменить
        b = b.replace(".", " "); // заменяем . на пробелы
        System.out.println(b);
        a = a.replaceAll("\\d+", " "); // заменяем цифры на пробелы
        System.out.println(a);                       // при помощи метода replaceAll
        // т.е. replaceAll принимает паттерн на вход, а не искомый символ
        a = a.replaceFirst(" ", "."); // меняет первое встреч. знач.
        System.out.println(a);
    }
}
