package kr.co.woobi.imyeon.tryedittextkeyboard;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener ,View.OnKeyListener {
        RadioGroup radioGroupSex, radioGroupJob;
        RadioButton radioFemale, radioMale, radioStudent, radioOfficer;
        TextView textViewName, textViewAge, textViewSex, textViewJob, textResult;
        EditText TextName, TextAge;
        Button buttonShowName, buttonShowAge, buttonShowResult;
        String sex, job, name, age;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroupSex=(RadioGroup)findViewById(R.id.radioGroupSex);
        radioGroupSex.setOnCheckedChangeListener(this);
        radioGroupJob=(RadioGroup)findViewById(R.id.radioGroupJob);
        radioGroupJob.setOnCheckedChangeListener(this);

        radioFemale=(RadioButton)findViewById(R.id.radioFemale);
        radioMale=(RadioButton)findViewById(R.id.radioMale);
        radioStudent=(RadioButton)findViewById(R.id.radioStudent);
        radioOfficer=(RadioButton)findViewById(R.id.radioOfficer);

        textResult=(TextView)findViewById(R.id.textResult);
        TextName=(EditText)findViewById(R.id.TextName);
        TextName.setOnKeyListener(this);
        TextAge=(EditText)findViewById(R.id.TextAge);
        TextAge.setOnKeyListener(this);


        buttonShowName=(Button)findViewById(R.id.buttonShowName);
        buttonShowName.setOnClickListener(this);
        buttonShowAge=(Button)findViewById(R.id.buttonShowAge);
        buttonShowAge.setOnClickListener(this);
        buttonShowResult=(Button)findViewById(R.id.buttonShowResult);
        buttonShowResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonShowName:
                textResult.setText("당신의 이름은 "+name);
                break;
            case R.id.buttonShowAge:
                textResult.setText("당신의 나이는"+ age);
                break;
            case R.id.buttonShowResult:
                textResult.setText("이름은 " + name +", 나이는 " + age +"세, 성별은 "
                + sex + ", 직업은 "+ job +"입니다. ");

                Intent intent=new Intent(this, ResultActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("age",age);
                intent.putExtra("sex", sex);
                intent.putExtra("job",job);
                startActivityForResult(intent, 1000);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==1000 && resultCode ==RESULT_OK){
            Toast.makeText(this, " 확인", Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
    switch (checkedId){
        case R.id.radioFemale:
            sex=radioFemale.getText().toString();
            break;
        case R.id.radioMale:
            sex=radioMale.getText().toString();
            break;
        case R.id.radioStudent:
            job=radioStudent.getText().toString();
            break;
        case R.id.radioOfficer:
            job=radioOfficer.getText().toString();
            break;
    }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        switch (v.getId()){
            case R.id.TextName:
                name=((EditText)v).getText().toString();
                break;
            case R.id.TextAge:
                age=((EditText)v).getText().toString();
                break;
        }
        return false;
    }
}



















