package com.planetpay.views.login_register;

import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidateFilter implements InputFilter {

    @Override
    public CharSequence filter(CharSequence charSequence, int start, int end, Spanned spanned, int dstart , int dend) {
        for ( int i = start ; i < end ; i++) {
            String checkMe = String. valueOf (charSequence.charAt(i)) ;
            Pattern pattern =
                    Pattern. compile ( "[ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456789_]*" ) ;
            Matcher matcher = pattern.matcher(checkMe) ;
            boolean valid = matcher.matches() ;
            if (!valid) {
                Log. d ( "" , "invalid" ) ;
                return "" ;
            }
        }
        return null;
    }
}
