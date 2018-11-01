package kr.co.woobi.imyeon.tryedittextkeyboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textViewResult=(TextView)findViewById(R.id.textViewResult2);
        Button buttonShowResult = findViewById(R.id.buttonShowResult);

        Intent intent = getIntent();
        if(intent !=null){
            String name=intent.getStringExtra("name");
            String age=intent.getStringExtra("age");
            String sex=intent.getStringExtra("sex");
            String job=intent.getStringExtra("job");
            textViewResult.setText("이름은 " + name +", 나이는 " + age +"세, 성별은 "
                    + sex + ", 직업은 "+ job +"입니다. ");
        }

        buttonShowResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });
    }


}
