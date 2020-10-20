package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public enum Operator {none,add,minus,multiply,devide};
    public Operator optr = Operator.none;
    public double data1 = 0 , data2 = 0, result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnResultClick(View view){
        if (optr!= Operator.none){
            EditText eText = (EditText) findViewById(R.id.resultEdit);
            char ch='+';
            if(optr == Operator.add)
                ch ='+';
            if (optr == Operator.minus)
                ch ='-';
            if (optr == Operator.multiply)
                ch ='X';
            if (optr == Operator.devide)
                ch ='/';
            data2 = Double.parseDouble(eText.getText().toString().substring(eText.getText().toString().indexOf(ch)+1));
            result = 0;
            if (optr== Operator.add)
                result = data1 + data2;
            if (optr== Operator.minus)
                result = data1 - data2;
            if (optr == Operator.multiply)
                result = data1 * data2;
            if (optr == Operator.devide)
                result = data1 / data2;
            optr = Operator.none;
            data1 = result;
            data2 =0;
            if (result - (int) result != 0)
                eText.setText(String.valueOf(result));
            else
                eText.setText(String.valueOf((int) result));


        }
    }
    public void btn00Click(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + "0");
    }
    public void btn01Click(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText(eText.getText()+"1");
    }
    public void btn02Click(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText(eText.getText()+"2");
    }
    public void btn03Click(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText(eText.getText()+"3");
    }
    public void btn04Click(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText(eText.getText()+"4");
    }
    public void btn05Click(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText(eText.getText()+"5");
    }
    public void btn06Click(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText(eText.getText()+"6");
    }
    public void btn07Click(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText(eText.getText()+"7");
    }
    public void btn08Click(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText(eText.getText()+"8");
    }
    public void btn09Click(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText(eText.getText()+"9");
    }
    public void btnAddClick(View view){
        if (optr == Operator.none){
            optr = Operator.add;
            EditText eText = (EditText) findViewById(R.id.resultEdit);
            data1 = Double.parseDouble(eText.getText().toString());
            eText.setText(eText.getText() + " + ");
        }
        else{
            btnResultClick(view);
            btnAddClick(view);
        }
    }
    public void btnMinusClick(View view){
        if (optr == Operator.none) {
            optr = Operator.minus;
            EditText eText = (EditText) findViewById(R.id.resultEdit);
            data1 = Double.parseDouble(eText.getText().toString());
            eText.setText(eText.getText() + " - ");
        }
        else{
            btnResultClick(view);
            btnMinusClick(view);
        }
    }
    public void btnMultiplyClick(View view){
        if (optr == Operator.none) {
            optr = Operator.multiply;
            EditText eText = (EditText) findViewById(R.id.resultEdit);
            data1 = Double.parseDouble(eText.getText().toString());
            eText.setText(eText.getText() + " X ");
        }
        else{
            btnResultClick(view);
            btnMultiplyClick(view);
        }
    }
    public void btnDevideClick(View view){
        if (optr == Operator.none) {
            optr = Operator.devide;
            EditText eText = (EditText) findViewById(R.id.resultEdit);
            data1 = Double.parseDouble(eText.getText().toString());
            eText.setText(eText.getText() + " / ");
        }
        else{
            btnResultClick(view);
            btnDevideClick(view);
        }
    }
    public void btnDotClick(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        if(eText.getText().toString().indexOf('.')==-1 || (optr != Operator.none && eText.getText().toString().indexOf('.') == eText.getText().toString().lastIndexOf('.')))
            eText.setText(eText.getText()+".");
    }
    public void btnClearClick(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText("0");
        optr = Operator.none;
        data1 =0;
        data2 =0;
        result =0;
    }


}