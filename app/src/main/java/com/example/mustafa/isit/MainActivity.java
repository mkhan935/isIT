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
 * fixed toDos*/
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
        //st.replaceAll("\\s+","")
        String temp;
        temp = content.replaceAll("\\s+", "");
        if(check(temp) == false){
            content ="Error String contains nonletters, only letters are allowed,\n ex. race car or nun";
            displayView(content);
        }
        if(check(temp)){
            if(checkPalindrome(temp) == false){
                content =content+"-  Is not a palindrome";
                displayView(content);
            }

            else {
                displayView("The word -"+content.toLowerCase()+ " is a palindrome ");
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
        String temp =s.toLowerCase();
        for(int i=0; i<(n/2); ++i){
            if(temp.charAt(i) != temp.charAt(n - i -1)){
                return false;
            }
        }
        return true;
    }

}
