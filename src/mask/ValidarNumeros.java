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
public class ValidarNumeros {

    public static void validarCpf(JFXTextField campo) {
        campo.lengthProperty().addListener((ObservableValue<? extends Number> observableValue, Number number, Number number2) -> {
            String mascara = "###.###.###-##";
            String alphaAndDigits = campo.getText().replaceAll("[^0-9]", "");
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
        
        //Long retornaLong = Long.parseLong;
        //return campo;
    }
    
    public static JFXTextField validarTelefone(JFXTextField telefone) {
        telefone.lengthProperty().addListener((ObservableValue<? extends Number> observableValue, Number number, Number number2) -> {
            String mascara = "(##)####-#####";
            String alphaAndDigits = telefone.getText().replaceAll("[^0-9]", "");
            StringBuilder resultado = new StringBuilder();
            int i = 0;
            int quant = 0;

            if (number2.intValue() > number.intValue()) {
                if (telefone.getText().length() <= mascara.length()) {
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
                    telefone.setText(resultado.toString());
                }
                if (telefone.getText().length() > mascara.length()) {
                    telefone.setText(telefone.getText(0, mascara.length()));
                }
            }
        });
        return telefone;
    }
    
    public static JFXTextField validarQuatroDig(JFXTextField valor) {
        valor.lengthProperty().addListener((ObservableValue<? extends Number> observableValue, Number number, Number number2) -> {
            String mascara = "####";
            String alphaAndDigits = valor.getText().replaceAll("[^0-9]", "");
            StringBuilder resultado = new StringBuilder();
            int i = 0;
            int quant = 0;

            if (number2.intValue() > number.intValue()) {
                if (valor.getText().length() <= mascara.length()) {
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
                    valor.setText(resultado.toString());
                }
                if (valor.getText().length() > mascara.length()) {
                    valor.setText(valor.getText(0, mascara.length()));
                }
            }
        });
        return valor;
    }
    
    public static JFXTextField validarOitoDig(JFXTextField valor) {
        valor.lengthProperty().addListener((ObservableValue<? extends Number> observableValue, Number number, Number number2) -> {
            String mascara = "########";
            String alphaAndDigits = valor.getText().replaceAll("[^0-9]", "");
            StringBuilder resultado = new StringBuilder();
            int i = 0;
            int quant = 0;

            if (number2.intValue() > number.intValue()) {
                if (valor.getText().length() <= mascara.length()) {
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
                    valor.setText(resultado.toString());
                }
                if (valor.getText().length() > mascara.length()) {
                    valor.setText(valor.getText(0, mascara.length()));
                }
            }
        });
        return valor;
    }
    
}
