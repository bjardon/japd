package com.bjardon.automata.application.controllers.initialconfig;

import com.bjardon.automata.Main;
import com.bjardon.automata.application.controllers.AppController;
import com.bjardon.automata.data.models.Symbol;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * Created by bruno on 29/03/17.
 */
public class AlphabetInitialConfigController extends AppController{

    @FXML
    private TextField txtSymbol;
    @FXML
    private TableView<Symbol> tbvSymbols;
    @FXML
    private TableColumn<Symbol, Character> tbcCharacter;

    @FXML
    public void addSymbol(ActionEvent event) {

        String symbol = this.txtSymbol.getText().trim();
        this.txtSymbol.clear();

        if(symbol.length() == 1)
            Main.getAlphabet().add(new Symbol(symbol.charAt(0)));

    }

    @FXML
    public void removeSymbol(ActionEvent event) {

        if(this.tbvSymbols.getFocusModel().getFocusedItem() != null) {
            Main.getAlphabet().remove(this.tbvSymbols.getFocusModel().getFocusedItem());
        }

    }

    @FXML
    public void nextStep(ActionEvent event) {

        if(!Main.getAlphabet().isEmpty())
            this.change(Main.getResourceLibrary().IC_STATES);

    }

    public void initialize() {

        this.tbcCharacter.setCellValueFactory(value -> value.getValue().getSymbolProperty());
        this.tbvSymbols.setItems(Main.getAlphabet());

    }

}
