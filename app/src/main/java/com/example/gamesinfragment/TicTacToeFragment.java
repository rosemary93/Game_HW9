package com.example.gamesinfragment;

import android.os.Bundle;

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
    private Button mButton00;
    private Button mButton01;
    private Button mButton02;
    private Button mButton11;
    private Button mButton10;
    private Button mButton12;
    private Button mButton20;
    private Button mButton21;
    private Button mButton22;
    private TextView mTextViewWinner;
    private TicTacToeInf ticTacToeInf;
    private boolean mHasNoWinner;
    private int counter=0;

    public TicTacToeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ticTacToeInf = new TicTacToeInf();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tic_tac_toe, container, false);
        findViews(view);
        setListeners();


        return view;
    }

    private void setListeners() {
        mButton00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInputsfromPlayers(mButton00,0,0);
                checkHasWinner();
                counter++;
                checkTie();
                ticTacToeInf.changeTurn();
                mButton00.setClickable(false);
            }
        });
        mButton01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInputsfromPlayers(mButton01,0,1);
                checkHasWinner();
                counter++;
                checkTie();
                ticTacToeInf.changeTurn();
                mButton01.setClickable(false);
            }
        });
        mButton02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInputsfromPlayers(mButton02,0,2);
                checkHasWinner();
                counter++;
                checkTie();
                ticTacToeInf.changeTurn();
                mButton02.setClickable(false);
            }
        });
        mButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInputsfromPlayers(mButton10,1,0);
                checkHasWinner();
                counter++;
                checkTie();
                ticTacToeInf.changeTurn();
                mButton10.setClickable(false);
            }
        });
        mButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInputsfromPlayers(mButton11,1,1);
                checkHasWinner();
                counter++;
                checkTie();
                ticTacToeInf.changeTurn();
                mButton11.setClickable(false);
            }
        });
        mButton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInputsfromPlayers(mButton12,1,2);
                checkHasWinner();
                counter++;
                checkTie();
                ticTacToeInf.changeTurn();
                mButton12.setClickable(false);
            }
        });
        mButton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInputsfromPlayers(mButton20,2,0);
                checkHasWinner();
                counter++;
                checkTie();
                ticTacToeInf.changeTurn();
                mButton20.setClickable(false);
            }
        });
        mButton21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInputsfromPlayers(mButton21,2,1);
                checkHasWinner();
                counter++;
                checkTie();
                ticTacToeInf.changeTurn();
                mButton21.setClickable(false);
            }
        });
        mButton22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInputsfromPlayers(mButton22,2,2);
                checkHasWinner();
                counter++;
                checkTie();
                ticTacToeInf.changeTurn();
                mButton22.setClickable(false);
            }
        });



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
        if (counter==9 && mHasNoWinner)
        {
            mTextViewWinner.setText("Tie");
        }
    }

    private void checkHasWinner() {
        switch (ticTacToeInf.checkWinner()){
            case 0:
                disableButtons();
                mTextViewWinner.setText("Player 1 wins");
                break;
            case 1:
                disableButtons();
                mTextViewWinner.setText("Player 2 wins");
                break;
            case -1:
                mHasNoWinner =true;
        }
    }

    private void disableButtons() {
        mButton00.setEnabled(false);
        mButton01.setEnabled(false);
        mButton02.setEnabled(false);
        mButton10.setEnabled(false);
        mButton11.setEnabled(false);
        mButton12.setEnabled(false);
        mButton20.setEnabled(false);
        mButton21.setEnabled(false);
        mButton22.setEnabled(false);
    }

    private void findViews(View view) {
        mButton00 = view.findViewById(R.id.button00);
        mButton01 = view.findViewById(R.id.button01);
        mButton02 = view.findViewById(R.id.button02);
        mButton10 = view.findViewById(R.id.button10);
        mButton11 = view.findViewById(R.id.button11);
        mButton12 = view.findViewById(R.id.button12);
        mButton20 = view.findViewById(R.id.button20);
        mButton21 = view.findViewById(R.id.button21);
        mButton22 = view.findViewById(R.id.button22);
        mTextViewWinner = view.findViewById(R.id.textViewWinnerTTT);
    }
}