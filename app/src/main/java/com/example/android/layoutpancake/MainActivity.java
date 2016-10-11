package com.example.android.layoutpancake;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    //Example layouts to display
    private static final String[] LIST_ITEMS = {
            "Simple Centered",
            "Simple List Item",
            "Centering Constraints",
            "Entry Form",
            "Weighted Vertical",
            "Ratios",
            "Any Size Ratios",
            "Animated Transition"
    };

    /*
    private static final int[] LAYOUT_IDS = {
            R.layout.layout_simple,
            R.layout.list_item_flat,
            R.layout.layout_center,
            R.layout.layout_form,
            R.layout.layout_weighted,
            R.layout.layout_ratios,
            R.layout.layout_ratios_any,
            R.layout.layout_transition_1
    };
    */

    private static final int[] LAYOUT_IDS = {
            R.layout.layout_simple_without_constraint,
            R.layout.list_item_flat_without_constraint,
            R.layout.layout_center_without_constraint,
            R.layout.layout_form_without_constraint,
            R.layout.layout_weighted_without_constraint,
            R.layout.layout_ratios,
            R.layout.layout_ratios_any,
            R.layout.layout_transition_1
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.list);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, LIST_ITEMS);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        if (LAYOUT_IDS[position] == R.layout.layout_transition_1) {
            Intent intent = new Intent(this, TransitionActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, LayoutDisplayActivity.class);
            intent.putExtra(Intent.EXTRA_TITLE, LIST_ITEMS[position]);
            intent.putExtra(LayoutDisplayActivity.EXTRA_LAYOUT_ID, LAYOUT_IDS[position]);

            startActivity(intent);
        }
    }
}
