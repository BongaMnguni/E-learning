package com.elearning.e_learning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.elearning.e_learning.ElitDigital.ElitsDigitalResults;

import java.util.ArrayList;
import java.util.List;

public class ElitsDigitals extends AppCompatActivity {

    LinearLayout linearLayoutGrade,linearLayoutSubject,linearLayoutLevel,linearLayoutLevelDifficulty,linearLayoutLevelLanguage;
    Spinner spinnerCategory,spinnerLevel,spinnerGrade,spinnerFETsubject,spinnerFETbootype,spinnerFETLtype,spinnerFETLanguagetype;
    private String category,level,grade,subject,booktype,difficulty,language;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elits_digitals);
        getSupportActionBar().setTitle("Elits Digital Material");

        linearLayoutGrade = (LinearLayout)findViewById(R.id.grade_layout_elit_digital);
        linearLayoutSubject = (LinearLayout)findViewById(R.id.subject_layout_elit_digital_csubject);
        linearLayoutLevel = (LinearLayout)findViewById(R.id.level_layout_elit_digital);
        linearLayoutLevel = (LinearLayout)findViewById(R.id.level_layout_elit_digital);
        linearLayoutLevelLanguage = (LinearLayout)findViewById(R.id.subject_layout_elit_digital_language);

        linearLayoutLevelDifficulty = (LinearLayout)findViewById(R.id.subject_layout_elit_digital_difficult);

        spinnerCategory = (Spinner)findViewById(R.id.spinner_category_elit_digital);
        spinnerLevel = (Spinner)findViewById(R.id.spinner_level_elit_digital);
        spinnerFETsubject = (Spinner)findViewById(R.id.spinner_FETsubject_elit_digital);
        spinnerFETbootype = (Spinner)findViewById(R.id.spinner_serchvide_booktype_elit_digital);
        spinnerFETLanguagetype = (Spinner)findViewById(R.id.spinner_FETsubject_elit_digital_language);

        spinnerGrade = (Spinner)findViewById(R.id.spinner_serchvide_grade_elit_digital);
        spinnerFETLtype = (Spinner)findViewById(R.id.spinner_FETsubject_elit_digital_difficult);
        button = (Button) findViewById(R.id.btnsearch_elit_digital);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ElitsDigitals.this,ElitsDigitalResults.class);
                intent.putExtra("category",category);
                intent.putExtra("level",level);
                intent.putExtra("grade",grade);
                intent.putExtra("subject",subject);
                intent.putExtra("booktype",booktype);
                intent.putExtra("difficulty",difficulty);
                startActivity(intent);
            }
        });

        spinnerFETLtype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                difficulty = spinnerFETLtype.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        spinnerFETLanguagetype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                subject = spinnerFETLanguagetype.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                category = spinnerCategory.getSelectedItem().toString();
                visible();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        spinnerLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                level = spinnerLevel.getSelectedItem().toString();
                check_mate(level);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

    }

    public void visible(){

        List<String> BTArray =  new ArrayList<String>();
        BTArray.add("Select");
        BTArray.add("Fiction");
        BTArray.add("Non-Fiction");

        ArrayAdapter<String> BTadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, BTArray);
        BTadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFETbootype.setAdapter(BTadapter);

        spinnerFETbootype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                booktype = spinnerFETbootype.getSelectedItem().toString();
                if(booktype.equals("Fiction")){
                    linearLayoutLevelDifficulty.setVisibility(View.VISIBLE);
                    linearLayoutLevelLanguage.setVisibility(View.VISIBLE);
                    linearLayoutSubject.setVisibility(View.GONE);
                    linearLayoutGrade.setVisibility(View.GONE);

                    grade="None";

                }
                if(booktype.equals("Non-Fiction")){
                    linearLayoutLevelDifficulty.setVisibility(View.GONE);
                    linearLayoutLevelLanguage.setVisibility(View.GONE);
                    linearLayoutSubject.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        if(category.equals("FET")){
            linearLayoutGrade.setVisibility(View.VISIBLE);

            spinnerFETsubject.setVisibility(View.VISIBLE);
            linearLayoutLevel.setVisibility(View.GONE);

            List<String> FETArray =  new ArrayList<String>();
            FETArray.add("-Select Grade-");
            FETArray.add("Grade 10");
            FETArray.add("Grade 11");
            FETArray.add("Grade 12");
            FETArray.add("All Grades");

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, FETArray);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerGrade.setAdapter(adapter);

            spinnerGrade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                    grade = spinnerGrade.getSelectedItem().toString();

                }
                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                }
            });

            List<String> Grade2Array =  new ArrayList<String>();
            Grade2Array.add("-Select Subject-");
            Grade2Array.add("Mathematics");
            Grade2Array.add("Mathematical Literacy");
            Grade2Array.add("Physical Science");
            Grade2Array.add("Life Science");
            Grade2Array.add("Geography");
            Grade2Array.add("Business Studies");
            Grade2Array.add("Economics");
            Grade2Array.add("Accounting");

            ArrayAdapter<String> Grade2adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Grade2Array);
            Grade2adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerFETsubject.setAdapter(Grade2adapter);

            spinnerFETsubject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                    subject = spinnerFETsubject.getSelectedItem().toString();
                }
                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                }
            });

        }else
        if(category.equals("GET")){
            linearLayoutLevel.setVisibility(View.VISIBLE);
            linearLayoutGrade.setVisibility(View.VISIBLE);

            spinnerGrade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                    grade = spinnerGrade.getSelectedItem().toString();
                    check_grade(grade);

                }
                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                }
            });

            spinnerFETsubject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                    subject = spinnerFETsubject.getSelectedItem().toString();
                }
                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                }
            });
        }
    }

    private void check_mate(String db){
        switch (db){
            case "Senior":
                List<String> SeniorArray =  new ArrayList<String>();
                SeniorArray.add("-Select Grade-");
                SeniorArray.add("Grade 7");
                SeniorArray.add("Grade 8");
                SeniorArray.add("Grade 9");
                SeniorArray.add("All Grades");

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, SeniorArray);

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerGrade.setAdapter(adapter);
                break;

            case "Intermediate":
                List<String> IntermediateArray =  new ArrayList<String>();
                IntermediateArray.add("-Select Grade-");
                IntermediateArray.add("Grade 4");
                IntermediateArray.add("Grade 5");
                IntermediateArray.add("Grade 6");
                IntermediateArray.add("All Grades");
                ArrayAdapter<String> Intermediateadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, IntermediateArray);
                Intermediateadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerGrade.setAdapter(Intermediateadapter);
                break;

            case "Foundation":
                List<String> FoundationArray =  new ArrayList<String>();
                FoundationArray.add("-Select Grade-");
                FoundationArray.add("Grade R");
                FoundationArray.add("Grade 1");
                FoundationArray.add("Grade 2");
                FoundationArray.add("Grade 3");
                ArrayAdapter<String> Foundationadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, FoundationArray);
                Foundationadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
               spinnerGrade.setAdapter(Foundationadapter);
                break;
        }
    }

    private void check_grade(String db){
        switch (db){
            case "Grade R":
                List<String> SeniorArray =  new ArrayList<String>();
                SeniorArray.add("-Select Subject-");
                SeniorArray.add("Mathematics");
                SeniorArray.add("Life Skills");
                SeniorArray.add("Language");
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, SeniorArray);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerFETsubject.setAdapter(adapter);
                break;

            case "Grade 1":
                List<String> Grade1Array =  new ArrayList<String>();
                Grade1Array.add("-Select Subject-");
                Grade1Array.add("Mathematics");
                Grade1Array.add("Life Skills");
                Grade1Array.add("Language");
                ArrayAdapter<String> Grade1adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Grade1Array);
                Grade1adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerFETsubject.setAdapter(Grade1adapter);
                break;

            case "Grade 2":
                List<String> Grade2Array =  new ArrayList<String>();
                Grade2Array.add("-Select Subject-");
                Grade2Array.add("Mathematics");
                Grade2Array.add("Life Skills");
                Grade2Array.add("Language");
                ArrayAdapter<String> Grade2adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Grade2Array);
                Grade2adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerFETsubject.setAdapter(Grade2adapter);
                break;

            case "Grade 3":
                List<String> Grade3Array =  new ArrayList<String>();
                Grade3Array.add("-Select Subject-");
                Grade3Array.add("Mathematics");
                Grade3Array.add("Life Skills");
                Grade3Array.add("Language");
                ArrayAdapter<String> Grade3adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Grade3Array);
                Grade3adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerFETsubject.setAdapter(Grade3adapter);
                break;


            case "Grade 4":
                List<String> Grade4Array =  new ArrayList<String>();
                Grade4Array.add("-Select Subject-");
                Grade4Array.add("Mathematics");
                Grade4Array.add("Natural Science & Technology");
                Grade4Array.add("Social Science");
                Grade4Array.add("English");
                Grade4Array.add("IsiZulu");
                Grade4Array.add("Afrikaans");
                Grade4Array.add("Life Skills");
                ArrayAdapter<String> Grade4adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Grade4Array);
                Grade4adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerFETsubject.setAdapter(Grade4adapter);
                break;

            case "Grade 5":
                List<String> Grade5Array =  new ArrayList<String>();
                Grade5Array.add("-Select Subject-");
                Grade5Array.add("Mathematics");
                Grade5Array.add("Natural Science & Technology");
                Grade5Array.add("Social Science");
                Grade5Array.add("English");
                Grade5Array.add("IsiZulu");
                Grade5Array.add("Afrikaans");
                Grade5Array.add("Life Skills");
                ArrayAdapter<String> Grade5adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Grade5Array);
                Grade5adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerFETsubject.setAdapter(Grade5adapter);
                break;

            case "Grade 6":
                List<String> Grade6Array =  new ArrayList<String>();
                Grade6Array.add("-Select Subject-");
                Grade6Array.add("Mathematics");
                Grade6Array.add("Natural Science & Technology");
                Grade6Array.add("Social Science");
                Grade6Array.add("English");
                Grade6Array.add("IsiZulu");
                Grade6Array.add("Afrikaans");
                Grade6Array.add("Life Skills");
                ArrayAdapter<String> Grade6adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Grade6Array);
                Grade6adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerFETsubject.setAdapter(Grade6adapter);
                break;

            case "Grade 7":
                List<String> Grade7Array =  new ArrayList<String>();
                Grade7Array.add("-Select Subject-");
                Grade7Array.add("Mathematics");
                Grade7Array.add("Natural Science");
                Grade7Array.add("Social Science");
                Grade7Array.add("Life Orientation");
                Grade7Array.add("English");
                Grade7Array.add("IsiZulu");
                Grade7Array.add("Afrikaans");
                Grade7Array.add("Creative Arts");
                Grade7Array.add("Technology");
                Grade7Array.add("Economics Management Science");
                ArrayAdapter<String> Grade7dapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Grade7Array);
                Grade7dapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerFETsubject.setAdapter(Grade7dapter);
                break;


            case "Grade 8":
                List<String> Grade8Array =  new ArrayList<String>();
                Grade8Array.add("-Select Subject-");
                Grade8Array.add("Mathematics");
                Grade8Array.add("Natural Science");
                Grade8Array.add("Social Science");
                Grade8Array.add("Life Orientation");
                Grade8Array.add("English");
                Grade8Array.add("IsiZulu");
                Grade8Array.add("Afrikaans");
                Grade8Array.add("Creative Arts");
                Grade8Array.add("Technology");
                Grade8Array.add("Economics Management Science");
                ArrayAdapter<String> Grade8dapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Grade8Array);
                Grade8dapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerFETsubject.setAdapter(Grade8dapter);
                break;

            case "Grade 9":
                List<String> Grade9Array =  new ArrayList<String>();
                Grade9Array.add("-Select Subject-");
                Grade9Array.add("Mathematics");
                Grade9Array.add("Natural Science");
                Grade9Array.add("Social Science");
                Grade9Array.add("Life Orientation");
                Grade9Array.add("English");
                Grade9Array.add("IsiZulu");
                Grade9Array.add("Afrikaans");
                Grade9Array.add("Creative Arts");
                Grade9Array.add("Technology");
                Grade9Array.add("Economics Management Science");
                ArrayAdapter<String> Grade9dapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Grade9Array);
                Grade9dapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerFETsubject.setAdapter(Grade9dapter);
                break;
        }
    }
}