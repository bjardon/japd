package com.bjardon.automata.application.controllers.initialconfig;

import com.bjardon.automata.Main;
import com.bjardon.automata.application.controllers.AppController;
import com.bjardon.automata.data.models.State;
import com.bjardon.automata.data.models.Symbol;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by bruno on 29/03/17.
 */
public class StatesInitialConfigController extends AppController {

    @FXML
    private TextField txtName;
    @FXML
    private CheckBox chkFinal;
    @FXML
    private TableView<State> tbvStates;
    @FXML
    private TableColumn<State, String> tbcStateName;
    @FXML
    private TableColumn<State, String> tbcType;

    @FXML
    public void addState(ActionEvent event) {

        String name = this.txtName.getText().trim();
        boolean isFinal = chkFinal.isSelected();

        this.txtName.clear();
        this.chkFinal.setSelected(false);

        if(name.length() > 0)
            Main.getStates().add(new State(name, isFinal));

        if(Main.getStates().size() == 1)
            Main.setInitialState(Main.getStates().get(0));

    }

    @FXML
    public void removeState(ActionEvent event) {

        if(this.tbvStates.getSelectionModel().getSelectedItem() != null) {
            Main.getStates().remove(this.tbvStates.getSelectionModel().getSelectedItem());
        }

    }

    @FXML
    public void nextStep(ActionEvent event) {

        if(!Main.getStates().isEmpty())
            this.change(Main.getResourceLibrary().IC_TRANSITIONS);

    }

    @FXML
    public void initialize() {

        tbcStateName.setCellValueFactory(state -> state.getValue().getNameProperty());
        tbcType.setCellValueFactory(state -> {
            SimpleStringProperty type = new SimpleStringProperty();
            if (state.getValue().isFinal() && state.getValue() == Main.getInitialState()) {
                type.setValue("Inicial / Aceptación");
            } else if (state.getValue().isFinal()) {
                type.setValue("Aceptación");
            } else if (state.getValue() == Main.getInitialState()) {
                type.setValue("Inicial");
            }


            return type;
        });

        tbvStates.setItems(Main.getStates());

    }

}
