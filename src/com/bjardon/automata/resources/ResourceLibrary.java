package com.bjardon.automata.resources;

import com.bjardon.automata.application.framework.Container;
import com.bjardon.automata.application.framework.View;
import com.bjardon.automata.application.framework.Window;

/**
 * Created by bruno on 23/03/17.
 */
public class ResourceLibrary {

    public final Window APP_WINDOW;
    public final Container APP_CONTAINER;

    public final View IC_ALPHABET;
    public final View IC_STATES;
    public final View IC_TRANSITIONS;

    public ResourceLibrary() {
        APP_CONTAINER = new Container("/com/bjardon/automata/application/views/AppContainer.fxml", "Autómata");
        APP_WINDOW = new Window(APP_CONTAINER);

        IC_ALPHABET = new View("/com/bjardon/automata/application/views/initialconfig/AlphabetInitialConfigView.fxml", "Configuración inicial: Alfabeto");
        IC_STATES = new View("/com/bjardon/automata/application/views/initialconfig/StatesInitialConfigView.fxml", "Configuración inicial: Estados");
        IC_TRANSITIONS = new View("/com/bjardon/automata/application/views/initialconfig/TransitionsInitialConfigView.fxml", "Configuración inicial: Transiciones");
    }

}
