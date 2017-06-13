package com.example.apprenti.quetegeoloc;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Color;
import android.provider.ContactsContract;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


/**
 * Created by apprenti on 11/05/17.
 */

public class WeatherAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<List> mForecastModelList;

    public WeatherAdapter (Context context, ArrayList<List> forecastModelList){
        mContext = context;
        mForecastModelList = forecastModelList;
    }

    @Override
    public int getCount() {
        return mForecastModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return mForecastModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).
                    inflate(R.layout.weather_item, parent, false);
        }

        List currentModel = (List)getItem(position);
        double cTemp = currentModel.getMain().getTemp()-273.15;
        String weather = currentModel.getWeather().get(0).getDescription();


        TextView textViewDate = (TextView)convertView.findViewById(R.id.textViewDate);
        TextView textViewTemp = (TextView)convertView.findViewById(R.id.textViewTemp);
        TextView textViewWeather = (TextView)convertView.findViewById(R.id.textViewWeather);


        textViewDate.setText(getDate(currentModel.getDt(),"dd/MM/yyyy HH:mm "));
        textViewTemp.setText(String.valueOf((int)(cTemp)+ " Degrès"));
        textViewWeather.setText(currentModel.getWeather().get(0).getDescription());


        return convertView;
    }

    public static String getDate(long milliSeconds, String dateFormat) {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds*1000);
        return formatter.format(calendar.getTime());
    }
}