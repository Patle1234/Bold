package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;


public class Controller {
    Image blank = new Image("resources/Bold images/Back.jpg");
    @FXML
    Label lblTurn, lblResult, player1,player2,player3,player4,currentLabel;
    @FXML
    Button btnStart,selectPlayers,checkButton,resetButton;
    @FXML
    GridPane gdpPlayGrid;
    @FXML
    ChoiceBox playerChoice;
    @FXML
    ListView scoreView;

    private Card [][] currentCards = new Card[4][5];//cards on the screen
    private ArrayList<String[]> cardCharacteristics=new ArrayList<>();//carateristics fo all of the cards
    private ArrayList<Card> deck=new ArrayList<>();//all of the remaing cards
    private ImageView [][] cardIMG = new ImageView [4][5];//card images on the screen
    private ArrayList<Card> selectedCards=new ArrayList<>();//cards selected by players
    private boolean[] ifMatch=new boolean[4];

    int row;
    int col;
    int counter;
    int playerScore1=0;
    int playerScore2=0;
    int playerScore3=0;
    int playerScore4=0;
    int currentPlayerScore;
    int turn;
    int numPlayers;

    @FXML
    private void start() {//creates cards/sets up the game and the player asks how many player
        btnStart.setVisible(false);
        playerChoice.setVisible(true);
        selectPlayers.setVisible(true);
        playerChoice.getItems().add("Computer");
        playerChoice.getItems().add("2 Player");
        playerChoice.getItems().add("3 Player");
        playerChoice.getItems().add("4 Player");


        for (int i = 0; i < cardIMG.length; i++) {
            for (int j = 0; j < cardIMG[0].length; j++) {
                cardIMG[i][j] = new ImageView();
                cardIMG[i][j].setImage(blank);
                cardIMG[i][j].setFitHeight(100);
                cardIMG[i][j].setFitWidth(130);
                gdpPlayGrid.add(cardIMG[i][j], j, i);
            }
        }
        createCards();

        //this is the mouse event: same as if you were adding it in scenebuilder but this lets you do it dynamically
        EventHandler z = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {//when a carded is clicked on
                row = GridPane.getRowIndex(((ImageView) t.getSource()));//row of the image you clicked on
                col = GridPane.getColumnIndex(((ImageView) t.getSource()));//coloum of the image clicked on
                selectCard(row, col);
            }
        };

