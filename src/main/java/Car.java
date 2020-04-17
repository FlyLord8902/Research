

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Serializable;
import java.nio.charset.*;
import java.nio.file.*;
import java.math.BigDecimal;




public class Car implements Serializable {

    private String brand;

    private BigDecimal price;

    public Car(){}

    public Car(String brand, BigDecimal price){
        this.brand = brand;
        this.price = price;
    }
    public String toString(){
        return "Brand: "+ brand +", " + "Price: "+ price;
    }

    public void setBrand(String newBrand){
        this.brand = newBrand;
    }

    public String getBrand(){
        return this.brand;
    }

    public void setPrice(BigDecimal newPrice){
        this.price = newPrice;
    }

    public BigDecimal getPrice(){
        return this.price;
    }

    public static void serializeCarCSV(Car car, String fileName) {
        try {
            Charset charset = StandardCharsets.UTF_8;
            StringBuilder line = new StringBuilder();
            Path path = Paths.get(fileName);

            try (BufferedWriter writer = Files.newBufferedWriter(path, charset)) {
                line.append("Brand").append(",").append("Price").append("\n");
                line.append(car.brand).append(",").append(car.price);
                writer.write(line.toString());

            } catch (Exception e) {
                e.printStackTrace();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public static Car deSerializeCarCSV(String fileName){
            Car newCar = null;
            Path nPath = Paths.get(fileName);

            try(BufferedReader reader = Files.newBufferedReader(nPath)) {
                reader.readLine();
                String[] para = reader.readLine().split(",");
                newCar = new Car(para[0], new BigDecimal(para[1]));
            }catch (Exception e){
                e.printStackTrace();
            }
            return newCar;
    }



    public boolean equals(Object other ){
        boolean isCar = false;
        if(other instanceof Car){
            Car nCar = (Car) other;
            isCar = nCar.getBrand().compareToIgnoreCase(brand) == 0;
            isCar = isCar && nCar.getPrice().compareTo(price) == 0;
        }

        return isCar;

    }
}
