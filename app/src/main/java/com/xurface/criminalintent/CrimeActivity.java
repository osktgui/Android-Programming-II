package com.xurface.criminalintent;

import android.support.v4.app.Fragment;

import com.xurface.Extras.SingleFragmentActivity;
import com.xurface.criminalintent.Fragments.CrimeFragment;

import java.util.UUID;


public class CrimeActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        UUID crimeId = (UUID)getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);

        return CrimeFragment.newInstance(crimeId);
    }
}
