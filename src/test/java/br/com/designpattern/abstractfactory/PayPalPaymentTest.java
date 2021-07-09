package br.com.designpattern.abstractfactory;

import br.com.designpattern.abstractfactory.operator.TransactionUnauthorizedException;
import br.com.designpattern.abstractfactory.payment.Payment;
import br.com.designpattern.abstractfactory.payment.PaymentFactory;
import br.com.designpattern.abstractfactory.payment.paypal.PayPalPaymentFactory;
import br.com.designpattern.abstractfactory.riskmanager.AlertRiskException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PayPalPaymentTest {

    private static Payment subject;

    @BeforeAll
    public static void setup() {
        PaymentFactory paymentFactory = new PayPalPaymentFactory();
        subject = new Payment(paymentFactory);
    }

    @Test
    public void givenAValidCard_whenAuthorizeSell_shouldBeAuthorizeSell() {
        Long authorizationCode = subject.authorize("2222.2222", new BigDecimal("200"));
        assertNotNull(authorizationCode);
    }

    @Test
    public void givenAExceededLimitCard_whenAuthorizeSell_shouldBeThrownTransactionUnauthorizedException() {
        Assertions.assertThrows(
                TransactionUnauthorizedException.class,
                () -> subject.authorize("2222.2222", new BigDecimal("2000"))
        );
    }

    @Test
    public void givenAValidCardWithHighLimit_whenAuthorizeSell_shouldBeAuthorizeSell() {
        Long authorizationCode = subject.authorize("3333.2222", new BigDecimal("2000"));
        assertNotNull(authorizationCode);
    }

    @Test
    public void givenASuspectedFraud_whenAuthorizeSell_shouldBeThrownAlertRiskException() {
        Assertions.assertThrows(
                AlertRiskException.class,
                () -> subject.authorize("1111.2222", new BigDecimal("5500"))
        );
    }

}
