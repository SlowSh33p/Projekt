package Applikation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import java.text.DecimalFormat;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {

@FXML
private Button schokoladenEis;
@FXML
private Button vanillaEis;
@FXML
private Button minzeEis;
@FXML
private Button erbeerEis;
@FXML
private ListView<String> warenkorb;
@FXML
private Label totalanzeige;
@FXML
private TextField guthabenEingabe;
@FXML
private Label guthabenDisplay;
@FXML
private Label bezahlungZustand;

private double kostenSchoko;
private double kostenVanilla;
private double kostenMinze;
private double kostenErdbeere;
private double totalPreis = 0;
private double guthaben;
private double wechselGeld;

private String auswahlSchockoladenEis;
private String auswahlMinzeEis;
private String auswahlVanilleEis;
private String auswahlErdbeerEis;

@FXML

public void buttonEisSchokolade(ActionEvent e) {
    kostenSchoko = 7.50;
    auswahlSchockoladenEis = "1x Schockoladen Eis: " + kostenSchoko + " CHF";
    warenkorb.getItems().add(auswahlSchockoladenEis);
    totalPreis += kostenSchoko;
    totalBerechnen();
}
   
@FXML

public void buttonEisMinze(ActionEvent e){
    kostenMinze = 8.30;
    auswahlMinzeEis = "1x Minze Eis: " + kostenMinze + " CHF";
    warenkorb.getItems().add(auswahlMinzeEis);
    totalPreis += kostenMinze;
    totalBerechnen();
    
}

@FXML

public void buttonEisVanille(ActionEvent e){
    kostenVanilla= 10.60;
    auswahlVanilleEis = "1x Vanilla Eis: " + kostenVanilla + " CHF";
    warenkorb.getItems().add(auswahlVanilleEis);
    totalPreis += kostenVanilla;
    totalBerechnen();
}

@FXML

public void buttonEisErdbeere(ActionEvent e){
    kostenErdbeere= 11.40;
    auswahlErdbeerEis = "1x Erdbeer Eis: " + kostenErdbeere + " CHF";
    warenkorb.getItems().add(auswahlErdbeerEis);
    totalPreis += kostenErdbeere;
    totalBerechnen();
}
    
@FXML

public void removeSchokoladenEis() {
    kostenSchoko = 7.50;
    auswahlSchockoladenEis = "1x Schockoladen Eis: " + kostenSchoko + " CHF";
    int index = warenkorb.getItems().indexOf(auswahlSchockoladenEis);
        if (index >= 0) {
            warenkorb.getItems().remove(index);
            totalPreis -= kostenSchoko;
            totalBerechnen();
        }
}

@FXML

public void removeMinzeEis() {
    kostenMinze = 8.30;
    auswahlMinzeEis = "1x Minze Eis: " + kostenMinze + " CHF";
    int index = warenkorb.getItems().indexOf(auswahlMinzeEis);
        if (index >= 0) {
            warenkorb.getItems().remove(index);
            totalPreis -= kostenMinze;
            totalBerechnen();
        }
}

@FXML

public void removeVanilleEis() {
    kostenVanilla = 10.60;
    auswahlVanilleEis = "1x Vanilla Eis: " + kostenVanilla + " CHF";
    int index = warenkorb.getItems().indexOf(auswahlVanilleEis);
        if (index >= 0) {
            warenkorb.getItems().remove(index);
            totalPreis -= kostenVanilla;
            totalBerechnen();
        }
}

@FXML

public void removeErdbeerEis() {
    kostenErdbeere = 11.40;
    auswahlErdbeerEis = "1x Erdbeer Eis: " + kostenErdbeere + " CHF";
    int index = warenkorb.getItems().indexOf(auswahlErdbeerEis);
        if (index >= 0) {
            warenkorb.getItems().remove(index);
            totalPreis -= kostenErdbeere;
            totalBerechnen();
        }
}

@FXML

public void totalBerechnen(){
    DecimalFormat decimalFormat = new DecimalFormat("#.00");
    String total_Formatiert = decimalFormat.format(totalPreis);
    totalanzeige.setText("Total: " +total_Formatiert + " CHF");
    
}
@FXML
public void listeLöschen(){
    warenkorb.getItems().clear();;
    totalPreis = 0;
    totalanzeige.setText("Total: " +totalPreis + " CHF");
    guthabenDisplay.setText("Guthaben: 0 CHF");
    guthaben = 0;
    
}
@FXML

public void bezahlen(ActionEvent e){

    wechselGeld = guthaben - totalPreis;

    if (warenkorb.getItems().isEmpty()){
        bezahlungZustand.setText("Fügen Sie einen Artikel hinzu.");
        bezahlungZustand.setTextFill(Color.web("#ff5934"));
    } else if (guthaben == totalPreis){
        DecimalFormat format3 = new DecimalFormat("0.00");
        String totalFormat3 = format3.format(wechselGeld);
        bezahlungZustand.setText("Bezahlung efolgreich. Wechselgeld: " + totalFormat3 +" CHF");
        bezahlungZustand.setTextFill(Color.web("#439428"));
        listeLöschen();
    } else if (wechselGeld > 0){
        DecimalFormat format1 = new DecimalFormat("0.00");
        String totalFormat1 = format1.format(wechselGeld);
        bezahlungZustand.setText("Bezahlung efolgreich. Wechselgeld: " + totalFormat1 +" CHF");
        bezahlungZustand.setTextFill(Color.web("#439428"));
        listeLöschen();
    } else if (wechselGeld == 0){
        DecimalFormat format2 = new DecimalFormat("0.00");
        String totalFormat2 = format2.format(wechselGeld);
        bezahlungZustand.setText("Bezahlung efolgreich. Wechselgeld: " + totalFormat2 +" CHF");
        bezahlungZustand.setTextFill(Color.web("#439428"));
        listeLöschen();
    } else {
        bezahlungZustand.setText("Guthaben zuklein.");
        bezahlungZustand.setTextFill(Color.web("#ff5934"));
    }
}

@FXML
public void guthaben(){
    guthaben = Double.parseDouble (guthabenEingabe.getText());
    if (guthaben > 0 ){
        guthabenDisplay.setText("Guthaben: " + guthaben + " CHF");
        guthabenEingabe.clear();
        bezahlungZustand.setText(" ");
    }
}

}
