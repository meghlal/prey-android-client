/*******************************************************************************
 * Created by Orlando Aliaga
 * Copyright 2015 Prey Inc. All rights reserved.
 * License: GPLv3
 * Full license at "/LICENSE"
 ******************************************************************************/
package com.prey.managers;

import android.content.Context;
import android.telephony.TelephonyManager;

import com.prey.PreyPhone;

public class PreyTelephonyManager {


    private Context ctx;
    private static PreyTelephonyManager _instance = null;

    private PreyTelephonyManager(Context ctx) {
        this.ctx=ctx;
    }

    public static PreyTelephonyManager getInstance(Context ctx) {
        if (_instance == null)
            _instance = new PreyTelephonyManager(ctx);
        return _instance;
    }

    public boolean isDataConnectivityEnabled(){
        return new PreyPhone(ctx).getDataState()==TelephonyManager.DATA_CONNECTED;
    }

    public int getSimState(){
        return new PreyPhone(ctx).getSimState();
    }

    public boolean isSimStateAbsent(){
        return getSimState()==TelephonyManager.SIM_STATE_ABSENT;
    }

    public boolean isSimStateReady(){
        return getSimState()==TelephonyManager.SIM_STATE_READY;
    }


    public String getLine1Number(){
        return new PreyPhone(ctx).getLine1Number();

    }


}

