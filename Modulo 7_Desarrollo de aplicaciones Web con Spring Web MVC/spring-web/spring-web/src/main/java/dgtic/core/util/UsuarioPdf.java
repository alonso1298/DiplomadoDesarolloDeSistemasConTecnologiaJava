package dgtic.core.util;

import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.*;
import dgtic.core.model.entity.UsuarioBd;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import java.awt.*;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Phaser;

@Component("utilerias/crear-pdf")
public class UsuarioPdf extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document,
                                    PdfWriter writer,
                                    HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
        List<UsuarioBd> datos=(List<UsuarioBd>) model.get("datos");
        String ruta=(String)model.get("ruta");
        String rutaAlm =ruta+"temp.pdf";
        PdfWriter.getInstance(document, new FileOutputStream(rutaAlm));
        document.open();
        PdfPTable table=new PdfPTable(3);
        PdfPCell celda=new PdfPCell(new Phrase("nombre"));
        celda.setBackgroundColor(new Color(167,218,255));
        celda.setPadding(8f);
        table.addCell(celda);
        table.addCell("Correo");
        table.addCell("Edad");
        for(UsuarioBd us:datos){
            table.addCell(us.getNombre());
            table.addCell(us.getCorreo());
            table.addCell( String.valueOf(us.getEdad()));
        }
        document.add(table);
        document.close();
    }
}
