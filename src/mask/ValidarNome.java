/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mask;

import com.jfoenix.controls.JFXTextField;

import javafx.beans.value.ObservableValue;

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

	public static void validarTamanhoCampo(JFXTextField campo) {
		campo.lengthProperty()
				.addListener((ObservableValue<? extends Number> observableValue, Number number, Number number2) -> {
					String mascara = "####################";
					String alphaAndDigits = campo.getText().replaceAll("[^\\sa-zA-Z]", "");
					StringBuilder resultado = new StringBuilder();
					int i = 0;
					int quant = 0;

					if (number2.intValue() > number.intValue()) {
						if (campo.getText().length() <= mascara.length()) {
							while (i < mascara.length()) {
								if (quant < alphaAndDigits.length()) {
									if ("#".equals(mascara.substring(i, i + 1))) {
										resultado.append(alphaAndDigits.substring(quant, quant + 1));
										quant++;
									} else {
										resultado.append(mascara.substring(i, i + 1));
									}
								}
								i++;
							}
							campo.setText(resultado.toString());
						}
						if (campo.getText().length() > mascara.length()) {
							campo.setText(campo.getText(0, mascara.length()));
						}
					}
				});

		// Long retornaLong = Long.parseLong;
		// return campo;
	}
}
