package com.yzx.yzxpractice.module.Retrofit_RxJava;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding.view.RxView;
import com.yzx.yzxpractice.R;
import com.yzx.yzxpractice.base.BaseActivity;
import com.yzx.yzxpractice.module.Retrofit_RxJava.model.Course;
import com.yzx.yzxpractice.module.Retrofit_RxJava.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/3/9.
 */

public class RetrofitRxJavaActivity extends BaseActivity {
    @BindView(R.id.tv_console)
    protected TextView tvConsole;

    @BindView(R.id.iv_console)
    protected ImageView ivConsole;

//    @OnClick(R.id.btn_shoot)
//    protected void shootSth() {
////        final int drawableRes = R.drawable.ic_menu_camera;
//        testFlatMap();
//    }

    private void testFlatMap() {
        Course courseCh = new Course("ch");
        Course courseMath = new Course("math");
        Course courseEn = new Course("En");
        List<Course> courseListH = new ArrayList<>();
        courseListH.add(courseCh);
        List<Course> courseListM = new ArrayList<>();
        courseListM.add(courseCh);
        courseListM.add(courseEn);
        List<Course> courseListA = new ArrayList<>();
        courseListA.add(courseMath);
        final Student[] students = {new Student("小红", courseListH), new Student("小米", courseListM), new Student("ac", courseListA)};
        Observable.from(students)
                .flatMap(new Func1<Student, Observable<Course>>() {
                    @Override
                    public Observable<Course> call(Student student) {
                        return Observable.from(student.getCourseList());
                    }
                })
                .subscribe(new Action1<Course>() {
                    @Override
                    public void call(Course course) {
                        tvConsole.setText(tvConsole.getText() + "!!" + course.getName());
                    }
                });

    }

    private void testMap() {
        Observable.just(R.drawable.ic_menu_camera)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<Integer, Drawable>() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public Drawable call(Integer integer) {
                        return getDrawable(integer);
                    }
                })
                .subscribe(new Action1<Drawable>() {
                    @Override
                    public void call(Drawable drawable) {
                        ivConsole.setImageDrawable(drawable);
                    }
                });
    }

    @Override
    protected void initView() {
        Button button = (Button) findViewById(R.id.btn_shoot);
        RxView.clicks(button)
                .throttleFirst(3, TimeUnit.SECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        tvConsole.setText(tvConsole.getText()+"0");
                    }
                });
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_retrofit;
    }
}
