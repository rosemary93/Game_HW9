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
 * Use the {@link FourInARowFragment} factory method to
 * create an instance of this fragment.
 */
public class FourInARowFragment extends Fragment {

    Button[][] mButtons;
    FourInARowInf fourInARowInf;
    TextView mTextViewFIRwinner;
    boolean mHasNoWinner;
    int counter=0;
    public FourInARowFragment() {
        // Required empty public constructor
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fourInARowInf=new FourInARowInf();
        mButtons=new Button[5][5];


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_four_in_a_row, container, false);

        findViews(view);
        setListeners();

        return view;
    }

    private void setListeners() {
        for (int i = 0; i <5 ; i++) {
            for (int j = 0; j <5 ; j++) {
                final int finalI = i;
                final int finalJ = j;
                mButtons[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            if (finalI == 4 || fourInARowInf.mTable[finalI + 1][finalJ] == -1 || fourInARowInf.mTable[finalI + 1][finalJ] == 1) {
                                counter++;
                                getInputs(finalI, finalJ);
                                checkWin(finalI, finalJ);
                                checkTie();
                                fourInARowInf.changeTurn();
                                mButtons[finalI][finalJ].setClickable(false);
                            }
                        }catch (Exception ignored){}
                    }
                });
            }
        }
    }

    private void checkTie() {
        if (counter==25 && mHasNoWinner)
        {
            setButtonsDisable();
            mTextViewFIRwinner.setText(R.string.tie);
        }
    }

    private void checkWin(int finalI, int finalJ) {
        if(fourInARowInf.checkRow(finalI,finalJ)||fourInARowInf.checkColumn(finalI,finalJ)|| fourInARowInf.checkDiagonal(finalI,finalJ))
        {
            mHasNoWinner=false;
            setButtonsDisable();
            if (fourInARowInf.mPlayer1Turn)
            {
                mTextViewFIRwinner.setText(String.format("%s wins", fourInARowInf.getPlayer1Name()));
            }
            else {
                mTextViewFIRwinner.setText(String.format("%s wins", fourInARowInf.getPlayer2Name()));
            }
        }
        else {
            mHasNoWinner=true;
        }
    }

    private void getInputs(int finalI, int finalJ) {
        if (fourInARowInf.mPlayer1Turn)
        {
            fourInARowInf.mTable[finalI][finalJ]=1;
            mButtons[finalI][finalJ].setBackgroundColor(getResources().getColor(R.color.four_in_a_row_player1_color));
        }else {
            fourInARowInf.mTable[finalI][finalJ]=-1;
            mButtons[finalI][finalJ].setBackgroundColor(getResources().getColor(R.color.four_in_a_row_player2_color));

        }
    }

    private void setButtonsDisable()
    {
        for (int i = 0; i <5 ; i++) {
            for (int j = 0; j <5 ; j++) {
                mButtons[i][j].setEnabled(false);
            }
        }
    }

    private void findViews(View view) {
        mButtons[0][0]=view.findViewById(R.id.FIRbutton00);
        mButtons[0][1]=view.findViewById(R.id.FIRbutton01);
        mButtons[0][2]=view.findViewById(R.id.FIRbutton02);
        mButtons[0][3]=view.findViewById(R.id.FIRbutton03);
        mButtons[0][4]=view.findViewById(R.id.FIRbutton04);
        mButtons[1][0]=view.findViewById(R.id.FIRbutton10);
        mButtons[1][1]=view.findViewById(R.id.FIRbutton11);
        mButtons[1][2]=view.findViewById(R.id.FIRbutton12);
        mButtons[1][3]=view.findViewById(R.id.FIRbutton13);
        mButtons[1][4]=view.findViewById(R.id.FIRbutton14);
        mButtons[2][0]=view.findViewById(R.id.FIRbutton20);
        mButtons[2][1]=view.findViewById(R.id.FIRbutton21);
        mButtons[2][2]=view.findViewById(R.id.FIRbutton22);
        mButtons[2][3]=view.findViewById(R.id.FIRbutton23);
        mButtons[2][4]=view.findViewById(R.id.FIRbutton24);
        mButtons[3][0]=view.findViewById(R.id.FIRbutton30);
        mButtons[3][1]=view.findViewById(R.id.FIRbutton31);
        mButtons[3][2]=view.findViewById(R.id.FIRbutton32);
        mButtons[3][3]=view.findViewById(R.id.FIRbutton33);
        mButtons[3][4]=view.findViewById(R.id.FIRbutton34);
        mButtons[4][0]=view.findViewById(R.id.FIRbutton40);
        mButtons[4][1]=view.findViewById(R.id.FIRbutton41);
        mButtons[4][2]=view.findViewById(R.id.FIRbutton42);
        mButtons[4][3]=view.findViewById(R.id.FIRbutton43);
        mButtons[4][4]=view.findViewById(R.id.FIRbutton44);
        mTextViewFIRwinner=view.findViewById(R.id.textViewFIRWinner);
    }
}