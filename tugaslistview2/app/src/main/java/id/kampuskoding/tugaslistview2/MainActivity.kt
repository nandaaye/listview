package id.kampuskoding.tugaslistview2

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var listView : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.listView)
        var list = mutableListOf<Model>()

        list.add(Model("Ruby",   "Ruby is an open source and fully object oriented programming language",   R.drawable.ruby  ))
        list.add(Model("Rails",   "Ruby on rais is a server side web application development framework written in ruby leanguage",   R.drawable.rails  ))
        list.add(Model("Phyton", "Phyton is Interpreted scripting and object based programming language", R.drawable.phyton  ))
        list.add(Model("Javascript",  "Javascript is an object based scripting language",  R.drawable.javascript  ))
        list.add(Model("PHP",  "PHP is an interpreted language ,i,e, thereis no need for compilation ",  R.drawable.php  ))

        listView.adapter = MyListAdapter(this,R.layout.row,list)

        listView.setOnItemClickListener{parent, view, position, id ->

            if (position==0){
                Toast.makeText(this@MainActivity, "Ruby",   Toast.LENGTH_SHORT).show()
            }
            if (position==1){
                Toast.makeText(this@MainActivity, "Rails",   Toast.LENGTH_SHORT).show()
            }
            if (position==2){
                Toast.makeText(this@MainActivity, "Phyton", Toast.LENGTH_SHORT).show()
            }
            if (position==3){
                Toast.makeText(this@MainActivity, "Javascript",  Toast.LENGTH_SHORT).show()
            }
            if (position==4){
                Toast.makeText(this@MainActivity, "PHP",  Toast.LENGTH_SHORT).show()
            }
        }

    }
}