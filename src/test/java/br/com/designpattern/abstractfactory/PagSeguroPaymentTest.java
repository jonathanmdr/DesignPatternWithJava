package br.com.designpattern.abstractfactory;

import br.com.designpattern.abstractfactory.operator.TransactionUnauthorizedException;
import br.com.designpattern.abstractfactory.payment.Payment;
import br.com.designpattern.abstractfactory.payment.PaymentFactory;
import br.com.designpattern.abstractfactory.payment.pagseguro.PagSeguroPaymentFactory;
import br.com.designpattern.abstractfactory.riskmanager.AlertRiskException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PagSeguroPaymentTest {

    private static Payment subject;

    @BeforeAll
    public static void setup() {
        PaymentFactory paymentFactory = new PagSeguroPaymentFactory();
        subject = new Payment(paymentFactory);
    }

    @Test
    public void givenAValidCard_whenAuthorizeSell_shouldBeAuthorizeSell() {
        Long authorizationCode = subject.authorize("2222.2222", new BigDecimal("200"));
        assertNotNull(authorizationCode);
    }

    @Test
    public void givenAInvalidCard_whenAuthorizeSell_shouldBeThrownTransactionUnauthorizedException() {
        Assertions.assertThrows(
                TransactionUnauthorizedException.class,
                () -> subject.authorize("5555.2222", new BigDecimal("2000"))
        );
    }

    @Test
    public void givenASuspectedFraud_whenAuthorizeSell_shouldBeThrownAlertRiskException() {
        Assertions.assertThrows(
                AlertRiskException.class,
                () -> subject.authorize("7777.2222", new BigDecimal("5500"))
        );
    }

}
