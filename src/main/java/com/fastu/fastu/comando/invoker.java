package com.fastu.fastu.comando;

import java.util.ArrayList;
import java.util.List;

//invocador
public class invoker {
    private final List<IOperacion> operaciones = new ArrayList<>(); //lista de operaciones

    public void recibirOperacion(IOperacion operacion) { //recibimos la operacion
        this.operaciones.add(operacion); //almacenamos la operacion
    }

    public void realizarOperaciones() {
        this.operaciones.forEach(x -> {
            x.execute();
        });
    }
}
