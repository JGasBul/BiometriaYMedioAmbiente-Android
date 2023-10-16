package com.example.biometria;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class ServicioEscucharBeacons extends IntentService {
    private static final String ETIQUETA_LOG = ">>>>";
    private long tiempoDeEspera = 10000;
    private boolean seguir = true;

    public ServicioEscucharBeacons(String name) {
        super("HelloIntentService");
        Log.d(ETIQUETA_LOG, " ServicioEscucharBeacons.constructor: termina");
    }

    public void parar() {
        Log.d(ETIQUETA_LOG, " ServicioEscucharBeacons.parar() ");
        if (!this.seguir) {
            return;
        }
        this.seguir = false;
        this.stopSelf();
        Log.d(ETIQUETA_LOG, " ServicioEscucharBeacons.parar() : acaba ");
    }

    public void onDestroy() {
        Log.d(ETIQUETA_LOG, " ServicioEscucharBeacons.onDestroy() ");
        this.parar();
    }

    /**
     * The IntentService calls this method from the default worker thread with
     * the intent that started the service. When this method returns, IntentService
     * stops the service, as appropriate.
     */
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        this.tiempoDeEspera = intent.getLongExtra("tiempoDeEspera", /* default */ 50000);
        this.seguir = true;
        // esto lo ejecuta un WORKER THREAD !
        long contador = 1;
        Log.d(ETIQUETA_LOG, " ServicioEscucharBeacons.onHandleIntent: empieza : thread=" + Thread.currentThread().getId());
        try {
            while (this.seguir) {
                Thread.sleep(tiempoDeEspera);
                Log.d(ETIQUETA_LOG, " ServicioEscucharBeacons.onHandleIntent: tras la espera:  " + contador);
                contador++;
            }
            Log.d(ETIQUETA_LOG, " ServicioEscucharBeacons.onHandleIntent : tarea terminada ( tras while(true) )");
        } catch (InterruptedException e) {
            // Restore interrupt status.
            Log.d(ETIQUETA_LOG, " ServicioEscucharBeacons.onHandleItent: problema con el thread");
            Thread.currentThread().interrupt();
        }
        Log.d(ETIQUETA_LOG, " ServicioEscucharBeacons.onHandleItent: termina");
    }
}
