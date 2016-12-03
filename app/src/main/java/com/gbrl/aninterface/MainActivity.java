package com.gbrl.aninterface;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

  private FragmentManager fragmentManager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.setContentView(R.layout.activity_main);

    this.fragmentManager = MainActivity.this.getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.replace(R.id.fragment_container, new MainFragment());
    fragmentTransaction.commit();

    BottomNavigationView bottomNavigationView = (BottomNavigationView) this.findViewById(R.id.bottom_navigation);
    bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
      @Override
      public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Boolean switched = Boolean.FALSE;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (item.getItemId()) {
          case R.id.main_menu_home:
            Fragment mainFragment = new MainFragment();
            fragmentTransaction.replace(R.id.fragment_container, mainFragment);
            switched = Boolean.TRUE;
            break;
          case R.id.main_menu_camera:
            Fragment cameraFragment = new CameraFragment();
            fragmentTransaction.replace(R.id.fragment_container, cameraFragment);
            switched = Boolean.TRUE;
            break;
          case R.id.main_menu_profile:
            Fragment preferencesFragment = new PreferencesFragment();
            fragmentTransaction.replace(R.id.fragment_container, preferencesFragment);
            switched = Boolean.TRUE;
            break;
        }
        fragmentTransaction.commit();
        return switched;
      }
    });
  }
}
