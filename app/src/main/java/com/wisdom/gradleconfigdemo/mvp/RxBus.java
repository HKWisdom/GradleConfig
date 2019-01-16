package com.wisdom.gradleconfigdemo.mvp;

/**
 * Created by hukun on 2018/1/18.
 */


import android.support.annotation.NonNull;

import com.wisdom.gradleconfigdemo.utils.LogUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/**
 * 用Rxjava实现的RxBus
 */
public class RxBus {

    //线程安全，效率更高
    @SuppressWarnings({"rawtypes"})
    private ConcurrentHashMap<Object,List<Subject>> mSubjectHashMap = new ConcurrentHashMap<>();

    private RxBus() {

    }

    private static class Instance {
        public static final RxBus instance = new RxBus();
    }

    public static RxBus getInstance() {
        return Instance.instance;
    }

    /**
     * register event
     * @param tag
     * @param <T>
     * @return
     */
    @SuppressWarnings({"rawtypes"})
    public <T> Observable<T> register(Object tag) {
        List<Subject> subjects = mSubjectHashMap.get(tag);
        if (subjects == null) {
            subjects = new ArrayList<>();
            mSubjectHashMap.put(tag,subjects);
        }
        Subject<T,T> subject;
        subjects.add(subject = PublishSubject.create());
        return subject;
    }

    /**
     * 取消监听
     *
     * @param tag
     * @param observable
     * @return
     */
    @SuppressWarnings("rawtypes")
    public RxBus unregister(@NonNull Object tag,
                            @NonNull Observable<?> observable) {
        if (null == observable)
            return getInstance();
        List<Subject> subjects = mSubjectHashMap.get(tag);
        if (null != subjects) {
            subjects.remove((Subject<?, ?>) observable);
            if (isEmpty(subjects)) {
                mSubjectHashMap.remove(tag);
                LogUtil.d("unregister"+ tag + "  size:" + subjects.size());
            }
        }
        return getInstance();
    }

    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Collection<Subject> collection) {
        return null == collection || collection.isEmpty();
    }

    public void post(@NonNull Object content) {
        post(content.getClass().getName(), content);
    }

    /**
     * 触发事件
     *
     * @param content
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void post(@NonNull Object tag, @NonNull Object content) {
        LogUtil.d("post"+ "eventName: " + tag);
        List<Subject> subjectList = mSubjectHashMap.get(tag);
        if (!isEmpty(subjectList)) {
            for (Subject subject : subjectList) {
                subject.onNext(content);
                LogUtil.d("onEvent"+ "eventName: " + tag);
            }
        }
    }

}
