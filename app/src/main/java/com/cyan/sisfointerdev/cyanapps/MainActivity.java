package com.cyan.sisfointerdev.cyanapps;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_login) {
                Toast.makeText(this, "Only alumni can be loged in", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.activity_login, null);
                final EditText mEmail = (EditText) mView.findViewById(R.id.etEmail);
                final EditText mPassword = (EditText) mView.findViewById(R.id.etPassword);
                Button mLogin = (Button) mView.findViewById(R.id.buttonLogin);

                mLogin.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View view) {
                        if(!mEmail.getText().toString().isEmpty() && !mPassword.getText().toString().isEmpty()){
                            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Pleae fill any empty fields", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            return true;
        }
        else if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_ourAlumni) {
            Toast.makeText(this, "These are some of our alumni", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, OurAlumni.class);
            OurAlumni OurAlumni = new OurAlumni();
            startActivity(new Intent(MainActivity.this, OurAlumni.class));
        } else if (id == R.id.nav_jobVacancy) {
            Toast.makeText(this, "Alumni can give us job opportunity!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, JobVacancy.class);
            JobVacancy JobVacancy = new JobVacancy();
            startActivity(new Intent(MainActivity.this, JobVacancy.class));
        } else if (id == R.id.nav_internship) {
            Toast.makeText(this, "Alumni can give us internship program!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Internship.class);
            Internship Internship = new Internship();
            startActivity(new Intent(MainActivity.this, Internship.class));
        } else if (id == R.id.nav_project) {
            Toast.makeText(this, "Alumni can give us valuable project!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Project.class);
            Project Project = new Project();
            startActivity(new Intent(MainActivity.this, Project.class));
        } else if (id == R.id.nav_sponsorship) {
            Toast.makeText(this, "Alumni can give us sponsor for our event!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Sponsorship.class);
            Sponsorship Sponsorship = new Sponsorship();
            startActivity(new Intent(MainActivity.this, Sponsorship.class));
        } else if (id == R.id.nav_findAlumni) {
            Toast.makeText(this, "Find Alumni here", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, FindAlumni.class);
            FindAlumni FindAlumni = new FindAlumni();
            startActivity(new Intent(MainActivity.this, FindAlumni.class));
        } else if (id == R.id.nav_facebook) {
            String url = "https://www.facebook.com/groups/379635565413475/?fref=ts";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        } else if (id == R.id.nav_faq) {
            Toast.makeText(this, "Several Frequently asked questions", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Faq.class);
            Faq Faq = new Faq();
            startActivity(new Intent(MainActivity.this, Faq.class));
        } else if (id == R.id.nav_contactUs) {
            Toast.makeText(this, "Feel free to contact us!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ContactUs.class);
            ContactUs ContactUs = new ContactUs();
            startActivity(new Intent(MainActivity.this, ContactUs.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
