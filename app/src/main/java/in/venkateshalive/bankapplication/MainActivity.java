package in.venkateshalive.bankapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void emi_btn_oc(View view)
    {
        startActivity(new Intent(getApplicationContext(), EmiCalculator.class));
    }



    public void cc_btn_oc(View views)
    {
        startActivity(new Intent(getApplicationContext(), CurrencyConventor.class));
    }



    public void otha(View v)
    {
        startActivity(new Intent(getApplicationContext(), AllBank.class));
    }



    public void gold(View view)
    {
        startActivity(new Intent(getApplicationContext(),IntrestCalculator.class));
    }
}
