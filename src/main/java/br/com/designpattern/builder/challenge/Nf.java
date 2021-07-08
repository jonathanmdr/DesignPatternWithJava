package br.com.designpattern.builder.challenge;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Nf {

    private String number;
    private Date createdAt;
    private List<NfItem> items;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<NfItem> getItems() {
        return items;
    }

    public void setItems(List<NfItem> items) {
        this.items = items;
    }

    public int getPercentTax() {return 0;}

    public BigDecimal getTotal() {
        BigDecimal total = items.stream()
                .map(item -> new BigDecimal(item.getAmount()).multiply(item.getValue()))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);

        return total.add(total.multiply(new BigDecimal(getPercentTax())).divide(new BigDecimal(100)));
    }

}
