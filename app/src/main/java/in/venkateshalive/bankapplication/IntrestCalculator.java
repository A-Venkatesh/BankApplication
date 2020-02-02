package in.venkateshalive.bankapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class IntrestCalculator extends AppCompatActivity {
    private EditText mLoanAmount, mInterestRate, mLoanPeriod;
    private TextView mMontlyPaymentResult, mTotalPaymentsResult;
    public int dpty;

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intrest_calculator);
        spinner =(Spinner)findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this,R.array.deposit_type,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                dpty = position +1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mLoanAmount = (EditText)findViewById(R.id.amount);
        mInterestRate = (EditText)findViewById(R.id.rate);
        mLoanPeriod = (EditText)findViewById(R.id.period);
        mMontlyPaymentResult = (TextView)findViewById(R.id.monthly_result);
        mTotalPaymentsResult = (TextView)findViewById(R.id.total_result);
    }

    public void showPayments(View clickedButton) {

        double loanAmount = Integer.parseInt(mLoanAmount.getText().toString());
        double interestRate = Double.parseDouble(mInterestRate.getText().toString());
        double loanPeriod = Integer.parseInt(mLoanPeriod.getText().toString());

        double monthlyPayment ;
        double totalPayment ;
        switch (dpty) {
            case 1:


                totalPayment = loanAmount + (loanAmount *((interestRate / 12)/100.0)*loanPeriod) ;
                monthlyPayment = totalPayment - loanAmount;

                mMontlyPaymentResult.setText(new DecimalFormat("##.##").format(monthlyPayment));
                mTotalPaymentsResult.setText(new DecimalFormat("##.##").format(totalPayment));

                break;
            case 2:


                totalPayment = loanAmount * loanPeriod + loanAmount * (loanPeriod * (loanPeriod + 1)) / 2.0 * (interestRate / 100.0) * (1.0 / 12.0);
                monthlyPayment = totalPayment - (loanAmount * loanPeriod) ;

                mMontlyPaymentResult.setText(new DecimalFormat("##.##").format(monthlyPayment));
                mTotalPaymentsResult.setText(new DecimalFormat("##.##").format(totalPayment));

                break;
            default:
                System.out.println("Wrong choice");}



    }
}