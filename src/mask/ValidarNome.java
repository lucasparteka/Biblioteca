/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mask;

import com.jfoenix.controls.JFXTextField;

/**
 *
 * @author Lucas
 */
public class ValidarNome {

    public JFXTextField validarNome(JFXTextField nome) {
        nome.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\sa-zA-Z*")) {
                nome.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
            }
        });
        return nome;
    }

}
