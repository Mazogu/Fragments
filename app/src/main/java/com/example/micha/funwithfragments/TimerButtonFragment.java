package com.example.micha.funwithfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class TimerButtonFragment extends Fragment {


    public TimerButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_timer_button, container, false);
    }

    public  void doTimer(View view){
        if (view.getId() == R.id.timerStart) {

        }

        else if (view.getId() == R.id.timerStop) {

        }
    }
}
