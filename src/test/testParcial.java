package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logica.Parcial;

import static org.junit.jupiter.api.Assertions.*;


class testParcial {

	private final Parcial parcial = new Parcial();

    @Test
    public void testRaicesRealesDistintas() {
        // Caso: a=1, b=-3, c=2 -> x^2 - 3x + 2 = 0 -> Raíces: x1=2, x2=1
        double[] resultado = parcial.retonarRaices(1, -3, 2);
        assertEquals(2.0, resultado[0], 0.0001);
        assertEquals(1.0, resultado[1], 0.0001);
    }

    @Test
    public void testRaicesRealesIguales() {
        // Caso: a=1, b=-2, c=1 -> x^2 - 2x + 1 = 0 -> Raíces: x1=x2=1
        double[] resultado = parcial.retonarRaices(1, -2, 1);
        assertEquals(1.0, resultado[0], 0.0001);
        assertEquals(1.0, resultado[1], 0.0001);
    }

    @Test
    public void testDiscriminanteNegativo() {
        // Caso: a=1, b=1, c=1 -> x^2 + x + 1 = 0 -> Discriminante negativo
        Exception exception = assertThrows(ArithmeticException.class, new Executable() {
            @Override
            public void execute() {
                parcial.retonarRaices(1, 1, 1);
            }
        });
        assertEquals("La ecuación tiene raíces complejas.", exception.getMessage());
    }

    @Test
    public void testCoeficienteAEsCero() {
        // Caso: a=0, b=2, c=1 -> No es una ecuación de segundo grado
        Exception exception = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() {
                parcial.retonarRaices(0, 2, 1);
            }
        });
        assertEquals("El valor de 'a' no puede ser 0 en una ecuación de segundo grado.", exception.getMessage());
    }

}
