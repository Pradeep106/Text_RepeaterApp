package com.helpscodewithu.blogspot.textrepeater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.StatusBarManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Creating new object.........
    Button button,button2;
    EditText editText,editText2;
    TextView textView,textView2;
    CheckBox checkBox;
    View image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //finding ids..........
        button=findViewById(R.id.btn);
        button2=findViewById(R.id.btn2);
        editText=findViewById(R.id.et);
        editText2=findViewById(R.id.et2);
        textView=findViewById(R.id.tv);
        textView2=findViewById(R.id.textview);
        checkBox=findViewById(R.id.cb);
        image=findViewById(R.id.clipboard);

        textView.setVisibility(View.GONE);

        // Set onclicklistener in Generate button......

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editText.length()==0||editText2.length()==0)
                {
                    Toast.makeText(MainActivity.this, "Textfield is empty", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String text = editText.getText().toString();
                    int number = Integer.parseInt(editText2.getText().toString());
                    StringBuilder ans = new StringBuilder();

                    //for getting size of created content in bytes

                    char [] chars=text.toCharArray();

                    int lenght=chars.length;
                    int count=0;
                    for (int i=1;i<=number;i++)
                    {
                        count=(lenght*2*number);
                    }
                    textView2.setText(count+" byte");

                    // for new line checkbox

                    if (checkBox.isChecked()) {
                        for (int i = 1; i <= number; i++)
                        {
                            ans.append(text + "\n");
                        }
                    }
                    else {

                        for (int i = 1; i <= number; i++)
                        {
                            ans.append(text);
                        }
                    }
                    textView.setText(ans);
                    textView.setVisibility(View.VISIBLE);

                    // copy clipboard
                    image.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ClipboardManager clipboardManager=(ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                            ClipData clip= ClipData.newPlainText(" edit text",ans);
                            clipboardManager.setPrimaryClip(clip);
                            Toast.makeText(MainActivity.this, "copied", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

        // Reset buton clear Edit text
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editText.setText(" ");
                        editText2.setText(" ");
                    }
                });
            }
        });
        }
}