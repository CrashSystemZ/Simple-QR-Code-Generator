import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import java.io.IOException;
import java.nio.file.FileSystems;

import static com.google.zxing.BarcodeFormat.QR_CODE;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@EqualsAndHashCode(of = {"url", "path"})
public class QRCodeGenerator {
    String url;
    String path;
    int width, height;

    public void generate() throws IOException, WriterException {
        MatrixToImageWriter.writeToPath(
                new QRCodeWriter().encode(url, QR_CODE, width, height),
                "png", //You can also use other picture formats
                FileSystems.getDefault().getPath(path)
        );
    }
}
