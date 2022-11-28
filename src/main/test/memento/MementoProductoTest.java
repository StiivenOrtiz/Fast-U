package memento;

import com.fastu.fastu.memento.MementoProducto;
import javafx.scene.image.Image;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import com.fastu.fastu.Modelo.Producto;

public class MementoProductoTest {

    private final Producto estado = new Producto("arroz", 2000, "arozz :)", null);

    public void pruebaMementoP(MementoProducto m){
        m=new MementoProducto(estado);

       Producto estado2 = m.getEstado();

       assertEquals(estado2, estado);
    }
}
