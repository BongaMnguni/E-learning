package com.elearning.e_learning;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.text.Html;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    /////// Ads /////////
    HttpResponse httpResponse;
    JSONObject jsonObject = null ;
    String StringHolder = "" ;

    String HttpURL = "http://mydm.co.za/Elearning/RetrieveAds.php";

    Timer t ;
    TimerTask task ;
    //////////////////////
    ImageView imageView;
    TextView Heading,oper;
    ImageView adsClose;

    AlertDialog dialog1;

    private boolean fabExpanded = false;
    private FloatingActionButton fabSettings,fabFacebook,fabTwitter,fabInstagram,fabYoutube;
    private LinearLayout layoutFabFacebook,layoutFabTwitter,layoutFabInstagram,layoutFabYoutube;

    private TextView textViewSocail;

    boolean connected ;

    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    private ViewFlipper mViewFlipper;
    private Context mContext;
    private final GestureDetector detector = new GestureDetector(new MainActivity.SwipeGestureDetector());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
///////////////////////////////////////////////////////////// ADS  ///////////////////////////

         imageView = (ImageView)findViewById(R.id.adsimage);

        textViewSocail = (TextView)findViewById(R.id.tvSocail);
        adsClose = (ImageView)findViewById(R.id.adsclose);
        adsClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.GONE);
                adsClose.setVisibility(View.GONE);
            }
        });

        // load the ads from server

        t=new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {

                    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
                    @Override
                    public void run() {


                        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                            //we are connected to a network
                            new GetDataFromServerIntoTextView(MainActivity.this).execute();
                            connected = true;
                        }
                        else
                            connected = false;


                    }
                });
            }
        };

        t.scheduleAtFixedRate(task, 0, 7000);


