package com.example.passwordmaker;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXSlider;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label pasLable;

    public void setNumberChecked(boolean numberChecked) {
        isNumberChecked = numberChecked;
    }

    private boolean isNumberChecked;


    @FXML Label LengthLable;

    @FXML
    private JFXCheckBox  lowerCheck;

    @FXML
    private JFXCheckBox numberCheck;


    @FXML
    private JFXCheckBox sympolyCheck;

    @FXML
    private JFXCheckBox upperCheck;

    @FXML
    private JFXSlider pasLength;

  private   int length;


    @FXML
    protected void makePassword() {
        char[] charl ={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] charu ={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        char[] sympoly ={'!','@','#','$','%','^','&','*','.','?'};
        char[] number ={'0','1','2','3','4','5','6','7','8','9'};
        char[] Password = new char[getLength()];
        Random random = new Random();
        for (int i = 0; i < Password.length; i++) {
            int rand = random.nextInt(3);
            switch(rand){
                case 0:
                    if(upperCheck.isSelected())
                    Password[i] = charu[random.nextInt(charu.length)];
                    else {
                        if(lowerCheck.isSelected())
                            Password[i] = charl[random.nextInt(charl.length)];
                        if(numberCheck.isSelected())
                            Password[i] = number[random.nextInt(number.length)] ;
                        if(sympolyCheck.isSelected()){
                            Password[i] = sympoly[random.nextInt(number.length)];}
                    }
                    break;
                case 1:
                    if(lowerCheck.isSelected())
                        Password[i] = charl[random.nextInt(charl.length)];
                    else {
                        if(numberCheck.isSelected())
                            Password[i] = number[random.nextInt(number.length)] ;
                        if(upperCheck.isSelected())
                            Password[i] = charu[random.nextInt(charu.length)];
                        if(sympolyCheck.isSelected()){
                            Password[i] = sympoly[random.nextInt(number.length)];}

                    }
                    break;
                case 2:
                    if(numberCheck.isSelected())
                    Password[i] = number[random.nextInt(number.length)] ;
                    else {
                        if(lowerCheck.isSelected())
                        Password[i] = charl[random.nextInt(charl.length)];
                        if(upperCheck.isSelected())
                        Password[i] = charu[random.nextInt(charu.length)];
                        if(sympolyCheck.isSelected()){
                            Password[i] = sympoly[random.nextInt(number.length)];}
                    }
                    break;

                case 3:
                    if(sympolyCheck.isSelected()){
                        Password[i] = sympoly[random.nextInt(number.length)];}
                    else
                    {
                        if(lowerCheck.isSelected())
                            Password[i] = charl[random.nextInt(charl.length)];
                        if(upperCheck.isSelected())
                            Password[i] = charu[random.nextInt(charu.length)];
                        Password[i] = number[random.nextInt(number.length)] ;
                        if(numberCheck.isSelected())
                            Password[i] = number[random.nextInt(number.length)] ;
                    }
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
    protected void change(ActionEvent event){
        if(numberCheck.isSelected()){
            System.out.println("Yes");
        }else
            System.out.println("No");
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