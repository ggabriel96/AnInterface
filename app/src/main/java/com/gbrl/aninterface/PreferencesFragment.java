package com.gbrl.aninterface;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

public class PreferencesFragment extends PreferenceFragmentCompat {
  @Override
  public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
    // Load the preferences from an XML resource
    this.setPreferencesFromResource(R.xml.pref_general, rootKey);
  }
}
