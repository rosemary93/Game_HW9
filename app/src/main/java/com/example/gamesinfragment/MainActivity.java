package com.example.gamesinfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

private Button mButtonTicTacToe;
private Button mButton4InARow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*FragmentManager fragmentManager=getSupportFragmentManager();
        Fragment fragment=fragmentManager.findFragmentById(R.id.fragment_container);
        if (fragment==null) {
            TicTacToeFragment ticTacToeFragment = new TicTacToeFragment();
            fragmentManager.beginTransaction().add(R.id.fragment_container, ticTacToeFragment).commit();
        }*/
        findViews();
        setListeners();
    }

    private void findViews() {
        mButtonTicTacToe =findViewById(R.id.button_tic_tac_toe);
        mButton4InARow =findViewById(R.id.button_4_in_row);
    }

    private void setListeners() {
        final FragmentManager fragmentManager =getSupportFragmentManager() ;
        final Fragment fragment=fragmentManager.findFragmentById(R.id.fragment_game_container);
        mButtonTicTacToe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TicTacToeFragment ticTacToeFragment = new TicTacToeFragment();
                if (fragment==null)
                {
                    fragmentManager.beginTransaction().add(R.id.fragment_game_container,ticTacToeFragment).commit();
                }
                else {
                    fragmentManager.beginTransaction().replace(R.id.fragment_game_container,ticTacToeFragment).commit();
                }
            }
        });

       /* m4InARow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });*/
    }
}