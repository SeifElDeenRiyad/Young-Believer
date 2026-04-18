package com.example.youngbeliever.ui;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.youngbeliever.R;
import com.example.youngbeliever.utils.SpaceManager;
import com.github.barteksc.pdfviewer.PDFView;

public class QuranPdfActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quran_pdf_activity);

        PDFView quranPdfView = findViewById(R.id.quran_pdf_view);
        FrameLayout scroll = findViewById(R.id.quran_pdf_scroll);

        int pageNum = getIntent().getIntExtra("page_number", 1);

        quranPdfView.fromAsset("holy_quran.pdf")
                .defaultPage(pageNum)
                //.swipeHorizontal(true)
                .enableSwipe(true)
                .enableDoubletap(true)
                .spacing(8)
                .load();

        SpaceManager spaceManager = new SpaceManager();
        spaceManager.setBottomPadding(scroll);
    }
}