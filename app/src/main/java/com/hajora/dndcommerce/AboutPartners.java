package com.hajora.dndcommerce;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

/**
 * Created by nikol on 13-Jul-17.
 */

public class AboutPartners extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_partners);

        Button AMCOR = (Button) findViewById(R.id.amcor);
        AMCOR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Partner.class);
                intent.putExtra("partner", "AMCOR");
                intent.putExtra("tekst", "Amcor je globalni lider u proizvodnji pakovnog materijala za sterilizaciju i nudi najveći broj inovativnih i održivih pakovnih rešenja. Prepoznatljivi su po kvalitetu svojih proizvoda, od kojih bismo izdvojili čuvenu liniju BOP kesa i rolni. Takođe, svojim patentima, Ultra rolnama i INTEGRApak kesama su ,,kupili” svoje korisnike širom sveta jer pružaju najviši nivo sigurnosti u sterilizaciji.\n" +
                        "Amcor Pergut, ćerka kompanije Amcor, sa sedištem u Madridu, osnovana je 2016. godine i od tada uspešno posluje na polju proizvodnje medicinskih sredstava za kontrolu sterilizacije, poštujući tradiciju kompanije Amcor da bude najbolja. Sa njihovim proizvodima kontrola sterilizacije je zasigurno na najvišem nivou.\n");
                intent.putExtra("link", "www.sps-amcor.fr");
                intent.putExtra("logo", "1");
                startActivity(intent);
            }
        });

        Button BELINTRA = (Button) findViewById(R.id.belintra);
        BELINTRA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Partner.class);
                intent.putExtra("partner", "BELINTRA");
                intent.putExtra("tekst", "Belintra je vodeći Evropski dobavljač logističkih rešenja sa sedištem u Belgiji. Oni su mnogo više od dobavljača opreme. Oni razvijaju neophodnu infrastrukturu, omogućavaju organizacione i logističke procese i implementiraju funkcionalna rešenja.\n" +
                        "Zahvaljujući efikasnim skladišnim i transportnim rešenjima, svaka zdravstvena organizacija može da poboljša vreme i sredstva uložena u dobrobit svojih pacijenata. Ovo važi za sva odeljenja: sterilizacija, operaciona sala, hitna služba, intenzivna nega, farmacija...\n" +
                        "Tokom 40 godina, Belintra je razvila bogato iskustvo u logistici, zbog čega je i postala pravi stručnjak. Linije različitih proizvoda razvijane su da služe potrebama određenih odeljenja, kao i transportna i skladišna rešenja koja se mogu koristiti u različitim odeljenjima.\n");
                intent.putExtra("link", "www.steelco.com");
                intent.putExtra("logo", "2");
                startActivity(intent);
            }
        });
        Button STERIMED = (Button) findViewById(R.id.sterimed);
        STERIMED.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Partner.class);
                intent.putExtra("partner", "STERIMED");
                intent.putExtra("tekst", "Kompanija Sterimed je svetski lider u rešenjima za pakovanje medicinskih sredstava, i to svih vrsta papira za pakovanje za sterilizaciju parom, EO ili plazmom. Uz uvažavanje najviših standarda, u kombinaciji zaštitne i mikrobne barijere, pogodni su za pakovanje različitih tipova setova. Sa aseptičnim otvaranjem, Sterimed nudi papire za sterilizaciju različitih tipova, karakteristika i veličina. Kao najnovije i inovativne proizvode, pored standardnih krep papira, izdvojili bismo Sterimed duo program već spojivih papira u oformljeni komplet za pakovanje.");
                intent.putExtra("link", "www.sterimed.fr");
                intent.putExtra("logo", "3");
                startActivity(intent);
            }
        });
        Button SOLTEC = (Button) findViewById(R.id.soltec);
        SOLTEC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Partner.class);
                intent.putExtra("partner", "SOLTEC");
                intent.putExtra("tekst", "Šta prvo vidite kada počnete sa reprocesiranjem medicinskih instrumenata? SOLTEC. To je vodeća svetska kompanija u proizvodnji ultrazvučnih kada, kadica i kupatila, koje se koriste, ne samo u medicini, već i u industriji. Širok spektar kapaciteta njihovih uređaja pokriva čišćenje od najmanjih instrumenata do teških industrijskih elemenata.");
                intent.putExtra("link", "www.soltec.it");
                intent.putExtra("logo", "4");
                startActivity(intent);
            }
        });
        Button STEELCO = (Button) findViewById(R.id.steelco);
        STEELCO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Partner.class);
                intent.putExtra("partner", "STEELCO");
                intent.putExtra("tekst", "Dovoljno je samo reći Steelco. Samim tim ste izabrali jednu od vodećih svetskih kompanija za proizvodnju aparata za sterilizaciju, pranje i dezinfekciju instrumenata, noćnih posuda i sistema za reprocesiranje endoskopa. Ono što ih čini jedinstvenim je italijanski dizajn i vrhunski kvalitet, kao što i samo ime govori. \n" +
                        "Steelco je lider u proizvodnji aparata koji se bavi kontrolom infekcije i može da pruži svojim korisnicima rešenja koja prevazilaze tržišne standarde.\n" +
                        "Steelco slogan ,,BUDITE UZ NAS” se odnosi na profesionalnu obuku kadra kroz Steelco akademiju.\n");
                intent.putExtra("link", "www.steelcospa.com");
                intent.putExtra("logo", "5");

                startActivity(intent);
            }
        });
        Button HAWO = (Button) findViewById(R.id.hawo);
        HAWO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Partner.class);
                intent.putExtra("partner", "HAWO");
                intent.putExtra("tekst", "Porodična kompanija sa iskustvom preko 40 godina i distribucijom u preko 120 zemalja sveta. Danas, gotovo da je nemoguće pronaći sterilizaciju koja nema bar jedan Hawo uređaj. Kompanija se bavi proizvodnjom lepilica za zatvaranje folija svih vrsta. Njihov portfolio pokriva od stomatoloških ordinacija preko bolnica do industrijskih uređaja. Ono što ih izdvaja od drugih je ulaganje u inovacije i žig koji svaki njihov uređaj poseduje - Made in Germany.");
                intent.putExtra("link", "www.hawo.com");
                intent.putExtra("logo", "6");
                startActivity(intent);
            }
        });
        Button PRINTEX = (Button) findViewById(R.id.printex);
        PRINTEX.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Partner.class);
                intent.putExtra("partner", "PRINTEX");
                intent.putExtra("tekst", "Printex je italijanska kompanija i jedna od vodećih u svetu u proizvodnji aparata za markiranje i nalepnica sa indikatorima za obeležavanje setova za sterilizaciju. Aparati za markiranje se mogu naći u dve varijante – sa dvorednim i trorednim štampanjem. Nalepnice različitih dimenzija poseduju procesni indikator (para, plazma, EO). Printex sistem za obeležavanje nam omogućava praćenje sterilisanog seta, preko serijskog broja, od centralne sterilizacije do operacione sale. Printex aparati za markiranje i nalepnice mogu se smatrati ekskluzivnim u svetu, zato što je Printex jedini u Italiji koji proizvodi sertifikovane aparate i nalepnice u skladu sa evropskim tržištem i ostatkom sveta.");
                intent.putExtra("link", "http://www.printexsrl.com");
                intent.putExtra("logo", "7");
                startActivity(intent);
            }
        });

        Button CBM = (Button) findViewById(R.id.cbm);
        CBM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Partner.class);
                intent.putExtra("partner", "CBM");
                intent.putExtra("tekst", "CBM je vodeća italijanska kompanija za proizvodnju stonih sterilizatora manjih kapaciteta namenjenih za stomatološke ordinacije i laboratorije, kao i korpi i rešetki za stomatološke instrumente, elektronskih panacea vodenih kupatila i elektronskih inkubatora.\n" +
                        "O kvalitetu kompanije CBM dovoljno govori podatak da posluju od 1962. godine.\n");
                intent.putExtra("link", "www.cbm-srl.com");
                intent.putExtra("logo", "8");
                startActivity(intent);
            }
        });
    }
        @Override
        public void onWindowFocusChanged ( boolean hasFocus){
            super.onWindowFocusChanged(hasFocus);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            if (hasFocus) {
                getWindow().getDecorView().setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
            }
        }
    }
