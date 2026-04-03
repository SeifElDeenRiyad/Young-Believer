package com.example.youngbeliever.ui;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youngbeliever.R;
import com.example.youngbeliever.utils.SpaceManager;
import com.github.barteksc.pdfviewer.PDFView;

public class QuranPdfActivity extends AppCompatActivity
{
    PDFView quranPDF;

    private MediaPlayer QuranPlayer;
    private AudioManager mAudioManager;

    SeekBar quranSeekBar;
    ImageButton quranPlay;
    ImageButton quranPause;

    private Handler mHandler;
    private Runnable mRunnable;
    private Context mContext;
    private Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quran_pdf_activity);

        String pdfPath = getIntent().getStringExtra("pdf");
        PDFView quranpdfView = findViewById(R.id.quran_pdf_view);
        FrameLayout scroll = findViewById(R.id.quran_pdf_scroll);

        int pageNum = getIntent().getIntExtra("page_number", 1);

        quranpdfView.fromAsset("holy_quran.pdf")
                .defaultPage(pageNum)
                //.swipeHorizontal(true)
                .enableSwipe(true)
                .enableDoubletap(true)
                .load();

        SpaceManager spaceManager = new SpaceManager();
        spaceManager.setBottomPadding(scroll);
    }
}
