package com.yzx.yzxpractice.base;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Description：
 * Created by yzx on 2017/3/17.
 */

public class RxBus {
    private static volatile RxBus mInstance;
    private final Subject<Object, Object> bus;       //不知道干什么用的

    //PublishSubject 只会把在订阅发生的时间点之后来自原始Observable的数据源发射给观察者
    public RxBus() {
        bus = new SerializedSubject<>(PublishSubject.create());
    }

    //单例RxBus
    public static RxBus getInstance() {
        if (mInstance == null) {
            synchronized (RxBus.class) {
                if (mInstance == null) {
                    mInstance = new RxBus();
                }
            }
        }
        return mInstance;
    }

    //发送一个事件
    public void post(Object o) {
        bus.onNext(o);
    }
    //根据传递的EventType 类型返回特定类型(EventType)的被观察者
    public <T> Observable<T> toObservable(Class<T> eventType){
        return bus.ofType(eventType);
    }

}
