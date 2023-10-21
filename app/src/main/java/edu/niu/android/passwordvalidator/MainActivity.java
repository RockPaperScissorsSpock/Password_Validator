/******************************************************************************************
 *                                                                                        *
 *  CSCI 322                             Assignment 4                          Fall 2023  *
 *                                                                                        *
 *          App Name: Password Validator                                                  *
 *                                                                                        *
 *        Class Name: MainActivity.java                                                   *
 *                                                                                        *
 *      Developer(s): Milad Jizan z1943173, Mark Southwood z058227                        *
 *                                                                                        *
 *          Due Date: 10/20/2023                                                          *
 *                                                                                        *
 *           Purpose: The purpose of this project is to develop an UI without XML and we  *
 *                    chose to use the Grid Layout like the TicTacToe app. This app       *
 *                    checks a user supplied password to see if it is weak or strong      *
 *                    based on the character length less than 8 for weak, greater or      *
 *                    equal for strong.                                                   *
 *                                                                                        *
 *****************************************************************************************/

package edu.niu.android.passwordvalidator;

import android.os.Bundle;
import android.text.TextWatcher;
import android.text.Editable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    private PasswordStrength model;
    private UIView view;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setTitle(R.string.app_name);

        model = new PasswordStrength();
        view = new UIView(this);
        setContentView(view);

        //Set up TextWatcher to change strengthIndicator TextView
        view.setPasswordTextWatcher(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s)
            {
                String password = view.getPasswordText();
                boolean weakPass = model.weakPass(password);
                view.strengthIndicatorUpdate(weakPass);
            }
        });
    }
}

