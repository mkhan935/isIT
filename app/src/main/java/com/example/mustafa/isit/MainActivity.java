package com.example.mustafa.isit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Simple Android application, it contains a edittext box, a button, and a textview box.
 * the button is used for the user to submit the word they type into the editbox
 * the word is then checked for any non letter characters, if they exist, display error in textview box
 * if the word passes the check, then it is checked to see if it is a palindrome,
 * a palindrome is a word that spelled backwards is the same word, example - nun
 * if it is palindrome, display both words, and "Good Job.."
 * if not throw an error msg on the textview
 * TODO Add functionality such that even words with spaces can be done, like " Race Car = Race Car in reverse*/
public class MainActivity extends AppCompatActivity {
    //Button check;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //check = (Button) findViewById(R.id.check_button);
        //input = (EditText) findViewById(R.id.edit_view);
    }


    public void displayView(String s ){
        TextView test = (TextView) findViewById(R.id.answer_view);
        test.setText(s);

    }

    public void clickIT(View v){
        input = (EditText) findViewById(R.id.edit_view);
        String content = input.getText().toString();
        if(check(content) == false){
            content ="Error String contains nonletters, only letters are allowed,\n currently spaces are also not supported";
            displayView(content);
        }
        if(check(content)){
            if(checkPalindrome(content) == false){
                String newContent =new StringBuilder(content).reverse().toString();
                content ="This is the word in reverse -"+ newContent+"\n it is not a palindrome";
                displayView(content);
            }

            else {
                String newContent =new StringBuilder(content).reverse().toString();
                displayView("The word -"+content+ " and its palindrome -" + newContent + " \nGood Job finding one!");
            }
        }
    }


    public boolean check(String s){
        char[] chars = s.toCharArray();
        for (char c : chars){
            if(!Character.isLetter(c)){
                return false;
            }
        }
        return true;
    }


    public boolean checkPalindrome(String s){
        int n = s.length();
        for(int i=0; i<(n/2); ++i){
            if(s.charAt(i) != s.charAt(n - i -1)){
                return false;
            }
        }
        return true;
    }

}