        for (int i = 0; i < cardIMG.length; i++) {
            for (int j = 0; j < cardIMG[0].length; j++) {
                //setting the onMouseClicked property for each of the ImageViews to call z (the event handler)
                cardIMG[i][j].setOnMouseClicked(z);
                cardIMG[i][j].setRotate(cardIMG[i][j].getRotate()+90);//rotates the card 90 degrees
            }
        }
    }

    private void createCards(){//creates all of the cards
        deck.add(new Card("DBBB",new Image("resources/Bold images/DBBB.jpg" )));
        deck.add(new Card("DBBM",new Image("resources/Bold images/DBBM.jpg" )));
        deck.add(new Card("DBBS",new Image("resources/Bold images/DBBS.jpg" )));
        deck.add(new Card("DBOB",new Image("resources/Bold images/DBOB.jpg" )));
        deck.add(new Card("DBOM",new Image("resources/Bold images/DBOM.jpg" )));
        deck.add(new Card("DBOS",new Image("resources/Bold images/DBOS.jpg" )));
        deck.add(new Card("DBYB",new Image("resources/Bold images/DBYB.jpg" )));
        deck.add(new Card("DBYM",new Image("resources/Bold images/DBYM.jpg" )));
        deck.add(new Card("DBYS",new Image("resources/Bold images/DBYS.jpg" )));
        deck.add(new Card("DCBB",new Image("resources/Bold images/DCBB.jpg" )));
        deck.add(new Card("DCBM",new Image("resources/Bold images/DCBM.jpg" )));
        deck.add(new Card("DCBS",new Image("resources/Bold images/DCBS.jpg" )));
        deck.add(new Card("DCOB",new Image("resources/Bold images/DCOB.jpg" )));
        deck.add(new Card("DCOM",new Image("resources/Bold images/DCOM.jpg" )));
        deck.add(new Card("DCOS",new Image("resources/Bold images/DCOS.jpg" )));
        deck.add(new Card("DCYB",new Image("resources/Bold images/DCYB.jpg" )));
        deck.add(new Card("DCYM",new Image("resources/Bold images/DCYM.jpg" )));
        deck.add(new Card("DCYS",new Image("resources/Bold images/DCYS.jpg" )));
        deck.add(new Card("DJBB",new Image("resources/Bold images/DJBB.jpg" )));
        deck.add(new Card("DJBM",new Image("resources/Bold images/DJBM.jpg" )));
        deck.add(new Card("DJBS",new Image("resources/Bold images/DJBS.jpg" )));
        deck.add(new Card("DJOB",new Image("resources/Bold images/DJOB.jpg" )));
        deck.add(new Card("DJOM",new Image("resources/Bold images/DJOM.jpg" )));
        deck.add(new Card("DJOS",new Image("resources/Bold images/DJOS.jpg" )));
        deck.add(new Card("DJYB",new Image("resources/Bold images/DJYB.jpg" )));
        deck.add(new Card("DJYM",new Image("resources/Bold images/DJYM.jpg" )));
        deck.add(new Card("DJYS",new Image("resources/Bold images/DJYS.jpg" )));
        deck.add(new Card("LBBB",new Image("resources/Bold images/LBBB.jpg" )));
        deck.add(new Card("LBBM",new Image("resources/Bold images/LBBM.jpg" )));
        deck.add(new Card("LBBS",new Image("resources/Bold images/LBBS.jpg" )));
        deck.add(new Card("LBOB",new Image("resources/Bold images/LBOB.jpg" )));
        deck.add(new Card("LBOM",new Image("resources/Bold images/LBOM.jpg" )));
        deck.add(new Card("LBOS",new Image("resources/Bold images/LBOS.jpg" )));
        deck.add(new Card("LBYB",new Image("resources/Bold images/LBYB.jpg" )));
        deck.add(new Card("LBYM",new Image("resources/Bold images/LBYM.jpg" )));
        deck.add(new Card("LBYS",new Image("resources/Bold images/LBYS.jpg" )));
        deck.add(new Card("LCBB",new Image("resources/Bold images/LCBB.jpg" )));
        deck.add(new Card("LCBM",new Image("resources/Bold images/LCBM.jpg" )));
        deck.add(new Card("LCBS",new Image("resources/Bold images/LCBS.jpg" )));
        deck.add(new Card("LCOB",new Image("resources/Bold images/LCOB.jpg" )));
        deck.add(new Card("LCOM",new Image("resources/Bold images/LCOM.jpg" )));
        deck.add(new Card("LCOS",new Image("resources/Bold images/LCOS.jpg" )));
        deck.add(new Card("LCYB",new Image("resources/Bold images/LCYB.jpg" )));
        deck.add(new Card("LCYM",new Image("resources/Bold images/LCYM.jpg" )));
        deck.add(new Card("LCYS",new Image("resources/Bold images/LCYS.jpg" )));
        deck.add(new Card("LJBB",new Image("resources/Bold images/LJBB.jpg" )));
        deck.add(new Card("LJBM",new Image("resources/Bold images/LJBM.jpg" )));
        deck.add(new Card("LJBS",new Image("resources/Bold images/LJBS.jpg" )));
        deck.add(new Card("LJOB",new Image("resources/Bold images/LJOB.jpg" )));
        deck.add(new Card("LJOM",new Image("resources/Bold images/LJOM.jpg" )));
        deck.add(new Card("LJOS",new Image("resources/Bold images/LJOS.jpg" )));
        deck.add(new Card("LJYB",new Image("resources/Bold images/LJYB.jpg" )));
        deck.add(new Card("LJYM",new Image("resources/Bold images/LJYM.jpg" )));
        deck.add(new Card("LJYS",new Image("resources/Bold images/LJYS.jpg" )));
        deck.add(new Card("SBBB",new Image("resources/Bold images/SBBB.jpg" )));
        deck.add(new Card("SBBM",new Image("resources/Bold images/SBBM.jpg" )));
        deck.add(new Card("SBBS",new Image("resources/Bold images/SBBS.jpg" )));
        deck.add(new Card("SBOB",new Image("resources/Bold images/SBOB.jpg" )));
        deck.add(new Card("SBOM",new Image("resources/Bold images/SBOM.jpg" )));
        deck.add(new Card("SBOS",new Image("resources/Bold images/SBOS.jpg" )));
        deck.add(new Card("SBYB",new Image("resources/Bold images/SBYB.jpg" )));
        deck.add(new Card("SBYM",new Image("resources/Bold images/SBYM.jpg" )));
        deck.add(new Card("SBYS",new Image("resources/Bold images/SBYS.jpg" )));
        deck.add(new Card("SCBB",new Image("resources/Bold images/SCBB.jpg" )));
        deck.add(new Card("SCBM",new Image("resources/Bold images/SCBM.jpg" )));
        deck.add(new Card("SCBS",new Image("resources/Bold images/SCBS.jpg" )));
        deck.add(new Card("SCOB",new Image("resources/Bold images/SCOB.jpg" )));
        deck.add(new Card("SCOM",new Image("resources/Bold images/SCOM.jpg" )));
        deck.add(new Card("SCOS",new Image("resources/Bold images/SCOS.jpg" )));
        deck.add(new Card("SCYB",new Image("resources/Bold images/SCYB.jpg" )));
        deck.add(new Card("SCYM",new Image("resources/Bold images/SCYM.jpg" )));
        deck.add(new Card("SCYS",new Image("resources/Bold images/SCYS.jpg" )));
        deck.add(new Card("SJBB",new Image("resources/Bold images/SJBB.jpg" )));
        deck.add(new Card("SJBM",new Image("resources/Bold images/SJBM.jpg" )));
        deck.add(new Card("SJBS",new Image("resources/Bold images/SJBS.jpg" )));
        deck.add(new Card("SJOB",new Image("resources/Bold images/SJOB.jpg" )));
        deck.add(new Card("SJOM",new Image("resources/Bold images/SJOM.jpg" )));
        deck.add(new Card("SJOS",new Image("resources/Bold images/SJOS.jpg" )));
        deck.add(new Card("SJYB",new Image("resources/Bold images/SJYB.jpg" )));
        deck.add(new Card("SJYM",new Image("resources/Bold images/SJYM.jpg" )));
        deck.add(new Card("SJYS",new Image("resources/Bold images/SJYS.jpg" )));

        counter=myRand(0,deck.size()-1);
        for(int i=0;i<currentCards.length;i++){//pickes the current cards
            for(int j=0;j<currentCards[0].length;j++){
                currentCards[i][j]=deck.get(counter);
                deck.remove(counter);
                counter=myRand(0, deck.size()-1);
            }
        }

        for(int i=0;i<deck.size();i++){//adds all of the card characteristics to the array
            cardCharacteristics.add(deck.get(i).getCharacteristics());
        }

    }

    @FXML
    private void decidePlayer(){//when the players pick the amt of players it sets up the rest of the game
        playerChoice.setVisible(false);
        selectPlayers.setVisible(false);
        gdpPlayGrid.setVisible(true);
        checkButton.setVisible(true);
        lblTurn.setVisible(true);
        lblResult.setVisible(true);
        player1.setVisible(true);
        player2.setVisible(true);
        player3.setVisible(true);
        player4.setVisible(true);
        scoreView.setVisible(true);
        if(playerChoice.getValue().equals("2 Player")){
            turn=myRand(0,1);
            numPlayers=2;
            lblTurn.setText("Player "+((turn%numPlayers)+1)+" will go first!");
            player3.setVisible(false);
            player4.setVisible(false);
        }else if(playerChoice.getValue().equals("3 Player")){
            turn=myRand(0,2);
            numPlayers=3;
            lblTurn.setText("Player "+((turn%numPlayers)+1)+" will go first!");
            player4.setVisible(false);
        }else if(playerChoice.getValue().equals("4 Player")){
            turn=myRand(0,3);
            numPlayers=4;
            lblTurn.setText("Player "+((turn%numPlayers)+1)+" will go first!");
        }else if(playerChoice.getValue().equals("Computer")){
            turn=0;
            numPlayers=2;
            lblTurn.setText("You will go first!");
            player2.setText("Computer(Player 2):0");
            player3.setVisible(false);
            player4.setVisible(false);
        }
    }

    @FXML
    private void check(){//when the player wants to end their turn
        checkMatch();
        ifGetPoints();
        switchTurn();
    }

    @FXML
    private void reset(){//when the player wants to reset the game
        btnStart.setVisible(true);
        resetButton.setVisible(false);
        gdpPlayGrid.setVisible(false);
        checkButton.setVisible(false);
        lblTurn.setVisible(false);
        lblResult.setVisible(false);
        player1.setVisible(false);
        player2.setVisible(false);
        player3.setVisible(false);
        player4.setVisible(false);
        scoreView.setVisible(false);
        playerScore1=0;
        playerScore2=0;
        playerScore3=0;
        playerScore4=0;
        playerChoice.getItems().clear();
        player1.setText("Player 1: 0");
        player2.setText("Player 1: 0");
        player3.setText("Player 1: 0");
        player4.setText("Player 1: 0");
        selectedCards.clear();
        deck.clear();
        scoreView.getItems().clear();
        createCards();
        for(int i=0;i< ifMatch.length;i++) {
            ifMatch[i] = true;
        }
        for (int i = 0; i < cardIMG.length; i++) {
            for (int j = 0; j < cardIMG[0].length; j++) {
                cardIMG[i][j].setImage(blank);
            }
        }
    }

    private void switchTurn(){//when the players turn is over
        if(ifCardsMatch()) {
            for (int i = 0; i < selectedCards.size(); i++) {
                currentCards[selectedCards.get(i).getRow()][selectedCards.get(i).getCol()] = deck.get(counter);
                cardIMG[selectedCards.get(i).getRow()][selectedCards.get(i).getCol()].setImage(blank);
                deck.remove(deck.get(counter));
                counter = myRand(0, deck.size() - 1);
            }
        }else {
            for (int i = 0; i < selectedCards.size(); i++) {
                cardIMG[selectedCards.get(i).getRow()][selectedCards.get(i).getCol()].setImage(blank);
            }
        }
        selectedCards.clear();
        turn++;
        if(playerChoice.getValue().equals("Computer")){
            if(((turn%numPlayers)+1)==2) {
                compTurn();
            }
         }
    }

    private void ifGetPoints() {//rewards the players points
        checkMatch();
        int numCards = selectedCards.size();
            if(ifCardsMatch()) {
                currentPlayerScore += Math.pow(numCards, 2);
                if ((turn%numPlayers+1) == 1) {
                    currentPlayerScore =currentPlayerScore+ playerScore1;
                    currentLabel = player1;
                    playerScore1 = currentPlayerScore;
                } else if ((turn%numPlayers+1) == 2) {
                    currentPlayerScore =currentPlayerScore+ playerScore2;
                    currentLabel = player2;
                    playerScore2 = currentPlayerScore;
                } else if ((turn%numPlayers+1) == 3) {
                    currentPlayerScore =currentPlayerScore+ playerScore3;
                    currentLabel = player3;
                    playerScore3 = currentPlayerScore;
                } else if ((turn%numPlayers+1) == 4) {
                    currentPlayerScore =currentPlayerScore+ playerScore4;
                    currentLabel = player4;
                    playerScore4 = currentPlayerScore;
                }

                currentLabel.setText("Player "+((turn%numPlayers)+1)+": "+currentPlayerScore);
                updatePlayerScore(numCards);
                currentPlayerScore=0;
            }else{
                updatePlayerScore(0);
            }
    }

    private void displayCard(int rowNum, int colNum){//displays the card picked
        cardIMG[rowNum][colNum].setImage(currentCards[rowNum][colNum].getCardFace());
    }

    private void selectCard(int rowNum, int colNum) {//adds a card to the currentCards array
        if(deck.size()<currentCards.length-1){//checks if game is over
            resetButton.setVisible(true);
        }

        selectedCards.add(currentCards[rowNum][colNum]);
        currentCards[rowNum][colNum].setRow(rowNum);
        currentCards[rowNum][colNum].setCol(colNum);
        displayCard(rowNum, colNum);

        if(selectedCards.size()>1) {
            checkMatch();
            if (ifCardsMatch()==false){
                updatePlayerScore(0);
                switchTurn();
                lblTurn.setText("It's player "+((turn%numPlayers)+1)+"'s turn");
            }
        }
    }

    private void checkMatch(){//checks which charicteristics match
        //"clears" the arrays to all be true
        ifMatch[0]=true;
        ifMatch[1]=true;
        ifMatch[2]=true;
        ifMatch[3]=true;
        for(int j = 0; j < 4; j++){//loops through all 4 of the charicteristics
            for (int i=1;i<selectedCards.size();i++){//loops through all of the cards that were selected by the player
                if(!(selectedCards.get(0).getCharacteristics()[j].equals(selectedCards.get(i).getCharacteristics()[j]))){//if the first cards "j" charicteristic does not match the "j" charicteritic of the "i" card then set the "j" charicteristic to false
                    ifMatch[j]=false;
                }
            }
        }
    }

    private boolean ifCardsMatch(){//checks if any of the characteristcs match
        int count=0;
        for(int i=0;i<ifMatch.length;i++){
            if(ifMatch[i]) {
                count++;
            }
        }
        if(count>0){
            return true;
        }else{
            return false;
        }
    }

    private void compTurn() {//this is the computers turn
        int numMatch = 0;
        int count=0;
        for (int i = 0; i < 2; i++) {//selects 2 starting cards
            int pickedRow = myRand(0, 3);
            int pickedCol = myRand(0, 4);
            currentCards[pickedRow][pickedCol].setRow(pickedRow);
            currentCards[pickedRow][pickedCol].setCol(pickedCol);
            selectedCards.add(currentCards[pickedRow][pickedCol]);
        }

        while(count==0) {
            checkMatch();//goes through the check
             for (int i= 0; i < ifMatch.length; i++) {//finds out how many charicteristics match
                if (ifMatch[i]) {
                    numMatch++;
                }
            }
            if (numMatch > 1) {//if more than one charicteristic matches than it picks another card
                int pickedRow = myRand(0, 3);
                int pickedCol = myRand(0, 4);
                currentCards[pickedRow][pickedCol].setRow(pickedRow);
                currentCards[pickedRow][pickedCol].setCol(pickedCol);
                selectedCards.add(currentCards[pickedRow][pickedCol]);
            } else{//if there are less than 1 match
                count++;
            }
            numMatch = 0;
        }
        count=0;
        ifGetPoints();
        switchTurn();
    }

    private void updatePlayerScore(int numCards){//updates the players score
        scoreView.getItems().add("Player "+((turn%numPlayers)+1)+" got "+(int)Math.pow(numCards, 2)+" points!");
    }

    private int myRand(int lowerBound, int upperBound){//picks a random number
        int rand=(int)(Math.random() * (upperBound - lowerBound+1))+lowerBound;
        return rand;
    }
}
