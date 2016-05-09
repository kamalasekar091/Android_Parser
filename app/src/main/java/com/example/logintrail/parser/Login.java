    package com.example.logintrail.parser;

    import android.content.Intent;
    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;
    import android.support.v7.widget.Toolbar;
    import android.view.Menu;
    import android.view.MenuItem;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.TextView;
    import android.widget.Toast;

    /**
    * This class is the Login class and it is used to authenticate the user for login
    * In this page user is allowed only three wrong instance, after three wrong instance the login button disables.
    */
    public class Login extends AppCompatActivity {

    //The text filed and the button are declared here inorder to be used in the further part of the code.
    EditText userName;
    EditText Password;
    Button loginButton;
    TextView textView4;
    int count =0;//A count option is declared inorder to be sed to disable the login button after three attempt of incorrect login

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);// We call the activityLogin.XML over here

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //The field from the XML are used here inorder to get the values form the XML file
        userName=(EditText) findViewById(R.id.editText);
        Password=(EditText) findViewById(R.id.editText2);
        loginButton=(Button) findViewById(R.id.login);
        textView4=(TextView)findViewById(R.id.textView4);


        //A listner button is been set for the login button to act onclick
        loginButton.setOnClickListener(new View.OnClickListener(){


            //An onclick method is been called.
            @Override
            public void onClick(View v) {

                //If count is greater than zero then the login button is disabled
                if ( count >= 2){
                    loginButton.setEnabled(false);

                }

                // This block of the code is is to check the null value
                if  ( userName.getText().toString().equals("")&& Password.getText().toString().equals("") ){

                    // This is a toast message to display the message Please Enter Valid Credetials
                    Toast.makeText(getApplicationContext(), "Please Enter Valid credentials", Toast.LENGTH_LONG).show();
                }

                // This block of the code check for the correct input from the user. The values are hard-Coaded in the file
                //Username is given as: - admin. Password is given as : - admin
                else if ( userName.getText().toString().equals("admin")&& Password.getText().toString().equals("admin") ){

                    // The toast message is displayed as Redirecting
                    Toast.makeText(getApplicationContext(), "Redirecting…", Toast.LENGTH_LONG).show();
                    //An intent is been declared and and object of the intent is been created.
                    final Intent intent = new Intent(Login.this, MainActivity.class);

                    // A new thread is been to call a parsing screen
                    Thread thread = new Thread(){
                        @Override
                        public void run() {
                            try {
                                //This sleep is been provided inorder display the parsing screen after the toast message is been displayed
                                //The time is been synced been the toast message and the next screen
                                Thread.sleep(2500); // As I am using LENGTH_LONG in Toast
                                //Here the next activity is been called.
                                startActivity(intent);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    thread.start();//The thread is been called after the sleep
                }
                //This block is to display the error message on incorrect credentials and to disable the login button
                else if( !userName.getText().toString().equals("admin") || !Password.getText().toString().equals("admin") ){

                    // Toast message is been displayed to prompt the user as wrong credientials.
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_LONG).show();
                    count=count+1;
                    textView4.setText("Attempt: -"+count);// Here we display the count of incorrect login
                    // If the count exceed more than 2 instance the login button is disabled.
                    if (count >2){
                        Toast.makeText(getApplicationContext(), "Login Button Disabled", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    }
