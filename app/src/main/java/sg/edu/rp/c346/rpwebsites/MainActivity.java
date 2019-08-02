package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Spinner spn1;
    Spinner spn2;
    TextView tv1;
    TextView tv2;
    Button btn;
    ArrayList<String> al;
    ArrayAdapter<String> aa;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1=findViewById(R.id.spinner1);
        spn2=findViewById(R.id.spinner2);
        tv1=findViewById(R.id.textView1);
        tv2=findViewById(R.id.textView2);
        al = new ArrayList<>();
        aa = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, al);
        al.addAll(Arrays.asList(getResources().getStringArray(R.array.second)));
        spn2.setAdapter(aa);

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        get = getResources().getStringArray(R.array.second);
                        break;
                    case 1:
                        get = getResources().getStringArray(R.array.second);
                        break;
                }
                al.clear();
                al.addAll(Arrays.asList(get));
                aa.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                String [][] sites = {
                        {"https://www.rp.edu.sg/", "https://www.rp.edu.sg/student-life"},
                        {"https://www.rp.edu.sg/soi/full-time-diplomas/details/r47",
                                "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12"}
                };
                intent.putExtra("website", sites[spn1.getSelectedItemPosition()][spn2.getSelectedItemPosition()]);
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor prefEdit = prefs.edit();
                prefEdit.putInt("owo", spn1.getSelectedItemPosition());
                prefEdit.putInt("uwu", spn2.getSelectedItemPosition());
                prefEdit.commit();
                startActivity(intent);
            }
        });
    }
}
