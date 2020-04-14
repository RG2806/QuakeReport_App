package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.util.List;

public class earthquakeAdapter extends ArrayAdapter<earthquake> {

    public earthquakeAdapter(Context context, List<earthquake> objects) {
        super(context, 0, objects);

    }
    private static final String LOCATION_SEPARATOR = " of ";
    DecimalFormat formatter = new DecimalFormat("0.0");



    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        View listItemView=convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        earthquake current=getItem(position);
        TextView first =(TextView) listItemView.findViewById(R.id.mag);
        first.setText( formatter.format(current.getmMag()));
        String originalLocation = current.getmLocation();
        String primaryLocation;
        String locationOffset;
        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }
        TextView second =(TextView) listItemView.findViewById(R.id.location_offset);
        second.setText(locationOffset);
        TextView fifth =(TextView) listItemView.findViewById(R.id.primary_location);
        fifth.setText(primaryLocation);
        TextView third =(TextView) listItemView.findViewById(R.id.date);
        third.setText( current.getmDate());
        TextView fourth =(TextView) listItemView.findViewById(R.id.time);
        fourth.setText( current.getmTime());
        GradientDrawable magnitudeCircle = (GradientDrawable) first.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(current.getmMag());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        return  listItemView;
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}