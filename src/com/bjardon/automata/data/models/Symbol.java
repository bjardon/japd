package com.bjardon.automata.data.models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.security.PublicKey;

/**
 * Created by bruno on 29/03/17.
 */
public class Symbol {

    private ObjectProperty<Character> symbol = new SimpleObjectProperty<>();

    public Symbol() {
        this((char)0);
    }

    public Symbol(char symbol) {
        this.symbol.setValue(symbol);
    }

    public Character getSymbol() {
        return symbol.get();
    }

    public ObjectProperty<Character> getSymbolProperty() {
        return this.symbol;
    }

    public void setSymbol(Character symbol) {
        this.symbol.set(symbol);
    }

    @Override
    public String toString() {
        return this.getSymbol().toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Symbol))
            return false;
        return ((Symbol)obj).getSymbol() == this.getSymbol();
    }
}
