package br.com.designpattern.builder;

import br.com.designpattern.builder.challenge.Nf;
import br.com.designpattern.builder.challenge.NfBuilder;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class NfTest {

    @Test
    public void shouldBeCalculateTotalNfToPhysicalPerson() {
        Nf nf = new NfBuilder()
                .physicalPerson()
                .number("1")
                .createdAt("07/07/2021")
                .withItem("Smartphone", 1, 1000)
                .withItem("Kindle", 1, 300)
                .build();

        BigDecimal actual = nf.getTotal();

        assertNotNull(nf.getNumber());
        assertEquals(new BigDecimal(1391).doubleValue(), actual.doubleValue(), 0.0001);
    }

    @Test
    public void shouldBeCalculateTotalNfToLegalPerson() {
        Nf nf = new NfBuilder()
                .legalPerson()
                .number("1")
                .createdAt("07/07/2021")
                .withItem("Smartphone", 1, 1000)
                .withItem("Kindle", 1, 300)
                .build();

        BigDecimal actual = nf.getTotal();

        assertNotNull(nf.getNumber());
        assertEquals(new BigDecimal(1352).doubleValue(), actual.doubleValue(), 0.0001);
    }

}
