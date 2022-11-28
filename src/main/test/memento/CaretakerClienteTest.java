package memento;

import com.fastu.fastu.Modelo.Cliente;
import com.fastu.fastu.memento.CaretakerCliente;
import com.fastu.fastu.memento.MementoCliente;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class CaretakerClienteTest {

     @Test
    public void pruebaDeCaretaker(CaretakerCliente m){

        Cliente cliente = new Cliente();
        cliente.setNombreCompleto("fabian");
        cliente.setCorreo("fab@si.com");
        cliente.setContrasena("1234");
        MementoCliente mem= new MementoCliente(cliente);
        m.addMemento(mem);
        Cliente cliente1= new Cliente();
        cliente1 = m.getMemento(1).getEstado();

        assertEquals("fabian", cliente1.getNombreCompletos());
    }


}
