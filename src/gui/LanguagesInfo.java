package gui;

import processing.core.PApplet;

public class LanguagesInfo {

    final int ENGLISH = 1;
    final int SPANISH = 2;
    final int CATALAN = 3;

    String[][] info;

    public LanguagesInfo(PApplet p5, String fileName){
        String[] lines = p5.loadStrings(fileName);
        this.info = new String[lines.length][4];
        for(int l=0; l<lines.length; l++){
            this.info[l] = lines[l].split(",");
        }
    }

    public String getTranslation(int language, String word){
        for(int i=0; i<info.length; i++){
            if(info[i][0].equals(word)){
                return info[i][language];
            }
        }
        return word;
    }
}
