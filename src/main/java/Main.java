import com.google.zxing.WriterException;
import java.io.IOException;

public class Main {

    private static final String EXAMPLE_URL = "https://media.discordapp.net/" +
                                              "attachments/" +
                                              "1197025155587776552/" +
                                              "1215368316621693089/" +
                                              "m-ftHZMeATI.gif?ex=65fc7ef3&is=65ea09f3&hm=fb00fe4c45ab3ad98fd3305f3033b45ccd954b5b61ff377b31b5885aa922df91&=&width=748&height=905";

    public static void main(String[] args) {
        try {
            QRCodeGenerator qrCodeGenerator = QRCodeGenerator.builder()
                    .path("./qr_example.png") //save path
                    .width(400) //output file width
                    .height(400) //output file height
                    .url(EXAMPLE_URL) //link that will open when scanning qr code
                    .build();

            qrCodeGenerator.generate(); //png creation
        } catch (WriterException exception) {
            System.out.println("Could not generate QR Code, WriterException: " + exception.getMessage());
        } catch (IOException exception) {
            System.out.println("Could not generate QR Code, IOException: " + exception.getMessage());
        }
    }
}
