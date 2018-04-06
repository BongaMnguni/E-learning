package com.elearning.e_learning.Interactive;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import com.elearning.e_learning.AssessmentSupports.AssessmentSupportResults;
import com.elearning.e_learning.Config;
import com.elearning.e_learning.ElitDigital.ElitsDigitalResults;
import com.elearning.e_learning.InteractiveMaterial;
import com.elearning.e_learning.MainActivity;
import com.elearning.e_learning.R;
import com.elearning.e_learning.RequestHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InteractiveResults extends AppCompatActivity {

    private String JSON_STRING;

    private String Rsubject;
    private String Rgrade;
    private String Rphase;
    private String Rcategory;
    private String Rfile;

    private String subject;
    private String grade;
    private String phase;
    private String category;
    private String file;

    LinearLayoutManager linearlayout;
    RecyclerView recyclerView;
    InteractiveAdapter interactiveAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interactive_results);
        getSupportActionBar().setTitle("Interactive Material");

        recyclerView = (RecyclerView)findViewById(R.id.listMessage);
        linearlayout = new LinearLayoutManager(this.getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearlayout);

        getJSON();

        Bundle bundle = getIntent().getExtras();
        Rsubject = bundle.getString("subject");
        Rgrade = bundle.getString("grade");
        Rphase = bundle.getString("level");
        Rcategory = bundle.getString("category");
        Rfile = bundle.getString("file");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_back) {
            startActivity(new Intent(this,InteractiveMaterial.class));
            return true;
        }

      /*  if (id == R.id.action_search) {

            AlertDialog dialog;
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(InteractiveResults.this);
            View mView = getLayoutInflater().inflate(R.layout.search_dialog, null);


            final EditText search = (EditText)mView.findViewById(R.id.etSearch);
            ImageView sendButton = (ImageView)mView.findViewById(R.id.sendButton);
            sendButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ShowResult(search.getText().toString().trim());

                }
            });


            mBuilder.setView(mView);
            dialog = mBuilder.create();
            dialog.show();
            dialog.setCancelable(true);
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }
    private void Search(String grade){

        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        List<InteractiveItems> arrList = new ArrayList<InteractiveItems>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Config.TAG_JSON_ARRAY);

            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);

                        if(jo.getString(Config.TAG_MESSAGE_GRADE).contains(grade) || jo.getString(Config.TAG_MESSAGE_SUBJECT).contains(grade)
                                || jo.getString(Config.TAG_MESSAGE_FILE).contains(grade)){

                            file = "http://kznfunda.kzndoe.gov.za/curriculumsupportmaterial/learning/"+jo.getString(Config.TAG_MESSAGE_FILE);
                            grade = jo.getString(Config.TAG_MESSAGE_GRADE);
                            subject = jo.getString(Config.TAG_MESSAGE_SUBJECT);
                            category = jo.getString(Config.TAG_MESSAGE_CATEGORY);
                            phase = jo.getString(Config.TAG_MESSAGE_PHASE);

                            HashMap<String,String> Tenants = new HashMap<>();

                            Tenants.put(Config.TAG_MESSAGE_FILE,file);
                            Tenants.put(Config.TAG_MESSAGE_GRADE,grade);
                            Tenants.put(Config.TAG_MESSAGE_SUBJECT,subject);
                            Tenants.put(Config.TAG_MESSAGE_CATEGORY,category);
                            Tenants.put(Config.TAG_MESSAGE_PHASE,phase);

                            list.add(Tenants);

                            arrList.add(new InteractiveItems(subject,grade,phase,category,file));

                        }

            }
            interactiveAdapter = new InteractiveAdapter(getApplicationContext(),arrList);
            recyclerView.setAdapter(interactiveAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    } private void showMessages(){

        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        List<InteractiveItems> arrList = new ArrayList<InteractiveItems>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Config.TAG_JSON_ARRAY);

            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);

                switch(Rcategory){

                    case "GET":
                        if(jo.getString(Config.TAG_MESSAGE_GRADE).equalsIgnoreCase(Rgrade) && jo.getString(Config.TAG_MESSAGE_SUBJECT).equalsIgnoreCase(Rsubject)
                                && jo.getString(Config.TAG_MESSAGE_CATEGORY).equalsIgnoreCase(Rcategory)  && jo.getString(Config.TAG_MESSAGE_PHASE).equalsIgnoreCase(Rphase)){

                            file = "http://kznfunda.kzndoe.gov.za/curriculumsupportmaterial/learning/"+jo.getString(Config.TAG_MESSAGE_FILE);
                            grade = jo.getString(Config.TAG_MESSAGE_GRADE);
                            subject = jo.getString(Config.TAG_MESSAGE_SUBJECT);
                            category = jo.getString(Config.TAG_MESSAGE_CATEGORY);
                            phase = jo.getString(Config.TAG_MESSAGE_PHASE);

                            HashMap<String,String> Tenants = new HashMap<>();

                            Tenants.put(Config.TAG_MESSAGE_FILE,file);
                            Tenants.put(Config.TAG_MESSAGE_GRADE,grade);
                            Tenants.put(Config.TAG_MESSAGE_SUBJECT,subject);
                            Tenants.put(Config.TAG_MESSAGE_CATEGORY,category);
                            Tenants.put(Config.TAG_MESSAGE_PHASE,phase);

                            list.add(Tenants);

                            arrList.add(new InteractiveItems(subject,grade,phase,category,file));

                        }
                    break;

                    case "FET":
                        if(jo.getString(Config.TAG_MESSAGE_GRADE).equals(Rgrade) && jo.getString(Config.TAG_MESSAGE_SUBJECT).equals(Rsubject)
                                && jo.getString(Config.TAG_MESSAGE_CATEGORY).equals(Rcategory)){

                            file = "http://kznfunda.kzndoe.gov.za/curriculumsupportmaterial/learning/"+jo.getString(Config.TAG_MESSAGE_FILE);
                            grade = jo.getString(Config.TAG_MESSAGE_GRADE);
                            subject = jo.getString(Config.TAG_MESSAGE_SUBJECT);
                            category = jo.getString(Config.TAG_MESSAGE_CATEGORY);
                            phase = jo.getString(Config.TAG_MESSAGE_PHASE);

                            HashMap<String,String> Tenants = new HashMap<>();

                            Tenants.put(Config.TAG_MESSAGE_FILE,file);
                            Tenants.put(Config.TAG_MESSAGE_GRADE,grade);
                            Tenants.put(Config.TAG_MESSAGE_SUBJECT,subject);
                            Tenants.put(Config.TAG_MESSAGE_CATEGORY,category);
                            Tenants.put(Config.TAG_MESSAGE_PHASE,phase);

                            list.add(Tenants);

                            arrList.add(new InteractiveItems(subject,grade,phase,category,file));

                        }
                        break;
                }

            }
            interactiveAdapter = new InteractiveAdapter(getApplicationContext(),arrList);
            recyclerView.setAdapter(interactiveAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(InteractiveResults.this,"Loading In Progress"," Please Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showMessages();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(Config.URL_GET_ALL_MESSAGES);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }
    public void ShowResult(final String grade){

        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(InteractiveResults.this,"Loading In Progress"," Please Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                Search(grade);

            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(Config.URL_GET_ALL_MESSAGES);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }

}
