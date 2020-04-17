
import java.io.*;

public class Serialize {

public static void binarySer(Object any, String filenName) {

    try {
        FileOutputStream fileOut = new FileOutputStream(filenName);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        out.writeObject(any);
        out.close();
        fileOut.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public static Object binaryDeSer(String fileName){
        Object obj = null;
        try{
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            obj = in.readObject();
    }catch (Exception e){
            e.printStackTrace();
        }
        return obj;
    }
}
