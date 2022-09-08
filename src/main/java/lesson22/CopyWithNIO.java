package lesson22;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyWithNIO{
    public static void main(String[] args) {

        try {
            // Запись в файл:
            FileChannel fc = new FileOutputStream("data.txt").getChannel();
            fc.write(ByteBuffer.wrap("qweasdfasdfaefaef текста ".getBytes()));
            fc.close();
            // Добавление в конец файла:
            fc = new RandomAccessFile("data.txt", "rw").getChannel();
            fc.position(fc.size()); // Переходим в конец
            fc.write(ByteBuffer.wrap("asdasfasgfergsg tsgrtgsrtg".getBytes()));
            fc.close();
            // Чтение файла:
            fc = new FileInputStream("data.txt").getChannel();
            ByteBuffer buff = ByteBuffer.allocate(1024);  // размер буфера.
            fc.read(buff);
            buff.flip();
            while(buff.hasRemaining())
                System.out.print((char)buff.get());
            buff.rewind();  // чтобы заново прочитать буфер
            System.out.println();
            while(buff.hasRemaining())
                System.out.print((char)buff.get());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }



}
