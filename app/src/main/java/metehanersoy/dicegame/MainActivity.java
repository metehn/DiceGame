package metehanersoy.dicegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button buttonPlayer1;
    Button buttonPlayer2;
    Button buttonReset;
    Button buttonExit;
    TextView player1Score;
    TextView player2Score;
    ImageView image;
    int counter=0;

    int images[] = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};
    int numbers[] = {-1,-1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Dice Game");

        Player player1 = new Player();
        Player player2 = new Player();

        buttonPlayer1 = findViewById(R.id.buttonPlayer1);
        buttonPlayer2 = findViewById(R.id.buttonPlayer2);
        buttonReset = findViewById(R.id.buttonReset);
        buttonExit = findViewById(R.id.buttonExit);
        player1Score = findViewById(R.id.player1Score);
        player2Score = findViewById(R.id.player2Score);
        image = findViewById(R.id.imageView);

        View.OnClickListener bt = new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                switch (v.getId()) {

                    case R.id.buttonPlayer1:

                        if(!player1.isCount()){
                            break;
                        }
                        counter++;
                        if(counter == 1){
                            System.out.println("player1 counter1");
                            int number = (int) (Math.random() * 6);
                            player1.setNumber(number + 1);
                            image.setImageResource(images[number]);
                            player1.setCount(false);
                            player2.setCount(true);

                        }
                        if(counter == 2){
                            System.out.println("player1 counter2");
                            int number = (int) (Math.random() * 6);
                            image.setImageResource(images[number]);
                            player1.setNumber(number + 1);

                            if(player1.getNumber() > player2.getNumber()){
                                System.out.println("p1 > p2");
                                int temp = player1.getScore();
                                temp++;
                                player1.setScore(temp);
                                player1Score.setText(Integer.toString(player1.getScore()));
                                counter=0;
                                player1.setCount(false);
                                player2.setCount(true);
                                break;
                            }
                            else if(player1.getNumber() < player2.getNumber()){
                                System.out.println("p1 < p2");
                                int temp = player2.getScore();
                                temp++;
                                player2.setScore(temp);
                                player2Score.setText(Integer.toString(player2.getScore()));
                                counter=0;
                                player1.setCount(false);
                                player2.setCount(true);
                                break;
                            }
                            else if(player1.getNumber() == player2.getNumber()){
                                System.out.println("p1 = p2");
                                counter=0;
                                player1.setCount(false);
                                player2.setCount(true);
                                break;
                            }
                        }

                        break;

                    case R.id.buttonPlayer2:


                        if(!player2.isCount()){
                            break;
                        }
                        counter++;
                        if(counter == 1){
                            System.out.println("player2 counter1");
                            int number = (int) (Math.random() * 6);
                            player2.setNumber(number + 1);
                            image.setImageResource(images[number]);
                            player2.setCount(false);
                            player1.setCount(true);

                        }
                        if(counter == 2){
                            System.out.println("player2 counter2");
                            int number = (int) (Math.random() * 6);
                            player2.setNumber(number + 1);
                            image.setImageResource(images[number]);

                            if(player2.getNumber() > player1.getNumber()){
                                System.out.println("p2 > p1");
                                int temp = player2.getScore();
                                temp++;
                                player2.setScore(temp);
                                player2Score.setText(Integer.toString(player2.getScore()));
                                counter=0;
                                player2.setCount(false);
                                player1.setCount(true);
                                break;
                            }
                            else if(player2.getNumber() < player1.getNumber()){
                                System.out.println("p2 < p1");
                                int temp = player1.getScore();
                                temp++;
                                player1.setScore(temp);
                                player1Score.setText(Integer.toString(player1.getScore()));
                                counter=0;
                                player2.setCount(false);
                                player1.setCount(true);
                                break;
                            }
                            else if(player2.getNumber() == player1.getNumber()){
                                System.out.println("p2 = p1");
                                counter=0;
                                player2.setCount(false);
                                player1.setCount(true);
                                break;
                            }
                        }


                        break;

                    case R.id.buttonReset:
                        counter =0;
                        player1.setScore(0);
                        player1.setNumber(0);
                        player1.setCount(true);
                        player1Score.setText("0");
                        player2.setScore(0);
                        player2.setNumber(0);
                        player2.setCount(true);
                        player2Score.setText("0");
                        image.setImageResource(R.drawable.mark);

                        break;

                    case R.id.buttonExit:
                        finish();
                        System.exit(0);
                        break;
                }

            }
        };

        buttonPlayer1.setOnClickListener(bt);
        buttonPlayer2.setOnClickListener(bt);
        buttonReset.setOnClickListener(bt);
        buttonExit.setOnClickListener(bt);


    }


}