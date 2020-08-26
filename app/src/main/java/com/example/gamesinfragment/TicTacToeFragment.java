package com.example.gamesinfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TicTacToeFragment#} factory method to
 * create an instance of this fragment.
 */
public class TicTacToeFragment extends Fragment {
    public static final String BUNDLE_KEY_TEXT_VIEW_TT_TWINNER = "textViewTTTwinner";
    public static final String BUNDLE_KEY_HAS_NO_WINNER = "hasNoWinner";
    public static final String BUNDLE_KEY_COUNTER = "counter";
    public static final String BUNDLE_KEY_GAME_TABLE = "gameTable";
    public static final String BUNDLE_KEY_PLAYER_1_TURN = "player1Turn";
    private Button[][]mButtons;
    private TextView mTextViewTTTWinner;
    private TicTacToeInf ticTacToeInf;
    private boolean mHasNoWinner;
    private int mCounter =0;

    public TicTacToeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ticTacToeInf = new TicTacToeInf();
        mButtons=new Button[3][3];
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    outState.putBoolean(BUNDLE_KEY_HAS_NO_WINNER,mHasNoWinner);
    outState.putInt(BUNDLE_KEY_COUNTER,mCounter);
    outState.putSerializable(BUNDLE_KEY_GAME_TABLE,ticTacToeInf.mTable);
    outState.putBoolean(BUNDLE_KEY_PLAYER_1_TURN,ticTacToeInf.mPlayer1Turn);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tic_tac_toe, container, false);
        findViews(view);
        if (savedInstanceState!=null)
        {
            mHasNoWinner=savedInstanceState.getBoolean(BUNDLE_KEY_HAS_NO_WINNER);
            mCounter=savedInstanceState.getInt(BUNDLE_KEY_COUNTER);
            ticTacToeInf.mTable= (byte[][]) savedInstanceState.getSerializable(BUNDLE_KEY_GAME_TABLE);
            ticTacToeInf.mPlayer1Turn=savedInstanceState.getBoolean(BUNDLE_KEY_PLAYER_1_TURN);
            ticTacToeInf.mPlayer2Turn=!(ticTacToeInf.mPlayer1Turn);

            updateUI();
            checkHasWinner();
            checkTie();
        }

        setListeners();
        return view;
    }

    private void updateUI() {
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                if (ticTacToeInf.mTable[i][j]==0)
                {
                 mButtons[i][j].setText("X");
                 mButtons[i][j].setClickable(false);
                }else if (ticTacToeInf.mTable[i][j]==1)
                {
                    mButtons[i][j].setText("O");
                    mButtons[i][j].setClickable(false);
                }
            }
        }
    }


    private void getInputsfromPlayers(Button mButton,int i,int j) {
        if (ticTacToeInf.mPlayer1Turn) {
            ticTacToeInf.mTable[i][j] = 0;
            mButton.setText("X");
        } else {
            ticTacToeInf.mTable[i][j] = 1;
            mButton.setText("O");
        }
    }

    private void checkTie() {
        if (mCounter ==9 && mHasNoWinner)
        {
            mTextViewTTTWinner.setText(R.string.tie);
        }
    }

    private void checkHasWinner() {
        switch (ticTacToeInf.checkWinner()){
            case 0:
                disableButtons();
                mTextViewTTTWinner.setText(String.format("%s wins", ticTacToeInf.getPlayer1Name()));
                mHasNoWinner=false;
                break;
            case 1:
                disableButtons();
                mTextViewTTTWinner.setText(String.format("%s wins", ticTacToeInf.getPlayer2Name()));
                mHasNoWinner=false;
                break;
            case -1:
                mHasNoWinner =true;
        }
    }

    private void disableButtons() {
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                mButtons[i][j].setEnabled(false);
            }
        }
    }

    private void setListeners() {
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                final int finalI = i;
                final int finalJ = j;
                mButtons[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getInputsfromPlayers(mButtons[finalI][finalJ],finalI,finalJ);
                        checkHasWinner();
                        mCounter++;
                        checkTie();
                        ticTacToeInf.changeTurn();
                        mButtons[finalI][finalJ].setClickable(false);
                    }
                });
            }
        }
    }

    private void findViews(View view) {
        mButtons[0][0]=view.findViewById(R.id.button00);
        mButtons[0][1]=view.findViewById(R.id.button01);
        mButtons[0][2]=view.findViewById(R.id.button02);
        mButtons[1][0]=view.findViewById(R.id.button10);
        mButtons[1][1]=view.findViewById(R.id.button11);
        mButtons[1][2]=view.findViewById(R.id.button12);
        mButtons[2][0]=view.findViewById(R.id.button20);
        mButtons[2][1]=view.findViewById(R.id.button21);
        mButtons[2][2]=view.findViewById(R.id.button22);
        mTextViewTTTWinner = view.findViewById(R.id.textViewWinnerTTT);
    }
}