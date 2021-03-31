package e.hp.task;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class decrypt extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private TextView textView;
    private String str,res="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypt);
        editText=(EditText)findViewById(R.id.edtd);
        button=(Button)findViewById(R.id.btnd);
        textView=(TextView)findViewById(R.id.tvd);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String inp=editText.getText().toString();
                button.setEnabled(!inp.isEmpty());
                if(inp.isEmpty()){
                    textView.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int flag=0;
                str=editText.getText().toString();
                for(int i=0;i<str.length()-1;i+=2){
                    if(!(Character.isDigit(str.charAt(i+1)))){
                        Toast.makeText(decrypt.this,"Please enter valid Input",Toast.LENGTH_SHORT).show();
                        flag=1;
                    }
                    else {
                        int k = Integer.parseInt(String.valueOf(str.charAt(i + 1)));
                        for (int j = 0; j < k; j++) {
                            res = res + str.charAt(i);
                        }
                    }
                }
                if(flag==0) {
                    textView.setText(res);
                }
                res="";
            }
        });
    }
}