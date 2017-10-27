package damon.assignment1_addition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Damon on 1/28/2017.
 */

public class AddActivity extends AppCompatActivity {
    private EditText mNum1;
    private EditText mNum2;
    private TextView mSum;
    private Button mAdd;
    private AddModel mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNum1 = (EditText) findViewById(R.id.num1_edit_view);
        mNum2 = (EditText) findViewById(R.id.num2_edit_view);
        mSum = (TextView) findViewById(R.id.sum_text_view);
        mAdd = (Button) findViewById(R.id.add_button);
        mModel = new AddModel();

        mAdd.setOnClickListener(addButtonListener);
    }

    View.OnClickListener addButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mModel.setNum1(mNum1.getText().toString());
            mModel.setNum2(mNum2.getText().toString());
            mModel.addNum();
            mSum.setText(Integer.toString(mModel.getSum()));
        }
    };
}
