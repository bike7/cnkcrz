package pl.kasieksoft.cinkciarz.model;

public final class CurrencyBuilder {
    private String currencyCode;
    private String sellRate;
    private String buyRate;

    private CurrencyBuilder() {
    }

    public static CurrencyBuilder aCurrency() {
        return new CurrencyBuilder();
    }

    public CurrencyBuilder withCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public CurrencyBuilder withSellRate(String sellRate) {
        this.sellRate = sellRate;
        return this;
    }

    public CurrencyBuilder withBuyRate(String buyRate) {
        this.buyRate = buyRate;
        return this;
    }

    public Currency build() {
        return new Currency(currencyCode, sellRate, buyRate);
    }
}
