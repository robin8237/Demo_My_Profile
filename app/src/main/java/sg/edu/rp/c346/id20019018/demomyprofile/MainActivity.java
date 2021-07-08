package sg.edu.rp.c346.id20019018.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;
    Button btnStore;
    Button btnRet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
        btnStore = findViewById(R.id.buttonStore);
        btnRet = findViewById(R.id.buttonRetrieve);

        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strName = etName.getText().toString();
                float GPA = Float.parseFloat(etGPA.getText().toString());

                SharedPreferences pref = getPreferences(MODE_PRIVATE);

                SharedPreferences.Editor prefEdit = pref.edit();

                prefEdit.putString("name",strName);
                prefEdit.putFloat("GPA",GPA);

                prefEdit.commit();
            }
        });

        btnRet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences pref = getPreferences(MODE_PRIVATE);

                String name = pref.getString("name","Person Name");
                Float gpa = pref.getFloat("GPA",0);
                etName.setText(name);
                etGPA.setText(gpa + "");

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences pref = getPreferences(MODE_PRIVATE);

        String name = pref.getString("name","Person Name");
        Float gpa = pref.getFloat("GPA",0);
        etName.setText(name);
        etGPA.setText(gpa + "");

    }

    @Override
    protected void onPause() {
        super.onPause();

        String strName = etName.getText().toString();
        float GPA = Float.parseFloat(etGPA.getText().toString());

        SharedPreferences pref = getPreferences(MODE_PRIVATE);

        SharedPreferences.Editor prefEdit = pref.edit();

        prefEdit.putString("name",strName);
        prefEdit.putFloat("GPA",GPA);

        prefEdit.commit();
    }

}