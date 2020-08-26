package com.example.gamesinfragment;

public class FourInARowInf {
    byte[][] mTable;
    boolean mPlayer1Turn;
    boolean mPlayer2Turn = false;
    String mPlayer1Name = "Player1";
    String mPlayer2Name = "Player2";

    public FourInARowInf() {
        mTable = new byte[5][5];
        mPlayer1Turn = true;
        initializeTable();
    }

    private void initializeTable() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                mTable[i][j] = 0;
            }
        }
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

    public boolean checkRow(int i, int j) {
        try {
            if (mTable[i][j] == mTable[i][j + 1] && mTable[i][j] == mTable[i][j + 2] && mTable[i][j] == mTable[i][j + 3]) {
                return true;
            }
        } catch (Exception ignored) {
        }

        try {
            if (mTable[i][j] == mTable[i][j + 1] && mTable[i][j] == mTable[i][j + 2] && mTable[i][j] == mTable[i][j - 1]) {
                return true;
            }
        } catch (Exception ignored) {
        }

        try {
            if (mTable[i][j] == mTable[i][j + 1] && mTable[i][j] == mTable[i][j - 1] && mTable[i][j] == mTable[i][j - 2]) {
                return true;
            }
        } catch (Exception ignored) {
        }
        try {
            if (mTable[i][j] == mTable[i][j - 1] && mTable[i][j] == mTable[i][j - 2] && mTable[i][j] == mTable[i][j - 3]) {
                return true;
            }
        } catch (Exception ignored) {
        }
        return false;
    }

    public boolean checkColumn(int i, int j) {
        try {
            if (mTable[i][j] == mTable[i + 1][j] && mTable[i][j] == mTable[i + 2][j] && mTable[i][j] == mTable[i + 3][j]) {
                return true;
            }
        } catch (Exception ignored) {
        }

        try {
            if (mTable[i][j] == mTable[i + 1][j] && mTable[i][j] == mTable[i + 2][j] && mTable[i][j] == mTable[i - 1][j]) {
                return true;
            }
        } catch (Exception ignored) {
        }

        try {
            if (mTable[i][j] == mTable[i + 1][j] && mTable[i][j] == mTable[i - 1][j] && mTable[i][j] == mTable[i - 2][j]) {
                return true;
            }
        } catch (Exception ignored) {
        }

        try {
            if (mTable[i][j] == mTable[i - 1][j] && mTable[i][j] == mTable[i - 2][j] && mTable[i][j] == mTable[i - 3][j]) {
                return true;
            }
        } catch (Exception ignored) {
        }
        return false;
    }

    public boolean checkDiagonal(int i, int j) {

        return checkUpRightDownLeftDiagonal(i, j) || checkDownRightUpLeftDiagonal(i, j);
    }


    private boolean checkUpRightDownLeftDiagonal(int i, int j) {
        //upRight-downLeft
        try {
            if (mTable[i][j] == mTable[i - 1][j + 1] && mTable[i][j] == mTable[i - 2][j + 2] && mTable[i][j] == mTable[i - 3][j + 3]) {
                return true;
            }
        } catch (Exception ignored) {
        }

        try {
            if (mTable[i][j] == mTable[i - 1][j + 1] && mTable[i][j] == mTable[i - 2][j + 2] && mTable[i][j] == mTable[i + 1][j - 1]) {
                return true;
            }
        } catch (Exception ignored) {
        }

        try {
            if (mTable[i][j] == mTable[i - 1][j + 1] && mTable[i][j] == mTable[i + 1][j - 1] && mTable[i][j] == mTable[i + 2][j - 2]) {
                return true;
            }
        } catch (Exception ignored) {
        }
        try {
            if (mTable[i][j] == mTable[i + 1][j - 1] && mTable[i][j] == mTable[i + 2][j - 2] && mTable[i][j] == mTable[i + 3][j - 3]) {
                return true;
            }
        } catch (Exception ignored) {
        }
        return false;
    }

    private boolean checkDownRightUpLeftDiagonal(int i, int j) {
        //downRight-upLeft
        try {
            if (mTable[i][j] == mTable[i + 1][j + 1] && mTable[i][j] == mTable[i + 2][j + 2] && mTable[i][j] == mTable[i + 3][j + 3]) {
                return true;
            }
        } catch (Exception ignored) {
        }

        try {
            if (mTable[i][j] == mTable[i + 1][j + 1] && mTable[i][j] == mTable[i + 2][j + 2] && mTable[i][j] == mTable[i - 1][j - 1]) {
                return true;
            }
        } catch (Exception ignored) {
        }

        try {
            if (mTable[i][j] == mTable[i + 1][j + 1] && mTable[i][j] == mTable[i - 1][j - 1] && mTable[i][j] == mTable[i - 2][j - 2]) {
                return true;
            }
        } catch (Exception ignored) {
        }
        try {
            if (mTable[i][j] == mTable[i - 1][j - 1] && mTable[i][j] == mTable[i - 2][j - 2] && mTable[i][j] == mTable[i - 3][j - 3]) {
                return true;
            }
        } catch (Exception ignored) {
        }
        return false;
    }
}
