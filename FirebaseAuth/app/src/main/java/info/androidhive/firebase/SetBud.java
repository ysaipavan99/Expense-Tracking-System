package info.androidhive.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SetBud extends AppCompatActivity {
    private ListView catBudView;
    private ArrayList<String> CatgBudg=new ArrayList<>();
    private ArrayList<String> Catg=new ArrayList<>();
    private Firebase mRootRef;
    private Firebase RefUid;
    private Firebase RefCat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_bud);
        catBudView = (ListView) findViewById((R.id.CatBud));


        final List<Map<String, String>> data = new ArrayList<Map<String, String>>();

        final SimpleAdapter adapter = new SimpleAdapter(this, data, android.R.layout.simple_list_item_2, new String[] {"Cat", "Bud"}, new int[] {android.R.id.text1, android.R.id.text2});


        catBudView.setAdapter(adapter);

       /*
        final ArrayAdapter<String> arrayAdapter1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,CatgBudg);
        final ArrayAdapter<String> arrayAdapter2=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_2,Catg);
        catBudView.setAdapter(arrayAdapter1);
        catBudView.setAdapter(arrayAdapter2);
*/
        mRootRef=new Firebase("https://expense-2a69a.firebaseio.com/");

        mRootRef.keepSynced(true);
        com.google.firebase.auth.FirebaseAuth auth = FirebaseAuth.getInstance();
        String Uid=auth.getUid();
        RefUid= mRootRef.child(Uid);
        RefCat=RefUid.child("Categories");

        RefCat.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value1= dataSnapshot.getKey().trim();
                String value2= dataSnapshot.getValue().toString().trim();

                //CatgBudg.add(value1);
                //arrayAdapter1.notifyDataSetChanged();

                Map<String, String> datum = new HashMap<String, String>(2);
                datum.put("Cat", value1);
                datum.put("Bud", value2);
                data.add(datum);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
/*
        RefCat.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value= dataSnapshot.getValue().toString().trim();
                Catg.add(value);
                arrayAdapter2.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });*/

    }
}
