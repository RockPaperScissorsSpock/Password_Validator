/*******************************************************************************************
 *                                                                                         *
 *  Class Name: PasswordStrength                                                           *
 *                                                                                         *
 *     Purpose: This class is the model for the app that has one method that returns       *
 *              a boolean that indicates whether or not the password is strong (8 or more  *
 *              characters) or weak (less than 8 characters)                               *
 *                                                                                         *
 ******************************************************************************************/
package edu.niu.android.passwordvalidator;

public class PasswordStrength
{
    // Determine whether or not the password is strong
    public boolean weakPass(String password)
    {
        return password.length() <= 8;
    }
}
