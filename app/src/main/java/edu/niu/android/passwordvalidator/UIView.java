/*******************************************************************************************
 *                                                                                         *
 *  Class Name: UIView                                                                     *
 *                                                                                         *
 *     Purpose: This class sets up the view for the app declaring a TextView and EditText  *
 *              using the GridLayout. The TextView is updated by a TextWatcher when the    *
 *              user enters a password. If the password is less than 8 characters the      *
 *              TextView displays weak password in red and if it is 8 or more characters   *
 *              the TextView displays strong password in green.                            *
 *                                                                                         *
 ******************************************************************************************/
package edu.niu.android.passwordvalidator;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;



public class UIView extends GridLayout{

    private EditText passwordEntry;
    private TextView strengthIndicator;

    public UIView(Context context)
    {
        super(context);

        // Set a single column
        setColumnCount(1);

        // Set up the strength Indicator TextView
        strengthIndicator = new TextView(context);
        GridLayout.LayoutParams labelParams = new GridLayout.LayoutParams();
        labelParams.width = LayoutParams.WRAP_CONTENT;
        labelParams.height = LayoutParams.WRAP_CONTENT;
        labelParams.setMargins(0, 200, 0, 0);
        strengthIndicator.setLayoutParams(labelParams);
        strengthIndicator.setText(R.string.starting_indicator);
        strengthIndicator.setTextSize(22);
        addView(strengthIndicator);


        // Set up the passwordEntry EditText

        passwordEntry = new EditText(context);
        GridLayout.LayoutParams passwordParams = new GridLayout.LayoutParams();
        passwordParams.width = LayoutParams.MATCH_PARENT;
        passwordParams.height = LayoutParams.WRAP_CONTENT;
        passwordParams.setMargins(0, 100, 0, 0);
        passwordEntry.setLayoutParams(passwordParams);
        passwordEntry.setHint(R.string.password_hint);
        addView(passwordEntry);
    }

    // Set up the TextWatcher for the passwordEntry EditText
    public void setPasswordTextWatcher(TextWatcher textWatcher) {
        passwordEntry.addTextChangedListener(textWatcher);
    }

    // Returns the user's password entry
    public String getPasswordText() {
        return passwordEntry.getText().toString();
    }
    // Change the color/text of the strengthIndicator based on the isWeak method from the model
    public void strengthIndicatorUpdate(boolean isWeak) {
        if (isWeak) {
            strengthIndicator.setText(R.string.weak_indicator);
            strengthIndicator.setTextColor(getResources().getColor(R.color.red));
        } else {
            strengthIndicator.setText(R.string.strong_indicator);
            strengthIndicator.setTextColor(getResources().getColor(R.color.green));
        }
    }
}
