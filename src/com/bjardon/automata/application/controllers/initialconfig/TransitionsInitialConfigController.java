package com.bjardon.automata.application.controllers.initialconfig;

import com.bjardon.automata.Main;
import com.bjardon.automata.application.controllers.AppController;
import com.bjardon.automata.data.models.State;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Created by bruno on 15/04/17.
 */
public class TransitionsInitialConfigController extends AppController {

    @FXML
    private TableView<State> tbvTransitions;
    @FXML
    private TableColumn<State, String> tbcStateName;


    @FXML
    public void initialize() {
        this.tbcStateName.setCellValueFactory(value -> value.getValue().getNameProperty());
        Main.getAlphabet().forEach(symbol -> {
            TableColumn<State, String> column = new TableColumn<State, String>(symbol.getSymbol().toString());
            column.setCellValueFactory(value -> {
                if(value.getValue().delta(symbol) != null)
                    return value.getValue().delta(symbol).getNameProperty();
                return new SimpleStringProperty();
            });
            this.tbvTransitions.getColumns().add(column);
        });
        this.tbvTransitions.setItems(Main.getStates());

    }

}
