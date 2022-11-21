/*
 * File: CollectorController.java
 * Created Date: 2021-09-24 10:42:41
 * Author: Sallai Andras
 * Github: https://github.com/andteki
 * -----
 * Last Modified: 2021-11-21
 * Modified By: Zentai Pál
 * -----
 * Copyright (c) 2021 Sallai Andras
 * 
 * GNU GPL v2
 */

package controllers;
import java.util.ArrayList;
import models.Page;
import views.MainWindow;

// A CollectorController osztály
public class CollectorController extends MainController {
    //A CollectorController osztály konstruktora    
    public CollectorController(MainWindow mainWindow) {
        super(mainWindow);

        /*pasteButton*/
        mainWindow.pasteButton.addActionListener(event -> {
            System.out.println("beillesztés");
            mainWindow.urlField.paste();
        });

        /*startButton*/
        mainWindow.startButton.addActionListener(event -> {
            // URL
            String utvonal = mainWindow.urlField.getText();
            if (utvonal.isEmpty()) {
                utvonal = "https://index.hu";
            }
            //weblap
            Page page = new Page();
            page.setUrl(utvonal);
            //Gyűjtött szavak:
            ArrayList<String> words = page.getContent();

            for(String word : words) {
                if (mainWindow.wordsModel.indexOf(word)<0) {
                    mainWindow.wordsModel.addElement(word);
                }                
            }
            Integer wordCount = mainWindow.wordsModel.getSize();
            mainWindow.statusBar.setm("Szavak: " + wordCount.toString());
        });
    }   
}
