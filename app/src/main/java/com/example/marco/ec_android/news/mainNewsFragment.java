package com.example.marco.ec_android.news;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.marco.ec_android.service.serviceInformationFragment;
import com.example.marco.ec_android.R;
import com.trello.rxlifecycle.components.RxFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class mainNewsFragment extends RxFragment {

    TextView service01 ;
    TextView service02 ;
    TextView service03 ;
    TextView service04 ;
    TextView service05 ;
    private FragmentManager mFragmentManager;


    private OnFragmentInteractionListener listener;

    public static mainNewsFragment newInstance() {
        return new mainNewsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_index, container, false);
        ButterKnife.bind(this, v);
        service01 = (TextView) v.findViewById(R.id.service01);
        service02 = (TextView) v.findViewById(R.id.service02);
        service03 = (TextView) v.findViewById(R.id.service03);
        service04 = (TextView) v.findViewById(R.id.service04);
        service05 = (TextView) v.findViewById(R.id.service05);
        service01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RxFragment fragment = null;

                System.out.println("按下1:");
//                fragment = (RxFragment) mFragmentManager.findFragmentByTag(serviceInformationFragment.class.getSimpleName());

                fragment = serviceInformationFragment.newInstance();


                if (fragment != null && mFragmentManager != null) {
                    System.out.println("按下:4");
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frame_layout, fragment);
                    fragmentTransaction.commit();
                } else {
                    System.out.println("按下:5");
                    mFragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frame_layout, serviceInformationFragment.newInstance());
                    fragmentTransaction.commit();
                }
            }
        });
        service02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("按下1:" +v.getTag());
            }
        });
        service03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("按下1:" +v.getTag());
            }
        });
        service04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("按下1:" +v.getTag());
            }
        });
        service05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("按下1:" +v.getTag());
            }
        });
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick({R.id.service01, R.id.service02, R.id.service03, R.id.service04, R.id.service05})
    public void myTextViewClick(TextView view) {
        System.out.println("按下:" +view);
    }

    public interface OnFragmentInteractionListener {
    }
}

