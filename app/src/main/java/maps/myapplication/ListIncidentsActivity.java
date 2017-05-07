package maps.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListViewCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ListIncidentsActivity extends AppCompatActivity {

    ListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_incidents);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Intent intent = new Intent(view.getContext(), ReportActivity.class);
                startActivity(intent);
            }
        });

/*
        // === Firebase ===
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference titleRef = database.getReference("incident");
        DatabaseReference timeRef = database.getReference("time");
        DatabaseReference descRef = database.getReference("desc");

        titleRef.limitToLast(5).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()) {

                    String value = dataSnapshot.child("title").toString();
                    Log.i("MapApp", "Incident is: " + value);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.e("MapApp", "Failed to read value: " + error.toException());
            }
        });

    }
    */
        ListView listView = (ListView) findViewById(R.id.ListView);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("incident");
        mAdapter = new FirebaseListAdapter<Incident>(this, Incident.class, android.R.layout.two_line_list_item, ref) {

            @Override
            protected void populateView(View view, Incident model, int position) {
                ((TextView)view.findViewById(android.R.id.text1)).setText(model.getTitle());
                ((TextView)view.findViewById(android.R.id.text2)).setText(model.getDesc());
                // Log.d("appmap", "Populating " + model.getTitle());
            }
        };
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = ((Incident)parent.getItemAtPosition(position)).getHumanDate();
                Snackbar.make(view, "Posted on " + value, Snackbar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //mAdapter.cleanup();
    }


}
