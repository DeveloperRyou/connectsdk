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
import android.widget.TextView;

import com.connectsdk.sampler.R;


public class MyFragment extends BaseFragment {
    public Button myButton;

    private final static String WEBOSID = "webOS TV";
    private final static String CASTID = "Chromecast";
    private final static String MULTISCREENID = "MultiScreen";

    static boolean isLaunched = false;

    TextView responseMessageTextView;
    String webAppId = null;

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

        myButton = (Button) rootView.findViewById(R.id.myButton);

        return rootView;
    }

    @Override
    public void enableButtons() {
        super.enableButtons();

        myButton.setEnabled(getTv().hasCapability(null));
        myButton.setOnClickListener(myFunction);

        if (getTv().getServiceByName(WEBOSID) != null)
            webAppId = "SampleWebApp";
        else if (getTv().getServiceByName(CASTID) != null)
            webAppId = "DDCEDE96";
        else if (getTv().getServiceByName(MULTISCREENID) != null)
            webAppId = "ConnectSDKSampler";
    }

    public View.OnClickListener myFunction = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (webAppId == null)
                return;

            myButton.setEnabled(false);
/*
            getWebAppLauncher().launchWebApp(webAppId, new LaunchListener() {

                @Override
                public void onError(ServiceCommandError error) {
                    Log.e("LG", "Error connecting to web app | error = " + error);
                    myButton.setEnabled(true);
                }

                @Override
                public void onSuccess(WebAppSession webAppSession) {
                    return;
                }
            });
            */

        }
    };

    @Override
    public void disableButtons() {
        super.disableButtons();
        isLaunched = false;
        webAppId = null;
    }
}