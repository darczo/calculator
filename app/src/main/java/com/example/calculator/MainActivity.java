package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView screen;
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9,
            buttonC, button_dot, button_eq, button_add, button_sub, button_mul, button_div;
    boolean screenCleaned = true;
    boolean dotEntered = false;
    String savedNumber;
    int mathOperation = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = findViewById(R.id.screen);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonC = findViewById(R.id.buttonC);
        button_dot = findViewById(R.id.button_dot);
        button_eq = findViewById(R.id.button_eq);
        button_add = findViewById(R.id.button_add);
        button_sub = findViewById(R.id.button_sub);
        button_mul = findViewById(R.id.button_mul);
        button_div = findViewById(R.id.button_div);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!screenCleaned) {
                    modifyScreen("0");
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifyScreen("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifyScreen("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifyScreen("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifyScreen("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifyScreen("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifyScreen("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifyScreen("7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifyScreen("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifyScreen("9");
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenCleaned = true;
                dotEntered = false;
                mathOperation = 0;
                screen.setText("0");
            }
        });

        button_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String screenVal;
                if (!dotEntered) {
                    screenCleaned = false;
                    dotEntered = true;
                    screenVal = screen.getText().toString() + ".";
                    screen.setText(screenVal);
                }
            }
        });

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!screenCleaned) {
                    savedNumber = screen.getText().toString();
                    mathOperation = 1;
                    screenCleaned = true;
                    dotEntered = false;
                    screen.setText("0");
                }
            }
        });

        button_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!screenCleaned) {
                    savedNumber = screen.getText().toString();
                    mathOperation = 2;
                    screenCleaned = true;
                    dotEntered = false;
                    screen.setText("0");
                }
            }
        });

        button_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!screenCleaned) {
                    savedNumber = screen.getText().toString();
                    mathOperation = 3;
                    screenCleaned = true;
                    dotEntered = false;
                    screen.setText("0");
                }
            }
        });

        button_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!screenCleaned) {
                    savedNumber = screen.getText().toString();
                    mathOperation = 4;
                    screenCleaned = true;
                    dotEntered = false;
                    screen.setText("0");
                }
            }
        });

        button_eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double first, second;
                String result;

                if (!screenCleaned) {
                    first = Double.parseDouble(savedNumber);
                    second = Double.parseDouble(screen.getText().toString());
                    switch (mathOperation) {
                        case 1:
                            result = String.valueOf(first + second);
                            screen.setText(result);
                            break;

                        case 2:
                            result = String.valueOf(first - second);
                            screen.setText(result);
                            break;

                        case 3:
                            result = String.valueOf(first * second);
                            screen.setText(result);
                            break;
                        case 4:
                            if (second != 0.0) {
                                result = String.valueOf(first / second);
                                screen.setText(result);
                            }
                            break;
                    }
                }
            }
        });
    }

    void modifyScreen(String number) {
        String screenVal;
        if (screenCleaned) {
            screen.setText(number);
            screenCleaned = false;

        } else {
            screenVal = screen.getText().toString() + number;
            screen.setText(screenVal);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putBoolean("screenState", screenCleaned);
        outState.putBoolean("dotState", dotEntered);
        outState.putString("firstNumber", savedNumber);
        outState.putInt("operation", mathOperation);
        outState.putString("screenVal", screen.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        screenCleaned = savedInstanceState.getBoolean("screenState");
        dotEntered = savedInstanceState.getBoolean("dotState");
        savedNumber = savedInstanceState.getString("firstNumber");
        mathOperation = savedInstanceState.getInt("operation");
        screen.setText(savedInstanceState.getString("screenVal"));
    }
}
