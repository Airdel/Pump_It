/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

/**
 *
 * @author Marval
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
 
/**
 * Class to remove OLE Header from images stored as OLE Object
 * @author Douglas.Pasqua
 */
public class OLEImage {
     
    // Map to store the initial block of different images formats
    private Map<String, String> imagesBeginBlock;
 
    public OLEImage() {
        // inicialize
        imagesBeginBlock = new HashMap<String, String>();
        imagesBeginBlock.put("JPEG", "\u00FF\u00D8\u00FF"); // JPEG
        imagesBeginBlock.put("PNG", "\u0089PNG\r\n\u001a\n"); // PNG
        imagesBeginBlock.put("GIF", "GIF8"); // GIF
        imagesBeginBlock.put("TIFF", "II*\u0000"); // TIFF
        imagesBeginBlock.put("BMP", "BM"); // BMP
    }
    
    public byte[] getByteImgFromOLEInputStream(InputStream input, String imageFormat) {
        // get begin block identifier using imageFormat parameter
        String beginBlock = imagesBeginBlock.get(imageFormat);
        if(beginBlock == null) {
            throw new RuntimeException("Unsupported image format parameter value.");
        }
         
        try {
            byte[] b = toByteArray(input);
            String str = new String(b, "ISO-8859-1");
             
            // identifying the initial position of the image 
            int index = str.indexOf(beginBlock);
            if(index == -1) {
                throw new RuntimeException("Imposible determinar el formato de imagen. :c.");
            }
             
            // removing the OLE Header 
            byte[] buffer = new byte[b.length - index];
            for(int i = 0, a = index; a < b.length; i++, a++) {
                buffer[i] = b[a];
            }
            return buffer;
             
        } catch(IOException e) {
            e.printStackTrace();
        } 
         
        return null;
    }
     
    /**
     * Convert InputStream object to array of bytes
     * @throws IOException 
     */
    public byte[] toByteArray(InputStream is) throws IOException {
        int len;
        int size = 1024;
        byte[] buf;
 
        if (is instanceof ByteArrayInputStream) {
            size = is.available();
            buf = new byte[size];
            len = is.read(buf, 0, size);
        } else {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            buf = new byte[size];
            while ((len = is.read(buf, 0, size)) != -1) {
                bos.write(buf, 0, len);
            }
            buf = bos.toByteArray();
        }
        return buf;
    }
}