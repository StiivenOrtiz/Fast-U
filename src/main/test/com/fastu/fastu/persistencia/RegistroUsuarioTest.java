package com.fastu.fastu.persistencia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class RegistroUsuarioTest {

    @Test
    public void usuarioRegistrado(){
        RegistroUsuario registroUsuario = new RegistroUsuario();
        try{
            Assertions.assertEquals(false, registroUsuario.registrarUsuario("Jorge", "jorge@gmail.com", "0987"));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    /*LA FUNCION crearArchivoDatosPersonales ESTA PRIVADA
    @Test
    public void archivoCreado(){
        RegistroUsuario creacionArchivo = new RegistroUsuario();
        try{
            Assertions.assertEquals(true, creacionArchivo.crearArchivoDatosPersonales("newArch", "Camilo", "camilo@gmail.com", "camilo123"));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    */
}
