package sample;

import javafx.scene.image.Image;

public class Card{
    private String[] characteristics=new String[4];
    Image cardFace;
    int row;
    int col;


    public Card(String x,Image y){
        for(int i=0;i<x.length();i++){//creates the charateristics and adds it to the charicteristics array
            characteristics[i]=x.substring(i,i+1);
        }
        cardFace=y;

    }

    public Image getCardFace(){
        return cardFace;
    }//gets the card face

    public void setRow(int r){
        row=r;
    }//sets the row

    public void setCol(int c){
        col=c;
    }//sets the colum

    public int getRow(){
        return row;
    }//gets the rows

    public int getCol() {
        return col;
    }//gets the colums

    public String[] getCharacteristics() {
        return characteristics;
    }

}
