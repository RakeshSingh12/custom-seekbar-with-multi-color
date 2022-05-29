package com.example.customseekbar;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button btnSeekTo;
    private CustomSeekBar seekbar;
    private EditText txtSeekProgress;
    private ToggleButton btnToogleSeek;

    private float totalSpan = 400;
    private float redSpan = 100;
    private float blueSpan = 100;
    private float greenSpan = 100;
    private float yellowSpan = 100;
    private float darkGreySpan;

    private ArrayList<ProgressItem> progressItemList;
    private ProgressItem mProgressItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekbar = ((CustomSeekBar) findViewById(R.id.seekBar0));
        btnSeekTo = ((Button) findViewById(R.id.btnSeekTo));
        btnToogleSeek = (ToggleButton) findViewById(R.id.btnToogleSeek);
        txtSeekProgress = (EditText) findViewById(R.id.txtSeekProgress);
        initDataToSeekbar();
        btnSeekTo.setOnClickListener(this);
        btnToogleSeek.setOnClickListener(this);
    }

    private void initDataToSeekbar() {
        progressItemList = new ArrayList<ProgressItem>();
        // red span
        mProgressItem = new ProgressItem();
        mProgressItem.progressItemPercentage = ((redSpan / totalSpan) * 100);
        Log.i("Mainactivity", mProgressItem.progressItemPercentage + "");
        mProgressItem.color = R.color.red;
        progressItemList.add(mProgressItem);
        // blue span
        mProgressItem = new ProgressItem();
        mProgressItem.progressItemPercentage = (blueSpan / totalSpan) * 100;
        mProgressItem.color = R.color.blue;
        progressItemList.add(mProgressItem);
        // green span
        mProgressItem = new ProgressItem();
        mProgressItem.progressItemPercentage = (greenSpan / totalSpan) * 100;
        mProgressItem.color = R.color.green;
        progressItemList.add(mProgressItem);
        // yellow span
        mProgressItem = new ProgressItem();
        mProgressItem.progressItemPercentage = (yellowSpan / totalSpan) * 100;
        mProgressItem.color = R.color.yellow;
        progressItemList.add(mProgressItem);
        // greyspan
        mProgressItem = new ProgressItem();
        mProgressItem.progressItemPercentage = (darkGreySpan / totalSpan) * 100;
        mProgressItem.color = R.color.grey;
        progressItemList.add(mProgressItem);

        seekbar.initData(progressItemList);
        seekbar.invalidate();
    }


    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        if (v.getId() == R.id.btnSeekTo) {
            String seekProgress = txtSeekProgress.getText().toString().trim();
            if (seekProgress.length() > 0) {
                seekbar.setProgress(Integer.valueOf(seekProgress));
            }
        } else {
            seekbar.setEnabled(btnToogleSeek.isChecked());
        }
    }
}
