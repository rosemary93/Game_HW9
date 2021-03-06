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
    FragmentManager fragmentManager;
    Fragment fragment;

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
        mButtonTicTacToe = findViewById(R.id.button_tic_tac_toe);
        mButton4InARow = findViewById(R.id.button_4_in_row);
    }

    private void setListeners() {
        fragmentManager = getSupportFragmentManager();
        fragment = fragmentManager.findFragmentById(R.id.fragment_game_container);
        mButtonTicTacToe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TicTacToeFragment ticTacToeFragment = new TicTacToeFragment();
                /*if (fragment==null)
                {
                    fragmentManager.beginTransaction().add(R.id.fragment_game_container,ticTacToeFragment).commit();
                }
                else {
                    fragmentManager.beginTransaction().remove(fragment);
                }*/
                if (fragment != null) {
                    fragmentManager.beginTransaction().remove(fragment).commit();
                }
                fragmentManager.beginTransaction().add(R.id.fragment_game_container, ticTacToeFragment).commit();
            }
        });

        mButton4InARow.setOnClickListener(new View.OnClickListener() {

            FourInARowFragment fourInARowFragment = new FourInARowFragment();

            @Override
            public void onClick(View v) {

                /*if (fragment==null)
                {
                    fragmentManager.beginTransaction().add(R.id.fragment_game_container,fourInARowFragment).commit();
                }
                else {
                    fragmentManager.beginTransaction().replace(R.id.fragment_game_container,fourInARowFragment).commit();

                }*/
                if (fragment != null) {
                    fragmentManager.beginTransaction().remove(fragment).commit();
                }
                fragmentManager.beginTransaction().add(R.id.fragment_game_container, fourInARowFragment).commit();
            }
        });
    }
}