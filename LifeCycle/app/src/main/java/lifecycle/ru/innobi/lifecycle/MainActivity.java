package lifecycle.ru.innobi.lifecycle;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Calendar;

import lifecycle.ru.innobi.lifecycle.dummy.DummyContent;

public class MainActivity extends AppCompatActivity
        implements CityFragment.OnListFragmentInteractionListener, TemperatureFragment.OnFragmentInteractionListener {

    public static final String KEY_CITY = "KeyCity";
    public static final String KEY_TEMPERATURE = "KeyTemperature";

    private final String TAG = "MESSAGE (" + this.getClass().getSimpleName() + "): ";
    CityFragment city;
    TemperatureFragment temperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Log.w(TAG,"onCreate");
        initUi();
    }

    private void initUi() {
        initFragments();
    }


    private void initFragments() {
        city = (CityFragment) getSupportFragmentManager().findFragmentById(R.id.city_fragment);
        temperature = (TemperatureFragment) getSupportFragmentManager().findFragmentById(R.id.temperature_fragment);
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        Log.d("TAG1", "onListFragmentInteraction: " + item + ": " + item.temperature);
        if (temperature != null && temperature.isVisible()) {
            temperature.changeTemperature(item.content, item.temperature);
        } else {
            Intent intent = new Intent(getApplicationContext(), TemperatureActivity.class);
            intent.putExtra(KEY_CITY, item.content);
            intent.putExtra(KEY_TEMPERATURE, item.temperature);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

    @Override
    protected void onStart() {
        /*Вызывается непосредственно перед тем, как activity приложения становится видимой, то есть
        выходит на передний план. Как правило, этот метод не переопределяют.*/
        super.onStart();
        Log.w(TAG,"onStart");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        /*Вызывается после метода onStart(). Восстановление визуального интерфейса можно возложить
        на этот метод, а не на onCreate(). Но этот метод вызывается только если Bundle
        не равен null.*/
        super.onRestoreInstanceState(savedInstanceState);
        Log.w(TAG,"onRestoreInstanceState");
    }

    @Override
    protected void onResume() {
        /*После вызова этого метода пользователь начинает работать с activity. Приложение получает
        монопольные ресурсы. Этот метод может вызываться после метода onPause(). Если вы остановили
        или освободили ресурсы на onPause(), то их надо восстановить в onResume().*/
        super.onResume();
        Log.w(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        /*Когда пользователь переходит к новой activity, вызывается метод onPause(). В этом методе
        следует останавливать действия, приводящие к загрузке процессора, например останавливать
        запись с камеры или воспроизведение анимации. Кроме того, здесь зафиксируют несохраненные
        записи, так как это последний гарантированно вызываемый метод. Методы onStop() и onDestroy()
        могут и не быть вызваны. Но все-таки этот метод лучше не нагружать, иначе вы получите
        задержку при переходе к другой activity. */
        super.onPause();
        Log.w(TAG,"onPause");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        /*Вызывается после onPause(). Здесь следует сохранить состояние приложения в передаваемый
        объект Bundle.*/
        super.onSaveInstanceState(outState);
        Log.w(TAG,"onSaveInstanceState");
    }

    @Override
    protected void onStop() {
        /*Здесь следует освобождать уже ненужные ресурсы. При этом состояние activity остается в
        памяти устройства. После вызова onStop() может быть вызван метод onRestart(), если
        пользователь решит вернуться к activity, или onDestroy() ‒ при закрытии приложения.
        Если системе не хватает памяти, то она может удалить скрытую activity командой onDestroy(),
        минуя вызов onStop().*/
        super.onStop();
        Log.w(TAG,"onStop");
    }

    @Override
    protected void onRestart() {
        /*Когда пользователь решает возобновить работу с activity, выполняется этот метод. После
        него всегда следует метод onStart().*/
        super.onRestart();
        Log.w(TAG,"onRestart");
    }

    @Override
    protected void onDestroy() {
        /*Вызывается при окончании работы с activity. Также возникает, когда система решает
        уничтожить activity либо при вызове метода finish(). Но этот метод может и не вызываться,
        поэтому не стоит на него полагаться.*/
        super.onDestroy();
        Log.w(TAG,"onDestroy");
    }

    @Override
    public void clickOnImage() {

    }
}
