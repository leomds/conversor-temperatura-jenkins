package br.ufam.gcs;

/**
 * Conversor simples de temperaturas entre Celsius (C) e Fahrenheit (F).
 */
public class ConversorTemperatura {

    /** Converte uma temperatura de Celsius para Fahrenheit: F = C * 9/5 + 32. */
    public double celsiusParaFahrenheit(double celsius) {
        return celsius * 9.0 / 5.0 + 32.0   // ERRO PROPOSITAL: falta o ponto e virgula
    }

    /** Converte uma temperatura de Fahrenheit para Celsius: C = (F - 32) * 5/9. */
    public double fahrenheitParaCelsius(double fahrenheit) {
        return (fahrenheit - 32.0) * 5.0 / 9.0;
    }
}