///////////////////////////////////////////////////  END    /////////////////////////////////////////////////////////////////////
        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mContext = this;
        mViewFlipper = (ViewFlipper)findViewById(R.id.view_flipper);
        mViewFlipper.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(final View view, final MotionEvent event) {
                detector.onTouchEvent(event);
                return true;
            }
        });

        mViewFlipper.setAutoStart(true);
        mViewFlipper.setFlipInterval(4000);
        mViewFlipper.startFlipping();

               Heading = (TextView)findViewById(R.id.heading);
        Heading.setText(Html.fromHtml("<u color='#DAA520'>Welcome to KZN Department of Education e-Learning solution</u>"));

        oper = (TextView)findViewById(R.id.operation);
        oper.setText(Html.fromHtml("<u color='#DAA520'>Operation Phakisa:ICT in Education initiative</u>"));

       final String facebook = "https://www.facebook.com/dbekzn/";
       final String twitter = "https://twitter.com/DBE_KZN?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor";
       final String youtube = "https://www.youtube.com/channel/UCVG7AuGrgvdCD2FMebSkPIQ";
       final String instagram = "https://www.instagram.com/kzn_education/";

        fabFacebook = (FloatingActionButton) this.findViewById(R.id.fabFacebook);
        fabTwitter = (FloatingActionButton) this.findViewById(R.id.fabTwitter);
        fabInstagram = (FloatingActionButton) this.findViewById(R.id.fabInstagram);
        fabYoutube = (FloatingActionButton) this.findViewById(R.id.fabYoutube);

        fabFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(facebook));
                startActivity(browserIntent);
            }
        });

        fabTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(twitter));
                startActivity(browserIntent);
            }
        });

        fabInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(instagram));
                startActivity(browserIntent);
            }
        });

        fabYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(youtube));
                startActivity(browserIntent);
            }
        });

        fabSettings = (FloatingActionButton) this.findViewById(R.id.fabSetting);
        fabSettings.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                fabSettings.setVisibility(View.GONE);
                layoutFabFacebook.setVisibility(View.GONE);
                layoutFabTwitter.setVisibility(View.GONE);
                layoutFabInstagram.setVisibility(View.GONE);
                layoutFabYoutube.setVisibility(View.GONE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fabSettings.setVisibility(View.VISIBLE);
                    }
                }, 5000);

                return false;
            }
        });

        layoutFabFacebook = (LinearLayout) this.findViewById(R.id.layoutFabFacebook);
        layoutFabTwitter = (LinearLayout) this.findViewById(R.id.layoutFabTwitter);
        layoutFabInstagram = (LinearLayout) this.findViewById(R.id.layoutFabInstagram);
        layoutFabYoutube = (LinearLayout) this.findViewById(R.id.layoutFabYoutube);

        fabSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fabExpanded == true){
                    closeSubMenusFab();
                } else {
                    openSubMenusFab();
                }
            }
        });
        closeSubMenusFab();

    }

    private void closeSubMenusFab(){
        //textViewSocail.setVisibility(View.GONE);
        layoutFabFacebook.setVisibility(View.INVISIBLE);
        layoutFabTwitter.setVisibility(View.INVISIBLE);
        layoutFabInstagram.setVisibility(View.INVISIBLE);
        layoutFabYoutube.setVisibility(View.INVISIBLE);
        fabSettings.setImageResource(R.mipmap.ic_chat_white_24dp);
        fabExpanded = false;
    }

    //Opens FAB submenus
    private void openSubMenusFab(){
        textViewSocail.setVisibility(View.GONE);
        layoutFabFacebook.setVisibility(View.VISIBLE);
        layoutFabTwitter.setVisibility(View.VISIBLE);
        layoutFabInstagram.setVisibility(View.VISIBLE);
        layoutFabYoutube.setVisibility(View.VISIBLE);
        //Change settings icon to 'X' icon
        fabSettings.setImageResource(R.mipmap.ic_close_white_24dp);
        fabExpanded = true;
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
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        String url_website ="http://www.kzneducation.gov.za/";
        String url_qlinks ="http://kznfunda.kzndoe.gov.za/";

        if (id == R.id.nav_website) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url_website));
            startActivity(browserIntent);
        }

      /*else   if (id == R.id.nav_calender) {
           /*startActivity(new Intent(getApplicationContext(),Calender.class));
        }*/

        else if (id == R.id.nav_qlinks) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url_qlinks));
            startActivity(browserIntent);
        }

         else if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_support) {

            AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
            View mView = getLayoutInflater().inflate(R.layout.support_dialog, null);
            mBuilder.setView(mView);

            dialog1 = mBuilder.create();
            dialog1.show();

        }else if (id == R.id.nav_contact) {
            startActivity(new Intent(MainActivity.this,ContactUs.class));
        } else if (id == R.id.nav_exit) {

            android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setMessage(Html.fromHtml("<font color='#15713E'>Are you sure you want to exit?</font>"))
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {System.exit(0);
                        }
                    })
                    .setNegativeButton("No",
                            new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            android.support.v7.app.AlertDialog alert = builder.create();
            alert.show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void InteractiveMaterial (View view){
        startActivity(new Intent(MainActivity.this,InteractiveMaterial.class));
    }

    public void CurriculumVideos  (View view){
        startActivity(new Intent(MainActivity.this,CurriculumVideos.class));
    }

    public void AssessmentSupport (View view){
        startActivity(new Intent(MainActivity.this,AssessmentSupport.class));
    }
    public void Elits (View view){
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.elits_dialog, null);
        mBuilder.setView(mView);

        final AlertDialog dialog = mBuilder.create();
        dialog.show();
        dialog1.dismiss();
    }

    public void ElitVideos  (View view){
        startActivity(new Intent(MainActivity.this,ElitVideos.class));
    }
    public void ElitDigital(View view){
        startActivity(new Intent(MainActivity.this,ElitsDigitals.class));
    }

    class SwipeGestureDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            try {
                // right to left swipe
                if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(mContext, R.anim.left_in));
                    mViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(mContext, R.anim.left_out));
                    mViewFlipper.showNext();
                    return true;
                } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(mContext, R.anim.right_in));
                    mViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(mContext,R.anim.right_out));
                    mViewFlipper.showPrevious();
                    return true;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return false;
        }
    }
////////////////////////////////////////  ADVERTISEMENT  HERE //////////////////////////////////////////////////////////////////////////


    // Declaring GetDataFromServerIntoTextView method with AsyncTask.
    public class GetDataFromServerIntoTextView extends AsyncTask<Void, Void, Void>
    {
        // Declaring CONTEXT.
        public Context context;


        public GetDataFromServerIntoTextView(Context context)
        {
            this.context = context;
        }

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0)
        {

            HttpClient httpClient = new DefaultHttpClient();

            // Adding HttpURL to my HttpPost oject.
            HttpPost httpPost = new HttpPost(HttpURL);

            try {
                httpResponse = httpClient.execute(httpPost);

                StringHolder = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");

            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try{
                // Passing string holder variable to JSONArray.
                JSONArray jsonArray = new JSONArray(StringHolder);
                jsonObject = jsonArray.getJSONObject(0);


            } catch ( JSONException e) {
                e.printStackTrace();
            }

            catch (Exception e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            try {

                //Loading ads images into picaso and imageview

                //Picasso.with(context).load("http://mydm.co.za/Elearning/allfile/"+jsonObject.get("image")).into(imageView);
                Glide.with(getApplicationContext()).load("http://mydm.co.za/Elearning/allfile/"+jsonObject.get("image")).into(new GlideDrawableImageViewTarget(imageView));

                // opens a browser when the ads image is clicked
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent browserIntent = null;
                        try {
                            browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(jsonObject.getString("site")));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        context.startActivity(browserIntent);

                    }
                });


            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }


}
