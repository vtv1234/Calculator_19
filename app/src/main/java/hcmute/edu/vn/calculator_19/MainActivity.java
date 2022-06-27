package hcmute.edu.vn.calculator_19;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.*;


public class MainActivity extends AppCompatActivity {
    //private static final String TAG = MainActivity.class.getSimpleName();
    private TextView previousCalculation;
    private EditText display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        previousCalculation = findViewById(R.id.previousCalculationView);
        display = findViewById(R.id.displayEditText);

        display.setShowSoftInputOnFocus(false);
    }

    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        display.setSelection(cursorPos + strToAdd.length());
    }

    public void zeroOnClick(View view) {
        updateText("0");
    }

    public void dotOnClick(View view) {
        updateText(".");
    }

    public void oneOnClick(View view) {
        updateText("1");

    }

    public void twoOnClick(View view) {
        updateText("2");
    }

    public void threeOnClick(View view) {
        updateText("3");
    }

    public void fourOnClick(View view) {
        updateText("4");
    }

    public void fiveOnClick(View view) {
        updateText("5");
    }

    public void sixOnClick(View view) {
        updateText("6");
    }

    public void sevenOnClick(View view) {
        updateText("7");
    }

    public void eightOnClick(View view) {
        updateText("8");
    }

    public void nineOnClick(View view) {
        updateText("9");
    }

    public void equalOnClick(View view) {
        String userExp = display.getText().toString();

        previousCalculation.setText(userExp);

        userExp = userExp.replaceAll(getResources().getString(R.string.divideText), "/");
        userExp = userExp.replaceAll(getResources().getString(R.string.multiplyText), "*");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }

    public void plusOnClick(View view){
        updateText("+");
   }

    public void mulOnClick(View view) {
        updateText(getResources().getString(R.string.multiplyText));
    }

    public void subOnClick(View view) {
        updateText("-");
    }

    public void divideOnClick(View view) {
        updateText(getResources().getString(R.string.divideText));
    }

    public void clearOnClick(View view) {
        display.setText("");
        previousCalculation.setText("");
    }


}
