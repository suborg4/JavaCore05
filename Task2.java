package javacorehw05;

import java.io.File;

public class Task2 {

    public static void main(String[] args) {
        printTree(new File("."), "", true);
    }

    static void printTree(File file, String indent, boolean isLast) {
        System.out.print(indent);

        // Проверяем элемент последним в уровне дерева
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }

        // Выводим имя элемента
        System.out.println(file.getName());

        // список элементов внутри директории
        File[] files = file.listFiles();
        if (files == null)
            return;

        int subDirTotal = 0;
        for (File f : files) {
            // количество поддиректорий в директории
            if (f.isDirectory())
                subDirTotal++;
        }

        int subDirCounter = 0;
        for (File f : files) {
            if (f.isDirectory()) {
                subDirCounter++;
                //  Рекурсивный метод для каждой поддиректории
                //  isLast в true, если  поддиректория последняя в  уровне
                printTree(f, indent, subDirCounter == subDirTotal);
            }
        }
    }

}
