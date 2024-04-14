//
//  Connect SDK Sample App by LG Electronics
//
//  To the extent possible under law, the person who associated CC0 with
//  this sample app has waived all copyright and related or neighboring rights
//  to the sample app.
//
//  You should have received a copy of the CC0 legalcode along with this
//  work. If not, see http://creativecommons.org/publicdomain/zero/1.0/.
//

package com.connectsdk.sampler.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.connectsdk.sampler.R;
import com.connectsdk.sampler.util.TestResponseObject;
import com.connectsdk.service.capability.KeyControl;


public class MyFragment extends BaseFragment {
    public Button okButton;
    public Button upButton;
    public Button downButton;
    public Button leftButton;
    public Button rightButton;
    static boolean isLaunched = false;


    public MyFragment() {};

    public MyFragment(Context context)
    {
        super(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setRetainInstance(true);
        View rootView = inflater.inflate(
                R.layout.fragment_my, container, false);

        okButton = (Button) rootView.findViewById(R.id.okButton);
        leftButton = (Button) rootView.findViewById(R.id.leftButton);
        rightButton = (Button) rootView.findViewById(R.id.rightButton);
        upButton = (Button) rootView.findViewById(R.id.upButton);
        downButton = (Button) rootView.findViewById(R.id.downButton);
        return rootView;
    }

    @Override
    public void enableButtons() {
        super.enableButtons();

        if (getMouseControl() != null) {
            getMouseControl().connectMouse();
        }

        if (getTv().hasCapability(KeyControl.Up)) {
            upButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getKeyControl() != null) {
                        getKeyControl().up(null);
                    }
                }
            });
        }

        if (getTv().hasCapability(KeyControl.Left)) {
            leftButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getKeyControl() != null) {
                        getKeyControl().left(null);
                    }
                }
            });
        }

        if (getTv().hasCapability(KeyControl.OK)) {
            okButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getKeyControl() != null) {
                        getKeyControl().ok(null);
                    }
                }
            });
        }

        if (getTv().hasCapability(KeyControl.Right)) {
            rightButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getKeyControl() != null) {
                        getKeyControl().right(null);
                    }
                }
            });
        }

        if (getTv().hasCapability(KeyControl.Down)) {
            downButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getKeyControl() != null) {
                        getKeyControl().down(null);
                    }
                }
            });
        }

        okButton.setEnabled(true);
        leftButton.setEnabled(true);
        rightButton.setEnabled(true);
        upButton.setEnabled(true);
        downButton.setEnabled(true);
    }


    @Override
    public void disableButtons() {
        super.disableButtons();
        isLaunched = false;
    }
}