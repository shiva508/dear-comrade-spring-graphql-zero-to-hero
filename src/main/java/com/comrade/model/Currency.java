package com.comrade.model;

import lombok.Getter;

@Getter
public enum Currency {
    Sterling("£"),
    Yen ("¥"),
    Franc ("₣"),
    Rupee ("₹"),
    Dinar ("د.ك"),
    Dirham ("د.إ"),
    Riyal ("﷼‎"),
    Mark ("₻"),
    Ruouble ("₽"),
    Lari ("₾"),
    Lira ("₺"),
    Manat ("₼"),
    Tenge ("₸"),
    Hryvnia ("₴"),
    Spesmilo ("₷"),
    Baht (" - ฿"),
    Won ("원"),
    Dong ("₫"),
    Tugrik ("₮"),
    Drachma ("₯"),
    Peso ("₱"),
    Austral ("₳"),
    Cedi ("₵"),
    Guarani ("₲"),
    Sheqel ("₪"),
    Penny ("₰");
    private final String symbol;

    Currency(String symbol) {
        this.symbol = symbol;
    }

    public static Currency fromCustomValue(String value) {
        for (Currency candidate : values()) {
            if (candidate.symbol.equals(value)) {
                return candidate;
            }
        }
        throw new IllegalArgumentException("Unknown media type '" + value + "'");
    }
}
