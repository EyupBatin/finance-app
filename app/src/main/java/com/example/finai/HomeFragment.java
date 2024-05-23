package com.example.finai;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import androidx.fragment.app.Fragment;

import com.example.finai.DataBaseHelper;
import com.example.finai.R;

public class HomeFragment extends Fragment {

    private DataBaseHelper dbHelper;
    private SimpleCursorAdapter adapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("HomeFragment", "onCreateView() called");
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        ListView listView = rootView.findViewById(R.id.listView);

        dbHelper = new DataBaseHelper(getActivity());
        Cursor cursor = dbHelper.getAllData();

        String[] fromColumns = {"column1", "column2", "column3"}; // Veritabanı sütun adları
        int[] toViews = {R.id.textView1, R.id.textView2, R.id.textView3}; // TextView'lerin ID'leri

        adapter = new SimpleCursorAdapter(getActivity(), R.layout.list_item, cursor, fromColumns, toViews, 0);
        listView.setAdapter(adapter);

        return rootView;
    }
}
