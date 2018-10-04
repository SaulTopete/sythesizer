package com.example.sythesizer;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonA;
    private Button buttonBb;
    private Button buttonB;
    private Button buttonC;
    private Button buttonCc;
    private Button buttonD;
    private Button buttonDd;
    private Button buttonE;
    private Button buttonF;
    private Button buttonFf;
    private Button buttonG;
    private Button buttonGg;
    private Button scaleButton;

    private Button challenge1;
    private Button challenge5;
    private Button challenge9;
    private Button challenge7;

    private SoundPool soundPool;

    private int noteA;
    private int noteB;
    private int noteBB;
    private int noteC;
    private int noteCc;
    private int noteD;
    private int noteDd;
    private int noteE;
    private int noteF;
    private int noteFf;
    private int noteG;
    private int noteGg;
    private int highA;
    private int highB;
    private int highBb;
    private int highC;
    private int highCc;
    private int highD;
    private int highDd;
    private int highE;
    private int highF;
    private int highFf;
    private int highG;
    private int highGg;


    private Map<Integer, Integer> noteMap;

    public static final float DEFAULT_VOLUME = 1.0f;
    public static final float DEFAULT_RATE = 1.0f;
    public static final int DEFAULT_PRIORITY = 1;
    public static final int WHOLE_NOTE = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        setListeners();
        initializeSoundPool();
        initializeNoteMap();
    }

    private void initializeNoteMap() {
        noteMap = new HashMap<>();
        //in a map, you store a key:value pair
        //the key is the buttonId, the value is the noteId
        noteMap.put(R.id.button_synth_a, noteA);
        noteMap.put(R.id.button_synth_b, noteB);
        noteMap.put(R.id.button_syntn_bb, noteBB);
        noteMap.put(R.id.button_synth_c, noteC);
        noteMap.put(R.id.button_synth_cc, noteCc);
        noteMap.put(R.id.button_synth_d, noteD);
        noteMap.put(R.id.button_synth_dd, noteDd);
        noteMap.put(R.id.button_synth_e, noteE);
        noteMap.put(R.id.button_synth_f, noteF);
        noteMap.put(R.id.button_synth_ff, noteFf);
        noteMap.put(R.id.button_synth_g, noteG);
        noteMap.put(R.id.button_synth_gg, noteGg);
    }


    private void initializeSoundPool() {
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundPool.load(this, R.raw.scalea, 1);
        noteA = soundPool.load(this, R.raw.scalea, 1);
        noteB = soundPool.load(this, R.raw.scaleb, 1);
        noteBB = soundPool.load(this, R.raw.scalebb, 1);
        noteC = soundPool.load(this, R.raw.scalec, 1);
        noteCc = soundPool.load(this, R.raw.scalecs, 1);
        noteD = soundPool.load(this, R.raw.scaled, 1);
        noteDd = soundPool.load(this, R.raw.scaleds, 1);
        noteE = soundPool.load(this, R.raw.scalee, 1);
        noteF = soundPool.load(this, R.raw.scalef, 1);
        noteFf = soundPool.load(this, R.raw.scalefs, 1);
        noteG = soundPool.load(this, R.raw.scaleg, 1);
        noteGg = soundPool.load(this, R.raw.scalegs, 1);
        highA = soundPool.load(this, R.raw.scalehigha, 1);
        highB = soundPool.load(this, R.raw.scalehighb, 1);
        highC = soundPool.load(this, R.raw.scalehighc, 1);
        highCc = soundPool.load(this, R.raw.scalehighcs, 1);
        highD = soundPool.load(this, R.raw.scalehighd, 1);
        highDd = soundPool.load(this, R.raw.scalehighds, 1);
        highE = soundPool.load(this, R.raw.scalehighe,1);
        highF = soundPool.load(this, R.raw.scalehighf, 1);
        highFf = soundPool.load(this, R.raw.scalehighfs, 1);
        highG = soundPool.load(this, R.raw.scalehighg, 1);
        highGg = soundPool.load(this, R.raw.scalehighgs, 1);
    }

    private void setListeners() {
        KeyboardNoteListener noteListener = new KeyboardNoteListener();
        buttonA.setOnClickListener(noteListener);
        buttonBb.setOnClickListener(noteListener);
        buttonB.setOnClickListener(noteListener);
        buttonBb.setOnClickListener(noteListener);
        buttonC.setOnClickListener(noteListener);
        buttonCc.setOnClickListener(noteListener);
        buttonD.setOnClickListener(noteListener);
        buttonDd.setOnClickListener(noteListener);
        buttonE.setOnClickListener(noteListener);
        buttonF.setOnClickListener(noteListener);
        buttonFf.setOnClickListener(noteListener);
        buttonG.setOnClickListener(noteListener);
        buttonGg.setOnClickListener(noteListener);

        scaleButton.setOnClickListener(this);
        challenge1.setOnClickListener(this);
        challenge5.setOnClickListener(this);
        challenge9.setOnClickListener(this);
        challenge7.setOnClickListener(this);
    }

    private void wireWidgets() {
        buttonA = findViewById(R.id.button_synth_a);
        buttonBb = findViewById(R.id.button_syntn_bb);
        buttonB = findViewById(R.id.button_synth_b);
        buttonC = findViewById(R.id.button_synth_c);
        buttonCc = findViewById(R.id.button_synth_cc);
        buttonD = findViewById(R.id.button_synth_d);
        buttonDd = findViewById(R.id.button_synth_dd);
        buttonE = findViewById(R.id.button_synth_e);
        buttonF = findViewById(R.id.button_synth_f);
        buttonFf = findViewById(R.id.button_synth_ff);
        buttonG = findViewById(R.id.button_synth_g);
        buttonGg = findViewById(R.id.button_synth_gg);

        scaleButton = findViewById(R.id.button_synth_scale);
        challenge1 = findViewById(R.id.button_synthe_challenge1);
        challenge5 = findViewById(R.id.button_synth_challenge5);
        challenge9 = findViewById(R.id.button_synth_challenge6);
        challenge7 = findViewById(R.id.button_synth_challenge7);
    }

    @Override
    public void onClick(View v) {
        //one method to handle the clicks of all the buttons
        //but don't forget to tell the buttons who is doing the listening
        switch(v.getId()){
            case R.id.button_synth_scale:
                playScale();
                break;
            case R.id.button_synthe_challenge1:
                playChallenge1();
                break;
            case R.id.button_synth_challenge5:
                playChallenge5();
                break;
            case R.id.button_synth_challenge6:
                playChallenge9();
                break;
            case R.id.button_synth_challenge7:
                playChallenge7();
                break;
        }
    }


    private void playScale() {
        Song scale = new Song();
        List<Note> notes = new ArrayList<>();
        scale.add(new Note(noteA));
        scale.add(new Note(noteBB));
        scale.add(new Note(noteB));

        playSong(scale);
    }

    private void playChallenge1(){
        playNote(noteE);
        delay(WHOLE_NOTE/2);
        playNote(noteFf);
        delay(WHOLE_NOTE/2);
        playNote(noteG);
        delay(WHOLE_NOTE/2);
        playNote(noteA);
        delay(WHOLE_NOTE/2);
        playNote(noteB);
        delay(WHOLE_NOTE/2);
        playNote(noteCc);
        delay(WHOLE_NOTE/2);
        playNote(noteD);
        delay(WHOLE_NOTE/2);
        playNote(noteE);
    }

    private void playChallenge5(){
        playNote(noteA);
        delay(WHOLE_NOTE/2);
        playNote(noteA);
        delay(WHOLE_NOTE/2);
        playNote(highE);
        delay(WHOLE_NOTE/2);
        playNote(highE);
        delay(WHOLE_NOTE/2);
        playNote(highFf);
        delay(WHOLE_NOTE/2);
        playNote(highFf);
        delay(WHOLE_NOTE/2);
        playNote(highE);
        delay(WHOLE_NOTE);
        playNote(noteD);
        delay(WHOLE_NOTE/2);
        playNote(noteD);
        delay(WHOLE_NOTE/2);
        playNote(noteCc);
        delay(WHOLE_NOTE/2);
        playNote(noteCc);
        delay(WHOLE_NOTE/2);
        playNote(noteB);
        delay(WHOLE_NOTE/2);
        playNote(noteB);
        delay(WHOLE_NOTE/2);
        playNote(noteA);
    }

    private void playChallenge9(){
        playChallenge5();
        delay(WHOLE_NOTE);
        playNote(highE);
        delay(WHOLE_NOTE/2);
        playNote(highE);
        delay(WHOLE_NOTE/2);
        playNote(noteD);
        delay(WHOLE_NOTE/2);
        playNote(noteD);
        delay(WHOLE_NOTE/2);
        playNote(noteCc);
        delay(WHOLE_NOTE/2);
        playNote(noteCc);
        delay(WHOLE_NOTE/2);
        playNote(noteB);
    }

    private void playChallenge7(){
       int chall7[] = {noteA, noteA, highE, highE, highFf, highFf, highE, noteD, noteD, noteCc, noteCc, noteB, noteB, noteA};
       for(int i = 0; i < chall7.length; i++){
           if(i > 6 && i < 8){
               delay(WHOLE_NOTE);
           }
           playNote(i);
           delay(WHOLE_NOTE/2);
       }
        Toast.makeText(this, "When you think about it, it sounds like 'Twinkle Twinkle Little Star :)", Toast.LENGTH_LONG).show();
    }

    private void playSong(Song scale){
        for(Note note : scale.getNotes()) {
            playNote(note);
            delay(note.getDelay());
        }
    }

    private void delay(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void playNote(int noteA, int loop) {
        soundPool.play(noteA, DEFAULT_VOLUME, DEFAULT_VOLUME, DEFAULT_PRIORITY, 0, DEFAULT_RATE);
    }

    private void playNote(int note) {
        playNote(note, 0);
    }

    private void playNote(Note note){
        playNote(note.getNoteId(), 0);
    }

    //make an inner class to handle the button clicks
    // for the individual notes
    private class KeyboardNoteListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            //get the ID of the button that was clicked
            int id = view.getId();
            //use the map to figure out what note to play
            int note = noteMap.get(id);
            //play the note
            playNote(note);
        }
    }

}
