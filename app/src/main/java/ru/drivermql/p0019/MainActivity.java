package ru.drivermql.p0019;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    final int MENU_RESET_ID = 1;
    final int MENU_QUIT_ID = 2;
    EditText etNum1;
    EditText etNum2;

    Button btnAdd, btnSub, btnMult,btnDiv;
    TextView tvResult;
    String oper ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  find the elements
        etNum1 = (EditText) findViewById(R.id.etNum1);
        etNum2 = (EditText) findViewById(R.id.etNum2);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);

        tvResult = (TextView) findViewById(R.id.tvResult);

        //  handler
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        float num1=0;
        float num2=0;
        float result=0;

        //check fields on emptiness
        if(TextUtils.isEmpty(etNum1.getText().toString())
                || TextUtils.isEmpty(etNum2.getText().toString())){
            tvResult.setText("Enter numbers in fields");
            return;
    }

        //read EditText and fill the variables with numbers
        num1 = Float.parseFloat(etNum1.getText().toString());
        num2 = Float.parseFloat(etNum2.getText().toString());

        //define the pressed button and perform the corresponding operation
        //in oper write operation, then will to use on output

        switch (view.getId()){
            case R.id.btnAdd:
                oper = " + ";
                result = num1 + num2;
                break;
            case R.id.btnSub:
                oper = " - ";
                result = num1 - num2;
                break;
            case R.id.btnMult:
                oper = " * ";
                result = num1 * num2;
                break;
            case R.id.btnDiv:
                oper = " / ";
                result = num1 / num2;
                break;
        }
        //form the output line
        tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);

    }
    //create Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(0,MENU_RESET_ID,0,"Reset");
        menu.add(0,MENU_QUIT_ID,0,"Quit");
        return super.onCreateOptionsMenu(menu);
    }
    //processing of menu click
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case MENU_RESET_ID:
                //clear fields
                etNum1.setText("");
                etNum2.setText("");
                tvResult.setText("");
                break;
            case MENU_QUIT_ID:
                //exiting the application
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
