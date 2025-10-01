package pe.edu.upeu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioBTest {

    @Order(1)
    @Test
    public void testMultiplicar(){
        ServicioB servicioB=new ServicioBImpl();
        int resultado=servicioB.multiplicar(3,4);
        Assertions.assertEquals(12,resultado);
    }

    @Order(2)
    @Test
    public void testMultiplicarSumar(){
        ServicioA servicioA=new ServicioAImpl();
        ServicioB servicioB=new ServicioBImpl();
        servicioB.setServicioA(servicioA);
        Assertions.assertEquals(10, servicioB.multiplicarSumar(2, 3, 2));
    }
    @Order(3)
    @Test
    public void testMultiplicarSumarMockito(){
        ServicioA servicioA= Mockito.mock(ServicioA.class);
        Mockito.when(servicioA.sumar(2,3)).thenReturn(5);

        ServicioB servicioB=Mockito.mock(ServicioB.class);
        servicioB.setServicioA(servicioA);

        Mockito.when(servicioB.multiplicarSumar(2,3,2)).thenReturn(10);
        int resultado=servicioB.multiplicarSumar(2,3,2);
        Assertions.assertEquals(10,resultado);

    }

}
