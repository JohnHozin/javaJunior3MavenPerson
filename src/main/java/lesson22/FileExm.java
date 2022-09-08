package lesson22;

import java.io.File;
import java.io.FileFilter;

public class FileExm {
    public static void main(String[] args) {
        File fl = new File("C:\\Users\\Home-PK\\Downloads");
        File[] arr = fl.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory())
                    return true;
                if (pathname.getName().endsWith(".torrent"))
                    return true;
                return false;
            }
        });
        for (File f : arr) {
            System.out.println(f);
        }
    }
}
