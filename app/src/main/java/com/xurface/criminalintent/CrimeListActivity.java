package com.xurface.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.xurface.Extras.SingleFragmentActivity;
import com.xurface.criminalintent.Fragments.CrimeListFragment;

/**
 * Created by luisoscategui on 5/1/15.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
