package co.develhope.meteoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val todayInfoList : ArrayList<TodayInfo> = arrayListOf(
        TodayInfo("11:00",R.drawable.sun_image,"24°","33%","45°","5/10","23%","SSE 7km/h","30%","0cm"),
        TodayInfo("12:00",R.drawable.sun_image,"26°","13%","55°","5/10","13%","SSE 7km/h","30%","0cm"),
        TodayInfo("13:00",R.drawable.sun_image,"27°","13%","50°","5/10","23%","SSE 7km/h","30%","0cm"),
        TodayInfo("14:00",R.drawable.sun_image,"25°","16%","50°","5/10","33%","SSE 7km/h","30%","0cm"),
        TodayInfo("15:00",R.drawable.sun_image,"26°","17%","47°","5/10","13%","SSE 7km/h","30%","0cm"),
        TodayInfo("16:00",R.drawable.sun_image,"24°","15%","45°","5/10","12%","SSE 7km/h","30%","0cm"),
        TodayInfo("17:00",R.drawable.sun_image,"23°","13%","43°","5/10","25%","SSE 7km/h","30%","0cm"),
        TodayInfo("18:00",R.drawable.sun_image,"28°","33%","42°","5/10","hHo","SSE 7km/h","30%","0cm"),
        TodayInfo("19:00",R.drawable.sun_image,"30°","22%","43°","5/10","12%","SSE 7km/h","30%","0cm"),
        TodayInfo("20:00",R.drawable.sun_image,"34°","13%","39°","5/10","15%","SSE 7km/h","30%","0cm"),
        TodayInfo("21:00",R.drawable.sun_image,"33°","17%","28°","5/10","16%","SSE 7km/h","30%","0cm"),
        TodayInfo("22:00",R.drawable.sun_image,"37°","19%","68°","5/10","17%","SSE 7km/h","30%","0cm"),
        TodayInfo("23:00",R.drawable.sun_image,"36°","10%","47°","5/10","18%","SSE 7km/h","30%","0cm"),
        TodayInfo("00:00",R.drawable.sun_image,"35°","18%","45°","5/10","20%","SSE 7km/h","30%","0cm")

    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = TodayInfoAdapter(todayInfoList)

    }

}