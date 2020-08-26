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
    private Button[][]mButtons;
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
        mButtons=new Button[3][3];
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

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
        mButtons[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInputsfromPlayers(mButtons[0][0],0,0);
                checkHasWinner();
                counter++;
                checkTie();
                ticTacToeInf.changeTurn();
                mButtons[0][0].setClickable(false);
            }
        });
        mButtons[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInputsfromPlayers(mButtons[0][1],0,1);
                checkHasWinner();
                counter++;
                checkTie();
                ticTacToeInf.changeTurn();
                mButtons[0][1].setClickable(false);
            }
        });
        mButtons[0][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInputsfromPlayers(mButtons[0][2],0,2);
                checkHasWinner();
                counter++;
                checkTie();
                ticTacToeInf.changeTurn();
                mButtons[0][2].setClickable(false);
            }
        });
        mButtons[1][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInputsfromPlayers(mButtons[1][0],1,0);
                checkHasWinner();
                counter++;
                checkTie();
                ticTacToeInf.changeTurn();
                mButtons[1][0].setClickable(false);
            }
        });
        mButtons[1][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInputsfromPlayers(mButtons[1][1],1,1);
                checkHasWinner();
                counter++;
                checkTie();
                ticTacToeInf.changeTurn();
                mButtons[1][1].setClickable(false);
            }
        });
        mButtons[1][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInputsfromPlayers(mButtons[1][2],1,2);
                checkHasWinner();
                counter++;
                checkTie();
                ticTacToeInf.changeTurn();
                mButtons[1][2].setClickable(false);
            }
        });
        mButtons[2][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInputsfromPlayers(mButtons[2][0],2,0);
                checkHasWinner();
                counter++;
                checkTie();
                ticTacToeInf.changeTurn();
                mButtons[2][0].setClickable(false);
            }
        });
        mButtons[2][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInputsfromPlayers(mButtons[2][1],2,1);
                checkHasWinner();
                counter++;
                checkTie();
                ticTacToeInf.changeTurn();
                mButtons[2][1].setClickable(false);
            }
        });
        mButtons[2][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInputsfromPlayers(mButtons[2][2],2,2);
                checkHasWinner();
                counter++;
                checkTie();
                ticTacToeInf.changeTurn();
                mButtons[2][2].setClickable(false);
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
            mTextViewWinner.setText(R.string.tie);
        }
    }

    private void checkHasWinner() {
        switch (ticTacToeInf.checkWinner()){
            case 0:
                disableButtons();
                String p1Win=ticTacToeInf.getPlayer1Name()+R.string.win;
                mTextViewWinner.setText(p1Win);
                mHasNoWinner=false;
                break;
            case 1:
                disableButtons();
                String p2Win=ticTacToeInf.getPlayer2Name()+R.string.win;
                mTextViewWinner.setText(p2Win);
                mHasNoWinner=false;
                break;
            case -1:
                mHasNoWinner =true;
        }
    }

    private void disableButtons() {
        mButtons[0][0].setEnabled(false);
        mButtons[0][1].setEnabled(false);
        mButtons[0][2].setEnabled(false);
        mButtons[1][0].setEnabled(false);
        mButtons[1][1].setEnabled(false);
        mButtons[1][2].setEnabled(false);
        mButtons[2][0].setEnabled(false);
        mButtons[2][1].setEnabled(false);
        mButtons[2][2].setEnabled(false);
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
        mTextViewWinner = view.findViewById(R.id.textViewWinnerTTT);
    }
}