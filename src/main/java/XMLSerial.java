
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class XMLSerial {

    public static void serializeToXML(String filename, Car car){
        try {
            XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)));
            encoder.setPersistenceDelegate(java.math.BigDecimal.class, encoder.getPersistenceDelegate(Integer.class));
            encoder.writeObject(car);
            encoder.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static Car deSerializeFromXML(String filename)throws Exception{
        Car obj = null;

        FileInputStream in = new FileInputStream(filename);
        XMLDecoder decoder = new XMLDecoder(in);

        obj = (Car)decoder.readObject();
        decoder.close();
        in.close();

        return obj;
    }
}
