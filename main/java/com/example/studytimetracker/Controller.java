package com.example.studytimetracker;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;


public class Controller {
    private boolean flag = true;
    private final MyTimer labelTimer = new MyTimer(0,25,0);

    @FXML
    private Label timeLabel;

    @FXML
    private Button startStopButton;

    @FXML
    private Label endLabel;

    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
        if(labelTimer.endTimeCheck()){
            endTimer();
        }
        timeLabel.setText(labelTimer.getTime());
        labelTimer.previousSecond();
        labelTimer.addSecond();
    }));

    public void timerOnOff(ActionEvent e){
        if(flag){
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
            flag = false;
            startStopButton.setText("STOP");
        } else {
            timeline.stop();
            startStopButton.setText("START");
            endLabel.setText(labelTimer.getPastTime());
            flag = true;
        }
    }

    public void endTimer(){
        timeline.stop();
        flag = !flag;
        startStopButton.setText("START");
        labelTimer.setTimer(0,25,0);
        endLabel.setText(labelTimer.getPastTime());
    }

}
