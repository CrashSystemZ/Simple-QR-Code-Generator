# Simple QR Code Generator

## Description

Simple generation of ordinary qr code. At the output is not the most beautiful picture that can be imagined, but for simple tasks is fine.

## Installation

Maven:
```xml
    <dependencies>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.30</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>com.google.zxing</groupId>
            <artifactId>core</artifactId>
            <version>3.5.2</version>
        </dependency>
        <dependency>
            <groupId>com.google.zxing</groupId>
            <artifactId>javase</artifactId>
            <version>3.4.1</version>
        </dependency>
    </dependencies>
```
## Usage

```java
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
```
