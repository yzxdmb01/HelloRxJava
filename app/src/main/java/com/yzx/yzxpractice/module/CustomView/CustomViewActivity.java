package com.yzx.yzxpractice.module.CustomView;

import android.widget.Button;

import com.jakewharton.rxbinding.view.RxView;
import com.yzx.yzxpractice.R;
import com.yzx.yzxpractice.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.PieChartView;
import rx.functions.Action1;

/**
 * Created by Administrator on 2017/3/8.
 */

public class CustomViewActivity extends BaseActivity {
    @BindView(R.id.chart)
    public PieChartView chartView;
    @BindView(R.id.btn_start_animation)
    public Button btnStart;
    private PieChartData data;

    private boolean hasLabels = false;
    private boolean hasLabelsOutside = false;
    private String[] labels = {"其他", "感染", "骨损伤", "韧带", "关节", "肌肉"};


    @Override
    protected void initView() {
        generateData();

        RxView.clicks(btnStart).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                toggleLabelsOutside();
                prepareDataAnimation();
                chartView.startDataAnimation();
            }
        });

    }

    private void toggleLabelsOutside() {
        // has labels have to be true:P
        hasLabelsOutside = !hasLabelsOutside;
        if (hasLabelsOutside) {
            hasLabels = true;
//            hasLabelForSelected = false;
//            chart.setValueSelectionEnabled(hasLabelForSelected);
        }

        if (hasLabelsOutside) {
            chartView.setCircleFillRatio(0.7f);
        } else {
            chartView.setCircleFillRatio(1.0f);
        }

        generateData();

    }

    private void generateData() {
        List<SliceValue> values = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            SliceValue sliceValue = new SliceValue((float) Math.random() * 30 + 15, ChartUtils.pickColor());
            sliceValue.setLabel(labels[i]);
            values.add(sliceValue);
        }
        data = new PieChartData(values);
        data.setHasLabels(hasLabels);
        data.setHasLabelsOutside(hasLabelsOutside);
        chartView.setPieChartData(data);
    }

    private void prepareDataAnimation() {
        for (SliceValue value : data.getValues()) {
            value.setTarget((float) Math.random() * 30 + 15);
        }
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_custom_view;
    }
}

