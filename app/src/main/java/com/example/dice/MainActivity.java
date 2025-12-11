package com.example.dice; // Must match manifest's package

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView leftDiceImage, rightDiceImage;
    private Button rollButton;
    private Random random;

    private final int[] diceImages = {
            R.drawable.dice1,
            R.drawable.dice2,
            R.drawable.dice3,
            R.drawable.dice4,
            R.drawable.dice5,
            R.drawable.dice6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ✅ Initialize Firebase
        FirebaseApp.initializeApp(this);
        FirebaseAuth auth = FirebaseAuth.getInstance();
        if (auth != null) {
            Toast.makeText(this, "Firebase connected successfully!", Toast.LENGTH_SHORT).show();
        }

        // 🎲 Initialize dice game UI
        leftDiceImage = findViewById(R.id.image_leftDice);
        rightDiceImage = findViewById(R.id.image_RightDice);
        rollButton = findViewById(R.id.Roll_btn);

        random = new Random();
        rollButton.setOnClickListener(view -> rollDice());

        Log.d("Message", "onCreate is called");
    }

    private void rollDice() {
        int leftDiceRoll = random.nextInt(diceImages.length);
        int rightDiceRoll = random.nextInt(diceImages.length);

        leftDiceImage.setImageResource(diceImages[leftDiceRoll]);
        rightDiceImage.setImageResource(diceImages[rightDiceRoll]);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Message", "onRestart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Message", "onResume called");
    }
}
