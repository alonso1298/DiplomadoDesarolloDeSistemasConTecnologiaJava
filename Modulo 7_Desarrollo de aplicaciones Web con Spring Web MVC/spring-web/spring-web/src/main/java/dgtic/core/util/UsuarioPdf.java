package dgtic.core.util;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;
import dgtic.core.model.entity.UsuarioBd;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

@Component("utilerias/crear-pdf")
public class UsuarioPdf extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document,
                                    PdfWriter writer,
                                    HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
        List<UsuarioBd> datos=(List<UsuarioBd>) model.get("Datos");
        String ruta=(String)model.get("ruta");
        String rutaAlm =ruta+"temp.pdf";
        PdfWriter.getInstance(document, new FileOutputStream(rutaAlm));
        document.open();
    }
}
