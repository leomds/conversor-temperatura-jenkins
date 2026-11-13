package br.ufam.gcs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConversorTemperaturaTest {

    private static final double DELTA = 0.001;
    private final ConversorTemperatura conversor = new ConversorTemperatura();

    // ---- Celsius -> Fahrenheit ----

    @Test
    @DisplayName("0 C (congelamento da agua) = 32 F")
    void celsiusParaFahrenheitPontoDeCongelamento() {
        assertEquals(32.0, conversor.celsiusParaFahrenheit(0.0), DELTA);
    }

    @Test
    @DisplayName("100 C (ebulicao da agua) = 212 F")
    void celsiusParaFahrenheitPontoDeEbulicao() {
        assertEquals(212.0, conversor.celsiusParaFahrenheit(100.0), DELTA);
    }

    // ---- Fahrenheit -> Celsius ----

    @Test
    @DisplayName("32 F = 0 C")
    void fahrenheitParaCelsiusPontoDeCongelamento() {
        assertEquals(0.0, conversor.fahrenheitParaCelsius(32.0), DELTA);
    }

    @Test
    @DisplayName("98.6 F (temperatura do corpo) = 37 C")
    void fahrenheitParaCelsiusTemperaturaCorporal() {
        assertEquals(37.0, conversor.fahrenheitParaCelsius(98.6), DELTA);
    }

    @Test
    @DisplayName("-40 F = -40 C (as escalas se cruzam)")
    void fahrenheitParaCelsiusPontoDeCruzamento() {
        assertEquals(-40.0, conversor.fahrenheitParaCelsius(-40.0), DELTA);
    }
}
