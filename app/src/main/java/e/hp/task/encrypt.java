package e.hp.task;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class encrypt extends AppCompatActivity {
private EditText editText;
private Button button;
private TextView textView;
private String str,res="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt);
        editText=(EditText)findViewById(R.id.edt);
        button=(Button)findViewById(R.id.btne);
        textView=(TextView)findViewById(R.id.tv);
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
                str=editText.getText().toString();
                int c=0;
                for(int i=0;i<str.length()-1;i++){
                    if(i==str.length()-2){
                        c++;
                        if(str.charAt(i) == str.charAt(i + 1)){
                            c++;
                            res=res+str.charAt(i)+c;
                        }
                        else{
                            res=res+str.charAt(i)+c;
                            c=0;
                            c++;
                            res=res+str.charAt(i+1)+c;
                        }
                    }
                    else {
                        if (str.charAt(i) == str.charAt(i + 1)) {
                            c++;
                        } else {
                            c++;
                            res = res + str.charAt(i) + c;
                            c = 0;
                        }
                    }
                }
                textView.setText(res);
                res="";
            }
        });
    }
}