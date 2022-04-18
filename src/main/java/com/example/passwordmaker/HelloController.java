package com.example.passwordmaker;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import com.jfoenix.controls.JFXSlider;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label pasLable;

    @FXML Label LengthLable;


    @FXML
    private JFXSlider pasLength;

  private   int length;


    @FXML
    protected void makePassword() {
        char[] charc ={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
                'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        //    char[] sympoly ={'_','_','#','$','*','!','','%','!','#'};
        char[] number ={'0','1','2','3','4','5','6','7','8','9'};
        char[] Password = new char[getLength()];
        Random random = new Random();
        for (int i = 0; i < Password.length; i++) {
            int rand = random.nextInt(2);
            switch(rand){
                case 0:
                    Password[i] = charc[random.nextInt(charc.length)];
                    break;
                case 1:
                    Password[i] = number[random.nextInt(number.length)] ;
                    break;
            }
        }
        String pas = "" ;
        for (int i = 0; i < Password.length; i++) {
           pas+=Password[i] ;
        }
        pasLable.setText(pas);
    }
    @FXML
    protected void showLegth(ActionEvent event){
        pasLable.setText(String.valueOf(getLength()));
    }

    private int getLength() {
        return this.length;
    }

    private void setLength(int length){
        this.length = length;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pasLength.valueProperty().addListener(new ChangeListener<Number>() {
          @Override
          public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
              length = (int) pasLength.getValue();
              setLength(length);
              LengthLable.setText("Password Length :"+Integer.toString(length));

          }
      });
    }
}