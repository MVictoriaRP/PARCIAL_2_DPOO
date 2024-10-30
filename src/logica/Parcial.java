package logica;

public class Parcial {
	
	public double[] retonarRaices(double a, double b, double c) throws ArithmeticException, IllegalArgumentException {
        if (a == 0) {
            throw new IllegalArgumentException("El valor de a no puede ser 0");
        }

        double discriminante = (b * b) - 4 * a * c;

        if (discriminante < 0) {
            throw new ArithmeticException("La ecuacion tiene raices complejas");
        }

        double raiz1 = (-b + Math.sqrt(discriminante)) / (2 * a);
        double raiz2 = (-b - Math.sqrt(discriminante)) / (2 * a);

        return new double[] {raiz1, raiz2};
    }
	
	
}