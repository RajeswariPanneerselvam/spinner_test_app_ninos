package com.app.spinnertestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner country_spinner, state_spinner, city_spinner;
    TextView spinner_result_text;
    String str;
    String country, state, city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        country_spinner = findViewById(R.id.country_spinner);
        state_spinner = findViewById(R.id.state_spinner);
        city_spinner = findViewById(R.id.city_spinner);
        spinner_result_text = findViewById(R.id.text_result);

        str = "~IN*TN>CHENNAI>MADURAI>KOVAI>ERODE*AP>ONGOLE>TENALI>VIZAG*TS>HYDERABAD>WARANG\n" +
                "AL>VIKARABAD~USA*ALASKA>JUNEAU>SITKA>KENAI~CHINA*HAINAN>HAIKOU>SANYA>DONGFANG*\n" +
                "HUNAN>CHANGHSA>YUEYANG>CHANGDE";

        country_spinner.setOnItemSelectedListener(this);
        city_spinner.setOnItemSelectedListener(this);
        state_spinner.setOnItemSelectedListener(this);
    }


    private String getColoredSpanned(String text, int color) {
        String input = "<font color=" + color + ">" + text + "</font>";
        return input;
    }





    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long L) {
        country = String.valueOf(country_spinner.getSelectedItem());
        state = String.valueOf(state_spinner.getSelectedItem());
        city = String.valueOf(city_spinner.getSelectedItem());


        int id = parent.getId();

        if (id == country_spinner.getId()) {
            if (country.contentEquals("IN")) {
                List<String> list = new ArrayList<String>();
                list.add("TN");
                list.add("AP");
                list.add("TS");
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, list);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dataAdapter.notifyDataSetChanged();
                state_spinner.setAdapter(dataAdapter);


            }


            if (country.contentEquals("USA")) {
                List<String> list = new ArrayList<String>();
                list.add("ALASKA");

                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, list);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dataAdapter.notifyDataSetChanged();
                state_spinner.setAdapter(dataAdapter);


            }
            if (country.contentEquals("CHINA")) {
                List<String> list = new ArrayList<String>();
                list.add("HAINAN");
                list.add("HUNAN");

                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, list);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dataAdapter.notifyDataSetChanged();
                state_spinner.setAdapter(dataAdapter);


            }
        }
       else if (id == state_spinner.getId()) {

            if (state.contentEquals("TN")) {
                List<String> list1 = new ArrayList<String>();
                list1.add("CHENNAI");
                list1.add("MADHURAI");
                list1.add("KOVAI");
                list1.add("ERODE");
                ArrayAdapter<String> tnAdapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, list1);
                tnAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                tnAdapter.notifyDataSetChanged();
                city_spinner.setAdapter(tnAdapter);
            } else if (state.contentEquals("AP")) {
                List<String> list2 = new ArrayList<String>();
                list2.add("ONGOLE");
                list2.add("TENALI");
                list2.add("VIZAG");
                ArrayAdapter<String> apAdapter1 = new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, list2);
                apAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                apAdapter1.notifyDataSetChanged();
                city_spinner.setAdapter(apAdapter1);
            } else if (state.contentEquals("TS")) {
                List<String> list3 = new ArrayList<String>();
                list3.add("HYDERABAD");
                list3.add("WARANGAL");
                list3.add("VIKRABAD");
                ArrayAdapter<String> tsAdapter1 = new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, list3);
                tsAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                tsAdapter1.notifyDataSetChanged();
                city_spinner.setAdapter(tsAdapter1);
            } else if (state.contentEquals("ALASKA")) {
                List<String> list4 = new ArrayList<String>();

                list4.add("JUNEAU");
                list4.add("SITKA");
                list4.add("KENAI");

                ArrayAdapter<String> dataAdapterA = new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, list4);
                dataAdapterA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dataAdapterA.notifyDataSetChanged();
                city_spinner.setAdapter(dataAdapterA);
            } else if (state.contentEquals("HAINAN")) {
                List<String> list5 = new ArrayList<String>();

                list5.add("HAIKOU");
                list5.add("SANYA");
                list5.add("DONGFANG");

                ArrayAdapter<String> dataAdapterH = new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, list5);
                dataAdapterH.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dataAdapterH.notifyDataSetChanged();
                city_spinner.setAdapter(dataAdapterH);
            } else if (state.contentEquals("HUNAN")) {
                List<String> list6 = new ArrayList<String>();

                list6.add("CHANGHSA");
                list6.add("YUEYANG");
                list6.add("CHANGDE");

                ArrayAdapter<String> dataAdapterHU = new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, list6);
                dataAdapterHU.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                dataAdapterHU.notifyDataSetChanged();
                city_spinner.setAdapter(dataAdapterHU);
            }
        }
        else if (id == city_spinner.getId()) {

        }


        String selected_country = getColoredSpanned(country, R.color.red);
        String selected_state = getColoredSpanned(state, R.color.green);
        String selected_city = getColoredSpanned(city, R.color.purple_500);

        spinner_result_text.setText(Html.fromHtml(selected_country + "->" + selected_state + "->" + selected_city));

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}