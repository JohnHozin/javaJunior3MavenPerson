package lesson22;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        CopyWhithIO copyWhithIO = new CopyWhithIO();

        long start = System.currentTimeMillis();
        try {
            copyWhithIO.copy
                    ("C:\\Users\\Home-PK\\Downloads\\dotnet-sdk-6.0.400-win-x64.exe", "qwe.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Копирование IO " + (System.currentTimeMillis() - start));
    }
}
