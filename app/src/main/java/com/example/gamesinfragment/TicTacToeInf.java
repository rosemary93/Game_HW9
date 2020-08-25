package com.example.gamesinfragment;

public class TicTacToeInf {
    byte[][] mTable;
    boolean mPlayer1Turn;
    boolean mPlayer2Turn=false;
    String mPlayer1Name="Player1";
    String mPlayer2Name="Player2";


    public TicTacToeInf() {
        mTable = new byte[3][3];
        initializeTable();
        mPlayer1Turn = true;
    }

    public String getPlayer1Name() {
        return mPlayer1Name;
    }

    public void setPlayer1Name(String player1Name) {
        mPlayer1Name = player1Name;
    }

    public String getPlayer2Name() {
        return mPlayer2Name;
    }

    public void setPlayer2Name(String player2Name) {
        mPlayer2Name = player2Name;
    }

    public void changeTurn() {
        mPlayer1Turn = !mPlayer1Turn;
        mPlayer2Turn = !mPlayer2Turn;
    }

    public void initializeTable()
    {
        byte counter=2;
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j < 3; j++) {
                mTable[i][j]=counter;
                counter++;
            }
        }
    }

    public int checkWinner() {
        if (mTable[0][0] == mTable[0][1] && mTable[0][1] == mTable[0][2]) {
            return mTable[0][0];
        } else if (mTable[1][0] == mTable[1][1] && mTable[1][1] == mTable[1][2]) {
            return mTable[1][0];
        } else if (mTable[2][0] == mTable[2][1] && mTable[2][1] == mTable[2][2]) {
            return mTable[2][0];
        } else if (mTable[0][0] == mTable[1][0] && mTable[1][0] == mTable[2][0]) {
            return mTable[0][0];
        } else if (mTable[0][1] == mTable[1][1] && mTable[1][1] == mTable[2][1]) {
            return mTable[0][1];
        } else if (mTable[0][2] == mTable[1][2] && mTable[1][2] == mTable[2][2]) {
            return mTable[0][2];
        } else if (mTable[0][0] == mTable[1][1] && mTable[1][1] == mTable[2][2]) {
            return mTable[0][0];
        } else if (mTable[2][0] == mTable[1][1] && mTable[1][1] == mTable[0][2]) {
            return mTable[2][0];
        } else {
            return -1;
        }
    }
}
