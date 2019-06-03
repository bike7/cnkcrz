package pl.kasieksoft.cinkciarz.model;

public class Currency {

    private String currencyCode;
    private String sellRate;
    private String buyRate;

    Currency(String currencyCode, String sellRate, String buyRate) {
        this.currencyCode = currencyCode;
        this.sellRate = sellRate;
        this.buyRate = buyRate;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "currencyCode='" + currencyCode + '\'' +
                ", sellRate=" + sellRate +
                ", buyRate=" + buyRate +
                '}';
    }
}
