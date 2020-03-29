package com.example.homework2.Exercise3;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.homework2.R;

public class ChatRoom extends AppCompatActivity {
    private String log = new String();
    public static final String RETURN_INFO = "ChatRoom";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);
        ((TextView)findViewById(R.id.tv_with_name)).setText(getIntent().getStringExtra(RETURN_INFO));

        ImageView sendBtn = findViewById(R.id.btn_send_info);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = ((EditText)findViewById(R.id.ed_say)).getText().toString();
                if (!input.isEmpty()) {
                    ((TextView)findViewById(R.id.tv_content_info))
                            .append(input + '\n');
                    ((EditText)findViewById(R.id.ed_say)).setText("");
                }
            }
        });
    }
}
