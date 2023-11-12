package javacorehw05;

// 1. Написать функцию, создающую резервную копию всех файлов в директории во вновь созданную папку ./backup

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class BackupFiles {
    public static void main(String[] args) {
        String sourceDir = "путь_к_директории"; // Заменить на путь к директории
        String backupDir = "./backup"; // Путь к папке копии

        try {
            File source = new File(sourceDir);
            File backup = new File(backupDir);

            // Создаем папку копии, если ее нет
            if (!backup.exists()) {
                backup.mkdir();
            }

            // Список файлов в директории
            File[] files = source.listFiles();

            if (files != null) {
                // Копируем каждый файл в папку копии
                for (File file : files) {
                    File dest = new File(backupDir + "/" + file.getName());
                    Files.copy(file.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
                System.out.println("Резервная копия создана успешно.");
            } else {
                System.out.println("Директория пуста.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}