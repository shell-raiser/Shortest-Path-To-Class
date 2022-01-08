package com.example.shortestpath;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.awt.*;

public class HelloController extends HelloApplication{
    public javafx.scene.control.TextField Text1;
    public javafx.scene.control.TextField Text2;
    Dijkstras yo = new Dijkstras();
    /*@FXML
    TextField TextOne;
    @FXML TextFieom/example/shortestpath/Graph.class
[OK] Successfully added the file to the exported jar: com/example/shortestpath/HelloApplicld TextTwo;*/
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText((yo.createGraph(Integer.parseInt(Text1.getText()),Integer.parseInt(Text2.getText())).toString()));
    }
}