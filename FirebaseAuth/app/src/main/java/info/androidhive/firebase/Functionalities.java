package info.androidhive.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Functionalities extends AppCompatActivity {
    private Button addTran,showTrans;
    private Button addCat,catTrans,SetBudget,Analysis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_functionalities);
        Analysis =(Button) findViewById(R.id.button6);
        addTran = (Button) findViewById(R.id.addTran);
        showTrans=(Button) findViewById(R.id.showTrans);
        addCat= findViewById(R.id.addCat);
        catTrans=findViewById(R.id.CatTrans);
        SetBudget=findViewById(R.id.setBudget);
        showTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Functionalities.this, ShowTransActivity.class));
            }
        });
        addTran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Functionalities.this, Transac.class));
            }
        });
        addCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Functionalities.this, AddCat.class));
            }
        });
        catTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Functionalities.this,CategTrans.class));
            }
        });
        SetBudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Functionalities.this,SetBud.class));
            }
        });
        Analysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Functionalities.this,AnalysisActivity.class));

            }
        });


    }
}
